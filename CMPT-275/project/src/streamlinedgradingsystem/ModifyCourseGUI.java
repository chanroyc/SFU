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

public class ModifyCourseGUI extends javax.swing.JFrame {
    private int test = 0;
    public final static int FIRSTNAME_INDEX = 0;
    public final static int MIDLLENAME_INDEX = 1;
    public final static int LASTNAME_INDEX = 2;
    public final static int EMPLOYEEID_INDEX = 3;
    public final static String SPLIT_SYMBOL = ",";
    /**
     * Creates new form ModifyCourseGUI
     */
    private Connection con;
    private Course courseModel;
    private User userModel;
    public ModifyCourseGUI(User userModel, Course courseModel) {
        this.userModel = userModel;
        this.courseModel = courseModel;
        initComponents();
        
        //display the current course being modified
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newCourseNumField = new javax.swing.JTextField();
        currentlyModTitle = new javax.swing.JLabel();
        newCourseNameLbl = new javax.swing.JLabel();
        newStartDateLbl = new javax.swing.JLabel();
        newEndDateLbl = new javax.swing.JLabel();
        courseNameLbl = new javax.swing.JLabel();
        newCourseNameField = new javax.swing.JTextField();
        newStartDateField = new javax.swing.JTextField();
        currentLbl = new javax.swing.JLabel();
        newLbl = new javax.swing.JLabel();
        startDateLbl = new javax.swing.JLabel();
        endDateLbl = new javax.swing.JLabel();
        newEndDateField = new javax.swing.JTextField();
        newCourseNumLbl = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        instructionLbl = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        courseNumLbl = new javax.swing.JLabel();
        courseNameField = new javax.swing.JTextField();
        courseNumField = new javax.swing.JTextField();
        startDateField = new javax.swing.JTextField();
        endDateField = new javax.swing.JTextField();
        insertCourseNameTitle = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newCourseNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCourseNumFieldActionPerformed(evt);
            }
        });

        currentlyModTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        currentlyModTitle.setText("Currently Modifying:");

        newCourseNameLbl.setText("Course Name (eg. Intro Computing):");

        newStartDateLbl.setText("Start Date (YYYY-MM-DD):");

        newEndDateLbl.setText("End Date (YYYY-MM-DD):");

        courseNameLbl.setText("Course Name:");

        newCourseNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCourseNameFieldActionPerformed(evt);
            }
        });

        currentLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        currentLbl.setText("Current");

        newLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        newLbl.setText("New");

        startDateLbl.setText("Start Date:");

        endDateLbl.setText("End Date:");

        newCourseNumLbl.setText("Course Number (eg. CMPT100):");

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        instructionLbl.setText("(Blank fields will be left unchanged.)");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        courseNumLbl.setText("Course Number:");

        courseNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameFieldActionPerformed(evt);
            }
        });

        courseNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNumFieldActionPerformed(evt);
            }
        });

        startDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateFieldActionPerformed(evt);
            }
        });

        endDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateFieldActionPerformed(evt);
            }
        });

        insertCourseNameTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insertCourseNameTitle.setForeground(java.awt.Color.blue);
        insertCourseNameTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertCourseNameTitleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(currentLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instructionLbl)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(currentlyModTitle)
                .addGap(18, 18, 18)
                .addComponent(insertCourseNameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(234, 234, 234))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseNameLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startDateLbl, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(courseNumField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                    .addComponent(startDateField)
                                    .addComponent(courseNameField, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(courseNumLbl)
                            .addComponent(endDateLbl)
                            .addComponent(endDateField))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newCourseNumLbl)
                            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newEndDateLbl)
                            .addComponent(newStartDateLbl)
                            .addComponent(newCourseNameLbl)
                            .addComponent(newCourseNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(newCourseNumField)
                            .addComponent(newStartDateField)
                            .addComponent(newEndDateField))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentlyModTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertCourseNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newLbl)
                    .addComponent(currentLbl)
                    .addComponent(instructionLbl))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseNameLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newCourseNameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newCourseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseNumLbl)
                    .addComponent(newCourseNumLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newCourseNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateLbl)
                    .addComponent(newStartDateLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newStartDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDateLbl)
                    .addComponent(newEndDateLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newEndDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newCourseNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCourseNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newCourseNumFieldActionPerformed

    private void newCourseNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCourseNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newCourseNameFieldActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
       
        String acourseName= courseModel.getCourseName();
        String acourseNum= courseModel.getCourseNumber();
        String astartDate = courseModel.getStartDate();
        String aendDate = courseModel.getEndDate();
        
        //change only if the field contains text
        if (!newCourseNameField.getText().equals("")){
            acourseName = newCourseNameField.getText();
            courseModel.setCourseName(acourseName);
        }
        if (!newCourseNumField.getText().equals("")){
            acourseNum = newCourseNumField.getText();
            courseModel.setCourseNumber(acourseNum);
        }
        if (!newStartDateField.getText().equals("")){
            astartDate = newStartDateField.getText();
            courseModel.setStartDate(astartDate);
        }
        if (!newEndDateField.getText().equals("")){
            aendDate = newEndDateField.getText();
            courseModel.setEndDate(aendDate);
        }

        
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
                //update course attributes with updated inputs
                sql = "UPDATE Course SET courseName = '" +courseModel.getCourseName()+"',courseNum = '"+courseModel.getCourseNumber()+"', startDate = '"+courseModel.getStartDate()+"', endDate = '"+courseModel.getEndDate()+"' WHERE courseID = '"+courseModel.getCourseID()+"'";
                        
                       

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
        //set next screen to modify TA/instructor
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ModifyCourseMarkerGUI(userModel, courseModel).setVisible(true);
                }
            });
    }//GEN-LAST:event_nextButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //move back to search course screen
        this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SearchCourseModifyGUI(userModel, courseModel).setVisible(true);
                }
            });
    }//GEN-LAST:event_backButtonActionPerformed

    private void courseNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameFieldActionPerformed
        

    }//GEN-LAST:event_courseNameFieldActionPerformed

    private void startDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateFieldActionPerformed

    private void endDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateFieldActionPerformed

    private void courseNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNumFieldActionPerformed

    private void insertCourseNameTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertCourseNameTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertCourseNameTitleActionPerformed

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
//            java.util.logging.Logger.getLogger(ModifyCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ModifyCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ModifyCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ModifyCourseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        //</editor-fold>
//
//        //</editor-fold>
//
//        //</editor-fold>
//
//        //</editor-fold>
//
//        //</editor-fold>
//
//        //</editor-fold>
//
//        //</editor-fold>
//
//        /* Create and display the form */
//
//    }
     private void connectToDatabase() {
        String userName = "c275g11";
        String password = "bL344y3Emh2dPtaT";
        String url = "jdbc:sqlserver://cypress;" +
                        "user = " + userName + ";" +
			"password = " + password;
        
        // DEBUGG-------------------------
        System.out.println("\n connectionUrl = " + url + "\n\n");
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException ce) {
            System.out.println("\n\nNo JDBC dirver; exit now.\n\n");
            return;
	}
        
        try {
            con = DriverManager.getConnection(url);
	} catch (SQLException se) {
            System.out.println("\n\nFail to connect to CSIL SQL Server; exit now.\n\n");
            return;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField courseNameField;
    private javax.swing.JLabel courseNameLbl;
    private javax.swing.JTextField courseNumField;
    private javax.swing.JLabel courseNumLbl;
    private javax.swing.JLabel currentLbl;
    private javax.swing.JLabel currentlyModTitle;
    private javax.swing.JTextField endDateField;
    private javax.swing.JLabel endDateLbl;
    private javax.swing.JTextField insertCourseNameTitle;
    private javax.swing.JLabel instructionLbl;
    private javax.swing.JTextField newCourseNameField;
    private javax.swing.JLabel newCourseNameLbl;
    private javax.swing.JTextField newCourseNumField;
    private javax.swing.JLabel newCourseNumLbl;
    private javax.swing.JTextField newEndDateField;
    private javax.swing.JLabel newEndDateLbl;
    private javax.swing.JLabel newLbl;
    private javax.swing.JTextField newStartDateField;
    private javax.swing.JLabel newStartDateLbl;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField startDateField;
    private javax.swing.JLabel startDateLbl;
    // End of variables declaration//GEN-END:variables
}
