package Sprint1;

/**
 * This class is the user's profile information
 * 
 * @author Team 7 
 *
 */
public class editUser 
{
	private String name;
	private String email;
	private String age;
	private String classStanding;
	
	/**
	 * This method creates the user's profile
	 * 
	 * @param name
	 * @param email
	 * @param age
	 * @param classStanding
	 */
	public editUser(String name, String email, String age, String classStanding) 
	{
		this.name = name;
		this.email = email;
		this.age = age;
		this.classStanding = classStanding;
	}
	
	/**
	 * @return 
	 */
	public String getName()
	{
		return this.name;
	}
}
