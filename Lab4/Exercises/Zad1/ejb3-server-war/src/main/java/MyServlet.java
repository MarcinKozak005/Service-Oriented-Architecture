import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet1", urlPatterns = "addThem")
public class MyServlet extends javax.servlet.http.HttpServlet {

    @EJB(lookup = "java:global/ejb3-server-war/TestBeanCounter!ILocalTestBeanCounter")
    ITestBeanCounter beanCounter;

    @EJB(lookup = "java:module/TestAddBean")
    ILocalTestAddBean addBean;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        beanCounter.increment();
        PrintWriter out = response.getWriter();
        int a = Integer.parseInt(request.getParameter("first"));
        int b = Integer.parseInt(request.getParameter("second"));
        out.println("Result: "+ addBean.add(a,b));
        out.println("Total clicks: "+ beanCounter.getNumber());
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
