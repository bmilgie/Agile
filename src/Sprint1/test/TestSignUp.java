package Sprint1.test;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.junit.*;

import Sprint1.MainPanel;
import Sprint1.Register;


public class TestSignUp {
	private Register SetUp;
	public MainPanel test;

	@Before
	public void setUp() throws Exception
	{
		test = new MainPanel();
		SetUp = new Register(test);
	}
	
	@After
	public void done() throws Exception
	{
		
	}
	
	@Test
	public void testRegister()
	{
		JFrame frame = new JFrame();
		frame.getContentPane().add(SetUp);
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
	public void testSubmit()
	{
		
	}
}


