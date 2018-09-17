package login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Users {

	private static LinkedList<User> allUsers = new LinkedList<User>();
	private User currentUser;
	private File file;
	
	public Users() {
		
		file = new File("userdata.txt"); 
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(file).useDelimiter(",");
			
			while(scan.hasNext()) {
				String[] userInfo = scan.next().split(":");
				User user = new User(userInfo[0],userInfo[1], userInfo[2], userInfo[3]);
				allUsers.add(user);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void createUser(String username, String password, String email, String sq) {
		User user = new User(username,password,email, sq);
		allUsers.add(user);		
		this.saveUserData();
	}
	public void updateUser(String username, String password, String email, String sq) {
		this.currentUser.setUsername(username);
		this.currentUser.setPassword(password);
		this.currentUser.setEmail(email);
		this.currentUser.setSq(sq);
		System.out.println(username);
		file = new File("userdata.txt");
		if(file.delete()){
			try {
				file.createNewFile();
				this.saveUserData();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public String generatePassword() {
		String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder password = new StringBuilder();
        Random rnd = new Random();
        while (password.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            password.append(CHARS.charAt(index));
        }
        String result = password.toString();
        return result;
	    
	}
	@SuppressWarnings("static-access")
	public String resetPassword(String username, String email, String sq){
		String newPassword =this.generatePassword();
		
		if(!username.equals("") && (!sq.equals(""))){
			for(int i=0; i < this.allUsers.size(); i++) {
				if(username.equals(this.allUsers.get(i).getUserName()) && (sq.equals(this.allUsers.get(i).getSq()))) {
					this.allUsers.get(i).setPassword(newPassword);
					this.saveUserData();
					return newPassword;
				}
			}
		}else if(!email.equals("") && (!sq.equals(""))) {
			for(int i=0; i < this.allUsers.size(); i++) {
				if(email.equals(this.allUsers.get(i).getEmail()) && (sq.equals(this.allUsers.get(i).getSq()))) {
					this.allUsers.get(i).setPassword(newPassword);
					this.saveUserData();
					return newPassword;
				}
			}			
		}
		return "not set due to Invalid Credentials. Try Again";
	}
	@SuppressWarnings("static-access")
	public void saveUserData() {
		//loop through data structure;
		String result = "";
		for(int i=0; i < this.allUsers.size(); i++) {
			User u = this.allUsers.get(i);
			String userInfo = u.getUserName()+":"+u.getPassWord()+":"+u.getEmail()+":" + u.getSq()+",";
			result += userInfo;
		}
		result  = result.substring(0,result.length()-1);

		
		try {
			FileWriter test = new FileWriter("userdata.txt");
			PrintWriter writer = new PrintWriter("userdata.txt");
			test.flush();
			test.close();
			//writer.println(myResult);
			//writer.print(result);
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
<<<<<<< HEAD
		
		

		PrintWriter writer;
		try {
			writer = new PrintWriter("userdata.txt");
			writer.print(result);
			writer.close();
			System.out.println(result);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
=======
		catch (FileNotFoundException | UnsupportedEncodingException e) 
		{
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
			e.printStackTrace();
		}

	}
	public boolean validateCredentials(String user, String pass) {
		for(int i=0; i < this.allUsers.size(); i++) {
			User u = this.allUsers.get(i);
			if(u.getUserName().equals(user)  && u.getPassWord().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	public User getUser(String userName){
		for(int i=0; i< this.allUsers.size(); i++){
			if(userName.equals(this.allUsers.get(i).getUserName())){
				return allUsers.get(i);
			}
		}
		return null;
	}
	public User getCurrentUser(){
		return this.currentUser;
	}
	public boolean setCurrentUser(String userName) {
		User tempUser =  this.getUser(userName);
		if(tempUser == null){
			return false;
		}else{
			this.currentUser = tempUser;
			return true;
		}
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
	
<<<<<<< HEAD
		public boolean checkExistingEmail(String email) {
=======
	/**
	 * This method checks if the user has given a valid username and password
	 * 
	 * @param user
	 * @returns a boolean value based on whether a username is already in the system or not
	 */
	public boolean checkDuplicateUser(String user) {
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
		for(int i=0; i < this.allUsers.size(); i++) {
			User u = this.allUsers.get(i);
			if(u.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}
	
<<<<<<< HEAD
=======
		public boolean checkExistingEmail(String email) {
		for(int i=0; i < this.allUsers.size(); i++) {
			User u = this.allUsers.get(i);
			if(u.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}
	
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
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
<<<<<<< HEAD
	public String forgotUsername(String email, String sq, String password) {
=======
	public String forgotUsername(String email, String sq) {
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
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
	
<<<<<<< HEAD

=======
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
}
