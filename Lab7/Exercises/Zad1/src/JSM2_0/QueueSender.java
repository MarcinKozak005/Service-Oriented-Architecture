package JSM2_0;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.jms.*;

@ManagedBean(name = "Sender")
@ViewScoped
public class QueueSender {
    @Resource(mappedName = "java:/jms/topic/SOA_Test")
    private Destination queueTest;

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory cf;

    public void sendMessage(String txt){
        try {
            System.out.println("Preparing to sending ...");
            Session session = cf.createConnection().createSession(false,Session.AUTO_ACKNOWLEDGE);
            TextMessage msg = session.createTextMessage(txt);
            session.createProducer(queueTest).send(msg);
            System.out.println("Sent");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
