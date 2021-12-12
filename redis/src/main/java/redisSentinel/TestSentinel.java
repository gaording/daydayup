package redisSentinel;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-14 15:53
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-14 gaorunding v1.0.0 修改原因
 */
public class TestSentinel {
    static JedisSentinelPool pool;

    static {
        String masterName="mymaster";
        Set<String> setinels=new HashSet<>();
        setinels.add(new HostAndPort("localhost",26379).toString());
        setinels.add(new HostAndPort("localhost",26380).toString());
        setinels.add(new HostAndPort("localhost",26381).toString());
        GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
        poolConfig.setMaxWaitMillis(1000);
        pool = new JedisSentinelPool(masterName, setinels,poolConfig);
    }

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = null;
        //TODO 这里是main线程和masterListener线程同时操作initpool
        // 导致偶尔获取资源的时候masterListener线程虽然更改了volatile修饰的currentHostPort值，
        // 但是还未能初始化完internalPool，main线程获取资源的时候internalPool为null，出现了npe异常
        // 让主线程sleep 1s，保证internalpool已被初始化完毕，就没这个问题了
        Thread.sleep(1000);
        try {
            jedis = pool.getResource();
            //TODO 还有个问题就是jedis读写分离支持的并不好，要不就自己实现，要不就考虑用集群
            System.out.println(jedis.get("sentinel"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            System.out.println("end");
        }


    }

}
