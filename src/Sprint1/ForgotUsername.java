<<<<<<< HEAD
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
public class ForgotUsername extends JPanel{
	private static MainPanel main;
	private static JButton backButton = new JButton("Back");
	private static JTextField passwordText = new JTextField();
	private static JTextField emailText = new JTextField();
	private static JTextField sqText = new JTextField();
	private static JButton submitButton = new JButton("Submit");
	
	
	private static JLabel usernameLabel = new JLabel("");
	private static JLabel emailLabel = new JLabel("Email Address");
	private static JLabel sqLabel = new JLabel("Animal's name");
	private static JLabel headerLabel = new JLabel("Forgot Username");
	private static JLabel passwordLabel = new JLabel("Password");

	public ForgotUsername(MainPanel mainPanel) {
		ForgotUsername.main = mainPanel;
		this.add(headerLabel);
		ForgotUsername.headerLabel.setPreferredSize(new Dimension(700,40));
		ForgotUsername.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));

		
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		
		
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
		
		JPanel usernameRow = new JPanel();
		usernameRow.add(ForgotUsername.usernameLabel);
		this.add(usernameRow);
		
		ForgotUsername.passwordText.setPreferredSize(new Dimension(150,25));
		ForgotUsername.emailText.setPreferredSize(new Dimension(150,25));
		ForgotUsername.sqText.setPreferredSize(new Dimension(150,25));
		
		ForgotUsername.sqLabel.setPreferredSize(new Dimension(150,25));
		ForgotUsername.passwordLabel.setPreferredSize(new Dimension(150,25));
		ForgotUsername.emailLabel.setPreferredSize(new Dimension(150,25));

		BackButtonListener backButtonListener  = new BackButtonListener();
		ForgotUsername.backButton.addActionListener(backButtonListener);
		
		SubmitButtonListener submitButtonListener  = new SubmitButtonListener();
		ForgotUsername.submitButton.addActionListener(submitButtonListener);
	}
	public void clearTextFields(){
		this.passwordText.setText("");
		this.emailText.setText("");
		this.sqText.setText("");
		this.usernameLabel.setText("");
	}


	private class SubmitButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String password = passwordText.getText();
    		String email = emailText.getText();
    		String sq = sqText.getText();
    		String username = main.forgotUsername(email, password, sq);
    		usernameLabel.setText("Your username is : " + username);

    	}
    }
	
    private class BackButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		main.sendEvent("home");
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
public class ForgotUsername extends JPanel{
	private static MainPanel main;
	private static JButton backButton = new JButton("Back");
	private static JTextField emailText = new JTextField();
	private static JTextField sqText = new JTextField();
	private static JButton submitButton = new JButton("Submit");
	
	
	private static JLabel usernameLabel = new JLabel("");
	private static JLabel emailLabel = new JLabel("Email Address");
	private static JLabel sqLabel = new JLabel("Animal's name");
	private static JLabel headerLabel = new JLabel("Forgot Username");

	public ForgotUsername(MainPanel mainPanel) {
		ForgotUsername.main = mainPanel;
		this.add(headerLabel);
		ForgotUsername.headerLabel.setPreferredSize(new Dimension(700,40));
		ForgotUsername.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));

		
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		
		
		JPanel emailRow = new JPanel();
		emailRow.add(emailLabel);
		emailRow.add(emailText);
		this.add(emailRow);
		
		JPanel sqNameRow = new JPanel();
		sqNameRow.add(sqLabel);
		sqNameRow.add(sqText);
		this.add(sqNameRow);
		
		
		JPanel buttonRow = new JPanel();
		buttonRow.add(submitButton);
		buttonRow.add(backButton);
		this.add(buttonRow);
		
		JPanel usernameRow = new JPanel();
		usernameRow.add(ForgotUsername.usernameLabel);
		this.add(usernameRow);

		ForgotUsername.emailText.setPreferredSize(new Dimension(150,25));
		ForgotUsername.sqText.setPreferredSize(new Dimension(150,25));
		
		ForgotUsername.sqLabel.setPreferredSize(new Dimension(150,25));
		ForgotUsername.emailLabel.setPreferredSize(new Dimension(150,25));

		BackButtonListener backButtonListener  = new BackButtonListener();
		ForgotUsername.backButton.addActionListener(backButtonListener);
		
		SubmitButtonListener submitButtonListener  = new SubmitButtonListener();
		ForgotUsername.submitButton.addActionListener(submitButtonListener);
	}



	private class SubmitButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String email = emailText.getText();
    		String sq = sqText.getText();
    		String username = main.forgotUsername(email, sq);
    		usernameLabel.setText("Your username is : " + username);

    	}
    }
    private class BackButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e) {
    		main.sendEvent("home");
    	}
    }

}
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
