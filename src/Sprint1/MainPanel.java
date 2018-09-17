package login;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	private static Login loginPanel;
	private static Register registerPanel;
	private static ResetPassword resetPanel;
	private static Profile profilePanel;
	private static Users users;
	private static ForgotUsername userNamePanel;
<<<<<<< HEAD
	private static EditPanel editPanel;
=======
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
	
	
	public MainPanel() {	
	}
	
<<<<<<< HEAD
	public void constructPanels(Login loginPanel, ResetPassword resetPanel, Register registerPanel, Profile profilePanel, ForgotUsername usernamePanel, EditPanel editPanel) {
		MainPanel.loginPanel = loginPanel;
		MainPanel.resetPanel = resetPanel;
		MainPanel.registerPanel = registerPanel;
		MainPanel.profilePanel = profilePanel;
		MainPanel.users = new Users();
		MainPanel.userNamePanel = usernamePanel;
		MainPanel.editPanel = editPanel;
=======
	/**
	 * This method constructs the connection between all of the panels.
	 * 
	 * @param loginPanel
	 * @param resetPanel
	 * @param registerPanel
	 * @param profilePanel
	 * @param userNamePanel
	 */
	public void constructPanels(Login loginPanel, ResetPassword resetPanel, Register registerPanel, Profile profilePanel, ForgotUsername usernamePanel) 
	{
		this.loginPanel = loginPanel;
		this.resetPanel = resetPanel;
		this.registerPanel = registerPanel;
		this.profilePanel = profilePanel;
		this.users = new Users();
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
	}
	public void createUser(String username,String password,String email, String sq) {
		MainPanel.users.createUser(username, password, email, sq);
	}
	public void updateUser(String username,String password,String email, String sq) {
		profilePanel.setUserData();
		MainPanel.users.updateUser(username, password, email, sq);
	}
	public boolean validateCredentials(String user, String pass) {
		return MainPanel.users.validateCredentials(user, pass);
	}
	public String resetPassword(String username, String email, String sq){
		String newPassword = MainPanel.users.resetPassword(username, email, sq);
		return newPassword;
	}
	public String forgotUsername(String email, String sq, String password){
		String newUsername = MainPanel.users.forgotUsername(email, sq, password);
		return newUsername;
	}
	@SuppressWarnings("static-access")
	public User getCurrentUser(){
		return this.users.getCurrentUser();
	}
	@SuppressWarnings("static-access")
	public void setCurrentUser(String userName){
		this.users.setCurrentUser(userName);
	}
	
<<<<<<< HEAD
	public void sendEvent(String event) {
			if(event.equalsIgnoreCase("login")){
			this.removeAll();
			this.repaint();
			this.revalidate();
			profilePanel.setUserData();
			this.add(profilePanel);
			
		}else if(event.equalsIgnoreCase("logout")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			//log user out
			loginPanel.clearTextFields();
			this.add(loginPanel);
		}else if(event.equalsIgnoreCase("reset")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			resetPanel.clearTextFields();
			this.add(resetPanel);
		}else if(event.equalsIgnoreCase("register")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			registerPanel.clearTextFields();
			this.add(registerPanel);
		}else if(event.equalsIgnoreCase("home")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			loginPanel.clearTextFields();
			this.add(loginPanel);
		}else if(event.equalsIgnoreCase("forgot")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			userNamePanel.clearTextFields();
			this.add(userNamePanel);
		}else if(event.equalsIgnoreCase("edit")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			editPanel.setUserData();
			this.add(editPanel);
		}else if(event.equalsIgnoreCase("profile")) {
			this.removeAll();
			this.repaint();
			this.revalidate();
			this.add(profilePanel);
		}else if(event.equalsIgnoreCase("submit")) {
			this.removeAll();
			profilePanel.setUserData();
			this.repaint();
			this.revalidate();
			this.add(profilePanel);
		}
=======
	 /**
	 * This method returns the username if it is forgotten.
	 * 
	 * @param email
	 * @param sq
	 * @returns username 
	 */
	public String forgotUsername(String email, String sq){
		String newUsername = MainPanel.users.forgotUsername(email, sq);
		return newUsername;
	}
	
	/**
	 * This method resets the frame when certain buttons are clicked
	 * 
	 * @param event
	 */
	public void sendEvent(String event) 
	{
			if(event.equalsIgnoreCase("login"))
			{
				this.removeAll();
				this.repaint();
				this.revalidate();
				this.add(profilePanel);
			}
			
			else if(event.equalsIgnoreCase("logout")) 
			{
				this.removeAll();
				this.repaint();
				this.revalidate();
				//log user out
				this.add(loginPanel);
			}
		
			else if(event.equalsIgnoreCase("reset")) 
			{
				this.removeAll();
				this.repaint();
				this.revalidate();
				this.add(resetPanel);
			}
			
			else if(event.equalsIgnoreCase("register")) 
			{
				this.removeAll();
				this.repaint();
				this.revalidate();
				this.add(registerPanel);
			}
			
			else if(event.equalsIgnoreCase("home"))
			{
				this.removeAll();
				this.repaint();
				this.revalidate();
				this.add(loginPanel);
			}
			
			else if(event.equalsIgnoreCase("forgot")) {
				this.removeAll();
				this.repaint();
				this.revalidate();
				this.add(userNamePanel);
			}
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
	}
}
