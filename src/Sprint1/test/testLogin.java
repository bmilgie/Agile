package Sprint1.test;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.junit.*;
import Sprint1.MainPanel;
import Sprint1.Login;

public class testLogin {
	private MainPanel mainPanel;
	@SuppressWarnings("unused")
	private Login loginPanel;
	
	@Before
	public void setUp()
	{
		mainPanel = new MainPanel();
		loginPanel = new Login(mainPanel);
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
	
	@Test
	public void loginUserName()
	{
		loginPanel.username.setText("John");
		loginPanel.password.setText("John");
		loginPanel.submit.doClick();
		
	}

}
