package JSM1_1;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.jms.*;

@ManagedBean(name = "Sender1")
@Stateless
public class Sender1{

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;
    @Resource(mappedName = "java:/jms/queue/SOA_test")
    private Queue queue;


    public void sendMessage()
    {
        try {
            Connection conn = cf.createConnection();
            Session session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(queue);
            TextMessage msg = session.createTextMessage();
            msg.setText(this.toString());
            producer.send(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
