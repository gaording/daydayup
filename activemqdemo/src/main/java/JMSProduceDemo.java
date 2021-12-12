import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-22 12:21
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-22 gaorunding v1.0.0 修改原因
 */
public class JMSProduceDemo {
    public static final String QUEUE_NAME = "queue1";
    public static final String TOPIC_NAME = "topic1";


    public static void main(String[] args) throws JMSException {
        //1。创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setAlwaysSyncSend(true);
        //2。开启连接
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3。创建会话
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        //4。创建指定queue的生产者
        //queue
        Destination destination = session.createQueue(QUEUE_NAME);
        //ttopic
//        Destination destination=session.createTopic(TOPIC_NAME);
        ActiveMQMessageProducer messageProducer = (ActiveMQMessageProducer) session.createProducer(destination);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //5。发送消息
        for (int i = 0; i < 10; i++) {
            String msgId = "msg--" + i;
            TextMessage textMessage = session.createTextMessage(msgId);
            textMessage.setJMSMessageID(msgId);
            messageProducer.send(textMessage, new AsyncCallback() {
                @Override
                public void onSuccess() {
                    System.out.println(msgId + "发送成功");
                }

                @Override
                public void onException(JMSException e) {
                    System.out.println(msgId + "发送失败");
                }
            });
            MapMessage message = session.createMapMessage();
            message.setString("k" + i, "v" + i);
            messageProducer.send(message);
        }
        //6.关闭资源
        messageProducer.close();
        session.close();
        connection.close();


    }
}
