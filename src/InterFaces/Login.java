/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterFaces;
import javax.swing.JOptionPane;
import pharmaaid.*;

/**
 *
 * @author USER
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    String username;
    String givenPass;
    String userType;
    int uID;
    public Login() {
        initComponents();
        
        //This is Github version
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginDetailsPanel = new javax.swing.JPanel();
        TitleLebel = new javax.swing.JLabel();
        UsernameLebel = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        PasswordLebel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        LoginBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        LoginPicPanel = new javax.swing.JPanel();
        BgPicLebel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLebel.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        TitleLebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLebel.setText("Login");

        UsernameLebel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        UsernameLebel.setText("Username :");

        UsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameFieldActionPerformed(evt);
            }
        });

        PasswordLebel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        PasswordLebel.setText("Password  :");

        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        LoginBtn.setBackground(new java.awt.Color(0, 153, 153));
        LoginBtn.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Employee", "Customer" }));

        javax.swing.GroupLayout LoginDetailsPanelLayout = new javax.swing.GroupLayout(LoginDetailsPanel);
        LoginDetailsPanel.setLayout(LoginDetailsPanelLayout);
        LoginDetailsPanelLayout.setHorizontalGroup(
            LoginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginDetailsPanelLayout.createSequentialGroup()
                .addGroup(LoginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginDetailsPanelLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(TitleLebel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LoginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PasswordLebel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(UsernameLebel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LoginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UsernameField)
                            .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
            .addGroup(LoginDetailsPanelLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginDetailsPanelLayout.setVerticalGroup(
            LoginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginDetailsPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(TitleLebel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(LoginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsernameLebel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(LoginDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLebel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BgPicLebel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Pharma1.jpg"))); // NOI18N

        javax.swing.GroupLayout LoginPicPanelLayout = new javax.swing.GroupLayout(LoginPicPanel);
        LoginPicPanel.setLayout(LoginPicPanelLayout);
        LoginPicPanelLayout.setHorizontalGroup(
            LoginPicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BgPicLebel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LoginPicPanelLayout.setVerticalGroup(
            LoginPicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BgPicLebel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LoginDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginPicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LoginPicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        LoginWorks login=new LoginWorks();
        
        username=UsernameField.getText();
        givenPass=PasswordField.getText();
        userType=jComboBox1.getSelectedItem().toString();
        uID=login.log_into(username, givenPass, userType);
        
        if(uID>0 && login.userStatusCheck(username, givenPass, userType).equals("Active")){
            if(userType.equals("Customer")){
                login.logConClose();
                CustomerDash cd=new CustomerDash();
                cd.setUserID(uID);
                cd.setTitle("PharmaAID | Customer Dashboard");
                this.hide();
                cd.setVisible(true);
                
                JOptionPane.showMessageDialog(null, "Welcome "+username+" ID ="+uID);
            }
            else if(userType.equals("Employee")){
                login.logConClose();
                Employee employee =new Employee();
                
                if(employee.getEmpType(uID).equals("Owner")){
                    OwnerDash od=new OwnerDash();
                    od.setTitle("PharmaAID | Owner Dashboard");
                    this.hide();
                    od.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome "+username+" ID ="+uID);
                }
                else{
                    EmployeeDash emp=new EmployeeDash();
                    emp.setTitle("PharmaAID | Staff Dashboard");
                    this.hide();
                    emp.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Welcome "+username+" ID ="+uID);
                }
            }
            else if(userType.equals("Admin")){
                login.logConClose();
                AdminDash AD=new AdminDash();
                this.hide();
                AD.setTitle(userType);
                AD.setVisible(true);
                JOptionPane.showMessageDialog(null, "Welcome "+username+" ID ="+uID);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "login failed");
        }
        login.logConClose();
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void UsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BgPicLebel;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPanel LoginDetailsPanel;
    private javax.swing.JPanel LoginPicPanel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLebel;
    private javax.swing.JLabel TitleLebel;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JLabel UsernameLebel;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}
