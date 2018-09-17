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
	private String sQ;
	
	/**
	 * This method creates the user
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param sq
	 */
	public User(String username, String password, String email, String sq) 
	{
		this.userName = username;
		this.passWord = password;
		this.email = email;
		this.sQ = sq;
	}

	/**
	 * This method gets the user's name
	 * 
	 * @returns the user's name 
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
	 * This method sets the user's password
	 * 
	 * @param newPassword
	 */
	public void setPassword(String newPassword) 
	{
		this.passWord = newPassword;
	}

	/**
	 * This method gets the answer to the security question
	 * 
	 * @returns the answer to the security question
	 */
	public String getSq() 
	{
		return this.sQ;
	}
	
	/**
	* This method sets the value of the security question
	*
	* @param newSecurityQuestion
	*/
	public void setSq(String newSecurityQuestion) {
		this.sQ = newSecurityQuestion;
	}
}
