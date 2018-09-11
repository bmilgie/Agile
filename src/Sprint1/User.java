package Sprint1;

/**
 * This class is user information 
 * 
 * @author Team 7
 *
 */
public class User 
{
	
	private String userName;
	private String passWord;
	private String email;
	
	/**
	 * This method creates the user
	 * 
	 * @param username
	 * @param password
	 * @param email
	 */
	public User(String username, String password, String email) 
	{
		this.userName = username;
		this.passWord = password;
		this.email = email;
	}

	/**
	 * This method gets the user's name
	 * 
	 * @returns the user's username
	 */
	public String getUserName() 
	{
		return this.userName;
	}
	
	/**
	 * This method gets the user's password
	 * 
	 * @returns the user's password
	 */
	public String getPassWord() 
	{
		return this.passWord;
	}
	
	/**
	 * This method gets the user's email
	 * 
	 * @returns the user's email
	 */
	public String getEmail() 
	{
		return this.email;
	}
	
	/**
	 * This method sets the user's password.
	 * 
	 * @param newPassword
	 */
	public void setPassword(String newPassword) 
	{
		this.passWord = newPassword;
	}
}