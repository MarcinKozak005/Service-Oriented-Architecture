import java.io.Serializable;

public class Seat implements Serializable {
    private int number;
    private int price;
    private boolean available;

    public Seat(int number, int price) {
        this.available = true;
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
