package pharmaaid;
import java.util.Random;
public class idGenarate {

    public idGenarate() {
    }
    
    public int customerID(){
        Random rand=new Random();
        int custID=10000;
        int ran=rand.nextInt(1000);
        return custID+ran;
    }
}
