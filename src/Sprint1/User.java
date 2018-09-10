package Sprint1;

/**
 * 
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
	 * 
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
	 * 
	 * @returns the user's username
	 */
	public String getUserName() 
	{
		return this.userName;
	}
	
	/**
	 * @returns the user's password
	 */
	public String getPassWord() 
	{
		return this.passWord;
	}
	
	/**
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