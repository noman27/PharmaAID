package pharmaaid;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Medicine {

    Connection medCon;
    ResultSet medRes=null;
    
    public Medicine() {
        
    }
    
    public int medicineExists(String medName,String company,float mg,Connection con){
        int id=0;
        try {
            String allMedSQL="select * from Medicine where MedicineName = ? AND Company = ? AND Mg = ?";
            PreparedStatement getMed=con.prepareStatement(allMedSQL);
            getMed.setString(1, medName);
            getMed.setString(2, company);
            getMed.setFloat(3, mg);
            medRes=getMed.executeQuery();
            if(medRes.next()){
               id=medRes.getInt("MedID");
               return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
