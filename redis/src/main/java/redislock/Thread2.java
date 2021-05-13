package redislock;

import redis.clients.jedis.Jedis;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-13 14:36
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-13 gaorunding v1.0.0 修改原因
 */
public class Thread2 {
    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis();
        String lockName = "lock";
        String lockValue = Thread2.class.getName();
        String result = jedis.set(lockName, lockValue, "nx", "ex", 10);
        if ("OK".equals(result)) {
            //业务处理
            Object o = jedis.eval("local lockKey=KEYS[1]\n" +
                    "local lockValue=KEYS[2]\n" +
                    "\n" +
                    "--get key\n" +
                    "local result_1=redis.call('get',lockKey)\n" +
                    "if result_1==lockValue\n" +
                    "then\n" +
                    "    local result_2=redis.call('del',lockKey)\n" +
                    "    return result_2\n" +
                    "else\n" +
                    "    return false\n" +
                    "end", 2, lockName, lockValue);
            System.out.println(o);
        }else {
            System.out.println("获取锁失败:"+result);
        }
    }
}
