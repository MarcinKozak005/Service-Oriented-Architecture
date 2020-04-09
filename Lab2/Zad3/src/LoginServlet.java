import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private Vector<User> userVector = new Vector<>();

    public LoginServlet(){
        userVector.add(new User("aaa","111","alaName","alaSurname"));
        userVector.add(new User("bbb","222","bobName","bobSurname"));
        userVector.add(new User("ccc","333","cccName","cccSurname"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User loggingOne = new User(login,password);

        if (login==null || login.equals(""))
        {
            request.setAttribute("errorMessage","Enter login");
            RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
            rs.forward(request,response);
        }
        else if (password==null || password.equals(""))
        {
            request.setAttribute("errorMessage","Enter password");
            RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
            rs.forward(request,response);
        }
        else {
            boolean goodData = false;
            for (User user : userVector) {
                if (user.equals(loggingOne)) {
                    goodData = true;
                    request.getSession().setAttribute("loggedIn",true);
                    request.getSession().setAttribute("login",login);
                    request.getRequestDispatcher("/Feedback").forward(request, response);
                    return;
                }
            }
            if(!goodData) {
                request.setAttribute("errorMessage", "Incorrect data");
                RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
                rs.forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
