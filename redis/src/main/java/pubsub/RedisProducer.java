package pubsub;

import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-12 10:46
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-12 gaorunding v1.0.0 修改原因
 */
public class RedisProducer {
    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis();
        String input;
        while (!"end".equals(input = new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            jedis.publish("test", input);
        }
    }
}
