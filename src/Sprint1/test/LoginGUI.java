package Sprint1.test;
import java.awt.Dimension;

import javax.swing.*;
import org.junit.*;
import Sprint1.*;

public class LoginGUI {
	private MainPanel mainPanel;
	private Login loginPanel;
	private Profile profile;
	private Register register;
	private Driver driver;
	
	@Before
	public void setUp()
	{
		mainPanel = new MainPanel();
		register = new Register(mainPanel);
		loginPanel = new Login(mainPanel);
		profile = new Profile(mainPanel);
		mainPanel.constructPanels(loginPanel, null, register, profile);
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
