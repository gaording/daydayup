import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 * @program: daydayup
 * @description: jedis连接池
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-20 14:32
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-20 gaorunding v1.0.0 修改原因
 */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool=null;

    private JedisPoolUtil(){

    }

    public static JedisPool getInstance(){
        if (jedisPool==null){
            synchronized (JedisPoolUtil.class){
                if (jedisPool==null){
                    GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
                    poolConfig.setMaxTotal(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool=new JedisPool(poolConfig,"localhost",6379,20000);
                }
            }
        }
        return jedisPool;
    }

    public static void release(Jedis jedis){
        if (null!=jedisPool&&null!=jedis){
            jedisPool.returnBrokenResource(jedis);
        }
    }
}
