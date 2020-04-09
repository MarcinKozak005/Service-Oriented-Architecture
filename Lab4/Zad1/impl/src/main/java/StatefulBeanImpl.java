import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@LocalBean
@Remote(IStatefulBean.class)
public class StatefulBeanImpl implements IStatefulBean {

    @EJB
    SingletonBeanImpl singletonBean;

    @EJB
    StatelessBeanImpl statelessBean;


    int budget = 1000;


    public void bookSeat(int seatNumber)  {
        if (statelessBean.checkAvailability(seatNumber)) {
            if(singletonBean.getSeatPrice(seatNumber)>budget)
                throw new TooExpensiveException();
            else{
                singletonBean.buyTicket(seatNumber);
                budget-=singletonBean.getSeatPrice(seatNumber);
            }
        }
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
