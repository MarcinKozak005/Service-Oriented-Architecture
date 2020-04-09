import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChooseBeer")
public class ChooseBeer extends HttpServlet {
    private BeerExpert beerAdvisor = new BeerExpert();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("beer", beerAdvisor.advise(request.getParameter("beerType")));

        RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
        rd.forward(request,response);

    }
}
