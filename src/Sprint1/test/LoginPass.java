package Sprint1.test;

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
	
	

}
 