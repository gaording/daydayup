scan指令和类似的sscan、hscan以及zcan都被用于渐进迭代集合中的元素。

* scan迭代当前redis数据库中keys的set
* sscan迭代Sets类型的元素
* hscan迭代Hash类型的字段和对应的value
* zscan迭代Sorted Set类型的元素和对应的scores

因为这些命令可以渐进迭代，每次调用仅返回一小部分元素，所以它们可以被用于生产环境，而没有keys或者smembers这些命令在调用有大量keys或者元素的集合时会阻塞服务一段时间（可能只有几秒）的缺点。

然而类似smembers这种阻塞命令可以提供给定时刻set中的所有元素，SCAN家族的命令对于我们在迭代过程中可能会改变的集合只提供有限的保证。

SCAN、SSCAN、HSCAN、ZSCAN工作原理是类似的，所以这篇文档包括了这4中指令。一个明显的不同是SSCAN、HSCAN和ZSCAN命令的第一个参数是Set、Hash、Sorted Set中的key。SCAN命令则不需要key参数，因为它迭代了当前数据库中的所有keys，迭代对象就是数据库本身。

### SCAN basic usage

scan是根据cursor迭代的。这就是说，每一次调用，服务器都会返回一个更新后的cursor，用户在下一次调用时需要使用这个cursor作为参数。

迭代开始时cursor为0，迭代结束时服务器返回的cursor也为0。下面是SCAN迭代的例子：

```plain
redis 127.0.0.1:6379> scan 0
1) "17"
2)  1) "key:12"
    2) "key:8"
    3) "key:4"
    4) "key:14"
    5) "key:16"
    6) "key:17"
    7) "key:15"
    8) "key:10"
    9) "key:3"
   10) "key:7"
   11) "key:1"
redis 127.0.0.1:6379> scan 17
1) "0"
2) 1) "key:5"
   2) "key:18"
   3) "key:0"
   4) "key:2"
   5) "key:19"
   6) "key:13"
   7) "key:6"
   8) "key:9"
   9) "key:11"
```
上面的例子中，第一次调用使用0作为一个cursor，开启了迭代。第二次调用使用前面调用返回的cursor作为新的cursor参数，也就是17。
可以看到SCAN返回值是一个有两个值的数组：第一个值是下一次调用使用的新的cursor，第二个是元素数组。

第二次调用返回的cursor是0，服务器告诉调用者，迭代已经结束了，整个集合被完全探测过了。开始迭代时用的cursor为0，并且调用scan直到返回的cursor再次为0，就是一次完整的迭代。

### Scan guarantees

SCAN命令和SCAN家族的其他命令，在完整迭代中能提供用户一些保证：

* 一次完整的迭代从开始到结束能扫描完这个集合中的所有元素。所以一个元素迭代开始前在集合内，迭代完成后还在集合内，那么在扫描过程中SCAN会将它返回给用户
* 一次完整的迭代从不返回集合内一直没有的元素。所以如果迭代前移除了这个元素，并且迭代过程中未重新加入集合，SCAN确保这个元素不被返回

但是因为SCAN有状态关联（和cursor），所以有下面的缺点：

* 一个元素可能被返回多次。它抛给应用去处理重复元素的情况，例如使用幂等操作确保多次调用统一元素不影响程序结果。
* 元素在迭代期间被移除了，那么它可能返回也可能不返回：这是不明确的
### Number of elements returned at every SCAN call

SCAN家族函数不确保在一个给定范围内每次调用返回的元素数量。这个命令也可能返回0个元素，但只要返回的cursor不为0，客户端就不应该考虑迭代完成。

返回元素的数量是有原因的，事实上SCAN在迭代大型集合时可能会返回几十个元素的最大数量的元素，或者可能会在单次调用中返回集合的所有元素，当迭代集合是足够小以至于内部表示为一个编码数据结构时，比如小的sets，hashes和sorted sets。

然而用户可以用COUNT参数来调控每次调用返回元素的数量级。

### The COUNT option

尽管SCAN不保证每回返回的元素数量，但可以用count参数根据经验调整。基本上，用户用count可以指定每次调用检索集合元素时的工作量。这只是一个命令的提示，但一般来说，大多数情况下大多数情况下都会达到预期。

* 默认的COUNT值是10
* 当遍历key空间或者一个Set、Hash、Sorted Set，这些是足够大以至于用hash table形式表示时，假设没有MATCH选项被使用，服务通常将返回比count或者比count稍多些的元素在每次调用中。在文章后面你能看到为什么SCAN能在一次返回所有元素。
* 当遍历编码成intsets（只有整数组成的小的sets）的sets或者被编码成ziplist（由小数值组成的hashes或者setes）的hashes或者sorted sets，通常第一次scan调用时就会返回所有元素，无视COUNT参数

重要地：没必要每次调用时都用一样的count值。调用者可以随意在每次调用中改变count值，只要cursor是上一次调用返回的cursor即可。

### The Match option

可以通过正则匹配迭代元素，类似于keys命令的匹配参数

只需要在scan命令中添加匹配参数MATCH <pattern>即可

例子如下：

```plain
redis 127.0.0.1:6379> sadd myset 1 2 3 foo foobar feelsgood
(integer) 6
redis 127.0.0.1:6379> sscan myset 0 match f*
1) "0"
2) 1) "foo"
   2) "feelsgood"
   3) "foobar"
redis 127.0.0.1:6379>
```
match过滤只会在元素已经从集合检索出来之后，也就是返回给客户端之前才执行。这就是说如果集合中匹配非常少的元素，那么大多数迭代时SCAN都将返回空。例子如下：
```plain
redis 127.0.0.1:6379> scan 0 MATCH *11*
1) "288"
2) 1) "key:911"
redis 127.0.0.1:6379> scan 288 MATCH *11*
1) "224"
2) (empty list or set)
redis 127.0.0.1:6379> scan 224 MATCH *11*
1) "80"
2) (empty list or set)
redis 127.0.0.1:6379> scan 80 MATCH *11*
1) "176"
2) (empty list or set)
redis 127.0.0.1:6379> scan 176 MATCH *11* COUNT 1000
1) "0"
2)  1) "key:611"
    2) "key:711"
    3) "key:118"
    4) "key:117"
    5) "key:311"
    6) "key:112"
    7) "key:111"
    8) "key:110"
    9) "key:113"
   10) "key:211"
   11) "key:411"
   12) "key:115"
   13) "key:116"
   14) "key:114"
   15) "key:119"
   16) "key:811"
   17) "key:511"
   18) "key:11"
redis 127.0.0.1:6379>
```
能看到大多数调用都会返回0个元素，最后一次count为1000，强制了这个命令做更多地扫描。
### The Type option

6.0版本你可以用这个选项去要求SCAN只返回指定type的对象，允许你遍历数据库查找指定类型的keys。type只能用于SCAN，不能用于HSCAN、ZSCAN等

type参数就是type指令返回的字符的名字。一些redis类型，比如GeoHashes，HyperLogLogs，Bitmaps和Bitfields，可能内部是用别的redis类型实现的，像是string或者zset，所以不能通过scan将其与同类型的其它keys区分开来。例如，ZSET和GEOHASH

```plain
redis 127.0.0.1:6379> GEOADD geokey 0 0 value
(integer) 1
redis 127.0.0.1:6379> ZADD zkey 1000 value
(integer) 1
redis 127.0.0.1:6379> TYPE geokey
zset
redis 127.0.0.1:6379> TYPE zkey
zset
redis 127.0.0.1:6379> SCAN 0 TYPE zset
1) "0"
2) 1) "geokey"
   2) "zkey"
```
这个TYPE类型过滤也是在元素从数据库检索出来后生效的，所以这个选项不能减少服务器完成整个扫描的工作量，并且对于稀少的types，你可能多次迭代时都不能获取到元素。
### Multiple parallel iterations

很可能有很多客户端同时迭代同一个集合，迭代的所有状态项就是cursor，那是每一次调用时被包含并且返回给客户端的。服务端不保留状态。

### Terminating iterations in the middle

既然服务端没有状态，完整的状态项只有cursor，那么调用者就可以随时终止一次迭代而无需通知服务端。任意数量的迭代都可以开始但可以没有任何问题的被终止掉。

### Calling SCAN with a corrupted cursor

调用scan用一个坏的、负数、超出范围或者其他无效的cursor，将导致无法预计的行为，但是不会陷入故障。但是SCAN指令的保证无法被确保了。

唯一有效的cursor是：

* 开始迭代时为0的cursor
* scan命令之前返回的cursor
### Guarantee of termination

scan算法确保遍历一个给定最大值的集合时能遍历结束，如果集合在持续增长中，那么SCAN能不能调用结束就取决于SCAN的调用次数、COUNT参数和集合增长的比率。

### Why SCAN may return all the items of an aggregate data type in a single call?

在count参数文档中，我们说了有时SCAN系列命令能在一次调用中就返回Set、Hash或者Sorted set的所有元素，而无视count参数。原因是以cursor为基准的迭代器能实现并生效，仅仅是当我们扫描的数据类型是hash table的时候。然而redis在小的数据类型中采用了内存优化策略。除非它们超过指定数量或者单个元素的最大值，否则就是用一个更严密地单个数据结构编码表示。在这种情况下，SCAN不能返回有意义的cursor，并且每次必须迭代整个数据结构，所以唯一合理的方式就是一次调用返回所有元素。

然而一旦数据结构越来越大并变为hash table时，scan系列命令将变成正常的行为。记住这个返回所有元素的特殊行为只在小的数据体的时候才存在，它对命令的复杂性或延迟没有影响。然而转换成hash tables的限制是用户可配置的，所以单次调用中你可以你能看到返回的最大元素数量取决于一个聚合数据类型是多大并且仍启用压缩表示的情况。

记住这个行为只出现在SSCAN、HSCAN、ZSCAN，SCAN不会有这种情况，因为对应的key空间总被表示为hash tables。

### Return value

SCAN、SSCAN、HSCAN和ZSCAN返回两个元素的回复，第一个元素是一个64位无符号数的字符串—cursor，第二个元素是元素数组

* scan元素数组是一个keys的列表
* sscan元素数组是一个set members的列表
* hscan是每一个元素都包含两个子元素的数组，两个子元素分别是字段和值，是hash中返回的每一个元素。
* zscan是每一个元素都包含两个子元素的数组，两个子元素分别是member和对应分数，是sorted set中返回的每一个元素。

