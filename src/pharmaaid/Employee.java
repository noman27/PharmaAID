package pharmaaid;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.util.ArrayList;

public class Employee extends AdminPanel{

    Connection EmpCon;
    ResultSet resultSet;
    Statement stmt;
    String userType;
    public Employee() {
        JDBCConnection connect=new JDBCConnection();
        EmpCon=connect.getConnection();
    }
    
    
    public void EmpUserInsert(String userName,String pass,String usertype){
        try {
            
            userType=usertype;
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
    
    public void EmpInsert(String userName,String Emp_Name, String Emp_Type,String dateofjoin,String resignDate,float salary){
        int uid=userIDGet(userName);
        Date doj=Date.valueOf(dateofjoin);
        Date rd;
        
        if(resignDate.equals("")){
            rd=null;
        }else{
            rd=Date.valueOf(resignDate);
        }
             
        
        if(uid!=0){
            try {
            idGenarate EmpID=new idGenarate();
            int id;
            
            if(Emp_Type.equals("Owner")){
              id=EmpID.OwnerID();
            }
            else{
                id=EmpID.employeeID();
            }
            
            String EmpTableSQL="insert into Employee(EmployeeID, UserID, Emp_Name, Emp_Type, DateofJoin, ResignDate, Salary)VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement addEmployee=EmpCon.prepareStatement(EmpTableSQL);
            addEmployee.setInt(1, id);
            addEmployee.setInt(2, uid);
            addEmployee.setString(3, Emp_Name);
            addEmployee.setString(4, Emp_Type);
            addEmployee.setDate(5, doj);
            addEmployee.setDate(6, rd);
            addEmployee.setFloat(7, salary);
            
            addEmployee.executeUpdate();
            System.out.println("Employee data added");
            
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("User data dont exist");
        }
        
    }
    
    public void EmpUpdateInfo(int UserID,String Name,String type,String dateOfjoin,String resignDate,float Salary,Connection con){
        
        Date doj=Date.valueOf(dateOfjoin);
        Date rd;
        
        if(resignDate.equals("")){
            rd=null;
        }else{
            rd=Date.valueOf(resignDate);
        }
        
        try {
            String updateSQL="UPDATE Employee SET Emp_Name = ?,Emp_Type = ?, DateofJoin = ?, ResignDate = ?, Salary = ? WHERE UserID = ?";
            PreparedStatement updateEmp=con.prepareStatement(updateSQL);
            updateEmp.setString(1, Name);
            updateEmp.setString(2, type);
            updateEmp.setDate(3, doj);
            updateEmp.setDate(4, rd);
            updateEmp.setFloat(5, Salary);
            updateEmp.setInt(6, UserID);
            updateEmp.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public ArrayList<EmployeeInfos> getEmployeeInfo(String empType,Connection con){
        
        ResultSet rs;
        ArrayList<EmployeeInfos> empInfo=new ArrayList<>();
        
        try {    
            String infoSQL="select * from Employee where Emp_Type = ?";
            PreparedStatement infos=con.prepareStatement(infoSQL);
            infos.setString(1, empType);
            
            rs=infos.executeQuery();
            
            while(rs.next()){
                EmployeeInfos empinfos=new EmployeeInfos();
                empinfos.setID(rs.getInt("EmployeeID"));
                empinfos.setName(rs.getString("Emp_Name"));
                empinfos.setType(rs.getString("Emp_Type"));
                empinfos.setDoj(rs.getDate("DateOfJoin").toString());
                //empinfos.setResDate(rs.getDate("ResignDate").toString());
                empinfos.setSalary(rs.getInt("Salary"));
                
                empInfo.add(empinfos);
            }
            return empInfo;
            
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empInfo;
    }
    
    public void getEmpContacts(){
    
          String ContactSQL="select c.ContactID , e.Emp_Name ,c.Contact_No from Employee e JOIN Contacts c ON e.EmployeeID=c.EmployeeID";
    }
    
    public int userIDGet(String userName){
        
        int id=0;
        
        try {
            String getuidSQL="select UserID from users where UserName = ? AND User_Type = ?";
            PreparedStatement getID=EmpCon.prepareStatement(getuidSQL);
            getID.setString(1, userName);
            getID.setString(2, "Employee");
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
    
    
    public String getEmpType(int uid){
        String type="";
        try {
            String empTypeSQL="select Emp_Type from Employee where UserID = ?";
            PreparedStatement emptype=EmpCon.prepareStatement(empTypeSQL);
            emptype.setInt(1, uid);
            resultSet=emptype.executeQuery();
            if(resultSet.next()){
                type=resultSet.getString("Emp_Type");
                return type;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }
    
    
    public void closeDatabase(){
        try {
            EmpCon.close();
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
