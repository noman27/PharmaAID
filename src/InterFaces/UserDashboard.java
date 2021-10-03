/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterFaces;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pharmaaid.*;
/**
 *
 * @author Tarik
 */
public class UserDashboard extends javax.swing.JFrame {

    /**
     * Creates new form UserDashboard
     */
    Connection con;
    ResultSet rs;
    static int ownerID;
    String Realname,type,uName;
    public UserDashboard() {
        initComponents();
        getData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userID = new javax.swing.JLabel();
        utype = new javax.swing.JLabel();
        updateUserData = new javax.swing.JButton();
        exitUser = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        cPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        realName = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        user.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("User");

        jLabel1.setText("ID:");

        jLabel2.setText("User Name");

        jLabel3.setText("User Type");

        jLabel4.setText("Password");

        jLabel5.setText("Conf Password");

        userID.setText("userID");

        utype.setText("type");

        updateUserData.setText("Update");
        updateUserData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserDataActionPerformed(evt);
            }
        });

        exitUser.setText("Exit");
        exitUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitUserActionPerformed(evt);
            }
        });

        jLabel6.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userID, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(utype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Password)
                            .addComponent(cPassword)
                            .addComponent(userName)
                            .addComponent(realName))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitUser, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateUserData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(realName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(utype))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(updateUserData)
                .addGap(18, 18, 18)
                .addComponent(exitUser)
                .addGap(45, 45, 45))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitUserActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_exitUserActionPerformed

    private void updateUserDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserDataActionPerformed
        try {    
            JDBCConnection connection=new JDBCConnection();
            con=connection.getConnection();

            String pass=Password.getText();
            String cpas=cPassword.getText();
            
            Realname=realName.getText();
            uName=userName.getText();
            
            String empSQL="UPDATE Employee SET Emp_Name = '"+Realname+"',Emp_Type = '"+type+"' WHERE UserID = "+ownerID;
            
            if(pass.equals(cpas) && !pass.isEmpty() && !cpas.isEmpty()){
                
                AdminPanel api=new AdminPanel();
                api.UpdateUser(ownerID, uName, pass, "Employee", con);
                api.closeDatabase();
                
                Statement stmt=con.createStatement();
                if(stmt.executeUpdate(empSQL)>0){
                    JOptionPane.showMessageDialog(null, "User Info updated");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Not updated Error occured");
                }
                
            }else{
                JOptionPane.showMessageDialog(null,"Password mismatch or empty");
            }
        
        
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateUserDataActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboard().setVisible(true);
            }
        });
    }
    
    private void getData(){
        try {
            System.out.println(ownerID);
            Employee emp=new Employee();
            rs=emp.getEmployeeInfo(ownerID, emp.EmpCon);
            if(rs.next()){
                this.Realname=rs.getString("Emp_Name");
                this.type=rs.getString("Emp_Type");
            }
            emp.closeDatabase();
            
            AdminPanel api=new AdminPanel();
            rs=api.getuser(ownerID);
            if(rs.next()){
                this.uName=rs.getString("UserName");
                
            }
            api.closeDatabase();
            
            realName.setText(Realname);
            userName.setText(uName);
            userID.setText(String.valueOf(ownerID));
            utype.setText(type);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getID(int id){
        UserDashboard.ownerID=id;
        System.out.println(ownerID);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JPasswordField cPassword;
    private javax.swing.JButton exitUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField realName;
    private javax.swing.JButton updateUserData;
    private javax.swing.JLabel user;
    private javax.swing.JLabel userID;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel utype;
    // End of variables declaration//GEN-END:variables
}
