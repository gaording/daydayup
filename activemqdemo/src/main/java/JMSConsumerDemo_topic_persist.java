import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;
import java.io.IOException;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-22 14:26
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-22 gaorunding v1.0.0 修改原因
 */
public class JMSConsumerDemo_topic_persist {
    public static final String TOPIC_NAME = "topic1";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("*****z3");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("z3");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);

        TopicSubscriber subscriber = session.createDurableSubscriber(topic, "remark");

        connection.start();
        Message receive = subscriber.receive(1000);
        while (null != receive) {
            if (receive instanceof TextMessage) {
                System.out.println(((TextMessage) receive).getText());
            }
            if (receive instanceof MapMessage) {
                System.out.println(((MapMessage) receive).getString("k1"));
            }
            receive = subscriber.receive(1000);
        }
        System.in.read();
        session.close();
        connection.close();


    }
}
