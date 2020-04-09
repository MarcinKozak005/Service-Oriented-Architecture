import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet1")
public class FirstServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        out.println("<html>");
        out.println("<head><title>First Servlet</title></head>");
        out.println("<body>");
        out.println("<p>Hello, "+name+", You are "+age+" years-old </p>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
