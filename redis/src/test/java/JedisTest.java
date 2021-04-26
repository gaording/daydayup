import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: jedis测试
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-19 09:50
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-19 gaorunding v1.0.0 修改原因
 */
public class JedisTest {

    private static Jedis jedis;

    @Before
    public void initJedis() {
        jedis = new Jedis("127.0.0.1", 6379,0);
    }

    //jedis string、list、set、hash、zset
    @Test
    public void test1() {
        //string
        jedis.mset("k5", "v5", "k6", "v6", "k7", "v7");
        System.out.println(jedis.mget("k5", "k6", "k7"));
        //list
        jedis.lpush("list1", "12", "34", "56");
        List<String> list = jedis.lrange("list1", 0, -1);
        list.forEach(System.out::println);
        //set
        jedis.sadd("set1", "v1", "v1", "v2", "v3");
        Set<String> stringSet = jedis.smembers("set1");
        stringSet.forEach(System.out::println);
        //hash
        jedis.hset("hash1", "username", "grd");
        System.out.println(jedis.hget("hash1", "username"));
        Map<String, String> map = new HashMap<>();
        map.put("telephone", "13795889786");
        map.put("address", "atguigu");
        map.put("email", "abc@163.com");
        jedis.hmset("hash2", map);
        List<String> result = jedis.hmget("hash2", "telephone", "address");
        result.forEach(System.out::println);
        //zset
        jedis.zadd("zset1", 60d, "v1");
        jedis.zadd("zset1", 70d, "v2");
        jedis.zadd("zset1", 80d, "v3");
        jedis.zadd("zset1", 90d, "v4");
        Set<String> s1 = jedis.zrange("zset1", 0, -1);
        s1.forEach(System.out::println);

    }

    //事务
    @Test
    public void testTx() {
        int balance;
        int debt;
        int amtToSubtract = 10;
        jedis.watch("balance");
        Transaction transaction = jedis.multi();
        transaction.set("balance", "10");
        transaction.incrBy("debt", amtToSubtract);
        List list= transaction.exec();
        System.out.println(list);
        balance = Integer.parseInt(jedis.get("balance"));
        debt = Integer.parseInt(jedis.get("debt"));
        System.out.println("balance-------" + balance);
        System.out.println("debt-------" + debt);
    }

    //主从
    @Test
    public void testMS(){
        Jedis jedis_S=new Jedis("127.0.0.1",6380);
        jedis_S.slaveof("127.0.0.1",6379);
    }

    //pub/sub
    @Test
    public void testPS(){
        JedisPubSub jedisPubSub=new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.println("-----channel:"+channel+"----message:"+message);
            }

            @Override
            public void onPMessage(String pattern, String channel, String message) {
                super.onPMessage(pattern, channel, message);
                System.out.println("----pattern:"+pattern+"-----channel:"+channel+"----message:"+message);
            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                System.out.println("订阅了channel----"+channel+"---订阅频道数---"+subscribedChannels);
                super.onSubscribe(channel, subscribedChannels);
            }

            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
                super.onUnsubscribe(channel, subscribedChannels);
            }

            @Override
            public void onPUnsubscribe(String pattern, int subscribedChannels) {
                super.onPUnsubscribe(pattern, subscribedChannels);
            }

            @Override
            public void onPSubscribe(String pattern, int subscribedChannels) {
                System.out.println("订阅了正则模式channel----"+pattern+"---订阅频道数---"+subscribedChannels);
                super.onPSubscribe(pattern, subscribedChannels);
            }

            @Override
            public void unsubscribe() {
                super.unsubscribe();
            }

            @Override
            public void unsubscribe(String... channels) {
                super.unsubscribe(channels);
            }

            @Override
            public void subscribe(String... channels) {
                super.subscribe(channels);
            }

            @Override
            public void psubscribe(String... patterns) {
                super.psubscribe(patterns);
            }

            @Override
            public void punsubscribe() {
                super.punsubscribe();
            }

            @Override
            public void punsubscribe(String... patterns) {
                super.punsubscribe(patterns);
            }
        };
        Jedis testJedis=TestOneJedisClient.getJedis();
        //只有第一个订阅会生效，后面两个都无效
        jedisPubSub.proceed(testJedis.getClient(),"foo");
        jedisPubSub.proceedWithPatterns(testJedis.getClient(),"f*");
        jedisPubSub.proceed(testJedis.getClient(),"goo");

    }

    //pub/sub
    @Test
    public void testPS2(){
        JedisPubSub jedisPubSub=new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.println("-----channel:"+channel+"----message:"+message);
            }

            @Override
            public void onPMessage(String pattern, String channel, String message) {
                super.onPMessage(pattern, channel, message);
                System.out.println("----pattern:"+pattern+"-----channel:"+channel+"----message:"+message);
            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                System.out.println("订阅了channel----"+channel+"---订阅频道数---"+subscribedChannels);
                super.onSubscribe(channel, subscribedChannels);
            }

            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
                super.onUnsubscribe(channel, subscribedChannels);
            }

            @Override
            public void onPUnsubscribe(String pattern, int subscribedChannels) {
                super.onPUnsubscribe(pattern, subscribedChannels);
            }

            @Override
            public void onPSubscribe(String pattern, int subscribedChannels) {
                System.out.println("订阅了正则模式channel----"+pattern+"---订阅频道数---"+subscribedChannels);
                super.onPSubscribe(pattern, subscribedChannels);
            }

            @Override
            public void unsubscribe() {
                super.unsubscribe();
            }

            @Override
            public void unsubscribe(String... channels) {
                super.unsubscribe(channels);
            }

            @Override
            public void subscribe(String... channels) {
                super.subscribe(channels);
            }

            @Override
            public void psubscribe(String... patterns) {
                super.psubscribe(patterns);
            }

            @Override
            public void punsubscribe() {
                super.punsubscribe();
            }

            @Override
            public void punsubscribe(String... patterns) {
                super.punsubscribe(patterns);
            }
        };
        Jedis testJedis=TestOneJedisClient.getJedis();
        //只有第一个订阅会生效，后面两个都无效
        jedisPubSub.proceed(testJedis.getClient(),"goo");
        jedisPubSub.proceed(testJedis.getClient(),"foo");
        jedisPubSub.proceedWithPatterns(testJedis.getClient(),"f*");

    }




}
