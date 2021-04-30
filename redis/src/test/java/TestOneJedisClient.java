import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 唯一jedis客户端
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-24 16:55
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-24 gaorunding v1.0.0 修改原因
 */
public class TestOneJedisClient {
    private static final Jedis jedis=new Jedis("127.0.0.1", 6379,0);

    public static Jedis getJedis() {
        return jedis;
    }

    @Test
    public void test(){
        System.out.println(2<<2);
    }

}
