import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Singleton
@LocalBean
@Remote(ISingletonBean.class)
public class SingletonBeanImpl implements ISingletonBean {

    private List<Seat> listOfSeats = new LinkedList<Seat>(Arrays.asList(
                new Seat(1,100),
                new Seat(2,200),
                new Seat(3,300),
                new Seat(4,400),
                new Seat(5,500),
                new Seat(6,600)
        ));


    @Lock
    public List<Seat> getSeatList() {
        return listOfSeats;
    }


    @Lock
    public int getSeatPrice(int seatNumber) {
        for (Seat seat: listOfSeats){
            if (seat.getNumber() == seatNumber) return seat.getPrice();
        }
        throw new SeatNumberNotFound();
    }

    @Lock
    public void buyTicket(int seatNumber) {
        for (Seat seat: listOfSeats){
            if (seat.getNumber() == seatNumber) seat.setAvailable(false);
        }
    }
}
