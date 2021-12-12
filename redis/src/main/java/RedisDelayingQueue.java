import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.UUID;

/**
 *
 * @program: daydayup
 * @description: 延时队列
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-28 20:45
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-28 gaorunding v1.0.0 修改原因
 */
public class RedisDelayingQueue<T> {
    static class TaskItem<T> {
        public String id;
        public T msg;
    }

    private Jedis jedis;
    private String queueKey;

    public RedisDelayingQueue(Jedis jedis, String queueKey) {
        this.jedis = jedis;
        this.queueKey = queueKey;
    }

    public void delay(T msg) {
        TaskItem<T> task = new TaskItem<>();
        //分配唯一的uuid
        task.id = UUID.randomUUID().toString();
        task.msg = msg;
        //fastjson序列化
        String s = JSON.toJSONString(task);
        //塞入延时队列，5秒后在伐
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, s);
    }

    public void loop() {
        while (!Thread.interrupted()) {
            //只取一条
            Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String s=values.iterator().next();
            if (jedis.zrem(queueKey,s)>0){
                //fastjson反序列化
                TaskItem task=JSON.parseObject(s,TaskItem.class);
                handleMsg(task);
            }
        }
    }

    private void handleMsg(TaskItem taskItem){
        System.out.println(taskItem.msg);
    }

    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost",6379);
        RedisDelayingQueue queue=new RedisDelayingQueue(jedis,"q-demo");
        Thread producer= new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.delay("codehole"+i);
            }
        });
        Thread consumer= new Thread(() -> queue.loop());
        producer.start();
        consumer.start();
        try {
            //主线程阻塞等待子线程结束
            producer.join();
            Thread.sleep(6000);
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
