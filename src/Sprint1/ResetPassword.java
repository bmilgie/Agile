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


@SuppressWarnings("serial")
public class ResetPassword extends JPanel{

	
	private static MainPanel main;
	public static JButton backButton = new JButton("Back");
	public static JTextField userNameText = new JTextField();
	public static JTextField emailText = new JTextField();
	public static JTextField sqText = new JTextField();
	public static JButton submitButton = new JButton("Reset Password");
	
	
	private static JLabel userNameLabel = new JLabel("User Name");
	private static JLabel emailLabel = new JLabel("Email Address");
	private static JLabel sqLabel = new JLabel("Animal's name");
	private static JLabel headerLabel = new JLabel("Enter your Username or Email");
	public static JLabel passwordLabel = new JLabel("");

	public ResetPassword(MainPanel mainPanel) {
		ResetPassword.main = mainPanel;
		this.add(headerLabel);
		ResetPassword.headerLabel.setPreferredSize(new Dimension(700,40));
		ResetPassword.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));

		
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
		
		JPanel sqNameRow = new JPanel();
		sqNameRow.add(sqLabel);
		sqNameRow.add(sqText);
		this.add(sqNameRow);
		
		
		JPanel buttonRow = new JPanel();
		buttonRow.add(submitButton);
		buttonRow.add(backButton);
		this.add(buttonRow);
		
		JPanel passwordRow = new JPanel();
		passwordRow.add(ResetPassword.passwordLabel);
		this.add(passwordRow);
		
		ResetPassword.userNameText.setPreferredSize(new Dimension(150,25));
		ResetPassword.emailText.setPreferredSize(new Dimension(150,25));
		ResetPassword.sqText.setPreferredSize(new Dimension(150,25));
		
		ResetPassword.sqLabel.setPreferredSize(new Dimension(150,25));
		ResetPassword.userNameLabel.setPreferredSize(new Dimension(150,25));
		ResetPassword.emailLabel.setPreferredSize(new Dimension(150,25));

		BackButtonListener backButtonListener  = new BackButtonListener();
		ResetPassword.backButton.addActionListener(backButtonListener);
		
		SubmitButtonListener submitButtonListener  = new SubmitButtonListener();
		ResetPassword.submitButton.addActionListener(submitButtonListener);
	}
	public void clearTextFields(){
		this.userNameText.setText("");
		this.emailText.setText("");
		this.sqText.setText("");
		this.passwordLabel.setText("");
	}
  
	
	
    private class SubmitButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String username = userNameText.getText();
    		String email = emailText.getText();
    		String sq = sqText.getText();
    		String password = main.resetPassword(username, email, sq);
    		passwordLabel.setText("Your new password is : " + password);

    	}
    }
    private class BackButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		main.sendEvent("home");
    	}
    }
}
