package Macka;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.jms.*;

@ManagedBean(name = "TopicReceiver")
public class TopicReceiver {
    @Resource(mappedName = "java:jms/topic/SOA_Test")
    Topic topic;
    @Resource
    ConnectionFactory connectionFactory;

    public void receiveMessage() throws JMSException {
        System.out.println(topic.toString());
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        MessageConsumer messageConsumer = session.createConsumer(topic);
        connection.start();
        Message message = messageConsumer.receive(10000);
        while (message!=null){
            System.out.println("Message received "+((TextMessage) message).getText());
            message = messageConsumer.receive(10000);
        }
        connection.close();
    }
}
