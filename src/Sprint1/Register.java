package Sprint1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class holds the logic for the registration.
 * 
 * @author Team 7 
 *
 */
public class Register extends JPanel 
{
	
	private static MainPanel main;
	private static JButton backButton = new JButton("Back");
	private static JTextField userNameText = new JTextField();
	private static JTextField password1Text = new JTextField();
	private static JTextField password2Text = new JTextField();
	private static JTextField emailText = new JTextField();
	private static JButton submitButton = new JButton("Create Account");
	
	
	private static JLabel userNameLabel = new JLabel("User Name");
	private static JLabel password1Label = new JLabel("Password");
	private static JLabel password2Label = new JLabel("Confirm Password");
	private static JLabel emailLabel = new JLabel("Email Address");
	private static JLabel headerLabel = new JLabel("Create An Account");
	

	/**
	 * This method creates all of the aspects of the register panel.
	 * 
	 * @param mainPanel
	 */
	public Register(MainPanel mainPanel) 
	{
		this.main = mainPanel;
		this.add(headerLabel);
		this.headerLabel.setPreferredSize(new Dimension(700,40));
		this.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));

		
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		
		
		
		JPanel emailRow = new JPanel();
		emailRow.add(emailLabel);
		emailRow.add(emailText);
		this.add(emailRow);

		
		JPanel userNameRow = new JPanel();
		userNameRow.add(userNameLabel);
		userNameRow.add(userNameText);
		this.add(userNameRow);
		
		
		JPanel passWord1Row = new JPanel();
		passWord1Row.add(password1Label);
		passWord1Row.add(password1Text);
		this.add(passWord1Row);
		
		
		JPanel passWord2Row = new JPanel();
		passWord2Row.add(password2Label);
		passWord2Row.add(password2Text);
		this.add(passWord2Row);
		
		JPanel buttonRow = new JPanel();
		buttonRow.add(submitButton);
		buttonRow.add(backButton);
		this.add(buttonRow);
		
		this.userNameText.setPreferredSize(new Dimension(150,25));
		this.password1Text.setPreferredSize(new Dimension(150,25));
		this.password2Text.setPreferredSize(new Dimension(150,25));
		this.emailText.setPreferredSize(new Dimension(150,25));
		
		
		this.userNameLabel.setPreferredSize(new Dimension(150,25));
		this.password1Label.setPreferredSize(new Dimension(150,25));
		this.password2Label.setPreferredSize(new Dimension(150,25));
		this.emailLabel.setPreferredSize(new Dimension(150,25));
		
		
		
		
		BackButtonListener backButtonListener  = new BackButtonListener();
		this.backButton.addActionListener(backButtonListener);
		
		SubmitButtonListener submitButtonListener  = new SubmitButtonListener();
		this.submitButton.addActionListener(submitButtonListener);
		
	}
	
    /**
     * This class deals with the register button's logic when the user wants to submit 
     * their username, password, and email to be able to create an account.
     * 
     * @author Team 7
     *
     */
    private class SubmitButtonListener implements ActionListener
    {
    	/* (non-Javadoc)
    	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    	 */
    	public void actionPerformed(ActionEvent e) 
    	{
    		String username = userNameText.getText();
    		String password = password1Text.getText();
    		String email = emailText.getText();
    		JButton continueButton = new JButton("Continue to login");
    		main.createUser(username, password, email);

    		main.removeAll();
    		main.repaint();
    		main.revalidate();
    		main.add(new JLabel("Account has been successfully created"));
    		
    		main.add(continueButton);
    		
    		BackButtonListener submitButtonListener  = new BackButtonListener();
    		continueButton.addActionListener(submitButtonListener);
    	}
    }
    
    /**
     * This class deals with the action when the back button is clicked.
     * 
     * @author Team 7
     *
     */
    private class BackButtonListener implements ActionListener
    {
    	
    	/* (non-Javadoc)
    	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    	 */
    	public void actionPerformed(ActionEvent e) 
    	{
    		main.sendEvent("home");
    	}
    }
}