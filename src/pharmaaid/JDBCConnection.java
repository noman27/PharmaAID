/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmaaid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Tarik
 */
public class JDBCConnection {
    Statement statement;
    Connection connection;
    public JDBCConnection() {
        String url = "jdbc:sqlserver://DESKTOP-C4L23FV\\SQLEXPRESS:1433;databaseName=PharmaAID";
        String user = "sa";
        String password = "MyP455forSql";
        
        try{
            connection = DriverManager.getConnection(url, user, password);        
          
            //String sqlInsert = "insert into Employee values('Sadee', '19-09-2019', '')";
            
            //Statement statementToInsert = connection.createStatement();
//            int rows = statementToInsert.executeUpdate(sqlInsert);
//            if(rows > 0)
//            {
//                System.out.println("Row has been inserted");
//            }
//            
//            String sqlShow = "select * from Employee";



            statement = connection.createStatement();
            
            
            
            
            //ResultSet result = statementToShow.executeQuery(sqlShow);
            //int count = 0;
            
//            while(result.next()) 
//            {
//                int employeeID = result.getInt("EmployeeID");
//                String employeeName = result.getString("Emp_Name");
//                String dateOfJoin = result.getString("DateOfJoin");
//                String dateOfResign = result.getString("DateOfResign");
//                System.out.printf("Users info %d %s %s %s \n", employeeID, employeeName, dateOfJoin, dateOfResign);
//            }
//            
//            connection.close();
//            
        } catch(Exception e) {
            System.out.println("Somthing's wrong.");
            e.printStackTrace();
        }
        
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }
}
