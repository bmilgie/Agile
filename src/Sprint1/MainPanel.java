package Sprint1;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static Login loginPanel;
	private static Register registerPanel;
	private static ResetPassword resetPanel;
	private static Profile profilePanel;
	private static Users users;
	
	
	public MainPanel() {	
	}
	
	public void constructPanels(Login loginPanel, ResetPassword resetPanel, Register registerPanel, Profile profilePanel) {
		this.loginPanel = loginPanel;
		this.resetPanel = resetPanel;
		this.registerPanel = registerPanel;
		this.profilePanel = profilePanel;
		this.users = new Users();
	}
	public void createUser(String username,String password,String email, String sq) {
		this.users.createUser(username, password, email, sq);
	}
	public boolean validateCredentials(String user, String pass) {
		return this.users.validateCredentials(user, pass);
	}
	public String resetPassword(String username, String email, String sq){
		String newPassword = this.users.resetPassword(username, email, sq);
		return newPassword;
	}
	public void sendEvent(String event) {
			if(event.equalsIgnoreCase("login")){
			this.removeAll();
			this.repaint();
			this.revalidate();
			this.add(profilePanel);
			
		}else if(event.equalsIgnoreCase("logout")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			//log user out
			this.add(loginPanel);
		}else if(event.equalsIgnoreCase("reset")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			this.add(resetPanel);
		}else if(event.equalsIgnoreCase("register")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			this.add(registerPanel);
		}else if(event.equalsIgnoreCase("home")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			this.add(loginPanel);
		}
	}
}
