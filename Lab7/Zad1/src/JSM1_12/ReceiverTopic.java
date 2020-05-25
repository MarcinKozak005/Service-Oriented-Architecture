package JSM1_12;

import Other.ForumManager;
import Other.ForumManagerAPI;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.faces.bean.ManagedBean;
import javax.jms.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "java:/jms/topic/SOA_Test"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Topic")
})
public class ReceiverTopic implements MessageListener {

    @EJB
    ForumManagerAPI forumManagerAPI;

    public void onMessage(Message message) {
        TextMessage textMessage = null;
        try {
            if(message instanceof MapMessage){
                String operation = ((MapMessage) message).getString("operation");
                if(operation.equals("createForumTopic"))
                {
                    String topicName = ((MapMessage) message).getString("message");
                    forumManagerAPI.addForum(topicName);
                    forumManagerAPI.printForumTopicsNames();
                }
            }
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
