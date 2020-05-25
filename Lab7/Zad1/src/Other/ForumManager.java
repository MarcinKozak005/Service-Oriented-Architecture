package Other;

import Model.ForumTopic;
import Model.User;

import javax.ejb.Local;
import javax.ejb.Singleton;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Local(ForumManagerAPI.class)
@Singleton
public class ForumManager implements ForumManagerAPI{

    public List<ForumTopic> forumTopicList = new LinkedList<ForumTopic>();
    public List<User> userList = new LinkedList<User>(Arrays.asList(
            new User("Adam"),
            new User("Martha"),
            new User("Joe")));

    public void addForum(String name){
        ForumTopic ft = new ForumTopic();
        ft.setName(name);
        ft.setObservers(new LinkedList<User>());
        ft.setPosts(new LinkedList<String>());
        forumTopicList.add(ft);
    }

    public void printForumTopicsNames()
    {
        for (ForumTopic f: forumTopicList){
            System.out.println(f.getName()+" <- it is a name");
        }
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<ForumTopic> getForumTopics() {
        return forumTopicList;
    }

    public void addMessage(User user, String msg, User user2){
        user.addNotification(user2.getUserName()+" "+msg);
        System.out.println(msg+"<- to jest MSG");

        if (user.getConversations().get(user2) == null){
            List tmpList = new LinkedList<String>();
            tmpList.add(msg);
            user.getConversations().put(user2,tmpList);
        }
        else
            user.getConversations().get(user2).add(msg);
    }
}
