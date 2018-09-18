
package Sprint1.test;

import java.awt.Dimension;

import javax.swing.JFrame;
import org.junit.*;
import Sprint1.*;



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
		
		mainPanel.constructPanels(loginPanel, resetPanel, register, profile,null, null);
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
	

}

