import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-22 14:26
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-22 gaorunding v1.0.0 修改原因
 */
public class JMSConsumerDemo2 {
    public static final String QUEUE_NAME = "queue1";
    public static final String TOPIC_NAME = "topic1";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Destination destination = session.createQueue(QUEUE_NAME);
        Destination destination = session.createTopic(TOPIC_NAME);
        MessageConsumer consumer = session.createConsumer(destination);
//        第一种接收消息方式：同步阻塞
//        while (true) {
//            TextMessage receive = (TextMessage) consumer.receive(1000L);
//            if (null != receive) {
//                System.out.println(receive.getText());
//            }else {
//                break;
//            }
//        }
        consumer.setMessageListener(message -> {
            if (message != null && message instanceof TextMessage) {
                try {
                    System.out.println(((TextMessage) message).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();


    }
}
