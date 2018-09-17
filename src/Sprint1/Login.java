<<<<<<< HEAD
package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Login extends JPanel {
	public static JTextField username = new JTextField();
    public static JTextField password = new JPasswordField();
    private static JPanel thisPanel = new JPanel();
    public static JButton submit = new JButton("Login");
    private static JButton register = new JButton("Register");
    private static JButton reset = new JButton("Reset Password");
    private static JButton forgot = new JButton("Forgot Username");
	private static JLabel passwordLabel = new JLabel("Password");
	private static JLabel usernameLabel = new JLabel("Username");
	private static JLabel errorLabel = new JLabel("");
    private static JLabel headerLabel = new JLabel("Login");
    private static MainPanel main;
    
    public Login(MainPanel mainPanel) {
        Login.main = mainPanel;
		this.add(headerLabel);
		Login.headerLabel.setPreferredSize(new Dimension(700,40));
		Login.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));
		
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		
		username.setPreferredSize(new Dimension(150,25));
        password.setPreferredSize(new Dimension(150, 25));
        
		JPanel usernameRow = new JPanel();
		usernameRow.add(usernameLabel);
		usernameRow.add(username);
		this.add(usernameRow);
        
		
		JPanel passwordRow = new JPanel();
		passwordRow.add(passwordLabel);
		passwordRow.add(password);
		this.add(passwordRow);
		
		JPanel errorRow = new JPanel();
		errorRow.add(errorLabel);
		Login.errorLabel.setFont(new Font("Serif", Font.BOLD, 14));
		Login.errorLabel.setForeground(Color.RED);
		this.add(errorRow);

		JPanel buttonRow = new JPanel();
		buttonRow.add(submit);
		buttonRow.add(register);
		buttonRow.add(reset);
		buttonRow.add(forgot);
		this.add(buttonRow);


		ClearErrorListener clearErrorListener  = new ClearErrorListener();
		SubmitListener submitListener  = new SubmitListener();
        ResetListener resetListener  = new ResetListener();
        RegisterListener registerListener  = new RegisterListener();
        ForgotListener forgotListener = new ForgotListener();
        errorLabel.addMouseMotionListener(clearErrorListener);
        submit.addActionListener(submitListener);
        reset.addActionListener(resetListener);
        register.addActionListener(registerListener);
        forgot.addActionListener(forgotListener);
        
   
        this.add(thisPanel);
    }
    public void clearTextFields(){
		this.username.setText("");
		this.password.setText("");		
	}
  
    private class ForgotListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		main.sendEvent("forgot");
    	}
    }
    private class ResetListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		main.sendEvent("reset");
    	}
    }
    private class RegisterListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		main.sendEvent("register");
    	}
    }
    private class ClearErrorListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			errorLabel.setText("");			
		}
    	
    }
    private class SubmitListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		String userName = username.getText();
    		String passWord = password.getText();

    		if(main.validateCredentials(userName, passWord)) {
    			main.setCurrentUser(userName);
    			main.sendEvent("login");
    		}else {
    			errorLabel.setText("Invalid Credentials");
    		}
    	}
    }
	public static void createAndShowGUI() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		
	}
}
=======
package Sprint1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * This class is the logic behind what you see on the user window when 
 * you are trying to login. This class validates if the username and password are
 * in the data structure.   
 * 
 * @author Team 7
 *
 */
public class Login extends JPanel 
{
	public static JTextField username = new JTextField();
    public static JTextField password = new JPasswordField();
    private static JPanel thisPanel = new JPanel();
    public static JButton submit = new JButton("Login");
    public static JButton register = new JButton("Register");
    public static JButton reset = new JButton("Reset Password");
    private static JButton forgot = new JButton("Forgot Username");
	private static JLabel passwordLabel = new JLabel("Password");
	private static JLabel usernameLabel = new JLabel("Username");
	public static JLabel errorLabel = new JLabel("");
    private static JLabel headerLabel = new JLabel("Login");
    private static MainPanel main;
    
    /**
     * This method creates all of the aesthetics of the login window.
     * This is the logic behind what you see on the login window.
     * 
     * @param mainPanel
     */
    public Login(MainPanel mainPanel) 
    {
	    this.main = mainPanel;
		this.add(headerLabel);
		this.headerLabel.setPreferredSize(new Dimension(700,40));
		this.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));
	
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
	
		username.setPreferredSize(new Dimension(150,25));
		password.setPreferredSize(new Dimension(150, 25));
	
		JPanel usernameRow = new JPanel();
		usernameRow.add(usernameLabel);
		usernameRow.add(username);
		this.add(usernameRow);
	
	
		JPanel passwordRow = new JPanel();
		passwordRow.add(passwordLabel);
		passwordRow.add(password);
		this.add(passwordRow);
	
		JPanel errorRow = new JPanel();
		errorRow.add(errorLabel);
		this.errorLabel.setFont(new Font("Serif", Font.BOLD, 14));
		this.errorLabel.setForeground(Color.RED);
		this.add(errorRow);
	
		JPanel buttonRow = new JPanel();
		buttonRow.add(submit);
		buttonRow.add(register);
		buttonRow.add(reset);
		this.add(buttonRow);
	
	
		ClearErrorListener clearErrorListener  = new ClearErrorListener();
		SubmitListener submitListener  = new SubmitListener();
	        ResetListener resetListener  = new ResetListener();
	        RegisterListener registerListener  = new RegisterListener();
		ForgotListener forgotListener = new ForgotListener();
	        errorLabel.addMouseMotionListener(clearErrorListener);
	        submit.addActionListener(submitListener);
	        reset.addActionListener(resetListener);
	        register.addActionListener(registerListener);
		forgot.addActionListener(forgotListener);
	        
	   
	        this.add(thisPanel);	
    }
    
     /**
     * This action listener class is used when the forgot username button is clicked 
     * and changes to the forgot username window.
     * 
     * @author Team 7
     *
     */
    private class ForgotListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
	{
    		main.sendEvent("forgot");
    	}
    }
    
    /**
     * This action listener class is used when the reset button is clicked 
     * and changes to the reset password window.
     * 
     * @author Team 7
     *
     */
    private class ResetListener implements ActionListener
    {
    	
    	public void actionPerformed(ActionEvent e) 
    	{
    		main.sendEvent("reset");
    	}
    }
    
    /**
     * This action listener class is used when the register button is clicked 
     * and changes to the register window.
     * 
     * @author Team 7
     *
     */
    private class RegisterListener implements ActionListener
    {
    	
    	public void actionPerformed(ActionEvent e) 
    	{
    		main.sendEvent("register");
    	}
    }
    
    /**
     * This class implements the methods when a mouse clicks on a
     * button on the login, register, or reset password window 
     * 
     * @author Team 7
     *
     */
    private class ClearErrorListener implements  MouseMotionListener
    {
    	

		@Override
		public void mouseDragged(MouseEvent arg0) 
		{
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) 
		{
			errorLabel.setText("");
			
		}

    }
    
    /**
     * This class creates the ActionListner when the user wants to
     * successfully logging in.
     * 
     * @author Team 7
     *
     */
    private class SubmitListener implements ActionListener
    {
    	
    	public void actionPerformed(ActionEvent e) 
    	{
    		String userName = username.getText();
    		String passWord = password.getText();

    		if(main.validateCredentials(userName, passWord)) 
    		{

    			main.sendEvent("login");
    		}
    		
    		else 
    		{
    			errorLabel.setText("Invalid Credentials");
    		}
    	}
    }
}
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
