import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @program: daydayup
 * @description: 手动实现bloomfilter
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-29 15:16
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-29 gaorunding v1.0.0 修改原因
 * 用redis的bitset，未用redis-bloom模块
 */
public class Bloomfilter {
    private static final int cap=1<<29;
    private int[] seeds=new int[]{3,5,7,11,13,31,37,61};
    private int hash(String value,int seed){
        int result=0;
        int length=value.length();
        for (int i = 0; i < length; i++) {
            result=seed*result+value.charAt(i);
        }
        return (cap-1)&result;
    }


    private StringRedisTemplate stringRedisTemplate;

    public void multiSetBit(String name,boolean value,long... offsets){
        stringRedisTemplate.executePipelined((RedisCallback<Object>) redisConnection -> {
            for (long offset:offsets){
                redisConnection.setBit(name.getBytes(),offset,value);
            }
            return null;
        });

    }

    public List<Boolean> multiGetBit(String name, long... offsets){
        List<Object> results=stringRedisTemplate.executePipelined((RedisCallback<?>) redisConnection -> {
            for (long offset:offsets){
                redisConnection.getBit(name.getBytes(),offset);
            }
            return null;
        });
        List<Boolean> list=new ArrayList<>();
        results.forEach(item->list.add((Boolean) item));
        return list;
    }

    public void test(String[] args) throws IOException {
        //放入
        FileInputStream inputStream=new FileInputStream("xxxx.csv");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        HashSet<Long> totalSet=new HashSet<>();
        String word;
        while ((word=bufferedReader.readLine())!=null){
            for (int seed:seeds){
                int hash=hash(word,seed);
                totalSet.add((long) hash);
            }
            long[] offsets=new long[totalSet.size()];
            int i=0;
            for (Long l:totalSet){
                offsets[i++]=l;
            }
            multiSetBit("BLOOM_FILTER_WORDS_DICTIONARY",true,offsets);
        }

        //查看
        String getWord="xxxx";
        long[] offsets=new long[seeds.length];
        for (int i = 0; i < seeds.length; i++) {
            int hash=hash(getWord,i);
            offsets[i]=hash;
        }
        List<Boolean> res= multiGetBit("BLOOM_FILTER_WORDS_DICTIONARY",offsets);
        for (Boolean resItem:res) {
            if (!resItem){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
