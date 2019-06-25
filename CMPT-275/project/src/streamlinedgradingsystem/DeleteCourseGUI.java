/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;
 
import ca.sfu.cmpt275.deliverable.colinq.*;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author naris
 */
public class DeleteCourseGUI extends javax.swing.JFrame {
    private Connection con;
    private Course courseModel;
    private User userModel;
    private UserManager CurrInstructor = new UserManager();

    private String fname;
    private String lname;
    private int countAct;
    
    public DeleteCourseGUI(User userModel, Course courseModel) {
        this.userModel = userModel;
        this.courseModel = courseModel;
        initComponents();
        
        displayAttributes();
        
        displayInstructor();
        
    }
    
    private void displayAttributes(){
        //display the attributes of current course being deleted
        insertCourseNameTitle.setText(courseModel.getCourseNumber());
        insertCourseNameTitle.setEditable(false);
        
        //display the current course attributes
        courseNameField.setText(courseModel.getCourseName());
        courseNameField.setEditable(false);
        
        courseNumField.setText(courseModel.getCourseNumber());
        courseNumField.setEditable(false);
        
        startDateField.setText(courseModel.getStartDate());
        startDateField.setEditable(false);
        
        endDateField.setText(courseModel.getEndDate());
        endDateField.setEditable(false);
    }
    
    private void displayInstructor(){
       //display the instructor attributes from database
  
        Integer InstID = courseModel.getInstructorID();
        
        int a=InstID;
        
        String DB_URL = "jdbc:sqlserver://cypress;";
        String USER = "c275g11";
        String PASS = "bL344y3Emh2dPtaT";
        Connection conn = null;
        Statement stmt = null;
         
        try{
                        
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn = DriverManager.getConnection(DB_URL,USER,PASS);
                        String sql;
                        sql="select firstName,lastName from Account where employeeID="+a+"";
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        if(rs.next()){
                            fname = rs.getString(1);
                            lname = rs.getString(2);
                        }
                            
                            
                        
                        
                            
                        rs.close();
                        stmt.close();
                        conn.close();
                        
        }
        catch(SQLException se){
                        //Handle errors for JDBC
                        JOptionPane.showMessageDialog(null,se,"SQLException", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
                        //Handle errors for Class.forName
                        JOptionPane.showMessageDialog(null,e,"Exception", JOptionPane.INFORMATION_MESSAGE);
        }

        //display instructor name in text box
        CurrInstructor.getUser(InstID);
        instName.setText(fname + lname);
        instName.setEditable(false);
        
        //display instructor ID in text box
        instID.setText(Integer.toString(courseModel.getInstructorID()));
        instID.setEditable(false);
        
    }
    
           
    private boolean hasActivities(){
     //check if the course contains activites
     Integer courseID = courseModel.getCourseID();
        
        int a=courseID;
        
        //connect to database
        String DB_URL = "jdbc:sqlserver://cypress;";
        String USER = "c275g11";
        String PASS = "bL344y3Emh2dPtaT";
        Connection conn = null;
        Statement stmt = null;
         
        try{
                        
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn = DriverManager.getConnection(DB_URL,USER,PASS);
                        String sql;
                        sql="select count(*) from Activity where courseID="+a+"";   //count how many activites the course has
                        stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        if(rs.next()){
                            countAct = rs.getInt(1);
                        }
   
                        rs.close();
                        stmt.close();
                        conn.close();
                        
        }
        catch(SQLException se){
                        //Handle errors for JDBC
                        JOptionPane.showMessageDialog(null,se,"SQLException", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
                        //Handle errors for Class.forName
                        JOptionPane.showMessageDialog(null,e,"Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        
       
       if (countAct == 0){
           //course has no activites
            return false;
       }
       //course has activites
       return true;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        insertCourseNameTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        courseNameField = new javax.swing.JTextField();
        courseNumField = new javax.swing.JTextField();
        startDateField = new javax.swing.JTextField();
        endDateField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        instName = new javax.swing.JTextField();
        instID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ConfirmButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("Course To Be Deleted:");

        insertCourseNameTitle.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        insertCourseNameTitle.setForeground(java.awt.Color.red);
        insertCourseNameTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCourseNameTitleActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Course Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Course Number:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Start Date:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("End Date:");

        courseNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        courseNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameFieldActionPerformed(evt);
            }
        });

        courseNumField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        startDateField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        endDateField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Instructor Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Instructor ID:");

        instName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        instName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instNameActionPerformed(evt);
            }
        });

        instID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(java.awt.Color.red);
        jLabel8.setText("Are you sure you would like to delete this course? Deletion of this course will result in its removal from the database.");

        ConfirmButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(insertCourseNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(courseNumField, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(startDateField)
                            .addComponent(endDateField)
                            .addComponent(courseNameField)
                            .addComponent(instName)
                            .addComponent(instID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(ConfirmButton)
                .addGap(244, 244, 244))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(insertCourseNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(courseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(courseNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(instName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(instID)))
                .addGap(50, 50, 50)
                .addComponent(jLabel8)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(ConfirmButton))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertCourseNameTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCourseNameTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertCourseNameTitleActionPerformed

    private void courseNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNameFieldActionPerformed

    private void instNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_instNameActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        if(hasActivities())
        {
         JOptionPane.showMessageDialog(null,
            "Course contains activities! Cannot be deleted" , "Reminder" , 
            JOptionPane.INFORMATION_MESSAGE);
        }
        else{
        String sUsername = "c275g11";
	String sPassword = "bL344y3Emh2dPtaT";
        String connectionUrl = "jdbc:sqlserver://cypress;" + "user = " + sUsername + ";" + "password = " + sPassword;
 	 
        Connection conn = null;
	Statement stmt = null;
        
				
        try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                String sql;
                conn = DriverManager.getConnection(connectionUrl);
                stmt = conn.createStatement();
                //delete the selected course
                
                sql = "DELETE from Course WHERE courseID = '"+courseModel.getCourseID()+"'";
                        
                       

                stmt.executeUpdate(sql);
                //JOptionPane.showMessageDialog(null,"add item success","success", JOptionPane.INFORMATION_MESSAGE);

                stmt.close();
                conn.close();
        }
        catch(SQLException se){
                //Handle errors for JDBC
                JOptionPane.showMessageDialog(null,se,"SQLException", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
                //Handle errors for Class.forName
                JOptionPane.showMessageDialog(null,e,"Exception", JOptionPane.INFORMATION_MESSAGE);
        }
        //notify that course has been deleted
         JOptionPane.showMessageDialog(null,
                           "Course has been successfully deleted" , "Reminder" , 
                           JOptionPane.INFORMATION_MESSAGE);
        //go back to manage courses
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ManageCoursesGUI(userModel).setVisible(true);
                }
            });
        }                                          
        
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // back to manage courses scren
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCourseDeleteGUI(userModel, courseModel).setVisible(true);
            }
            });
    }//GEN-LAST:event_BackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DeleteCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DeleteCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DeleteCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DeleteCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new DeleteCourseGUI(User, Course).setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JTextField courseNameField;
    private javax.swing.JTextField courseNumField;
    private javax.swing.JTextField endDateField;
    private javax.swing.JTextField insertCourseNameTitle;
    private javax.swing.JTextField instID;
    private javax.swing.JTextField instName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField startDateField;
    // End of variables declaration//GEN-END:variables
}
