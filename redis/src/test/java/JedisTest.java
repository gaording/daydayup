import org.junit.Test;
import redis.clients.jedis.Jedis;

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

    @Test
    public void test1(){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        //string
        jedis.mset("k5","v5","k6","v6","k7","v7");
        System.out.println(jedis.mget("k5","k6","k7"));
        //list
        jedis.lpush("list1","12","34","56");
        List<String> list= jedis.lrange("list1",0,-1);
        list.forEach(System.out::println);
        //set
        jedis.sadd("set1","v1","v1","v2","v3");
        Set<String> stringSet= jedis.smembers("set1");
        stringSet.forEach(System.out::println);
        //hash
        jedis.hset("hash1","username","grd");
        System.out.println(jedis.hget("hash1","username"));
        Map<String,String> map=new HashMap<>();
        map.put("telephone","13795889786");
        map.put("address","atguigu");
        map.put("email","abc@163.com");
        jedis.hmset("hash2",map);
        List<String> result=jedis.hmget("hash2","telephone","address");
        result.forEach(System.out::println);
        //zset
        jedis.zadd("zset1",60d,"v1");
        jedis.zadd("zset1",70d,"v2");
        jedis.zadd("zset1",80d,"v3");
        jedis.zadd("zset1",90d,"v4");
        Set<String> s1=jedis.zrange("zset1",0,-1);
        s1.forEach(System.out::println);

    }
}
