import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TestAddBean implements ILocalTestAddBean {
    public int add(int a, int b) {
        int r = a + b;
        return r;
    }
}
