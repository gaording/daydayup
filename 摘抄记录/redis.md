### Redis Strings

redis string类型是你能用redis key值最简单的一种value类型，它是memcached中唯一的类型，所以刚接触redis的人用它是非常自然的。

因为redis的key为strings，所以我们用string类型作为value时，就是将一个string映射到另一个string。string数据类型在很多情况下都是有用的，类似匹配html网页。

小试一下string类型

你可以用set和get方法来设置和获取一个string值，set将替代这个key中已经存在的值，即使这个可以对应的value不是string类型的。所以set更像是一个任务

values可以是每一种类型的strings（包含二进制），例如存储一个jpeg图片，value不能超过512M。

set可以有一些额外选项，通过加参数设置，比如可以设置key存在时set失败，或者只当key存在时才set成功。对应参数为nx：当key存在时set失败 xx：当key存在时set成功。

即便strings是redis的基础values，你仍可以利用它做一些有趣的操作。比如：自动增长（做唯一主键）。incr命令能转换string作为一个整数，做加一操作，并且设置这个加一的结果值作为新的value。有类似的命令如：incrby、decr、decrby。事实上，它们内部处理都是同一个指令，只不过命令叫法不同。

incr是原子性的意味着什么？即便多个客户端，同时对同一个key执行incr指令，它们也不会陷入竞争中。例如，客户端client1和客户端client2同时读取到10，然后都做加一操作。最后的value将总是12并且这个read—increment—set操作总被执行，即便其他的客户端不是同时执行这一命令

有很多指令操作一个strings。例如，getset指令设置一个key为新的value，同时返回旧的value。当你有一个通过incr自增redis的key的系统的时候，你可以用这个指令。例如每一次你的网站获取到一个新的访问者。你可以每小时收集下这个信息，不用担心丢掉任何一个增长。你可以通过getset这个key，来赋给它新的0值，并且读取旧的value

通过一个命令去设置或者获取多个keys的能力也是有利于减少延迟的。因此有mset和mget指令。用mget时，redis会返回一个values的数组。

有些命令不属于任何一种特定类型，但是和the space of keys交互是有用的。因此，可以被用于任何一种类型。例如EXISTS指令，可以返回0或1判定数据库中查找的key是否存在。而DEL指令可以删除任意一个key。

有很多key space相关的命令，但是上面两个是基础的。同样基础的还有TYPE指令，TYPE指令返回key存储的value的类型


redis expires:指定对应keys的存活时间。

在探讨更复杂的数据结构之前，我们需要讨论与value type无关的另一种特色，就是Redis expires。你可以用它设置一个key的超时时间，也就是key的存活时间。当设置时间到的时候，这个key被自动销毁，就像用户调用了DEL命令

关于Redis Expires的几个简明信息：

* 可以被设置成以秒或毫秒为单位
* 过时时间的解析单位总是毫秒
* 过期时间被复制并且持久化在磁盘上，当你的redis server一直停止的时候，时间就会过去(这意味着Redis保留了这个将过期的时间)
```plain
> set key some-value
OK
> expire key 5
(integer) 1
> get key (immediately)
"some-value"
> get key (after some time)
(nil)
```
在两次GET调用时，这个key消失了，既然第二次调用超过了5s，上述粒子中我们用expire来设置过期时间（它可以被用于设置一个已经设置过过期时间的key，设置一个新的过期时间）。当然我们也可以用别的Redis命令设置key的过期时间，比如用SET指令：
```plain
> set key 100 ex 10
OK
> ttl key
(integer) 9
```
上述例子设置了一个Value为100，过期时间为10s的key，调用TTL命令查看这个key的存活时间。
为了设置和检查以毫秒为单位的存活时间，可以用PEXPIRE和PTTL命令，和SET指令的全部list

### Redis Lists

解释List数据类型最好从一些理论出发。List这个词通常被信息技术人员不正确的使用。例如“Python Lists”不是名称所暗示的（链表），而是数组（事实上Ruby中相同的数据类型就叫做数组）。

简单来说，list就是一个有序元素的序列。但是用一个数组实现一个列表是非常困难的，而用一个链表去实现一个列表是比较简单的。Redis lists就是通过链表实现的，这意味着即使这个list有百万个元素，在list头或尾添加元素仍是常数级别的。用LPUSH添加新元素到一个有10个元素的列表和到一个1千万元素的列表，速度是一样的。

那缺点是什么呢？在数组中通过索引访问元素是非常快的（常数级别），而在链表中访问元素并不快（该操作的工作量与所访问元素的索引成正比）

Redis Lists用链表实现，因为对于一个数据库系统来说，对一个很长的列表添加元素是至关重要的。另一个优势，你之后可以看到，就是Redis Lists以固定长度获取时只需花费常数级的时间。

如果快速获取一个大的元素集合中的中间元素是重要的，那么有另一种叫做sorted sets的数据结构可以使用。sorted sets将在本教程的后半部分讲解。

#### Redis Lists的第一步

LPUSH指令添加一个新的元素到一个列表中，添加到左边或者说头部，而RPUSH命令添加一个新的元素，则是添加到右边或者说尾部。LRANGE提取列表元素的一部分。

```plain
> rpush mylist A
(integer) 1
> rpush mylist B
(integer) 2
> lpush mylist first
(integer) 3
> lrange mylist 0 -1
1) "first"
2) "A"
3) "B"
```
LRANGE需有两个索引，分别表示返回的第一个和最后一个元素。两个索引都可以是附属，高速Redis从尾部开始数：所以-1是最后一个元素，-2是倒数第二个元素，以此类推
你能看到RPUSH是从列表右侧添加元素，而LPUSH是从左侧添加元素

两个命令是可变参数命令，意味着你一个命令中可以任意添加多个元素

```plain
> rpush mylist 1 2 3 4 5 "foo bar"
(integer) 9
> lrange mylist 0 -1
1) "first"
2) "A"
3) "B"
4) "1"
5) "2"
6) "3"
7) "4"
8) "5"
9) "foo bar"
```
一个Redis lists中定义的重要操作是弹出元素的能力。弹出元素是一种检索列表中元素并且同时删除它的操作。你可以从左侧或右侧弹出元素，就像push元素时那样
```plain
> rpush mylist a b c
(integer) 3
> rpop mylist
"c"
> rpop mylist
"b"
> rpop mylist
"a"
```
我们添加了三个元素并且弹出了三个元素，所以执行最后的命令时，list是空的并且没有更多可多元素可弹出。所以我们试图弹出另一个元素时，这是我们获得的结果：
```plain
> rpop mylist
(nil)
```
redis返回一个null值，意味着列表中已没有更多的元素
#### Lists的通常使用

有很多任务时可以使用Lists，下面有两个代表性的使用案例：

* 记住用户发布到社交网络上的最近更新内容
* 进程之间的交流，比如生产者和消费者模式中，生产者可以推送项目到列表中，然后一个消费者（通常是工作线程）消费这些项目并且执行任务。Redis有特殊的list命令让这个使用案例更可靠、更有效

例如Ruby受欢迎的两个库resque和sidekiq内部都用了Redis lists来执行后台任务。

twitter社交网获取用户推送的最新推文也是用Redis lists

为了一步步描述一个通常的使用案例，想象在一个照片社交网，你的主页展示最新发布的照片，并且你想要快速上传

* 每一次一个用户推送了一张新照片，我们把它的Id通过LPUSH加入到list中
* 当用户访问主页时，我们用LRANGE 0 9来获取最新发布的10个照片
#### 封顶列表Capped lists

很多情况下，我们只想要用lists去存储最新的数据，不过这些数据是社交网更新或者日志或者别的东西。

Redis允许我们用lists作为一个置顶列表，只要记住最新的N条数据并且通过LTRIM命令丢弃掉所有更老的数据。

这个LTRIM命令类似于LRANGE，但是和展示指定范围的元素不同的是它设置了新的列表value的范围，不在这个范围内的元素都被移除掉。

一个例子让它更清晰：

```plain
> rpush mylist 1 2 3 4 5
(integer) 5
> ltrim mylist 0 2
OK
> lrange mylist 0 -1
1) "1"
2) "2"
3) "3"
```
上面的LTRIM命令告诉Redis只保留索引从0到2的列表元素，其它的被抛弃掉。这个允许一个非常简单但是有用的方式。执行一个列表推送，在执行一个列表修剪，就能添加一个新元素并且抛弃超出限制的元素。
```plain
LPUSH mylist <some element>
LTRIM mylist 0 999
```
上面的组合增加了一个新元素，并且只保留了列表中最新的1000个元素。通过LRANGE你可以获得最新的数据而无需保留非常老的数据。
记住：尽管LRANGE是一个技术上为O（N）复杂度的命令，但是获得头或尾的小范围数据是一个常数级别的操作。

#### lists的阻塞操作Blocking operations on lists

lists有一个专门的特点，使得它们更适合实现队列，并且通常作为进程间通信系统的组成部分：阻塞操作。

想象你想要用一个进程推送数据都一个列表，并且通过另一个不同的进程去做一些关于这些数据的处理。这是通常的producer/consumer设置，并且可以用下面简单的方式实现。

* 生产者调用LPUSH推送数据到列表中
* 消费者调用RPOP提取列表中的数据

然而有可能某些时候，这个列表是空的并且没有数据可推送，那么RPOP就会返回null。这种情况下消费者被迫等待，并且只能通过RPOP一次一次重试。这就叫做polling，这不是一个好的方式，因为它有几个缺点：

* 强制Redis和客户端去执行无用的命令（当这个列表为空的时候，所有的请求事实上没有有效工作，因为它们只会返回null）
* 增加了一个处理数据的延迟，因为在一个worker收到一个null后，它等待一段时间。为了让延迟更小，我们可以在调用RPOP之前等待更少的时间，但是副作用是加剧了问题1，即更多的无效调用

所以Redis实现了BRPOP和BLPOP的命令，这是RPOP和LPOP的阻塞版本，如果列表为空时，它们将阻塞。只有当list中添加了新的元素后，它们才会返回给调用者，或者当用户设定的超时时间到达的时候。

这里有一个我们可以用在worker中BRPOP调用的例子：

```plain
> brpop tasks 5
1) "tasks"
2) "do_something"
```
它意味着：“等待列表中的元素，若超过5s仍无元素可用时则返回”
记住你可以将超时时间设置为0，那样就会永远等待元素。你也可以指定多个lists而不只是一个。为了同时等待多个lists，并且当第一个list收到元素时获得通知，有几个关于BRPOP的注意点：

* 用有序的方式服务客户端：列表中第一个被阻塞等待的客户端，也要第一个被服务当一个元素被推送到别的客户端时，以此类推
* 返回值是不同于RPOP的，他是一个包含key的两个元素的数组。因为BRPOP和BLPOP是可能阻塞等待多个列表中的元素的。
* 如果超时，则返回null

有更多应该知道的关于lists和阻塞行为的事情，我们建议你读下面的东西

* 用LMOVE可以构建更安全的队列或者循环队列
* LMOVE对应的阻塞命令就是BLMOVE
#### keys的自动创建和移除

到目前为止，我们在push元素的时候从未创建一个空的列表，而在列表已无元素之后也并未主动移除空列表。redis会主动做这些事，当列表为空时移除列表，当列表不存在时创建列表，它适合所有由多个元素组成的redis data——streams，sets，sorted sets和hashes。

一般我们总结为如下三个规则：

* 当我们向一个集合数据类型添加元素时，如果目标key不存在，添加元素前一个空的集合数据类型会被创建
* 当我们从一个集合数据类型移除元素时，如果这个value为空，这个key会被自动销毁。stream类型是唯一的例外。
* 调用一些只读命令时（如LLEN），或者一个移除空数据中元素的写命令时，结果都是一样的。就好像这个key拥有一个命令期望找到的空的数据类型

demo：

```plain
> del mylist
(integer) 1
> lpush mylist 1 2 3
(integer) 3
```
但是如果这个key是存在的，我们不能调用错误的指令:
```plain
> set foo bar
OK
> lpush foo 1 2 3
(error) WRONGTYPE Operation against a key holding the wrong kind of value
> type foo
string
```
第二个例子：
```plain
> lpush mylist 1 2 3
(integer) 3
> exists mylist
(integer) 1
> lpop mylist
"3"
> lpop mylist
"2"
> lpop mylist
"1"
> exists mylist
(integer) 0
```
所有元素被pop后，这个key就不再存在了。
第三个例子：

```plain
> del mylist
(integer) 0
> llen mylist
(integer) 0
> lpop mylist
(nil)
```
### Redis Hashes

redis看起来就是人们期望看到的“散列值”的样子，是键值对的模式：

```plain
> hmset user:1000 username antirez birthyear 1977 verified 1
OK
> hget user:1000 username
"antirez"
> hget user:1000 birthyear
"1977"
> hgetall user:1000
1) "username"
2) "antirez"
3) "birthyear"
4) "1977"
5) "verified"
6) "1"
```
hashes是用于代表Objects的，事实上你可以存储任意多的字段，并没有什么限制（除了内存）。所以你能在自己的应用中用不同的方式使用hashes。
hmset命令可以设置hash的多个字段，hget可以获得哈希的单个字段。hmget类似于hget，但是返回一个values的数组

```plain
> hmget user:1000 username birthyear no-such-field
1) "antirez"
2) "1977"
3) (nil)
```
有一些命令能对单个字段进行操作，比如HINCRBY
```plain
> hincrby user:1000 birthyear 10
(integer) 1987
> hincrby user:1000 birthyear 10
(integer) 1997
```
可以在redis命令文档中找到所有的hash命令列表。
值得注意的是，小的hash（只有几个元素的小的values）在内存中以特殊方式编译，为了让内存更为有效。

### Redis Sets

redis sets是无序字符串列表。SADD命令添加新的元素到set，set也有很多操作，比如测试一个元素是否存在，获取多个sets的交集或者并集，等等。

```plain
> sadd myset 1 2 3
(integer) 3
> smembers myset
1. 3
2. 1
3. 2
```
这里我有三个元素并且告诉redis返回所有元素，你可以看到返回结果并未排序。redis在每一次调用时都能随意以任何顺序返回这些元素，因为set不对用户保证返回一定会有序。
redis有检测是否是成员的指令。例如，检测是否一个元素存在：

```plain
> sismember myset 3
(integer) 1
> sismember myset 30
(integer) 0
```
3是set成员，而30不是
展示objects之间的关系用sets是方便的。例如我们很容易用sets实现标签。

模拟这个问题的一个简单方法就是有一个我们想要标记的每一个物体的集合。这个集合包含物体标签的ID。

一个例子是为新闻文章添加标签。如果一个ID为1000的文章被标记着1，2，5，77。集合可以讲这些标记ID和新闻项相关联。

```plain
> sadd news:1000:tags 1 2 5 77
(integer) 4
```
我们可能也想获得相反的关系：一个指定标签下的新闻项列表
```plain
> sadd tag:1:news 1000
(integer) 1
> sadd tag:2:news 1000
(integer) 1
> sadd tag:5:news 1000
(integer) 1
> sadd tag:77:news 1000
(integer) 1
```
获取给定对象的所有标记非常简单
```plain
> smembers news:1000:tags
1. 5
2. 1
3. 77
4. 2
```
注意：这个例子中我们假设你有另一个数据结构，比如一个redis hash，可以映射标记IDs到标记names。
执行一些繁琐的操作用redis命令也是比较简单的。比如我们想要一些被标记了1、2、10和77的新闻项。我们可以用sinter指令去做，可以获得不同集合的交集。可以用：

```plain
> sinter tag:1:news tag:2:news tag:10:news tag:27:news
... results here ...
```
除了交集，你还可以执行并集、差集，甚至获取一个随机的元素，等等。
获取一个随机元素的命令是SPOP，很适合于某些问题。例如实现一种网上扑克牌，你可能想用一个set代替你的卡组。想象我们用一个字符的前缀表示C（clubs黑桃）、D（diamonds方块）、H（hearts红心）、S（spades梅花）：

```plain
>  sadd deck C1 C2 C3 C4 C5 C6 C7 C8 C9 C10 CJ CQ CK
D1 D2 D3 D4 D5 D6 D7 D8 D9 D10 DJ DQ DK H1 H2 H3
H4 H5 H6 H7 H8 H9 H10 HJ HQ HK S1 S2 S3 S4 S5 S6
S7 S8 S9 S10 SJ SQ SK
(integer) 52
```
现在我们给每个玩家发5张牌。通过SPOP命令移除一个随机的元素，返回个客户端，这个命令就是这个例子中的完美操作。
然而如果我们直接对着卡牌调用它，下一次再玩的时候我们需要再次填充卡牌，那不是理想的。所以为了能直接开始，我们可以做一个这个set的拷贝，存储卡牌在game:1:deck:key下

这可以通过SUNIONSYORE命令完成，这个命令是获取多个set的并集并把结果存储在另一个集合中。既然并集就是集合本身，那么就能拷贝卡组用下面命令：

```plain
> sunionstore game:1:deck deck
(integer) 52
```
现在可以给第一个玩家发5张牌了：
```plain
> spop game:1:deck
"C6"
> spop game:1:deck
"CQ"
> spop game:1:deck
"D1"
> spop game:1:deck
"CJ"
> spop game:1:deck
"SJ"
```
一个对，牌不算好。。。
然后就能介绍提供set内的元素数量的命令了，在关于set理论的文章中，这通常被叫做set的基数，对应的redis命令是SCARD

```plain
> scard game:1:deck
(integer) 47
```
简单的数学公式：52-5=47
如果你只想要获得随机的元素而不把它们移出set中，更合适的命令是SRANDMENMBER。它也意味着可能会返回重复的元素。

### Redis Sorted Sets

sorted sets是一种类似于Set和Hash混合体的数据类型。它的元素和set一样，也是由不同元素组成的，不重复的字符串元素，某种意义上sorted set是和set一样的。

然而sets内部的元素是无序的，sorted set中的每一个元素是联系着一个浮点数值，这个数值就是分数（这是为什么sorted sets类似hash类型的，因为每个元素都匹配着一个分数）

sorted sets中的元素是按序排列的（它们不是按照请求排序的，顺序是这个数据结构的一种特性，代表着sorter sets）。他们的顺序是根据下面的规则排列的：

* 如果A和B是两个有不同分数的元素，如果A.score>B.score，那么A>B
* 如果A和B恰好分数相同，那么当A在字典序上在B之前时，A>B。A和B字符串不能是相等的，因为sorted sets只能用不同的元素

让我们开始一个简单的例子，添加几个黑客的名称作为sorted sets元素，把他们的出生年份作为score

```plain
> zadd hackers 1940 "Alan Kay"
(integer) 1
> zadd hackers 1957 "Sophie Wilson"
(integer) 1
> zadd hackers 1953 "Richard Stallman"
(integer) 1
> zadd hackers 1949 "Anita Borg"
(integer) 1
> zadd hackers 1965 "Yukihiro Matsumoto"
(integer) 1
> zadd hackers 1914 "Hedy Lamarr"
(integer) 1
> zadd hackers 1916 "Claude Shannon"
(integer) 1
> zadd hackers 1969 "Linus Torvalds"
(integer) 1
> zadd hackers 1912 "Alan Turing"
(integer) 1
```
能看出来ZADD类似于SADD，但是多了一个额外的参数（被添加的元素之前展示的那个），那就是score。ZADD也是可变参数，所以可以一次性添加多个score-value对，虽然上述例子中未能使用。
执行提示：sorted sets内部是一个有跳表和哈希表组成的双端口的数据结构，所以每一次我们添加一个元素的时间复杂度为O(log(N))。但是当我们请求排序的数据的时候，redis就不用做额外的工作了，数据已经排好序了。

```plain
> zrange hackers 0 -1
1) "Alan Turing"
2) "Hedy Lamarr"
3) "Claude Shannon"
4) "Alan Kay"
5) "Anita Borg"
6) "Richard Stallman"
7) "Sophie Wilson"
8) "Yukihiro Matsumoto"
9) "Linus Torvalds"
```
提示：0和-1意味着从元素索引0到最后一个元素（-1在这里的作用和在LRANGE命令中的作用是一样的）
如果我想要用相反的方式排序他们呢，获得更年轻的顺序而不是更老的？只需用ZRERANGE代替ZRANGE：

```plain
> zrevrange hackers 0 -1
1) "Linus Torvalds"
2) "Yukihiro Matsumoto"
3) "Sophie Wilson"
4) "Richard Stallman"
5) "Anita Borg"
6) "Alan Kay"
7) "Claude Shannon"
8) "Hedy Lamarr"
9) "Alan Turing"
```
也可以返回分数，用withscores参数：
```plain
> zrange hackers 0 -1 withscores
1) "Alan Turing"
2) "1912"
3) "Hedy Lamarr"
4) "1914"
5) "Claude Shannon"
6) "1916"
7) "Alan Kay"
8) "1940"
9) "Anita Borg"
10) "1949"
11) "Richard Stallman"
12) "1953"
13) "Sophie Wilson"
14) "1957"
15) "Yukihiro Matsumoto"
16) "1965"
17) "Linus Torvalds"
18) "1969"
```
#### Operating on ranges

sorted sets在这方面是更有效的。它们可以根据范围操作。让我们获得出生在1950年之前的人。我们用ZRANGEBYSCORE命令实现它。

```plain
> zrangebyscore hackers -inf 1950
1) "Alan Turing"
2) "Hedy Lamarr"
3) "Claude Shannon"
4) "Alan Kay"
5) "Anita Borg"
```
我们请求redis返回负无穷大到1950年之间的元素（边界被包括在内）
也可以根据范围移除元素。让我们移除1940和1960间的黑客。

```plain
> zremrangebyscore hackers 1940 1960
(integer) 4
```
zremrangebyscore可能不是最好的命令名称，但是它是非常有用的，并且返回移除元素的数量。
另一个有用的操作是获取排名。有可能我们会去查找有序元素集合中一个元素的位置。

```plain
> zrank hackers "Anita Borg"
(integer) 4
```
类似的，zrevrange可以用于获取倒序时的排名
#### Lexicographical scores

在redis2.8的版本，一个新的特性加入了，就是允许按照字典序获取范围，假设一个sorted set中的元素插入时是完全相同的分数（元素与C memcmp函数进行比较，因此保证没有排序规则，每个Redis实例都会以相同的输出进行应答）

通过字典序操作的主要命令是ZRANGEBYLEX，ZREVRANGEBYLEX，ZREMRANGEBYLEX和ZLEXCOUNT

例如，我们再次加入著名黑客列表，但是这一次所有元素分数都设为0。

```plain
> zadd hackers 0 "Alan Kay" 0 "Sophie Wilson" 0 "Richard Stallman" 0
  "Anita Borg" 0 "Yukihiro Matsumoto" 0 "Hedy Lamarr" 0 "Claude Shannon"
  0 "Linus Torvalds" 0 "Alan Turing"
```
因为这种排序规则，它们已经按照字典序排列了。
```plain
> zrange hackers 0 -1
1) "Alan Kay"
2) "Alan Turing"
3) "Anita Borg"
4) "Claude Shannon"
5) "Hedy Lamarr"
6) "Linus Torvalds"
7) "Richard Stallman"
8) "Sophie Wilson"
9) "Yukihiro Matsumoto"
```
使用ZRANGEBYLEX我们可以访问字典序范围：
```plain
> zrangebylex hackers [B [P
1) "Claude Shannon"
2) "Hedy Lamarr"
3) "Linus Torvalds"
```
ranges可以被包含或者排除（依据第一个字符），字符串正无穷和负无穷可以用+和-指定。可以从文档中查看更多信息。
这个特色是重要的，因为它允许我们像一个一般的索引一样使用sorted sets。例如，如果你想要通过一个128bit的无符号整数参数索引元素，你所需要做的就是添加元素到sorted sets中，用同样的分数（例如0），但是有一个16字节的前缀，由128位的大端数字组成。由于数字是大端，字典序事实上是数字排序，你可以请求128位空间的范围，并获得丢弃前缀的元素值。

#### 
