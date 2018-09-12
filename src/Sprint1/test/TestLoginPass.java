package Sprint1.test;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.junit.*;
import Sprint1.*;


public class TestLoginPass {
	JFrame frame;
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
		;
		
	}
	
	@After
	public void done()
	{
		
	}
	
	@Test
	public void loginGUI()
	{

		frame = new JFrame();
		frame.getContentPane().add(mainPanel);
		mainPanel.add(loginPanel);
		frame.setSize(new Dimension(800,800));
		frame.setVisible(true);
	
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
	}
	
	@Test
	public void loginUserNamePass()
	{
		Login.username.setText("oscaravila2");
		Login.password.setText("Test123");
		Login.submit.doClick(1000);
		
	}
	
//     @Test
//    public void loginUserNameFail()
//    {
//    	 setUp();
//    	loginPanel.errorLabel.setText("");
//    	loginPanel.username.setText("b");
//    	loginPanel.password.setText("b");
//    	
//    	loginPanel.submit.doClick();
//    	
//    }

}