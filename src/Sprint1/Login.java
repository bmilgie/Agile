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
    public static JTextField password = new JTextField();
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