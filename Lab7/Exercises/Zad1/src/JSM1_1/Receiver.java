package JSM1_1;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/SOA_test")
})
public class Receiver implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = null;
        try {
            if(message instanceof TextMessage){
                textMessage = (TextMessage) message;
                String txt = textMessage.getText();
                System.out.println(txt+" second one");
            }
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
