package OldExample;

import javax.jms.*;
import javax.naming.InitialContext;

public class Odbiorca {
    public static void main(String[] args) {
        try{
            InitialContext ctx = new InitialContext();
            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");
            QueueConnection con = f.createQueueConnection();
            con.start();

            QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue t =(Queue)ctx.lookup("SOA_test");

            QueueReceiver receiver = ses.createReceiver(t);

            MyListener listener = new MyListener();

            receiver.setMessageListener(listener);

            System.out.println("Jestem gotowy dostać komunikat");
            while (true){
                Thread.sleep(1000);
            }

        }catch (Exception e)
        {e.printStackTrace();}
    }
}
