package OldExample;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyListener implements MessageListener {
    public void onMessage(Message m) {
        try{
            TextMessage msg = (TextMessage)m;
            System.out.println("Otrzymałem: "+msg.getText());
        }catch (Exception e)
        {e.printStackTrace();}
    }
}
