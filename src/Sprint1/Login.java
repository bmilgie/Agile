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
 * 
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
    
    protected static MainPanel main;
    
    /**
     * 
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
     * 
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
     * 
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
     * 
     * 
     * @author Team 7
     *
     */
    private class ClearErrorListener implements MouseListener
    {
    	
    	/**
    	 * 
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
     * 
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