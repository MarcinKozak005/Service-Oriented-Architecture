package Model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {
    String userName;
    List<ForumTopic> observedTopics = new LinkedList<ForumTopic>();
    List<String> notifications = new LinkedList<String>();

    Map<User,List<String>> conversations = new HashMap<User, List<String>>();

    public User(String userName) {
        this.userName = userName;
    }

    public void observe(ForumTopic topic)
    {
        observedTopics.add(topic);
    }

    public boolean isObserving(ForumTopic topic){
        return observedTopics.contains(topic);
    }

    public void unobserve(ForumTopic topic) {
        observedTopics.remove(topic);
    }

    public void addNotification(String message){
        this.notifications.add(message);
    }
}
