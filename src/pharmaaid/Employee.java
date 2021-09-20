package pharmaaid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employee {

    public Employee() {
    }
    
    Connection EmpCon;
    ResultSet resultSet;
    Statement stmt;
    
    public void EmpUserInsert(String userName,String pass){
        try {
            
            String userType="Employee";
            String userTableSQL="insert into Users(UserName,User_Pass,User_Type)VALUES(?,?,?)";
             
            PreparedStatement addUser = EmpCon.prepareStatement(userTableSQL);
            addUser.setString(1, userName);
            addUser.setString(2, pass);
            addUser.setString(3, userType);
            addUser.executeUpdate();
            System.out.println("Employee User data added");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void CustInsert(String userName,String Emp_Name, String Emp_Type,String address,String email,String contact){
        int uid=userIDGet(userName);
        
        if(uid!=0){
            try {
            idGenarate EmpID=new idGenarate();
            int id=EmpID.employeeID();
            
            String EmpTableSQL="insert into Employee(EmployeeID, UserID, Emp_Name, Emp_Type, DateofJoin, ResignDate, Salary)VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement addCustomer=EmpCon.prepareStatement(EmpTableSQL);
            addCustomer.setInt(1, id);
            addCustomer.setInt(2, uid);
            addCustomer.setString(3, address);
            addCustomer.setString(4, email);
            addCustomer.setString(5, contact);
            addCustomer.setInt(6, uid);
            addCustomer.executeUpdate();
            System.out.println("Employee data added");
            
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
            PreparedStatement getID=EmpCon.prepareStatement(getuidSQL);
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
    
}
