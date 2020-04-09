import java.util.HashMap;

public class BeerExpert {

    private HashMap<String,String> beerMap = new HashMap<>();

    public BeerExpert(){
        beerMap.put("dark","BeerForDarkFans");
        beerMap.put("light","BeerForLightFans");
        beerMap.put("amber","BeerForAmberFans");
    }

    public String advise(String beerColour)
    {
        String answer = beerMap.get(beerColour);
        if (answer!= null)
            return answer;
        else
            return "I don't know";

    }
}
