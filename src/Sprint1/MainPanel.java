package Sprint1;

import javax.swing.JPanel;

/**
 * This class is the controller for the project.
 * 
 * @author Team 7
 *
 */
public class MainPanel extends JPanel 
{

	private static Login loginPanel;
	private static Register registerPanel;
	private static ResetPassword resetPanel;
	private static Profile profilePanel;
	private static Users users;
	
	
	/**
	 * Constructor for Main Panel 
	 */
	public MainPanel() 
	{
		
		
	}
	
	/**
	 * This method constructs the connection between all of the panels.
	 * 
	 * @param loginPanel
	 * @param resetPanel
	 * @param registerPanel
	 * @param profilePanel
	 */
	public void constructPanels(Login loginPanel, ResetPassword resetPanel, Register registerPanel, Profile profilePanel) 
	{
		this.loginPanel = loginPanel;
		this.resetPanel = resetPanel;
		this.registerPanel = registerPanel;
		this.profilePanel = profilePanel;
		this.users = new Users();
		
		
	}
	
	/**
	 * This method creates the user
	 * 
	 * @param username
	 * @param password
	 * @param email
	 */
	public void createUser(String username,String password,String email) 
	{
		this.users.createUser(username, password, email);
	}
	
	/**
	 * This method checks if the information provided by the user is valid
	 * 
	 * @param user
	 * @param pass
	 * @returns valid username and password
	 */
	public boolean validateCredentials(String user, String pass) 
	{
		return this.users.validateCredentials(user, pass);
	}
	
	/**
	 * This method returns a new password that is auto generated.
	 * 
	 * @param username
	 * @param email
	 * @returns new password
	 */
	public String resetPassword(String username, String email)
	{
		String newPassword = this.users.resetPassword(username, email);
		return newPassword;
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
	}
}