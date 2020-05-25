package Macka;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.jms.*;

@ManagedBean(name = "TopicPublisher")
public class TopicPublisher  {
    @Resource(mappedName = "java:/jms/topic/SOA_Test")
    Topic topic;
    @Resource
    ConnectionFactory connectionFactory;

    public void sendMessage (String txt)
    {
        Connection conn = null;
        try{
            conn = connectionFactory.createConnection();
            Session session = conn.createSession();

            MessageProducer publisher = session.createProducer(topic);
            TextMessage msg = session.createTextMessage();
            msg.setText(txt);
            publisher.send(msg);
            System.out.println("Message has been sent");
        }catch (JMSException e){
            e.printStackTrace();
        }

    }
}
