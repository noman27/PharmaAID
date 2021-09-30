package pharmaaid;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sale {

    public Sale() {
    }
    
    public void salesInsert(int saleID,int EmployeeID,int custID,String medname,int qty,float price,float rate,String saleDate,Connection con){
        try {
            
            String saleSQL="insert into Sales(SaleID,EmployeeID,CustID,MedicineName,Qty,Price,Rate,Sale_Date)VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement sale=con.prepareStatement(saleSQL);
            sale.setInt(1, saleID);
            sale.setInt(2, EmployeeID);
            sale.setInt(3, custID);
            sale.setString(4, medname);
            sale.setInt(5, qty);
            sale.setFloat(6, price);
            sale.setFloat(7, rate);
            sale.setString(8, saleDate);
            sale.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet showCurrntSale(int custID,Connection con){
        ResultSet rs=null;
        try {
            String sql="select * from Sales where CustID = ?";
            PreparedStatement sale=con.prepareStatement(sql);
            sale.setInt(1, custID);
            rs=sale.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public float getTotalCurrentSale(int id,Connection con){
        ResultSet rs;
        float Total=0;
        try {    
            String totalSQL="select SUM(Rate) as Total from Sales where CustID = ?";
            PreparedStatement total=con.prepareStatement(totalSQL);
            total.setInt(1, id);
            rs=total.executeQuery();
            if(rs.next()){
                Total=rs.getFloat("Total");
                return Total;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Total;
    }
}
