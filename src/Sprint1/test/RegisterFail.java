package Sprint1.test;

import org.junit.*;
import Sprint1.*;

public class RegisterFail {
	@Before
	public void setUp()
	{
		
	}
	
	@After
	public void done()
	{
		
	}
	
	/*
	 * IMORTANT INFORMATION: we currently do not have a way to delete users so
	 * this test can only be ran ONCE and then the user will be registered and
	 * will not let you register the user again unless you edit theuserdata.txt
	 * file and remove the user manually and all their information
	 */
	@Test
	public void registerFail()
	{
		Driver.createAndShowGUI();
		Login.register.doClick();
		Register.emailText.setText("Test@gmail.com");
		Register.password1Text.setText("Test1234");
		Register.password2Text.setText("Test1234");
		Register.userNameText.setText("oscaravila2");
		Register.sqText.setText("Test");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Register.submitButton.doClick();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
