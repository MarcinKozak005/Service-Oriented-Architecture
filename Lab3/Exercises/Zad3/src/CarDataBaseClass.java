import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

// chyba nie potrzebne
@ManagedBean(name = "CarDB")
@SessionScoped
public class CarDataBaseClass {
    public List<Car> carList = new LinkedList<>();

    public CarDataBaseClass()
    {
        carList.add(new Car("Fiat","Punto",100,"ON"));
        carList.add(new Car("Fiat","Punto",100,"ON"));
        carList.add(new Car("Renault","Megane",100,"Gasoline"));
        carList.add(new Car("BMW","BMW1",100,"Gasoline"));
        carList.add(new Car("BMW","BMW1",100,"Gasoline"));
        carList.add(new Car("BMW","BMW1",100,"Gasoline"));
        carList.add(new Car("Subaru","Subaru1",100,"ON"));
        carList.add(new Car("Subaru","Subaru1",100,"ON"));
    }

    public List<Car> getCars(String brand, String model, int minPrice, int maxPrice, String engimeType)
    {
        List<Car> result = new LinkedList<>();
        for (Car car: carList)
            if (car.isSimilar(brand, model, minPrice, maxPrice, engimeType) ) result.add(car);
        return result;
    }
}
