/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterFaces;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import pharmaaid.*;
import java.time.*;
import java.util.Calendar;

/**
 *
 * @author USER
 */
public class EmployeeSales extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeSales
     */
    int id;
    String loginTime;
    String loginDate;
    String logOutTime;
    
    float givenQTY;
    int EmpID,CustID,row=1,saleID,medID;
    String medName,company;
    float MG;
    Connection con;
    ResultSet rs;
    float total,rate,desiredQTY;
    
    public EmployeeSales() {
        initComponents();
        JDBCConnection connect=new JDBCConnection();
        con=connect.getConnection();
        idGenarate id=new idGenarate();
        this.CustID=id.OfflineCustID();
        
        getTodayDateTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Medlist = new javax.swing.JTable();
        sales = new javax.swing.JButton();
        Medicine = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        companyName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mg = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        ALLMed = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SalesRecord = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        NewSale = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        desQTY = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        head.setBackground(new java.awt.Color(0, 204, 204));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sales");

        javax.swing.GroupLayout headLayout = new javax.swing.GroupLayout(head);
        head.setLayout(headLayout);
        headLayout.setHorizontalGroup(
            headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headLayout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headLayout.setVerticalGroup(
            headLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setForeground(new java.awt.Color(255, 255, 255));

        Medlist.setBackground(new java.awt.Color(204, 255, 204));
        Medlist.setForeground(new java.awt.Color(0, 0, 0));
        Medlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MedID", "Name", "type", "Company", "Exp", "Mfg", "Qty", "Mg", "Price"
            }
        ));
        Medlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Medlist);

        sales.setBackground(new java.awt.Color(0, 204, 102));
        sales.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sales.setForeground(new java.awt.Color(0, 0, 0));
        sales.setText("Sale");
        sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Medicine");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Company");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("MG");

        Search.setBackground(new java.awt.Color(0, 204, 204));
        Search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Search.setForeground(new java.awt.Color(0, 0, 0));
        Search.setText("SEARCH");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        ALLMed.setBackground(new java.awt.Color(0, 153, 51));
        ALLMed.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ALLMed.setForeground(new java.awt.Color(0, 0, 0));
        ALLMed.setText("ALL MEDICINE");
        ALLMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALLMedActionPerformed(evt);
            }
        });

        SalesRecord.setBackground(new java.awt.Color(204, 255, 204));
        SalesRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SaleID", "CustID", "EmpID", "MedicineName", "Qty", "Price", "Rate", "SaleDate"
            }
        ));
        jScrollPane2.setViewportView(SalesRecord);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Total:");

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("LOG OUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Total.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));

        NewSale.setBackground(new java.awt.Color(0, 204, 51));
        NewSale.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NewSale.setForeground(new java.awt.Color(0, 0, 0));
        NewSale.setText("NEW SALE");
        NewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewSaleActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MEDICINE TABLE");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SALE TABLE");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Qty");

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addComponent(NewSale, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(Medicine, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(companyName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
                            .addGroup(bodyLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(351, 351, 351)))
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ALLMed)
                            .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(desQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))))
            .addGroup(bodyLayout.createSequentialGroup()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton4))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(471, 471, 471)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(Medicine, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(companyName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewSale))
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ALLMed)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(desQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MedlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedlistMouseClicked
 
        int index=Medlist.getSelectedRow();
        givenQTY=Float.parseFloat(Medlist.getValueAt(index, 6).toString());
        medID=Integer.parseInt(Medlist.getValueAt(index, 0).toString());
//        this.saleID=id.SaleID();
//        desiredQTY=Float.parseFloat(desQTY.getText());
//        float mrp=Float.parseFloat(Medlist.getValueAt(index, 8).toString());
//        rate=mrp*desiredQTY;
    }//GEN-LAST:event_MedlistMouseClicked

    private void NewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewSaleActionPerformed
        idGenarate id=new idGenarate();
        this.CustID=id.OfflineCustID();
     
        row=0;
        DefaultTableModel model = (DefaultTableModel) Medlist.getModel();
        int mrowCount=model.getRowCount();
        for(int i=mrowCount-1;i>=0;i--){
            model.removeRow(i);
        }
        
        DefaultTableModel model2 = (DefaultTableModel) SalesRecord.getModel();
        int srowCount=model2.getRowCount();
        for(int i=srowCount-1;i>=0;i--){
            model2.removeRow(i);
        }
        
        Medicine.setText("");
        companyName.setText("");
        mg.setText("");
        Total.setText("");
    }//GEN-LAST:event_NewSaleActionPerformed

    private void ALLMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALLMedActionPerformed
        showMedics();
    }//GEN-LAST:event_ALLMedActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            insertLogs();
            con.close();
            this.setVisible(false);
            Login log=new Login();
            log.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesActionPerformed
        idGenarate id=new idGenarate();
        Medicine med=new Medicine();
        Sale sale=new Sale();
        int index=Medlist.getSelectedRow();
        
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String currentDate=formatter.format(today.getTime());
        if(!desQTY.getText().isEmpty()){
            desiredQTY=Float.parseFloat(desQTY.getText());

            if(givenQTY>desiredQTY){
                this.saleID=id.SaleID();
    //            float mrp=Math.round(Float.parseFloat(Medlist.getValueAt(index, 8).toString()));
    //            rate=Math.round(mrp*desiredQTY);
                float mrp=round(Float.parseFloat(Medlist.getValueAt(index, 8).toString()),2);
                rate=round(mrp*desiredQTY, 2);
                medName=Medlist.getValueAt(index, 1).toString();
                givenQTY=givenQTY-desiredQTY;


                sale.salesInsert(saleID, EmpID, CustID, medName, (int)desiredQTY, mrp, rate, currentDate, con);
                med.medicineUpdate(medID, (int)givenQTY, con);
                total=sale.getTotalCurrentSale(CustID, con);
                showCurrentSales();
                Total.setText(Float.toString(total));
    //            System.out.println(rate);
    //            System.out.println(this.CustID);
    //            System.out.println(currentDate);
            }
            else{
                JOptionPane.showMessageDialog(null, "Not enough in stock");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Qty field is empty");
        }
    }//GEN-LAST:event_salesActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        if(Medicine.getText().isEmpty() && companyName.getText().isEmpty() && mg.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Medicine name,company name and Mg Required");
        }
        else{
           medName=Medicine.getText();
           company=companyName.getText();
           MG=Float.parseFloat(mg.getText());
           
           Medicine med=new Medicine();
           rs=med.searchMedicine(medName, company, MG, con);
           Medlist.setModel(DbUtils.resultSetToTableModel(rs));
        }
    }//GEN-LAST:event_SearchActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeSales().setVisible(true);
            }
        });
    }
    
    private void showMedics(){
        Medicine med=new Medicine();
        rs=med.searchMedicine(con);
        Medlist.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    private void showCurrentSales(){
       Sale sale=new Sale();
       rs=sale.showCurrntSale(CustID, con);
       SalesRecord.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    public void getCurrentEmpID(int userID){
        try {
            Employee emp=new Employee();
            rs=emp.getEmployeeInfo(userID, con);
            if(rs.next()){
                this.EmpID=rs.getInt("EmployeeID");
                System.out.println(this.EmpID);
            }
            emp.closeDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static float round(float value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (float) tmp / factor;
    }
    
    private void getTodayDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        loginTime=dateFormat.format(calendar.getTime());
        loginDate=dateFormat2.format(calendar.getTime());
        System.out.println(loginTime);
        System.out.println(loginDate);
    }
    
    private void insertLogs(){
        Logs log=new Logs();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        logOutTime=dateFormat.format(calendar.getTime());
        log.insertLoginLogout(con, id, loginTime, logOutTime, loginDate);
        
    }
    
    public void setID(int id){
        this.id=id;
        System.out.println(this.id);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALLMed;
    private javax.swing.JTextField Medicine;
    private javax.swing.JTable Medlist;
    private javax.swing.JButton NewSale;
    private javax.swing.JTable SalesRecord;
    private javax.swing.JButton Search;
    private javax.swing.JLabel Total;
    private javax.swing.JPanel body;
    private javax.swing.JTextField companyName;
    private javax.swing.JTextField desQTY;
    private javax.swing.JPanel head;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mg;
    private javax.swing.JButton sales;
    // End of variables declaration//GEN-END:variables
}
