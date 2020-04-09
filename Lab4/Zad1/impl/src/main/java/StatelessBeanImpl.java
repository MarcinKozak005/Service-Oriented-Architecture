import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@LocalBean
@Remote(IStatelessBean.class)
public class StatelessBeanImpl implements IStatelessBean {

    @EJB
    SingletonBeanImpl singletonBean;

    public boolean checkAvailability(int seatNumber) {
        for (Seat seat: singletonBean.getSeatList())
        {
            if (seat.getNumber()==seatNumber)
                return seat.isAvailable();
        }
        throw new SeatNumberNotFound();
    }
}
