package Sprint1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is the logic behind what you see on the user window when 
 * you are trying to login. This class creates the username and password 
 * text field, the login, register, and reset password buttons.  
 * 
 * @author Team 7
 *
 */
public class Login extends JPanel 
{
	private static JTextField username = new JTextField();
    private static JTextField password = new JTextField();
    private static JPanel thisPanel = new JPanel();
    private static JButton submit = new JButton("Login");
    private static JButton register = new JButton("Register");
    private static JButton reset = new JButton("Reset Password");
	private static JLabel passwordLabel = new JLabel("Password");
	private static JLabel usernameLabel = new JLabel("Username");
	private static JLabel errorLabel = new JLabel("");
    private static JLabel headerLabel = new JLabel("Login");
<<<<<<< HEAD
    
    protected static MainPanel main;
=======
    private static MainPanel main;
>>>>>>> b8945faa22e8d8b2cc67c71c836b42e854eefc23
    
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
        errorLabel.addMouseListener(clearErrorListener);
        submit.addActionListener(submitListener);
        reset.addActionListener(resetListener);
        register.addActionListener(registerListener);
        
   
        this.add(thisPanel);
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
    private class ClearErrorListener implements MouseListener
    {
    	
    	/**
    	 * Unused action performed method
    	 * 
    	 * @param e
    	 */
    	public void actionPerformed(ActionEvent e) 
    	{
    		
    	}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
		 */
		public void mouseClicked(MouseEvent arg0) 
		{
			errorLabel.setText("");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) 
		{
			// TODO Auto-generated method stub
			
		}

    }
    
    /**
     * This class creates the ActionListner when the user wants to
     * successfully login, successfully create an account, or successfully
     * reset your password.
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