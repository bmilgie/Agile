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
 * 
 * 
 * @author angelsanabria
 *
 */
public class ResetPassword extends JPanel
{

	
	private static MainPanel main;
	private static JButton backButton = new JButton("Back");
	private static JTextField userNameText = new JTextField();
	private static JTextField emailText = new JTextField();
	private static JButton submitButton = new JButton("Reset Password");
	
	
	private static JLabel userNameLabel = new JLabel("User Name");
	private static JLabel emailLabel = new JLabel("Email Address");
	private static JLabel headerLabel = new JLabel("Enter your Username or Email");
	private static JLabel passwordLabel = new JLabel("");

	/**
	 * 
	 * 
	 * @param mainPanel
	 */
	public ResetPassword(MainPanel mainPanel) 
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
		
		
		JPanel buttonRow = new JPanel();
		buttonRow.add(submitButton);
		buttonRow.add(backButton);
		this.add(buttonRow);
		
		JPanel passwordRow = new JPanel();
		passwordRow.add(this.passwordLabel);
		this.add(passwordRow);
		
		this.userNameText.setPreferredSize(new Dimension(150,25));
		this.emailText.setPreferredSize(new Dimension(150,25));
		
		
		this.userNameLabel.setPreferredSize(new Dimension(150,25));
		this.emailLabel.setPreferredSize(new Dimension(150,25));
		
		
		
		
		BackButtonListener backButtonListener  = new BackButtonListener();
		this.backButton.addActionListener(backButtonListener);
		
		SubmitButtonListener submitButtonListener  = new SubmitButtonListener();
		this.submitButton.addActionListener(submitButtonListener);
	}
	
	
    /**
     * 
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
    		String email = emailText.getText();
    		String password = main.resetPassword(username, email);
    		passwordLabel.setText("Your new password is : " + password);

    	}
    }
    
    /**
     * 
     * 
     * @author Team 7
     *
     */
    private class BackButtonListener implements ActionListener
    {
    	
    	public void actionPerformed(ActionEvent e) 
    	{
    		main.sendEvent("home");
    	}
    }
}