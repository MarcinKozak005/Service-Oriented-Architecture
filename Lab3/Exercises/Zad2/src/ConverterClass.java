import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.*;

@ManagedBean(name = "Converter")
@SessionScoped
public class ConverterClass {
    double valueToExchange;
    String currencyFrom;
    String currencyTo;
    double exchangedValue;

    NBPConnector nbpConnector = new NBPConnector();
    Map<String,Double> ratesMap = new HashMap<>();

    public ConverterClass() throws IOException {
        ratesMap.put("EUR",nbpConnector.exchangeRate("EUR"));
        ratesMap.put("PLN",1.0);
        System.out.println(ratesMap);
    }

    public List<String> ratesAsList()
    {
        List<String> result = new LinkedList<>();
        result.addAll(ratesMap.keySet());
        return result;
    }

    public String exchange() throws IOException {
//        exchangedValue = valueToExchange * ExchangeRateClass.getExchangeRate(currencyFrom,currencyTo);
        exchangedValue = valueToExchange * ratesMap.get(currencyFrom) / ratesMap.get(currencyTo);
        return "result";
    }

    public void addCurrency(String currency) throws IOException {
        String bigOne = currency.toUpperCase();
        double rate = nbpConnector.exchangeRate(bigOne);
        if(rate!=0) ratesMap.put(bigOne,rate);
        System.out.println(ratesMap);
    }

    public void validateCurrency(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String value = (String) o;
        if(value.length() != 3){
            ((UIInput) uiComponent).setValid(false);

            FacesMessage message = new FacesMessage("Currency length must by exactly 3");
            facesContext.addMessage(uiComponent.getClientId(facesContext), message);
        }
    }

    // Getters & Setters

    public double getValueToExchange() {
        return valueToExchange;
    }

    public void setValueToExchange(double valueToExchange) {
        this.valueToExchange = valueToExchange;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public double getExchangedValue() {
        return exchangedValue;
    }

    public void setExchangedValue(double exchangedValue) {
        this.exchangedValue = exchangedValue;
    }

    public Map<String, Double> getRatesMap() {
        return ratesMap;
    }

    public void setRatesMap(Map<String, Double> ratesMap) {
        this.ratesMap = ratesMap;
    }
}
