package Other;

import Model.ForumTopic;
import Model.User;

import java.util.List;

public interface ForumManagerAPI {
    void addForum(String forumName);
    void printForumTopicsNames();

    List<User> getUserList();

    List<ForumTopic> getForumTopics();

    void addMessage(User user, String msg, User user2);
}
