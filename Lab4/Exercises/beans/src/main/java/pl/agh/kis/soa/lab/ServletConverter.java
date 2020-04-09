package pl.agh.kis.soa.lab;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletConverter")
// url Pattern zmiana POST not supported
// Name nie ma w na razie znaczenia
public class ServletConverter extends javax.servlet.http.HttpServlet {

    @EJB
    private ConverterBeanInterface bean;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        System.out.println(request.getParameter("temp"));
        System.out.println(request.getParameter("direction"));
        out.println("czesc!");

        try{
            double temp =  Double.parseDouble(request.getParameter("temp"));
            switch (request.getParameter("direction")){
                case "cels2fahr":
                    out.println(bean.celsius2fahrenheit(temp));
                    break;
                case "fahr2cels":
                    out.println(bean.fahrenheit2celsius(temp));
                    break;
            }
        } catch (Exception e) {
            out.println("Provide valid number in format xxxx.yyyy");
        }

        //request.getRequestDispatcher("/lab/TemperatureForm.html").include(request,response);
        out.close();

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
