import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: 简单限流
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-09 11:59
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-09 gaorunding v1.0.0 修改原因
 */
public class SimpleRateLimiter {
    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis){
        this.jedis=jedis;
    }

    public boolean isActionAllowed(String userId,String actionKey,int period,int maxCount) throws IOException {
        String key=String.format("hist:%s:%s",userId,actionKey);
        long nowTs=System.currentTimeMillis();
        Pipeline pipe=jedis.pipelined();
        pipe.multi();
        pipe.zadd(key,nowTs,""+nowTs);
        pipe.zremrangeByScore(key,0,nowTs-period*1000);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key,period+1);
        pipe.exec();
        pipe.close();
        return count.get()<=maxCount;
    }

    public static void main(String[] args) throws IOException {
        Jedis jedis=new Jedis("localhost",6379);
        System.out.println(jedis.getDB());
        SimpleRateLimiter limiter=new SimpleRateLimiter(jedis);
        for (int i = 0; i < 20; i++) {
            System.out.println(limiter.isActionAllowed("laoqian","replay",60,5));
        }
    }
}
