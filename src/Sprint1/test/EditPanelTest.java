package Sprint1.test;
import org.junit.*;
import Sprint1.*;

public class EditPanelTest {
	
	@Before
	public void setUp()
	{
		
	}
	
	@After
	public void done()
	{
		
	}
	
	public void waitTimer(int x)
	{
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void GUI()
	{
		Driver.createAndShowGUI();
		waitTimer(1000);
		Login.password.setText("Test123");
		Login.username.setText("oscaravila2");
		Login.submit.doClick();
		
		Profile.editButton.doClick();
		waitTimer(10000);
	}

}
