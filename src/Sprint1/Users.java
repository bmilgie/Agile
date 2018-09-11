package Sprint1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class holds the data structures for all users
 * 
 * @author Team 7
 *
 */
public class Users 
{

	private static LinkedList<User> allUsers = new LinkedList();
	
	/**
	 * This constructor parses the file into username, email, and password.Then it
	 * is added into the text file.
	 */
	public Users() 
	{
		
		File file = new File("userdata.txt"); 
		try {
			Scanner scan = new Scanner(file).useDelimiter(",");
			
			while(scan.hasNext()) 
			{
				String[] userInfo = scan.next().split(":");
				User user = new User(userInfo[0],userInfo[1], userInfo[2]);
				allUsers.add(user);
			}
			
		}
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method creates the user with the information given.
	 * 
	 * @param username
	 * @param password
	 * @param email
	 */
	public void createUser(String username, String password, String email) 
	{
		User user = new User(username,password,email);
		allUsers.add(user);		
		this.saveUserData();
	}
	
	/**
	 * This method creates a new password.
	 * 
	 * @returns the user's generated password
	 */
	public String generatePassword() 
	{
		String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        
        while (password.length() < 5) // length of the random string.
        { 
            int index = (int) (rnd.nextFloat() * CHARS.length());
            password.append(CHARS.charAt(index));
        }
        
        String result = password.toString();
        return result;
	    
	}
	
	/**
	 * This method resets the user's password if the username and email is valid.
	 * 
	 * @param username
	 * @param email
	 * @returns the newly created password for the user.
	 */
	public String resetPassword(String username, String email)
	{
		String newPassword =this.generatePassword();
		
		if(!username.equalsIgnoreCase("")) 
		{
			for(int i=0; i < this.allUsers.size(); i++) 
			{
				if(username.equalsIgnoreCase(this.allUsers.get(i).getUserName())) 
				{
					this.allUsers.get(i).setPassword(newPassword);
					this.saveUserData();
					return newPassword;
				}
			}
		}
		else if(!email.equalsIgnoreCase("")) 
		{
			for(int i=0; i < this.allUsers.size(); i++) 
			{
				System.out.println(this.allUsers.get(i).getEmail().length());
				System.out.println(this.allUsers.get(i).getEmail() +" - "+ email +"               : "+ email.equalsIgnoreCase(this.allUsers.get(i).getEmail()));
				if(email.equalsIgnoreCase(this.allUsers.get(i).getEmail())) 
				{
					this.allUsers.get(i).setPassword(newPassword);
					this.saveUserData();
					return newPassword;
				}
			}			
		}
		
		
		return null;
	}
	
	/**
	 * This method saves the User's username and password
	 */
	public void saveUserData() 
	{
		//loop through data structure;
		String result = "";
		for(int i=0; i < this.allUsers.size(); i++) 
		{
			User u = this.allUsers.get(i);
			String userInfo = u.getUserName()+":"+u.getPassWord()+":"+u.getEmail()+",";
			result += userInfo;
		}
		result  = result.substring(0,result.length()-1);

		PrintWriter writer;
		try 
		{
			writer = new PrintWriter("userdata.txt", "UTF-8");
			//writer.println(myResult);
			writer.print(result);
			writer.close();
		} 
		
		catch (FileNotFoundException | UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * This method checks if the user has given a valid username and password
	 * 
	 * @param user
	 * @param pass
	 * @returns the user's username and password.
	 */
	public boolean validateCredentials(String user, String pass) 
	{
		for(int i=0; i < this.allUsers.size(); i++) 
		{
			User u = this.allUsers.get(i);
			if(u.getUserName().equalsIgnoreCase(user)  && u.getPassWord().equalsIgnoreCase(pass)) 
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method checks if the username is already present in the system
	 * 
	 * @param user
	 * @returns the boolean value depending on if the username already exists in the system
	 */
	public boolean checkDuplicateUser(String user) {
		for(int i=0; i < this.allUsers.size(); i++) {
			User u = this.allUsers.get(i);
			if(u.getUserName().equalsIgnoreCase(user)) {
				return true;
			}
		}
		return false;
	}
}
