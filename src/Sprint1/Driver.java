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
        Profile profilePanel = new Profile(mainPanel); 
        ForgotUsername usernamePanel = new ForgotUsername(mainPanel);
        EditPanel editPanel = new EditPanel(mainPanel);
        mainPanel.constructPanels(loginPanel, resetPanel, registerPanel, profilePanel, usernamePanel, editPanel);
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