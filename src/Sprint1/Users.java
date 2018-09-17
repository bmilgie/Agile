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
					User user = new User(userInfo[0],userInfo[1], userInfo[2], userInfo[3]);
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
	 * @param sq
	 */
	public void createUser(String username, String password, String email, String sq) 
	{
		User user = new User(username,password,email, sq);
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
	 * @param sq
	 * @returns the newly created password for the user
	 */
	public String resetPassword(String username, String email, String sq)
	{
		String newPassword =this.generatePassword();
		
		if(!username.equals("") && (!sq.equals("")))
		{
			for(int i=0; i < this.allUsers.size(); i++) 
			{
				if(username.equals(this.allUsers.get(i).getUserName()) && (sq.equals(this.allUsers.get(i).getSq()))) 
				{
					this.allUsers.get(i).setPassword(newPassword);
					this.saveUserData();
					return newPassword;
				}
			}
		}
		
		else if(!email.equals("") && (!sq.equals(""))) 
		{
			for(int i=0; i < this.allUsers.size(); i++) 
			{
				if(email.equals(this.allUsers.get(i).getEmail()) && (sq.equals(this.allUsers.get(i).getSq()))) 
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
	public void saveUserData() {
		//loop through data structure;
		String result = "";
		for(int i=0; i < this.allUsers.size(); i++) 
		{
			User u = this.allUsers.get(i);
			String userInfo = u.getUserName()+":"+u.getPassWord()+":"+u.getEmail()+":" + u.getSq()+",";
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
			if(u.getUserName().equals(user)  && u.getPassWord().equals(pass)) 
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method checks if the user has given a valid username and password
	 * 
	 * @param user
	 * @returns a boolean value based on whether a username is already in the system or not
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
	
		public boolean checkExistingEmail(String email) {
		for(int i=0; i < this.allUsers.size(); i++) {
			User u = this.allUsers.get(i);
			if(u.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}
	
	 /**
	 * This method returns the username based on their email
	 * 
	 * @param email
	 * @returns the user's username.
	 */
	public String getUserName(String email) {
		String userNameReturn = null;
		for(int i=0; i < this.allUsers.size(); i++) {
			User u = this.allUsers.get(i);
			if(u.getEmail().equalsIgnoreCase(email)) {
				userNameReturn = u.getUserName();
			} else {
				userNameReturn = "error: User not in system";
			}
		}
		return userNameReturn;
	}
	
	 /**
	 * This method checks if the security questions match
	 * 
	 * @param user
	 * @param securityQuestion
	 * @returns a boolean value based on if the security questions match
	 */
	public boolean securityQuestionCheck(String email, String securityQuestion) {
		boolean isCorrect = false;
		String storedSecurityQuestion = null;
		
		for(int i=0; i < this.allUsers.size(); i++) {
			User u = this.allUsers.get(i);
			if(u.getEmail().equalsIgnoreCase(email)) {
				storedSecurityQuestion = u.getSq();
			}
		}
		
		if (securityQuestion.equalsIgnoreCase(storedSecurityQuestion)) {
			isCorrect = true;
		} else {
			isCorrect = false;
		}
		
		return isCorrect;
	}
	
	 /**
	 * This method returns the username given that the proper email and security response are given
	 * 
	 * @param email
	 * @param sq
	 * @returns the username
	 */
	public String forgotUsername(String email, String sq) {
		String usernameReturn = "";
		//checks to see if email is in system first
		if(checkExistingEmail(email)) {
			//then checks if security question is correct
			if (securityQuestionCheck(email, sq)) {
				//returns the actual username
				usernameReturn = getUserName(email);
			} else {
				usernameReturn = "error: Wrong security question answer";
			}
		} else {
			usernameReturn = "error: Email not in system";
		}
		return usernameReturn;
	}
	
}
