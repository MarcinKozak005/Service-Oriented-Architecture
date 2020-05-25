package JSM1_12;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.faces.bean.ManagedBean;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "java:/jms/topic/SOA_Test"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Topic")
})
public class ReceiverTopic implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = null;
        try {
            if(message instanceof TextMessage){
                textMessage = (TextMessage) message;
                String txt = textMessage.getText();
                System.out.println(txt+" Topic has been received by "+this.toString());
            }
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
