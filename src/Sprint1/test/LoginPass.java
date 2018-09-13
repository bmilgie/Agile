package Sprint1.test;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.junit.*;

import Sprint1.*;

public class LoginPass {
	private MainPanel mainPanel;
	private Login loginPanel;
	private Profile profile;
	private Register register;
	
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
	public void loginSuccess()
	{
		Driver.createAndShowGUI();
		Login.username.setText("oscaravila2");
		Login.password.setText("Test123");
		
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Login.submit.doClick();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
 