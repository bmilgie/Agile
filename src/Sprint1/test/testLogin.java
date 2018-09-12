package Sprint1.test;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.junit.*;
import Sprint1.*;


public class testLogin {
	private MainPanel mainPanel;
	@SuppressWarnings("unused")
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
	public void loginGUI()
	{
		JFrame frame = new JFrame();
		frame.getContentPane().add(loginPanel);
		frame.setSize(new Dimension(800,800));
		frame.setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
//	@Test
//	public void loginUserNamePass()
//	{
//		loginPanel.username.setText("oscaravila2");
//		loginPanel.password.setText("Test123");
//		loginPanel.submit.doClick();
//
//		
//	}
	
     @Test
    public void loginUserNameFail()
    {
    	 setUp();
    	loginPanel.errorLabel.setText("");
    	loginPanel.username.setText("b");
    	loginPanel.password.setText("b");
    	mainPanel.repaint();
    	loginPanel.submit.doClick();
    }

}
