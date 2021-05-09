import lombok.AllArgsConstructor;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description: redis漏斗限流
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-09 15:25
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-09 gaorunding v1.0.0 修改原因
 */
@AllArgsConstructor
public class RedisCellDistributedRateLimiter {
    private Jedis jedis;
    private String key;
    private int period;
    private int maxCapacity;

    public boolean tryAcquire(int quote){
        List<String> keys=new ArrayList<>();
        keys.add(key);
        List<String> argvs= Arrays.asList(String.valueOf(maxCapacity),
                String.valueOf(maxCapacity),String.valueOf(period),
                String.valueOf(quote));
        List<Long> result = (List<Long>) jedis.eval(LUA_SCRIPT, keys, argvs);
        return result.get(0)==0;
    }

    public static final String LUA_SCRIPT="local key= KEYS[1]\n" +
            "local init_burst=tonumber(ARGV[1])\n" +
            "local max_burst = tonumber(ARGV[2])\n" +
            "local period = tonumber(ARGV[3])\n" +
            "local quota=ARGV[4]\n" +
            "return redis.call('CL.THROTTLE',key,init_burst,max_burst,period,quota)";


    public static void main(String[] args) {
        Jedis jedis=new Jedis();
        String key="redis-cell-test";
        int period=5;
        int maxCapacity=1;
        RedisCellDistributedRateLimiter limiter=new RedisCellDistributedRateLimiter(jedis,key,period,maxCapacity);
        for (;;){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (limiter.tryAcquire(1)){
                System.out.println("通过限流");
            }else {
                System.out.println("无法通过");
            }
        }
    }
}
