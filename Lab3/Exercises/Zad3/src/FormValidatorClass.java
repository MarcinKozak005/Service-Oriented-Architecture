import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagedBean(name = "FormValidator")
@ViewScoped
public class FormValidatorClass {

    String selectedBrand;
    String selectedModel;
    String minPrice;
    String maxPrice;
    String priceMessage = "";
    String engineType = "ON";
    String numberMessage = "";
    String name;
    String number;
    CarDataBaseClass carDataBaseClass;

    boolean correctPrice = false;
    boolean correctName = false;
    boolean correctNumber = false;

    List<Car> foundCars;


    Map<String, List<String>> carMap = new HashMap<>();
    List<String> availableModels = new LinkedList<>(); // TODO


    public FormValidatorClass(){
        carDataBaseClass = new CarDataBaseClass();
        carMap.put("Fiat", Arrays.asList("Punto","500","SuperFiat"));
        carMap.put("Renault", Arrays.asList("Megane","Scenic","GrandScenic"));
        carMap.put("BMW", Arrays.asList("BMW1","BMW2","BMW3"));
        carMap.put("Subaru", Arrays.asList("Subaru1","Subaru2","Subaru3"));
        carMap.put("VW", Arrays.asList("VW1","VW2","VW3"));

        selectedBrand = "Fiat";
        selectedModel = "Punto";
        availableModels = carMap.get(selectedBrand);
    }

    public boolean isAllValid()
    {
        return correctName && correctNumber && correctPrice;
    }

    public void nameValidator(AjaxBehaviorEvent ajaxBehaviorEvent)
    {
        correctName = !name.isEmpty();
    }

    public void numberValidator(AjaxBehaviorEvent ajaxBehaviorEvent) {
        Pattern pattern = Pattern.compile("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d");
        Matcher matcher = pattern.matcher(this.number);
        if (!matcher.find()) {
            this.numberMessage = "Input number in 'NNN-NNN-NNN' format";
            correctNumber = false;
        }
        else{
            this.numberMessage = "";
            correctNumber = true;
        }
    }

    public void priceValidator(AjaxBehaviorEvent ajaxBehaviorEvent)
    {
        boolean wrong = false;
        double min = 0, max=0;
        try {
            min = Double.parseDouble(this.minPrice);
            max = Double.parseDouble(this.maxPrice);
        }catch (Exception e){
            this.priceMessage = "Min and Max price must be both numbers!";
            wrong = true;
        }
        if(!wrong) {
            if (min > max || min < 0 || max < 0){
                this.priceMessage = "Inncorect min or max value";
                correctPrice = false;
            }
            else {
                this.priceMessage="";
                correctPrice = true;
            }
        }
    }

    public void lookForCars(){
        foundCars = new LinkedList<>(carDataBaseClass.getCars(selectedBrand,selectedModel,Integer.parseInt(minPrice),Integer.parseInt(maxPrice),engineType));
    }

    public void brandChange(AjaxBehaviorEvent ajaxBehaviorEvent) {
        this.availableModels = this.carMap.get(selectedBrand);
    }

    public List<String> getMapAsList()
    {
        return new LinkedList<>(carMap.keySet());
    }

    public List<String> getModelsForBrand()
    {
        return carMap.get(selectedBrand);
    }


    // Getters & Setters

    public String getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(String selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    public List<String> getAvailableModels() {
        return availableModels;
    }

    public void setAvailableModels(List<String> availableModels) {
        this.availableModels = availableModels;
    }

    public String getSelectedModel() {
        return selectedModel;
    }

    public void setSelectedModel(String selectedModel) {
        this.selectedModel = selectedModel;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getPriceMessage() {
        return priceMessage;
    }

    public void setPriceMessage(String priceMessage) {
        this.priceMessage = priceMessage;
    }


    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getNumberMessage() {
        return numberMessage;
    }

    public void setNumberMessage(String numberMessage) {
        this.numberMessage = numberMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Car> getFoundCars() {
        return foundCars;
    }

    public void setFoundCars(List<Car> foundCars) {
        this.foundCars = foundCars;
    }
}
