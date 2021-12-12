import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
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
public class JMSProduceDemo_Topic_Persist {
    public static final String TOPIC_NAME = "topic1";


    public static void main(String[] args) throws JMSException {
        //1。创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        //2。开启连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //3。创建会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //4。创建指定queue的生产者
        //ttopic
        Destination destination = session.createTopic(TOPIC_NAME);
        MessageProducer messageProducer = session.createProducer(destination);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        //5。发送消息
        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = session.createTextMessage("msg--" + i);
            messageProducer.send(textMessage);
            MapMessage message = session.createMapMessage();
            message.setString("k" + i, "v" + i);
            messageProducer.send(message);
        }
        session.commit();
        //6.关闭资源
        messageProducer.close();
        session.close();
        connection.close();


    }
}
