package pharmaaid;
import InterFaces.Login;
import InterFaces.MedicineDashboard;
public class PharmaAID {
    public static void main(String[] args) {
        Login login=new Login();
        //New line for test
        
        login.setTitle("Pharma AID");
        login.setVisible(true);
        
        
        
        MedicineDashboard mbdb = new MedicineDashboard();
        mbdb.setVisible(true);
  
        
    }
    
}
