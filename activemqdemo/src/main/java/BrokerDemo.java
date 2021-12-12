import org.apache.activemq.broker.BrokerService;

/**
 *
 * @program: daydayup
 * @description: broker就代表activemq实例
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-23 11:57
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-23 gaorunding v1.0.0 修改原因
 */
public class BrokerDemo {
    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
