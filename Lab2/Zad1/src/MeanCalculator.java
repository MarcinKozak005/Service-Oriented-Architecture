import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MeanCalculator")
public class MeanCalculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        int x1 = Integer.parseInt(request.getParameter("number1"));
        int x2 = Integer.parseInt(request.getParameter("number2"));
        int x3 = Integer.parseInt(request.getParameter("number3"));
        int x4 = Integer.parseInt(request.getParameter("number4"));
        int x5 = Integer.parseInt(request.getParameter("number5"));
        out.println("<html>");
        out.println("<head><title>Calculated Mean</title></head>");
        out.println("<body>");
        out.println("<p> Mean of that 5 numbers is equal to "+ (x1+x2+x3+x4+x5)/5.0+"</p>");
        out.println("</body>");
        out.println("</html>");

    }
}
