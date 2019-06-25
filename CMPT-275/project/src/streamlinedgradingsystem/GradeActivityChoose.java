/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

import java.io.File;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.util.ArrayList;

import ca.sfu.cmpt275.deliverable.colinq.*;

/**
 *
 * @author liufanl
 */
public class GradeActivityChoose extends javax.swing.JFrame {

    private boolean isCourseselected = false;
    private boolean isActivityselected = false;
    private boolean isStudentselected = false;

    private int selectedcourseID;
    private int selectedactivityID;
    private int selectedstudentID;

    private String courseName;
    private String activityName;
    private String studentName;

    private String activityType;

    private User userModel;
    private Course courseModel;
    private Activity activityModel;

    private int instructorID;
    private int courseID;

    private ArrayList<String> activityList = new ArrayList();
    private ArrayList<Integer> studentIDList = new ArrayList();
    private ActivityManager activityManager = new ActivityManager();

    private void getAllActivity() {

        String DB_URL = "jdbc:sqlserver://cypress;";
        String USER = "c275g11";
        String PASS = "bL344y3Emh2dPtaT";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql;
            sql = "select * from activity where courseID =" + courseID + "";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Activity newActivity = new Activity();
                newActivity.setActivityID(rs.getInt("activityID"));
                newActivity.setActivityName(rs.getString("activityName"));
                newActivity.setActivityType(rs.getString("activityType"));
                newActivity.setSubmissionPath(rs.getString("pathToSubmissions"));
                newActivity.setSolutionPath(rs.getString("pathToSolution"));
                newActivity.display();
                activityManager.addActivity(newActivity);

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {

            //Handle errors for JDBC
            JOptionPane.showMessageDialog(null, se, "SQLException", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

            //Handle errors for Class.forName
            JOptionPane.showMessageDialog(null, e, "Exception", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void getAllStudent() {

        String DB_URL = "jdbc:sqlserver://cypress;";
        String USER = "c275g11";
        String PASS = "bL344y3Emh2dPtaT";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql;
            sql = "select studentID from student where courseID =" + courseID + "";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                studentIDList.add(rs.getInt("studentID"));

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {

            //Handle errors for JDBC
            JOptionPane.showMessageDialog(null, se, "SQLException", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {

            //Handle errors for Class.forName
            JOptionPane.showMessageDialog(null, e, "Exception", JOptionPane.INFORMATION_MESSAGE);
        }

    }

//   private String getSelectedActivity(){
//       
//    }
    private void update_comobox() {

        for (Activity a : activityManager.getActivities()) {
            a.display();
            String boxItem = "";
            boxItem = Integer.toString(a.getActivityID()) + ", "
                    + a.getActivityName();
            jComboBox1.addItem(boxItem);
        }
//       for(String s: activityList){
//            jComboBox1.addItem(s);
//        }
        for (int a : studentIDList) {
            jComboBox2.addItem(a);
        }
    }

    /**
     * Creates new form GradeActivityChoose
     */
    public GradeActivityChoose(User userModel, Course courseModel) {
        this.userModel = userModel;
        this.courseModel = courseModel;

        initComponents();
        instructorID = userModel.getEmployeeID();
        courseID = courseModel.getCourseID();
        getAllActivity();
        getAllStudent();
        update_comobox();

        System.out.println("activities are :");
        for (String s : activityList) {
            System.out.println(s);
        }
        System.out.println("students are :");
        for (int a : studentIDList) {
            System.out.println(a);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Next.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Grading Activity");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Please select an activity and a student");

        Back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("select a student");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("select a activity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox2, 0, 247, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        if (activityType.equals("programming assignment")) {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GradeProgrammingActivity(userModel, courseModel, activityModel, selectedstudentID).setVisible(true);
                }
            });
        } else if (activityType.equals("essay")) {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GradingEssay(userModel, courseModel, activityModel, selectedstudentID).setVisible(true);
                }
            });
        } else /*if(activityType == "problem set")*/ {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GradingProblemSet(userModel, courseModel, activityModel, selectedstudentID).setVisible(true);
                }
            });
        }
        /*
         else{ // Mutiple choice
         this.setVisible(false);
         java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new GradingChoose().setVisible(true);
         }
         });
         }
         */
    }//GEN-LAST:event_NextActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageActivitiesGUI(userModel, courseModel).setVisible(true);
            }
        });
    }//GEN-LAST:event_BackActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String chosenActivity = (String) cb.getSelectedItem();
        int chosenID = Integer.parseInt(chosenActivity.split(",")[0]);
        activityModel = activityManager.getActivity(chosenID);
        activityType = activityModel.getActivityType();
        System.out.println("---------- activity type:" + activityType);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        int chosenStudentID = (int) cb.getSelectedItem();
        System.out.println("chosenStudentID is:" + chosenStudentID);
        selectedstudentID = chosenStudentID;
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
//            java.util.logging.Logger.getLogger(GradeActivityChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GradeActivityChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GradeActivityChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GradeActivityChoose.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GradeActivityChoose().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Next;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
