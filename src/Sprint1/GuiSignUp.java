package Sprint1;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;


/**
 * This class will create a GUI for the sign up portion.
 * 
 * @author Team 7
 *
 */
public class GuiSignUp 
{
	   private static JTextField username = new JTextField();
	   private static JTextField password = new JTextField();
	   private static JPanel mainPanel;
	   private static JLabel usernameLabel = new JLabel("Username", JLabel.CENTER);
	   private static JLabel passwordLabel = new JLabel("Password", JLabel.CENTER);
	   private static JButton submit = new JButton();
	   private static int fieldHeight = 30;
	   private static int fieldWidth = 100;
	   private static int frameHeight = 500;
	   private static int frameWidth = 500;
	   
	   
	   /**
	    * Create the GUI and show it.  For thread safety,
	    * this method should be invoked from the
	    * event-dispatching thread.
	    */
	   private static void createAndShowGUI() 
	   {
		   //JPanel
		   mainPanel = new JPanel();
		   
		   //JLabels
		   mainPanel.add(usernameLabel);
		   // only textfield put under JLabels for positioning purposes
		   mainPanel.add(username);
		   mainPanel.add(passwordLabel);
		
		   //JFrame
		   JFrame frame = new JFrame("Sign Up");
		   frame.setVisible(true);
		   frame.setSize(frameHeight, frameWidth);
		      
		   //JTextFields
	       username.setPreferredSize(new Dimension(fieldWidth,fieldHeight));
           password.setPreferredSize(new Dimension(fieldWidth,fieldHeight));
	       mainPanel.add(password);
	       
	       //JButton
	       submit = new JButton("Submit");
	       mainPanel.add(submit);
	       
	       //creates the frame and maximum panel width/height
	       frame.getContentPane().add(mainPanel);
	       mainPanel.setMaximumSize(new Dimension(frameWidth,frameHeight));
	       
	       submit.addActionListener(new ActionListener()
	    	       {
	    	         public void actionPerformed(ActionEvent e)
	    	         {
	    	           if(username.getText().equals("a") && password.getText().equals("b")) {
	    	            mainPanel.removeAll();
	    	           	mainPanel.add(new JLabel("logged in"));
	    	           }else {
	    	            JOptionPane.showMessageDialog(frame, "Sorry, try again.");
	    
	    	           }
	    
	    	         }
	    	       });
	   }
	   
	   
	   /**
	    * 
	    * Runs the GUI
	 * @param args
	 */
	public static void main(String[] args) 
	   {
	      createAndShowGUI();
	   }
}
