package login;
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
public class EditPanel extends JPanel{
	private MainPanel main;
	private JButton backButton = new JButton("Back");
	private JTextField usernameText = new JTextField();
	private JTextField passwordText = new JTextField();
	private JTextField emailText = new JTextField();
	private JTextField sqText = new JTextField();
	private JButton submitButton = new JButton("Submit");
	
	private JLabel usernameLabel = new JLabel("User Name");
	private JLabel emailLabel = new JLabel("Email Address");
	private JLabel sqLabel = new JLabel("Animal's name");
	private JLabel headerLabel = new JLabel("Enter Changes into the Textfields");
	private JLabel passwordLabel = new JLabel("Password");

	

	public EditPanel(MainPanel mainPanel){
		this.main = mainPanel;
		this.add(headerLabel);
		this.headerLabel.setPreferredSize(new Dimension(700,40));
		this.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));

		
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		
		JPanel usernameRow = new JPanel();
		usernameRow.add(usernameLabel);
		usernameRow.add(usernameText);
		this.add(usernameRow);
		
		JPanel emailRow = new JPanel();
		emailRow.add(emailLabel);
		emailRow.add(emailText);
		this.add(emailRow);

		
		JPanel passwordRow = new JPanel();
		passwordRow.add(passwordLabel);
		passwordRow.add(passwordText);
		this.add(passwordRow);
		
		JPanel sqNameRow = new JPanel();
		sqNameRow.add(sqLabel);
		sqNameRow.add(sqText);
		this.add(sqNameRow);
		
		
		JPanel buttonRow = new JPanel();
		buttonRow.add(submitButton);
		buttonRow.add(backButton);
		this.add(buttonRow);
		
		this.usernameText.setPreferredSize(new Dimension(150,25));
		this.passwordText.setPreferredSize(new Dimension(150,25));
		this.emailText.setPreferredSize(new Dimension(150,25));
		this.sqText.setPreferredSize(new Dimension(150,25));
		
		this.usernameLabel.setPreferredSize(new Dimension(150,25));
		this.sqLabel.setPreferredSize(new Dimension(150,25));
		this.passwordLabel.setPreferredSize(new Dimension(150,25));
		this.emailLabel.setPreferredSize(new Dimension(150,25));
		
		BackButtonListener backButtonListener  = new BackButtonListener();
		this.backButton.addActionListener(backButtonListener);
		
		SubmitButtonListener submitButtonListener  = new SubmitButtonListener();
		this.submitButton.addActionListener(submitButtonListener);
	}
	public void clearTextFields(){
		this.usernameText.setText("");
		this.passwordText.setText("");
		this.emailText.setText("");
		this.sqText.setText("");	
	}
	public void setUserData(){
		User tempUser =  main.getCurrentUser();
		this.usernameText.setText(tempUser.getUserName());
		this.emailText.setText(tempUser.getEmail());
		this.sqText.setText(tempUser.getSq());
		this.passwordText.setText(tempUser.getPassWord());
	}
	
	private class BackButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		main.sendEvent("Profile");
    	}
    }


	private class SubmitButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String username = usernameText.getText();
    		String password = passwordText.getText();
    		String email = emailText.getText();
    		String sq = sqText.getText();
    		main.updateUser(username, password, email, sq);
    		main.sendEvent("submit");
    	}
    }
	
}
