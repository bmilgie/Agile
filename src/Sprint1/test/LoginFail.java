package Sprint1.test;

import Sprint1.*;
import org.junit.*;

public class LoginFail {
	private MainPanel mainPanel;
	private Register register;
	private Login loginPanel;
	private Profile profile;
	
	@Before
	public void setUp()
	{
		mainPanel = new MainPanel();
		register = new Register(mainPanel);
		loginPanel = new Login(mainPanel);
		profile = new Profile(mainPanel);
		mainPanel.constructPanels(loginPanel, null, register, profile);
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
