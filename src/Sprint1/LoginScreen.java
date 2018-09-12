package Sprint1;

import java.awt.Dimension;
import java.awt.event.*;

/*
* HelloWorldSwing.java requires no other files. 
*/
import javax.swing.*;        

/**
 * This class creates and shows the login screen
 * 
 * @author Team 7
 *
 */
public class LoginScreen {


   private static JTextField username = new JTextField();
   private static JTextField password = new JTextField();
   private static JLabel usernameLabel = new JLabel();
   private static JLabel passwordLabel = new JLabel();
   private static JPanel mainPanel = new JPanel();
   public boolean loginFailed;
   
   /**
    * Create the GUI and show it.  For thread safety,
    * this method should be invoked from the
    * event-dispatching thread.
    */
   private static void createAndShowGUI() {
       //Create and set up the window.
       JFrame frame = new JFrame("HelloWorldSwing");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JButton submit = new JButton("submit");
       usernameLabel.setPreferredSize(new Dimension(100,100));
       passwordLabel.setPreferredSize(new Dimension(100,100));
       username.setPreferredSize(new Dimension(100,50));
       password.setPreferredSize(new Dimension(100,50));
       password.setPreferredSize(new Dimension(100,50));
       mainPanel.add(username);
       mainPanel.add(password);
       mainPanel.add(submit);
       frame.getContentPane().add(mainPanel);
       
       
       
       submit.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {
           if(username.getText().equals("a") && password.getText().equals("b")) {
            mainPanel.removeAll();
		loginFailed = false;
           	mainPanel.add(new JLabel("logged in"));
           }else {
            	JOptionPane.showMessageDialog(frame, "Sorry, try again.");
		loginFailed = true;
           }

         }
       });
       
       frame.pack();
       frame.setVisible(true);
   }
   
   /**
 * @returns the username of the user
 */
public String getUsername() {
	   return ""; //username
   }
   //this is testing the git commit
//   public void setUsername(Username user) {
//	   return this.user; //username
//   }

   /**
    * This method will run the GUI
    * 
 * @param args
 */
public static void main(String[] args) {
       //Schedule a job for the event-dispatching thread:
       //creating and showing this application's GUI.
       javax.swing.SwingUtilities.invokeLater(new Runnable() 
       {
           public void run() 
           {
               createAndShowGUI();
           }
       });
   }

}


