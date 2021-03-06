/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;

import ca.sfu.cmpt275.deliverable.colinq.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author colinq
 */
public class RoleSelectionGUI extends javax.swing.JFrame {
    private User model;
    private String chosenRole;
    private String hello;

    public RoleSelectionGUI(User model) {
        this.model = model;
        chosenRole = null;
        
        initComponents();
        addItemsToCombobox();
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
        roleSelectionCombobox = new javax.swing.JComboBox();
        BackButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        roleSelectionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Please select a role to continue:");

        roleSelectionCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleSelectionComboboxActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        roleSelectionLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        roleSelectionLabel.setText("Role Selection");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(roleSelectionCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(roleSelectionLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(roleSelectionLabel)
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleSelectionCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
			new UserMenuGUI(model).setVisible(true);
		}
	});
    }//GEN-LAST:event_BackButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if(chosenRole == null) {
             JOptionPane.showMessageDialog(null,
                       "No roles selected!" , "Warning" , JOptionPane.WARNING_MESSAGE);
        }
        if(chosenRole == User.ADMINISTRATOR) {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdministratorMenuGUI(model).setVisible(true);
                            }
            });
        } 
        else if(chosenRole == User.SYSTEM_ADMINISTRATOR) {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
			new SystemAdministratorMenuGUI(model).setVisible(true);
		}
            });
        }
        else if(chosenRole == User.INSTRUCTOR) {
            Course courseModel = new Course();
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
			new InstructorMenuGUI(model, courseModel).setVisible(true);
		}
            });
        }
        else if(chosenRole == User.ADMINISTRATIVE_ASSISTANT) {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdministativeAssistantMenuGUI(model).setVisible(true);
                }
            });
        } 
        else {
            this.setVisible(false);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TAMenuGUI(model).setVisible(true);
                }
            });  
        }

    }//GEN-LAST:event_nextButtonActionPerformed

    private void roleSelectionComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleSelectionComboboxActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        chosenRole = (String)cb.getSelectedItem();
           
        //DEBUG
        System.out.println("Role chosen is: " + chosenRole);
    }//GEN-LAST:event_roleSelectionComboboxActionPerformed

    private void addItemsToCombobox() {
        ArrayList<String> roles = model.getAccount().getRoles();
        for(String role : roles) {
            roleSelectionCombobox.addItem(role);
        }
    }

    
 //    private void connectToDatabase() {
//        String userName = "c275g11";
//        String password = "bL344y3Emh2dPtaT";
//        String url = "jdbc:sqlserver://cypress;" +
//                        "user = " + userName + ";" +
//			"password = " + password;
//        
//        // DEBUGG-------------------------
//        System.out.println("\n connectionUrl = " + url + "\n\n");
//        
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        }catch(ClassNotFoundException ce) {
//            System.out.println("\n\nNo JDBC dirver; exit now.\n\n");
//            return;
//	}
//        
//        try {
//            con = DriverManager.getConnection(url);
//	} catch (SQLException se) {
//            System.out.println("\n\nFail to connect to CSIL SQL Server; exit now.\n\n");
//            return;
//        }
//    }
    
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
//            java.util.logging.Logger.getLogger(RoleSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RoleSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RoleSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RoleSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        String c="a";
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RoleSelectionGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nextButton;
    private javax.swing.JComboBox roleSelectionCombobox;
    private javax.swing.JLabel roleSelectionLabel;
    // End of variables declaration//GEN-END:variables
}
