package Sprint1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 
 * @author Team 7
 *
 */
public class Profile extends JPanel
{
	
	private static MainPanel main;
	private static JButton logoutButton = new JButton("Logout");
	
	
	/**
	 * 
	 * 
	 * @param mainPanel
	 */
	public Profile(MainPanel mainPanel) 
	{
		this.main = mainPanel;
		this.logoutButton.addActionListener(new LogoutListener());
		this.add(new JLabel("PRofile panel"));
		this.add(this.logoutButton);
		
	}
	
	/**
	 * 
	 * 
	 * @author Team 7
	 *
	 */
	private class LogoutListener implements ActionListener
	   {
	    	
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		main.sendEvent("logout");
	    	}
	    }
}