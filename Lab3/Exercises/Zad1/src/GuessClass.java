import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

@ManagedBean(name = "Guess")
@SessionScoped
public class GuessClass {

    public static int lotteryNumber;
    public final Vector<Integer> visitCounter = new Vector<>();
    public int visitVictory = 0;
    public GuessClass()
    {
        lotteryNumber = new Random().nextInt(4)+1;
        for(int i=0;i<5;++i) visitCounter.add(0);
    }

    public String check(int userGuess){
        if(userGuess==lotteryNumber){
            lotteryNumber = new Random().nextInt(4)+1;
            visitVictory++;
            return "victory";
        }
        else {
            visitCounter.set(userGuess-1,visitCounter.get(userGuess-1)+1);
            return Integer.toString(userGuess);
        }
    }

    public Vector<Integer> getVisitCounter() {
        return visitCounter;
    }

    public int getVisitVictory() {
        return visitVictory;
    }

    public void setVisitVictory(int visitVictory) {
        this.visitVictory = visitVictory;
    }
}
