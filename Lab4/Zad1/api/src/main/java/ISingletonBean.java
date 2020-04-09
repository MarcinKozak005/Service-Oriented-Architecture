import java.util.List;

public interface ISingletonBean {
    List<Seat> getSeatList();
    int getSeatPrice(int seatNumber);
    void buyTicket(int seatNumber);

}
