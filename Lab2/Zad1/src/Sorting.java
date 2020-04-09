import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Sorting")
public class Sorting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Calculated Mean</title></head>");
        out.println("<body>");
        Enumeration collection = request.getParameterNames();
        List<Integer> numbersList = new LinkedList();
        while(collection.hasMoreElements())
        {
            String parameter = (String) collection.nextElement();
            try {
                numbersList.add(Integer.parseInt(request.getParameter(parameter)));
            }
            catch(NumberFormatException e){
                out.println("<p>One or more parameters are not numbers!</p>");
                out.println("</body>");
                out.println("</html>");
                return;
            }
        }
        Collections.sort(numbersList);
        out.println("<p>Sorted list of parameters: "+numbersList +"</p>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
