package pharmaaid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer {
    
    Connection custCon;
    ResultSet resultSet;
    Statement stmt;
    
    
    public Customer() {
        JDBCConnection connect=new JDBCConnection();
        custCon=connect.getConnection();
    }
    
    //name,address,email,contact will be added at Customer table
            //userName, pass will be added at users table
            
    
    
    
    public void CustUserInsert(String userName,String pass){
        try {
            
            String userType="Customer";
            String userTableSQL="insert into Users(UserName,User_Pass,User_Type)VALUES(?,?,?)";
             
            PreparedStatement addUser = custCon.prepareStatement(userTableSQL);
            addUser.setString(1, userName);
            addUser.setString(2, pass);
            addUser.setString(3, userType);
            addUser.executeUpdate();
            System.out.println("Customer User data added");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void CustInsert(String userName,String name,String address,String email,String contact){
        int uid=userIDGet(userName);
        
        if(uid!=0){
            try {
            idGenarate custID=new idGenarate();
            int id=custID.customerID();
            
            String custTableSQL="insert into Customer(CustomerID,Cust_Name,Cust_address,Cust_Email,Cust_contact,UserID)VALUES(?,?,?,?,?,?)";
            
            PreparedStatement addCustomer=custCon.prepareStatement(custTableSQL);
            addCustomer.setInt(1, id);
            addCustomer.setString(2, name);
            addCustomer.setString(3, address);
            addCustomer.setString(4, email);
            addCustomer.setString(5, contact);
            addCustomer.setInt(6, uid);
            addCustomer.executeUpdate();
            System.out.println("Customer data added");
            
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("User data dont exist");
        }
        
    }
    
    public int userIDGet(String userName){
        
        int id=0;
        
        try {
            String getuidSQL="select UserID from users where UserName = ? AND User_Type = ?";
            PreparedStatement getID=custCon.prepareStatement(getuidSQL);
            getID.setString(1, userName);
            getID.setString(2, "Customer");
            resultSet=getID.executeQuery();
            
            if(resultSet.next()){
                id=resultSet.getInt("UserID");
                //System.out.println("Customer user id is="+id);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void closeDatabase(){
        try {
            custCon.close();
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
