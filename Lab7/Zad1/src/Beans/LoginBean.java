package Beans;

import Model.User;
import Other.ForumManagerAPI;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "LoginBean")
@Getter
@Setter
public class LoginBean {
    @EJB
    ForumManagerAPI forumManagerAPI;

    String name;

    public void logIn()
    {
        List<User> userList = forumManagerAPI.getUserList();
        Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        boolean loggedIn = false;
        for(User user: userList)
        {
            if (user.getUserName().equals(name))
            {
                loggedIn = true;
                sessionMap.put("user", name);
                sessionMap.put("userObj", user);
                sessionMap.put("loggedIn", true);
            }
        }
        if(!loggedIn)
            FacesContext.getCurrentInstance().addMessage("loginForm:loginText", new FacesMessage("Incorrect logging data"));
    }
}
