package Sprint1.test;

import org.junit.*;
import Sprint1.*;


public class RegisterGUI {

	@Before
	public void setUp()
	{
		
	}
	
	@After
	public void done()
	{
		
	}
	
	@Test
	public void registerGUI()
	{
		Driver.createAndShowGUI();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException a) {
			a.printStackTrace();
		}
		Login.register.doClick();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
