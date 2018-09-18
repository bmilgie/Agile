package Sprint1.test;
import org.junit.*;

import Sprint1.*;

public class ForgotUsernameTest {
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void done() {
		
	}
	
	public void waitTimer() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitLonger()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void GUI()
	{
		Driver.createAndShowGUI();
		waitTimer();
		Login.forgot.doClick();
		waitLonger();
	}
	
	@Test
	public void wrongEmail()
	{
		ForgotUsername.emailText.setText("ThisIsWrong@gmail.com");
		ForgotUsername.passwordText.setText("Test123");
		ForgotUsername.sqText.setText("Dog");
		ForgotUsername.submitButton.doClick();
		waitTimer();
	}
	
	@Test
	public void validInfo()
	{
		ForgotUsername.emailText.setText("oscaravila@u.boisestate.edu");
		ForgotUsername.passwordText.setText("Test123");
		ForgotUsername.submitButton.doClick();
		waitTimer();
	}

}
