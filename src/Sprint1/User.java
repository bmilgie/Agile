package login;

public class User {
	
	private String userName;
	private String passWord;
	private String email;
	private String sQ;
	
	public User(String username, String password, String email, String sq) {
		this.userName = username;
		this.passWord = password;
		this.email = email;
		this.sQ = sq;
	}

	public String getUserName() {
		return this.userName;
	}
	public String getPassWord() {
		return this.passWord;
	}
	public String getEmail() {
		return this.email;
	}
	public void setPassword(String newPassword) {
		this.passWord = newPassword;
	}
	public void setUsername(String newUsername) {
		this.userName = newUsername;
	}

	public String getSq() {
		return this.sQ;
	}
<<<<<<< HEAD

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	public void setSq(String newSq) {
		this.sQ = newSq;
=======
	
	/**
	* This method sets the value of the security question
	*
	* @param newSecurityQuestion
	*/
	public void setSq(String newSecurityQuestion) {
		this.sQ = newSecurityQuestion;
>>>>>>> 4c5df7468c3bc9e80445100c8e10f633907cbd17
	}
}
