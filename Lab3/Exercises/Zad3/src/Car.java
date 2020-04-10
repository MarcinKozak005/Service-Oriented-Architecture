public class Car {
    String brand;
    String model;
    int price;
    String engineType;

    public Car(String brand, String model, int price, String engineType) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.engineType = engineType;
    }

    boolean priceInRange(int minPrice, int maxPrice){
        return price>=minPrice && price<=maxPrice;
    }

    boolean isSimilar(String brand, String model, int minPrice, int maxPrice, String engimeType)
    {
        return this.brand.equals(brand) &&
                this.model.equals(model) &&
                this.engineType.equals(engimeType) &&
                priceInRange(minPrice,maxPrice);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
