package JSM2_0;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "TestBean")
@ViewScoped
public class TestBean {
    QueueSender queueSender = new QueueSender();
    QueueReceiver queueReceiver = new QueueReceiver();

    public void sendMessage(String msg){
        queueSender.sendMessage(msg);
    }

    public void receiveMessage()
    {
        queueReceiver.receiveMessage();
    }
}
