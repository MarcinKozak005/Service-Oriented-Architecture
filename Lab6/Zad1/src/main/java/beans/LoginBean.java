package beans;

import api.ReaderAPI;
import lombok.Getter;
import lombok.Setter;
import model.Reader;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "LoginBean")
@ViewScoped
@Getter
@Setter
public class LoginBean {

    @EJB
    ReaderAPI readerAPI;

    String name;
    String surname;


    public void logIn()
    {
        List<Reader> readerList = readerAPI.getAllReaders();
        Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        boolean loggedIn = false;
        for(Reader reader: readerList)
        {
            if (reader.getReader_name().equals(name) && reader.getReader_surname().equals(surname))
            {
                loggedIn = true;
                sessionMap.put("userId",reader.getReader_id());
                sessionMap.put("user", name);
                sessionMap.put("userObj",reader);
                sessionMap.put("loggedIn", true);
            }
        }
        if(!loggedIn)
            FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage("Incorrect logging data"));
    }

}
