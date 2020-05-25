package JSM2_0;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Topic;
import java.net.InetAddress;
import java.net.UnknownHostException;

@ManagedBean(name = "Receiver")
@Stateless
public class QueueReceiver {

    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:/jms/topic/SOA_Test")
    Destination myQueue;

    public String receiveMessage(){
        try {
            context.setClientID(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String message = context.createDurableConsumer((Topic) myQueue,"R1").receiveBody(String.class);
        if(message == null)
            message = "Queue is empty";
        System.out.println(message+"- in receiverQueue");
        return message;
    }
}
