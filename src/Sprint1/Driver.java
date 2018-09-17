package login;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;        


public class Driver {
    
    public static void createAndShowGUI() {
        MainPanel mainPanel = new MainPanel();
    	JFrame frame = new JFrame("Team7 Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(700,300));
        
        Login loginPanel = new Login(mainPanel);
        Register registerPanel = new Register(mainPanel);
        ResetPassword resetPanel = new ResetPassword(mainPanel);
<<<<<<< HEAD
        Profile profilePanel = new Profile(mainPanel); 
        ForgotUsername usernamePanel = new ForgotUsername(mainPanel);
        EditPanel editPanel = new EditPanel(mainPanel);
        mainPanel.constructPanels(loginPanel, resetPanel, registerPanel, profilePanel, usernamePanel, editPanel);
=======
        Profile profilePanel = new Profile(mainPanel);
        ForgotUsername usernamePanel = new ForgotUsername(mainPanel);
        mainPanel.constructPanels(loginPanel, resetPanel, registerPanel, profilePanel, usernamePanel);
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
        mainPanel.add(loginPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
