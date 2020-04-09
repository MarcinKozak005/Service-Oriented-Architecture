import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "CinemaBean")
@SessionScoped
public class CinemaClass {

    @EJB
    SingletonBeanImpl singletonBean;

    @EJB
    StatefulBeanImpl statefulBean;



    public List<Seat> getSeats(){return singletonBean.getSeatList();}
    public int getBudget(){return statefulBean.getBudget();}

    public void book(Seat s){
        try {
            statefulBean.bookSeat(s.getNumber());
        }
        catch (Exception e) {
            throw new TooExpensiveException();
        }
    }

}
