package JSM1_12;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.jms.*;

@ManagedBean(name = "SenderTopic")
@Stateless
public class SenderTopic {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;
    @Resource(mappedName = "java:/jms/topic/SOA_Test")
    private Topic topic;


    public void sendMessage()
    {
        try {
            Connection conn = cf.createConnection();
            Session session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(topic);
            TextMessage msg = session.createTextMessage();
            msg.setText(this.toString());
            producer.send(msg);
            System.out.println("Topic has been sent");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
