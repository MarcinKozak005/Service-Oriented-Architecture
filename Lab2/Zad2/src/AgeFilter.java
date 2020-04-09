import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AgeFilter")
public class AgeFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("windows-1250");
        PrintWriter out = resp.getWriter();
        HttpServletRequest request = (HttpServletRequest) req;
        int age = Integer.parseInt(request.getParameter("age"));

        if (age<18)
        {
            out.println("<html>");
            out.println("<head><title>Underage</title></head>");
            out.println("<body>");
            out.println("<p>You are not old enough</p>");
            out.println("</body>");
            out.println("</html>");
        }
        else {
            RequestDispatcher rd = req.getRequestDispatcher("form.html");
            rd.forward(req,resp);
        }
    }
}
