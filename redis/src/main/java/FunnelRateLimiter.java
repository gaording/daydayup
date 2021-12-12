import java.util.HashMap;
import java.util.Map;

/**
 *
 * @program: daydayup
 * @description: 漏斗限流
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-09 13:22
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-09 gaorunding v1.0.0 修改原因
 */
public class FunnelRateLimiter {
    static class Funnel{
        int capacity;
        float leakingRate;
        int leftQuota;
        long leakingTs;

        public Funnel(int capacity,float leakingRate){
            this.capacity=capacity;
            this.leakingRate=leakingRate;
            this.leftQuota=capacity;
            this.leakingTs=System.currentTimeMillis();
        }

        void makeSpace(){
            long nowTs=System.currentTimeMillis();
            long deltaTs=nowTs-leakingTs;
            int deltaQuota= (int) (deltaTs*leakingRate);
            //间隔时间太长，整数数字过大溢出
            if (deltaQuota<0){
                leftQuota=capacity;
                leakingTs=nowTs;
                return;
            }
            //腾出空间太小，最小单位是1
            if (deltaQuota<1){
                return;
            }
            leftQuota+=deltaQuota;
            leakingTs=nowTs;
            if (leftQuota>capacity){
                leftQuota=capacity;
            }
        }

        boolean watering(int quota){
            makeSpace();
            if (this.leftQuota>=quota){
                this.leftQuota-=quota;
                return true;
            }
            return false;
        }
    }

    private Map<String,Funnel> funnels=new HashMap<>();
    public boolean isActionAllowed(String userId,String actionKey,int capacity,float leakingRate){
        String key=String.format("%s:%s",userId,actionKey);
        Funnel funnel=funnels.get(key);
        if (funnel==null){
            funnel=new Funnel(capacity,leakingRate);
            funnels.put(key,funnel);
        }
        return funnel.watering(1);
    }
}
