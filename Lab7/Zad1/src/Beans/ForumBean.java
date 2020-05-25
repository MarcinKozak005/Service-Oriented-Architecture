package Beans;

import Model.ForumTopic;
import Model.User;
import Other.ForumManagerAPI;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "ForumBean")
public class ForumBean {
    @EJB
    ForumManagerAPI forumManagerAPI;

    public List<ForumTopic> getTopics()
    {
        return forumManagerAPI.getForumTopics();
    }

    public void removeMyNotifications(User user)
    {
        user.getNotifications().clear();
    }

    public List<User> getUsers(){
        return forumManagerAPI.getUserList();
    }

    public List<User> getUsersWithoutMe(User user)
    {
        List tmp = new LinkedList<User>(getUsers());
        tmp.remove(user);
        return tmp;
    }

    public void sendMsg(User u1, String msg, User u2){
        forumManagerAPI.addMessage(u1,msg,u2);
    }

}
