package Sprint1.test;

import java.awt.Dimension;

import javax.swing.*;
import org.junit.*;
import Sprint1.*;


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