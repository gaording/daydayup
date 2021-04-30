import java.util.Arrays;
import java.util.BitSet;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-04-29 18:25
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-04-29 gaorunding v1.0.0 修改原因
 * java实现bloomfilter
 */
public class JavaBloomFilter {
    //布隆过滤器容量
    private static final int DEFAULT_SIZE=2<<28;
    //bit数组，用来存放key
    private static BitSet bitSet=new BitSet(DEFAULT_SIZE);
    //后面hash函数会用到，用来生成不同的hash值
    private static final int[] ints={1,6,8,18,28};

    //add方法，计算出key的hash值，并将对应下标置为true
    public void add(Object key){
        Arrays.stream(ints).forEach(i->bitSet.set(hash(key,i)));
    }

    //判断key是否存在
    public boolean isContain(Object key){
        boolean result=true;
        for (int i:ints) {
            result=result&&bitSet.get(hash(key,i));
            if (!result){
                return result;
            }
        }
        return result;
    }

    private int hash(Object key,int i){
        int h;
        return key==null?0:(i*(DEFAULT_SIZE-1)&((h=key.hashCode())^h>>>6));
    }

    public static void main(String[] args) {
        JavaBloomFilter javaBloomFilter=new JavaBloomFilter();
        javaBloomFilter.add("张学友");
        javaBloomFilter.add("郭德纲");
        javaBloomFilter.add("蔡徐坤");
        javaBloomFilter.add("666");
        System.out.println(javaBloomFilter.isContain("张学友"));
        System.out.println(javaBloomFilter.isContain("张学友 "));
        System.out.println(javaBloomFilter.isContain("张学友1"));
        System.out.println(javaBloomFilter.isContain("郭德纲"));
        System.out.println(javaBloomFilter.isContain("rap"));
        System.out.println(javaBloomFilter.isContain("666"));
        System.out.println(javaBloomFilter.isContain("888"));
    }


}
