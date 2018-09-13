package Sprint1.test;

import Sprint1.*;
import org.junit.*;

public class LoginFail {

	
	@Before
	public void setUp()
	{

	}
	
	@After
	public void done()
	{
		
	}
	
	@Test
	public void loginUserNameFail()
	{
		Driver.createAndShowGUI();
		Login.username.setText("t");
		Login.password.setText("t");
		Login.submit.doClick();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
