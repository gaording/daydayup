package pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-12 10:51
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-12 gaorunding v1.0.0 修改原因
 */
public class RedisConsumer {
    public static void main(String[] args) {
        Jedis jedis=new Jedis();
        JedisPubSub jedisPubSub= new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.println(String.format("从频道%s接收到消息%s",channel,message));
            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                super.onSubscribe(channel, subscribedChannels);
                System.out.println(String.format("订阅了频道%s，总订阅数%d",channel,subscribedChannels));
            }

            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
                super.onUnsubscribe(channel, subscribedChannels);
                System.out.println(String.format("取消订阅频道%s，总订阅数%d",channel,subscribedChannels));
            }

            @Override
            public void unsubscribe() {
                super.unsubscribe();
                System.out.println("取消订阅");
            }

            @Override
            public void unsubscribe(String... channels) {
                super.unsubscribe(channels);
                System.out.println(String.format("取消订阅频道%s",channels));
            }

            @Override
            public void subscribe(String... channels) {
                super.subscribe(channels);
                System.out.println(String.format("订阅频道%s",channels));
            }
        };
        jedis.subscribe(jedisPubSub,"test","test1","test2");
    }
}
