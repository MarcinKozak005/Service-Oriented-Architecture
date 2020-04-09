import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
    FeedbackVector feedbackVector = new FeedbackVector();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = Optional.ofNullable(request.getParameter("name")).map(String::trim).orElse("");
        String email = Optional.ofNullable(request.getParameter("email")).map(String::trim).orElse("");
        String comment = Optional.ofNullable(request.getParameter("comment")).map(String::trim).orElse("");

        if (!email.isEmpty() && !name.isEmpty() && !comment.isEmpty()){
            feedbackVector.addFeedback(name,email,comment);
        }


        request.setAttribute("Comments",feedbackVector.toString());
        RequestDispatcher rs = request.getRequestDispatcher("logged.jsp");
        rs.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
