/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

import ca.sfu.cmpt275.deliverable.colinq.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ROY
 */
public class InstructorMenuGUI extends javax.swing.JFrame {
    private User userModel;
    private Course courseModel;
//    private Course courseModel = null;
    private ArrayList<Course> courses = new ArrayList<Course>();
    /**
     * Creates new form InstructorMenuGUI
     */
    private Connection con;
    public InstructorMenuGUI(User userModel, Course courseModel) {
//        userModel = new User();
        this.userModel = userModel;        
        this.courseModel = courseModel;
        
        initComponents();
        fillcombo();

    }

    InstructorMenuGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        courseSelectionComboBox = new javax.swing.JComboBox();
        nextButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Instructor Menu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Please select a course:");

        courseSelectionComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        courseSelectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseSelectionComboBoxActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(courseSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(101, 101, 101)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(courseSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void courseSelectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseSelectionComboBoxActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        String chosenCourse = (String)cb.getSelectedItem();
        if (chosenCourse == "(Select a course)"){
            courseModel.setCourseID(0);
        }else{
        String[] splittedInfo = chosenCourse.split(",");
        int courseIDIndex = 0;
        int courseID = Integer.parseInt(splittedInfo[courseIDIndex].trim());
        
        System.out.println("cousre ID is: " + courseID);
        System.out.println("Size is: " + courses.size());
        
        
        for(Course c : courses) {
            System.out.println("courses are: ");
            c.display();
            if(c.getCourseID() == courseID) {
                courseModel = c;
                break;
            }
        }
        if (courseModel != null) {
            System.out.println("couse selected is: " + courseModel.getCourseID());
        }
        }
      
    }//GEN-LAST:event_courseSelectionComboBoxActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (courseModel.getCourseID() == 0) {
            JOptionPane.showMessageDialog(null,"Please select a course.","Reminder", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ManageActivitiesGUI(userModel, courseModel).setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoleSelectionGUI(userModel).setVisible(true);
            }
            });
    }//GEN-LAST:event_backButtonActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(InstructorMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InstructorMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InstructorMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InstructorMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//      
//    }
    private void fillcombo() {

		String DB_URL = "jdbc:sqlserver://cypress;";
		String USER = "c275g11";
		String PASS = "bL344y3Emh2dPtaT";
		Connection conn = null;
		Statement stmt = null;

                try{
                    
                    String sql;
                    
                    int employeeID = userModel.getEmployeeID();
//                    int row = 0;
                    
                    
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    stmt = conn.createStatement();
                    
//                        sql = "SELECT courseNum from Course where instructorEmployeeID = '"+ employeeID +"'" ;
                    sql = "SELECT * from Course where instructorEmployeeID = '"+ employeeID +"'" ;
                    
                    ResultSet rs = stmt.executeQuery(sql);
                    
                    processResult(rs);
                    
//                    ArrayList<String> listID=new ArrayList<String>();
//                    while(rs.next()){
//                        
//                        listID.add(rs.getString("courseNum"));
//                        courseSelectionComboBox.addItem(rs.getString("courseNum"));
//                        
//                    }
                    
                }
		catch(SQLException se){
			//Handle errors for JDBC
			JOptionPane.showMessageDialog(null,se,"SQLException", JOptionPane.INFORMATION_MESSAGE);
                        se.printStackTrace();
		}
                
		catch(Exception e){
			//Handle errors for Class.forName
			JOptionPane.showMessageDialog(null,e,"Exception", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();

		}
    }
    
    private void processResult(ResultSet rs) {
        try {
            while(rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt("courseID"));
                course.setCourseName(rs.getString("courseName"));
                course.setCourseNumber(rs.getString("courseNum"));
                course.setStartDate(rs.getString("startDate"));
                course.setEndDate(rs.getString("endDate"));
                course.setEmployeeID(rs.getInt("instructorEmployeeID"));
                
                courseSelectionComboBox.addItem(course.getCourseID() + ", "
                                                + course.getCourseName() + ", "
                                                + course.getStartDate() + ", "
                                                + course.getEndDate());
                courses.add(course);
                
            }
        } catch (SQLException ex) {
            
//            Logger.getLogger(InstructorMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
            
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox courseSelectionComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton nextButton;
    // End of variables declaration//GEN-END:variables
}