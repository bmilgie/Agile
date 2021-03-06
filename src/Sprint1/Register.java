package Sprint1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Register extends JPanel {

	private static MainPanel main;
	public static JButton backButton = new JButton("Back");
	public static JTextField userNameText = new JTextField();
	public static JTextField password1Text = new JPasswordField();
	public static JTextField password2Text = new JPasswordField();
	public static JTextField sqText = new JTextField();
	public static JTextField emailText = new JTextField();
	public static JButton submitButton = new JButton("Create Account");


	private static JLabel userNameLabel = new JLabel("User Name");
	private static JLabel password1Label = new JLabel("Password");
	private static JLabel password2Label = new JLabel("Confirm Password");
	private static JLabel sqLabel = new JLabel("Animal's name");
	private static JLabel emailLabel = new JLabel("Email Address");
	private static JLabel headerLabel = new JLabel("Create An Account");


	public Register(MainPanel mainPanel) {
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

		JPanel sqRow = new JPanel();
		sqRow.add(sqLabel);
		sqRow.add(sqText);
		this.add(sqRow);

		JPanel buttonRow = new JPanel();
		buttonRow.add(submitButton);
		buttonRow.add(backButton);
		this.add(buttonRow);

		this.userNameText.setPreferredSize(new Dimension(150,25));
		this.password1Text.setPreferredSize(new Dimension(150,25));
		this.password2Text.setPreferredSize(new Dimension(150,25));
		this.emailText.setPreferredSize(new Dimension(150,25));
		this.sqText.setPreferredSize(new Dimension(150,25));

		this.userNameLabel.setPreferredSize(new Dimension(150,25));
		this.password1Label.setPreferredSize(new Dimension(150,25));
		this.password2Label.setPreferredSize(new Dimension(150,25));
		this.emailLabel.setPreferredSize(new Dimension(150,25));
		this.sqLabel.setPreferredSize(new Dimension(150,25));


		BackButtonListener backButtonListener  = new BackButtonListener();
		this.backButton.addActionListener(backButtonListener);

		SubmitButtonListener submitButtonListener  = new SubmitButtonListener();
		this.submitButton.addActionListener(submitButtonListener);

	}
	public void clearTextFields(){
		this.userNameText.setText("");
		this.password1Text.setText("");
		this.password2Text.setText("");
		this.emailText.setText("");
		this.sqText.setText("");	
	}
	private class BackButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			main.sendEvent("home");
		}
	}
	private class SubmitButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton continueButton = new JButton("Continue to login");
			JButton retryButton = new JButton("retry");
			String passwordInput1 = password1Text.getText();
			String passwordInput2 = password2Text.getText();
			String usernameInput = userNameText.getText();
			String emailInput = emailText.getText();
			String questionInput = sqText.getText();

			boolean isDuplicate;
			Users duplicateCheck = new Users();

			isDuplicate = duplicateCheck.checkDuplicateUser(usernameInput);
			if (passwordInput1.compareTo(passwordInput2) != 0) {
				//checks that passwords match
				main.removeAll();
				main.repaint();
				main.revalidate();
				main.add(new JLabel("Passwords do not match"));
				main.add(retryButton);
				BackButtonListener submitButtonListener  = new BackButtonListener();
				retryButton.addActionListener(submitButtonListener);

			} else if (usernameInput.isEmpty()) {
				//checks for empty username
				main.removeAll();
				main.repaint();
				main.revalidate();
				main.add(new JLabel("Username is empty"));
				main.add(retryButton);
				BackButtonListener submitButtonListener  = new BackButtonListener();
				retryButton.addActionListener(submitButtonListener);

			} else if (isDuplicate) {
				//if username is taken
				main.removeAll();
				main.repaint();
				main.revalidate();
				main.add(new JLabel("Username is taken"));
				main.add(retryButton);
				BackButtonListener submitButtonListener  = new BackButtonListener();
				retryButton.addActionListener(submitButtonListener);

			} else if (!emailInput.contains("@")) {
				//checks for valid email
				main.removeAll();
				main.repaint();
				main.revalidate();
				main.add(new JLabel("Invalid Email"));
				main.add(retryButton);
				BackButtonListener submitButtonListener  = new BackButtonListener();
				retryButton.addActionListener(submitButtonListener);

			} else {
				String username = usernameInput;
				String password = passwordInput1;
				String email = emailInput;
				String question = questionInput;

				main.createUser(username, password, email, question);

				main.removeAll();
				main.repaint();
				main.revalidate();
				main.add(new JLabel("Account has been successfully created"));

				main.add(continueButton);

				BackButtonListener submitButtonListener  = new BackButtonListener();
				continueButton.addActionListener(submitButtonListener);
			}
		}
		
	}
}
