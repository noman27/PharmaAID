package pharmaaid;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sale {

    public Sale() {
    }
    
    public void salesInsert(int saleID,int EmployeeID,int custID,String medname,int qty,float price,float rate,String saleDate,Connection con){
        Date sale_date=Date.valueOf(saleDate);
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
            sale.setDate(8, sale_date);
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
    
    public ResultSet getAllSale(Connection con){
        ResultSet rs=null;
        String saleSQL="select s.SaleID,d.Emp_Name,s.CustID,s.MedicineName,s.Qty,s.Price,s.Rate,s.Sale_Date from Sales s JOIN Employee d ON s.EmployeeID=d.EmployeeID";
        try {
            PreparedStatement pst=con.prepareStatement(saleSQL);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getAllSale(Connection con,String med){
        ResultSet rs=null;
        String saleSQL="select s.SaleID,d.Emp_Name,s.CustID,s.MedicineName,s.Qty,s.Price,s.Rate,s.Sale_Date from Sales s JOIN Employee d ON s.EmployeeID=d.EmployeeID where s.MedicineName = ?";
        try {
            PreparedStatement pst=con.prepareStatement(saleSQL);
            pst.setString(1, med);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getTodaySale(Connection con){
        ResultSet rs=null;
        String saleSQL="select s.SaleID,d.Emp_Name,s.CustID,s.MedicineName,s.Qty,s.Price,s.Rate,s.Sale_Date from Sales s JOIN Employee d ON s.EmployeeID=d.EmployeeID where DATEDIFF(day,s.Sale_Date,GETDATE())=0";
        try {
            PreparedStatement pst=con.prepareStatement(saleSQL);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getTodaySale(Connection con,String Med){
        ResultSet rs=null;
        String saleSQL="select s.SaleID,d.Emp_Name,s.CustID,s.MedicineName,s.Qty,s.Price,s.Rate,s.Sale_Date from Sales s JOIN Employee d ON s.EmployeeID=d.EmployeeID where DATEDIFF(day,s.Sale_Date,GETDATE())=0 AND s.MedicineName = ?";
        try {
            PreparedStatement pst=con.prepareStatement(saleSQL);
            pst.setString(1, Med);
            rs=pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public float getTotal(Connection con){
        float total=0;
        ResultSet rs=null;
        String sql="select SUM(Rate) as Total from Sales where DATEDIFF(day,Sale_Date,GETDATE())=0";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                total=rs.getFloat("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public int getTotalQtyToday(Connection con,String med){
        int total=0;
        ResultSet rs=null;
        String sql="select SUM(Qty) as Total from Sales where DATEDIFF(day,Sale_Date,GETDATE())=0 AND MedicineName = ?";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, med);
            rs=pst.executeQuery();
            if(rs.next()){
                total=rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public int getTotalQtyAll(Connection con,String med){
        int total=0;
        ResultSet rs=null;
        String sql="select SUM(Qty) as Total from Sales where MedicineName = ?";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, med);
            rs=pst.executeQuery();
            if(rs.next()){
                total=rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
}
