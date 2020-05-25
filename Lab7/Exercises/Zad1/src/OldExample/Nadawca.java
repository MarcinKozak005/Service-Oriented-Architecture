package OldExample;

import javax.jms.*;
import javax.naming.InitialContext;

public class Nadawca {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup("QueueConnectionFactory");
            QueueConnection con = f.createQueueConnection();
            con.start();

            QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue t = (Queue)ctx.lookup("SOA_test"); // TODO ten lookup co szuka?
            QueueSender sender = ses.createSender(t);

            TextMessage msg = ses.createTextMessage();
            msg.setText("Ala ma kotka");

            sender.send(msg);
            System.out.println("Kominikat wysłany");
            con.close();
        }
        catch (Exception e)
        {e.printStackTrace();}
    }
}
