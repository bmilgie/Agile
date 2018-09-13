<<<<<<< HEAD
package Sprint1.test;
=======
package Tests;
>>>>>>> cc7292a489ff7a22816af3dd12a844794cba37a4

import java.awt.Dimension;

import javax.swing.JFrame;

import org.junit.*;

<<<<<<< HEAD
import Sprint1.*;
=======
import Login.*;
>>>>>>> cc7292a489ff7a22816af3dd12a844794cba37a4

public class ResetPasswordFail {
	private MainPanel mainPanel;
	private Login loginPanel;
	private Profile profile;
	private Register register;
	private ResetPassword resetPanel;

	
	@Before
	public void setUp()
	{
		mainPanel = new MainPanel();
		register = new Register(mainPanel);
		loginPanel = new Login(mainPanel);
		profile = new Profile(mainPanel);
		resetPanel = new ResetPassword(mainPanel);
		
		mainPanel.constructPanels(loginPanel, resetPanel, register, profile);
	}
	@After
	public void done()
	{
		
	}
	public void sleepFor(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Test
	public void runTest()
	{
		Driver.createAndShowGUI();
		Login.reset.doClick();
		ResetPassword.submitButton.doClick();
		String password=  ResetPassword.passwordLabel.getText();
			   password = password.replace("Your new password is : ", "");
		
		System.out.println(password);
	    this.sleepFor(3000);
		
	}
	
<<<<<<< HEAD
}
=======
}
>>>>>>> cc7292a489ff7a22816af3dd12a844794cba37a4
