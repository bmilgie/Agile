<<<<<<< HEAD
package Sprint1.test;
=======
package Tests;
>>>>>>> cc7292a489ff7a22816af3dd12a844794cba37a4
import java.awt.Dimension;

import javax.swing.*;
import org.junit.*;
<<<<<<< HEAD
import Sprint1.*;
=======
import Login.*;
>>>>>>> cc7292a489ff7a22816af3dd12a844794cba37a4

public class ResetPasswordGUI {
	private MainPanel mainPanel;
	private Login loginPanel;
	private Profile profile;
	private Register register;
	private Driver driver;
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
		driver = new Driver();
	}
	
	@After
	public void done()
	{
		
	}
	
	@Test
	public void loginGui()
	{
		driver.createAndShowGUI();
		Login.reset.doClick();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}