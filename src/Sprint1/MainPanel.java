package Sprint1;

import javax.swing.JPanel;

/**
 * This class creates the main panel of the project
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
	 * This method creates the main panel.
	 */
	public MainPanel() 
	{
		
		
	}
	
	/**
	 * This method constructs 
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
	 * 
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	public boolean validateCredentials(String user, String pass) 
	{
		return this.users.validateCredentials(user, pass);
	}
	
	/**
	 * @param username
	 * @param email
	 * @return
	 */
	public String resetPassword(String username, String email)
	{
		String newPassword = this.users.resetPassword(username, email);
		return newPassword;
	}
	
	/**
	 * 
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