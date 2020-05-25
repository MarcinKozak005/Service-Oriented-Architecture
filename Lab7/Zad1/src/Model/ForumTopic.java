package Model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class ForumTopic {
    String name;
    List<String> posts = new LinkedList<String>();
    List<User> observers = new LinkedList<User>();

    public void observe(User user)
    {
        observers.add(user);
        user.observe(this);
    }

    public void unobserve(User user)
    {
        observers.remove(user);
        user.unobserve(this);
    }

    public void sendMessage(String message){
        posts.add(message);
        for (User user: observers)
            user.addNotification(this.name+" "+message);
    }

    public String showObservers()
    {
        StringBuilder sb = new StringBuilder();
        for(User u: observers){
            sb.append(u.userName).append(" ");
        }
        return sb.toString();
    }
}
