/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamlinedgradingsystem;
import ca.sfu.cmpt275.deliverable.colinq.*;
import javax.swing.*;
/**
 *
 * @author colinq
 */
public class StreamlinedGradingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User userModel = new User();
        Course courseModel = new Course();
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                  new LoginGUI().setVisible(true);
            }
        });
        
    }
    
}
