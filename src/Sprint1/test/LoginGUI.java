package Sprint1.test;
import java.awt.Dimension;

import javax.swing.*;
import org.junit.*;
import Sprint1.*;

public class LoginGUI {

	
	@Before
	public void setUp()
	{

	}
	
	@After
	public void done()
	{
		
	}
	
	@Test
	public void loginGui()
	{
		Driver.createAndShowGUI();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
