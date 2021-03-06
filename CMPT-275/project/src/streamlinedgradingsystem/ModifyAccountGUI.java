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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

/**
 *
 * @author colinq
 */
public class ModifyAccountGUI extends javax.swing.JFrame {
    private User userModel;
    private User chosenUser;
    private User originalUser;
    private UserManager userManager;
    private UserAccount chosenAccount;
    private Connection con;
    /**
     * Creates new form ModifyAccountGUI
     */
    public ModifyAccountGUI(User userModel, User chosenUser) {
        this.userModel = userModel;
        this.userManager = new UserManager();
        this.chosenUser = chosenUser;
        chosenAccount = chosenUser.getAccount();
        
        initComponents();
        connectToDatabase();
        loadAccountsIntoModel();
        
        originalUser = userManager.getUser(chosenUser);      
        
        System.out.println("Chosen user is: ");
        chosenUser.display();
        System.out.println("original user is: ");
        originalUser.display();
        
        displayUserInfo();
        
        System.out.println("initialized manager is: ");
        userManager.display();
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
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        employeeIDField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        middleNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        loginIDField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        systemAdministratorCheckbox = new javax.swing.JCheckBox();
        administrativeAssistantCheckbox = new javax.swing.JCheckBox();
        instructorCheckbox = new javax.swing.JCheckBox();
        TACheckbox = new javax.swing.JCheckBox();
        administratorCheckbox = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        generateTempPasswordButton = new javax.swing.JButton();
        tempPasswordLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        accountIDLabel = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("View Account");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Modify Account");

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("User Information:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("First Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Middle Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Last Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Employee ID:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Login ID:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Password:");

        employeeIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIDFieldActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        systemAdministratorCheckbox.setText("System Administrator");
        systemAdministratorCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systemAdministratorCheckboxActionPerformed(evt);
            }
        });

        administrativeAssistantCheckbox.setText("Administrative Assistant");
        administrativeAssistantCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrativeAssistantCheckboxActionPerformed(evt);
            }
        });

        instructorCheckbox.setText("Instructor");
        instructorCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorCheckboxActionPerformed(evt);
            }
        });

        TACheckbox.setText("TA/TM");
        TACheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TACheckboxActionPerformed(evt);
            }
        });

        administratorCheckbox.setText("Administrator");
        administratorCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administratorCheckboxActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Role(s):");

        generateTempPasswordButton.setText("Generate Temporary Password");
        generateTempPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateTempPasswordButtonActionPerformed(evt);
            }
        });

        tempPasswordLabel.setText("Temp Password");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Account ID:");

        accountIDLabel.setText("jLabel12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(288, 288, 288))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(261, 261, 261))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                    .addComponent(middleNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                    .addComponent(employeeIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                    .addComponent(loginIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                    .addComponent(tempPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(accountIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                                        .addComponent(generateTempPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(111, 111, 111)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(systemAdministratorCheckbox)
                                            .addComponent(administratorCheckbox))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(administrativeAssistantCheckbox)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(instructorCheckbox)
                                                .addGap(40, 40, 40)
                                                .addComponent(TACheckbox)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(accountIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(employeeIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(middleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(loginIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(generateTempPasswordButton)
                    .addComponent(tempPasswordLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(administratorCheckbox)
                            .addComponent(administrativeAssistantCheckbox))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TACheckbox)
                            .addComponent(systemAdministratorCheckbox)
                            .addComponent(instructorCheckbox))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAccountGUI(userModel).setVisible(true);
            }
        });
    }//GEN-LAST:event_backButtonActionPerformed

    private void systemAdministratorCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systemAdministratorCheckboxActionPerformed
        AbstractButton button = (AbstractButton) evt.getSource();
        boolean isSelected = button.getModel().isSelected();
        if (isSelected) {
            chosenAccount.addRole(User.SYSTEM_ADMINISTRATOR);
        } else {
            chosenAccount.removeRole(User.SYSTEM_ADMINISTRATOR);
        }

        // DEBUGGING--------------------------
        chosenAccount.dump();
    }//GEN-LAST:event_systemAdministratorCheckboxActionPerformed

    private void administrativeAssistantCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrativeAssistantCheckboxActionPerformed
        AbstractButton button = (AbstractButton) evt.getSource();
        boolean isSelected = button.getModel().isSelected();
        if (isSelected) {
            chosenAccount.addRole(User.ADMINISTRATIVE_ASSISTANT);
        } else {
            chosenAccount.removeRole(User.ADMINISTRATIVE_ASSISTANT);
        }

        // DEBUGGING--------------------------
        chosenAccount.dump();
    }//GEN-LAST:event_administrativeAssistantCheckboxActionPerformed

    private void instructorCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructorCheckboxActionPerformed
        AbstractButton button = (AbstractButton) evt.getSource();
        boolean isSelected = button.getModel().isSelected();
        if (isSelected) {
            chosenAccount.addRole(User.INSTRUCTOR);
        } else {
            chosenAccount.removeRole(User.INSTRUCTOR);
        }

        // DEBUGGING--------------------------
       chosenAccount.dump();
    }//GEN-LAST:event_instructorCheckboxActionPerformed

    private void TACheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TACheckboxActionPerformed
        AbstractButton button = (AbstractButton) evt.getSource();
        boolean isSelected = button.getModel().isSelected();
        if (isSelected) {
            chosenAccount.addRole(User.TA);
        } else {
            chosenAccount.removeRole(User.TA);
        }

        // DEBUGGING--------------------------
        chosenAccount.dump();
    }//GEN-LAST:event_TACheckboxActionPerformed

    private void administratorCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administratorCheckboxActionPerformed
        AbstractButton button = (AbstractButton) evt.getSource();
        boolean isSelected = button.getModel().isSelected();
        if (isSelected) {
            chosenAccount.addRole(User.ADMINISTRATOR);
        } else {
            chosenAccount.removeRole(User.ADMINISTRATOR);
        }

        // DEBUGGING--------------------------
        chosenAccount.dump();
    }//GEN-LAST:event_administratorCheckboxActionPerformed

    private void generateTempPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateTempPasswordButtonActionPerformed
        Random rand = new Random();
        String tempPassword = Integer.toString(rand.nextInt(Integer.MAX_VALUE) + 1);
        chosenAccount.setPassword(tempPassword);
        chosenAccount.makePasswordTemp();
        tempPasswordLabel.setText(tempPassword);
        //Debug
        chosenAccount.dump();
    }//GEN-LAST:event_generateTempPasswordButtonActionPerformed

    private void employeeIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIDFieldActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        
        
        
        int employeeID = -1;
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String middleName = middleNameField.getText();
        String loginID = loginIDField.getText();
        try {
            employeeID = Integer.parseInt(employeeIDField.getText());
            chosenUser.setEmployeeID(employeeID);
            chosenUser.setFirstName(firstName);
            chosenUser.setLastName(lastName);
            chosenUser.setMiddleName(middleName);
            chosenAccount.setLoginID(loginID);
            chosenUser.addAccount( chosenAccount);
            
            if (validateAccountInfo()) {
                
                
                
                System.out.println("\nmofified user is: ");
                
                chosenUser.display();
                if (validateDuplicateIDs()) {
                    try {
                        updateAccount();
                        JOptionPane.showMessageDialog(null,
                                "Modification Successful!" , "Information" , JOptionPane.INFORMATION_MESSAGE);
                       // originalUser = chosenUser;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(ModifyAccountGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Please enter the ID only in integer type, with maximum digit of 10." ,
                    "Incorrect ID Format" , JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_confirmButtonActionPerformed
    
    private void updateAccount() throws SQLException {
        
        if (originalUser.getEmployeeID() != chosenUser.getEmployeeID()) {
            String sql = "UPDATE Account SET employeeID = " + chosenUser.getEmployeeID()
                    + " WHERE accountID = " + chosenAccount.getAccountID();
            executeSQL(sql);
        }
        if (!originalUser.getAccount().getLoginID().equals(chosenUser.getAccount().getLoginID())) {
            String sql = "UPDATE Account SET loginID = '" + chosenUser.getAccount().getLoginID()
                    + "' WHERE accountID = " + chosenAccount.getAccountID();
            executeSQL(sql);
        }
        if (!originalUser.getAccount().getPassword().equals(chosenUser.getAccount().getPassword())) {
            String sql = "UPDATE Account SET password = '" + chosenUser.getAccount().getPassword()
                    + "' WHERE accountID = " + chosenAccount.getAccountID();
            executeSQL(sql);
        }
        if (!originalUser.getFirstName().equals(chosenUser.getFirstName())) {
            String sql = "UPDATE Account SET firstName = '" + chosenUser.getFirstName()
                    + "' WHERE accountID = " + chosenAccount.getAccountID();
            executeSQL(sql);
        }
        if (!originalUser.getMiddleName().equals(chosenUser.getMiddleName())) {
            String sql = "UPDATE Account SET middleName = '" + chosenUser.getMiddleName()
                    + "' WHERE accountID = " + chosenAccount.getAccountID();
            executeSQL(sql);
        }
        if (!originalUser.getLastName().equals(chosenUser.getLastName())) {
            String sql = "UPDATE Account SET lastName = '" + chosenUser.getLastName()
                    + "' WHERE accountID = " + chosenAccount.getAccountID();
            executeSQL(sql);
        }
        String sql = "UPDATE Account SET ispasswdtemp = " + chosenAccount.isPassTemp()
                + " WHERE accountID = " + chosenAccount.getAccountID();
        executeSQL(sql);
        String roleSQL = "";
        roleSQL = "UPDATE Account SET isAssistAdmin = " + chosenAccount.isAdministrativeAssistant()
                + ", isSysAdmin = " + chosenAccount.isSystemAdministrator()
                + ", isAdministrator = " + chosenAccount.isAdministrator()
                + ", isInstructor = " + chosenAccount.isInstructor()
                + ", isTA = " + chosenAccount.isTA()
                + " WHERE accountID = " + chosenAccount.getAccountID();
        executeSQL(roleSQL);   
    }
    
    private void executeSQL(String sql) throws SQLException {
        
         Statement stmt = con.createStatement();
         stmt.executeUpdate(sql);
//        try {
//           
//        } catch (SQLException ex) {
//            
//            Logger.getLogger(ModifyAccountGUI.class.getName()).log(Level.SEVERE, null, ex);
//            ex.printStackTrace();
//        }
    }
    
    private boolean validateDuplicateIDs() {
        
        for (User user : userManager.getUsers()) {
            if (!user.equals(originalUser)) {
                if (user.getAccount().getLoginID().equals(chosenUser.getAccount().getLoginID())) {
                    JOptionPane.showMessageDialog(null,
                            "The User ID has already been used!",
                            "Warning" , JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                if (user.getEmployeeID() == chosenUser.getEmployeeID()) {
                    JOptionPane.showMessageDialog(null,
                            "The Employee ID has already been used!",
                            "Warning" , JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }
    /*
    private boolean validateDuplicateRoles(User user) {
        if (userManager.getUser(user) == null) {
                return true;
        } else {
            for(String role : user.getAccount().getRoles()) {
                if (userManager.getUser(user).searchRole(role)) {
                    JOptionPane.showMessageDialog(null,
                            "This user already has account with the role: " + role + "!",
                            "Warning" , JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
          return true;
        }
       
    }
    */
    
    
    private boolean validateAccountInfo() {
       if(chosenUser.getEmployeeID() == 0) {
           JOptionPane.showMessageDialog(null,
                       "No Employee ID!" , "Warning!" , JOptionPane.WARNING_MESSAGE);
           return false;
       }
       if(chosenUser.getEmployeeID() < 0) {
           JOptionPane.showMessageDialog(null,
                       "No Employee ID!" , "ID Format!" , JOptionPane.WARNING_MESSAGE);
           return false;
       }
       if(chosenUser.getFirstName() == null || chosenUser.getFirstName().equals("")) {
            JOptionPane.showMessageDialog(null,
                       "No First Name!" , "Warning!" , JOptionPane.WARNING_MESSAGE);
           return false;
       }
       if(chosenUser.getLastName() == null || chosenUser.getLastName().equals("")) {
            JOptionPane.showMessageDialog(null,
                       "No Last Name!" , "Warning!" , JOptionPane.WARNING_MESSAGE);
           return false;
       }
       if(chosenAccount.getLoginID() == null || chosenAccount.getLoginID().equals("")) {
            JOptionPane.showMessageDialog(null,
                       "No Login ID!" , "Warning!" , JOptionPane.WARNING_MESSAGE);
           return false;
       }
       
       if(chosenAccount.getPassword() == null || chosenAccount.getPassword().equals("")) {
             JOptionPane.showMessageDialog(null,
                       "No Temp Password!" , "Warning!" , JOptionPane.WARNING_MESSAGE);
           return false;
       }
       if(chosenAccount.getRoles().isEmpty()) {
           JOptionPane.showMessageDialog(null,
                       "No Roles Selected!" , "Warning!" , JOptionPane.WARNING_MESSAGE);
           return false;
       }
       return true;
   }
    
     private void displayUserInfo() {
        accountIDLabel.setText(Integer.toString(chosenUser.getAccount().getAccountID()));
        employeeIDField.setText(Integer.toString(chosenUser.getEmployeeID()));
        firstNameField.setText(chosenUser.getFirstName());
        middleNameField.setText(chosenUser.getMiddleName());
        lastNameField.setText(chosenUser.getLastName());
//        accountIDField.setText(Integer.toString(chosenUser.getAccount().getAccountID()));
        loginIDField.setText(chosenUser.getAccount().getLoginID());
        tempPasswordLabel.setText(chosenUser.getAccount().getPassword());
        
        UserAccount acct = chosenUser.getAccount();
        if (acct.isAdministrativeAssistant() == 1) {
            administrativeAssistantCheckbox.setSelected(true);
        }
        if (acct.isAdministrator() == 1) {
            administratorCheckbox.setSelected(true);
        }
        if (acct.isSystemAdministrator() == 1) {
            systemAdministratorCheckbox.setSelected(true);
        }
        if (acct.isInstructor() == 1) {
            instructorCheckbox.setSelected(true);
        }
        if (acct.isTA() == 1) {
            TACheckbox.setSelected(true);
        }
    }
     
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
     
    private void loadAccountsIntoModel() {
        try {
            PreparedStatement stat = con.prepareStatement(
                    "SELECT * FROM Account");
            ResultSet accounts = executeQuery(stat);
            processAccountInfo(accounts);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private ResultSet executeQuery(PreparedStatement pstmt) {
        try {
            return(pstmt.executeQuery());
        } catch (SQLException se){
            System.out.println("\nSQL Exception occured, the state : "+
                    se.getSQLState()+"\nMessage:\n"+se.getMessage()+"\n");
            return null;
        }
    }
    
     private void processAccountInfo(ResultSet accounts) throws SQLException {
        
        while(accounts.next()) {
            User nextUser = new User();
            UserAccount nextUserAccount = new UserAccount();
            
            nextUser.setFirstName(accounts.getString("firstName"));
            nextUser.setMiddleName(accounts.getString("middleName"));
            nextUser.setLastName(accounts.getString("lastName"));
            nextUser.setEmployeeID(accounts.getInt("employeeID"));
            nextUserAccount.setLoginID(accounts.getString("loginID"));
            nextUserAccount.setAccountID(accounts.getInt("accountID"));
            nextUserAccount.setPassword(accounts.getString("password"));
            if (accounts.getInt("islocked") == 1) {
                nextUserAccount.blockAccount();
            } else {
                nextUserAccount.unBlockAccount();
            }
            if (accounts.getInt("ispasswdTemp") == 1) {
                nextUserAccount.makePasswordTemp();
            } else {
                nextUserAccount.makePassReal();
            }
            
            
            if (accounts.getInt("isAdministrator") == 1) {
                nextUserAccount.addRole(User.ADMINISTRATOR);
            }
            if (accounts.getInt("isAssistAdmin") == 1) {
                nextUserAccount.addRole(User.ADMINISTRATIVE_ASSISTANT);
            }
            if (accounts.getInt("isSysAdmin") == 1) {
                nextUserAccount.addRole(User.SYSTEM_ADMINISTRATOR);
            }
            if (accounts.getInt("isTA") == 1) {
                nextUserAccount.addRole(User.TA);
            }
            if (accounts.getInt("isInstructor") == 1){
                nextUserAccount.addRole(User.INSTRUCTOR);
            }
            
            nextUser.addAccount(nextUserAccount);
//            if (nextUser.getEmployeeID() != chosenUser.getEmployeeID()) {
//                userManager.addUser(nextUser);
//            }
            userManager.addUser(nextUser);
        }
    }
     
    
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
//            java.util.logging.Logger.getLogger(ModifyAccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ModifyAccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ModifyAccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ModifyAccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ModifyAccountGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox TACheckbox;
    private javax.swing.JLabel accountIDLabel;
    private javax.swing.JCheckBox administrativeAssistantCheckbox;
    private javax.swing.JCheckBox administratorCheckbox;
    private javax.swing.JButton backButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField employeeIDField;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton generateTempPasswordButton;
    private javax.swing.JCheckBox instructorCheckbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField loginIDField;
    private javax.swing.JTextField middleNameField;
    private javax.swing.JCheckBox systemAdministratorCheckbox;
    private javax.swing.JLabel tempPasswordLabel;
    // End of variables declaration//GEN-END:variables
}
