# Pub/Sub

subscribe、unsubscribe和publish实现了发布/订阅模式，维基上说明是发布者不用指定发送消息到指定的接收者。发布者只需发布到指定的频道，不需要知道有哪些订阅者。订阅者凭兴趣订阅一个或多个频道，并且只接收订阅频道的消息，而无需知道有哪些发布者。这种模式解藕了发布者和订阅者，使之更具扩展性和伸缩性。

例如为订阅一个foo频道，客户端发送包含频道名称的subscribe命令

```plain
SUBSCRIBE foo bar
```
其它客户端发送给这些频道的消息可以被推送给所有订阅后的客户端。
订阅了频道的客户端不应该发送命令，尽管它可以订阅或者取消订阅。对订阅和取消订阅操作的回复以消息的形式发送，这样客户机就可以读取一致的消息流，其中第一个元素表示消息的类型。一个订阅的客户端中可被允许的指令是SUBSCRIBE、PSUBSCRIBE、UNSUBSCRIBE、PUNSUBSCRIBE、PING和QUIT。

redis-cli一旦进入订阅模式，就不再接收任何指令，退出只能通过Ctrl-C命令。

## Format of pushed messages

一个消息的回复是由三个元素组成的数组形式。

第一个元素是消息的种类：

* subscribe：意味着我们成功订阅了频道，也就是返回的第二个元素。第三个元素表示我们当前订阅的频道的数量。
* unsubscribe：意味着我们成功取消了订阅，返回第二个元素是取消订阅的频道，第三个元素代表我们当前订阅的个数。当第三个参数为0时，代表我们已不再订阅任何一个频道，客户端可以发送包含Pub/Sub在内的任何一种redis命令。
* message：这是接收到另一个客户端调用PUBLISH命令发送的消息，第二个参数是发送的频道的名称，第三个参数才是消息载体。
## Database & Scoping

Pub/Sub和key空间无关，它不在任何层面上受到干扰，包括数据库的数目。

在db 10发布，也可以在db 1接收到。

如果你需要限定一些范围，可以在channels上加上环境前缀，比如test、staging、production。。。

## Wire protocol example

这里就是一个订阅和取消订阅的例子，没搞明白它想表达什么，直接跳过

## Pattern-matching subscriptions

redis Pub/Sub支持模式匹配订阅。客户端可以订阅正则匹配模式来获取所有符合模式匹配的频道中的消息。

例如：

```plain
PSUBSCRIBE news.*
```
我们获取news.art.figurative，news.music.jazz等等，所有匹配模式都是有效的，通配符当然是支持的。
```plain
PUNSUBSCRIBE news.*
```
我们也可以根据通配符模式取消订阅。这个调用中没有其它订阅者被影响。模式订阅的匹配结果接收会以一种不同的形式发送。
* 这种消息的类型是pmessage：也是一个被别的客户端通过publish命令发送的消息，当然发送频道匹配模式。第二个元素是订阅的正则表达式，第三个元素是初始频道的名字，最后一个元素是实际的消息内容。

PSUBSCRIBE和SUBSCRIBE发送订阅消息的格式是一样的，PUNSUBSCRIBE和UNSUBSCRIBE发送取消订阅消息的格式也是一样的。

## Messages matching both a pattern and a channel subscription

一个客户端可能多次收到同一条消息，如果既通过PSUBSCRIBE以通配符的方式订阅了频道，又通过SUBSCRIBE的方式订阅了频道，类似下面这种方式

```plain
SUBSCRIBE foo
PSUBSCRIBE f*
```
那么客户端将收到两次消息，一个类型为message，一个类型为pmessage
## The meaning of the subscription count with pattern matching

在subscribe、unsubscribe、psubscribe和punsunscribe消息类型中，最后的参数是仍活跃的订阅的数量。这个数量事实上是这个客户端仍在订阅的频道和模式的数量。所以当取消订阅让这个数为0时，客户端就会退出Pub/Sub状态。

## Programming example

Pieter Noordhuis提供了一个用eventMachine和redis做多用户高性能很好的例子

## Client library implementation hints

因为所有收到的消息都包含消息分发的原始订阅（消息类型为通道，pmessage类型为原始模式），所以客户端库函数可以使用哈希表将原始订阅绑定到回调（可以是匿名函数、块、函数指针）。









