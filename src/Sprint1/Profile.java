package Sprint1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates the profile page
 * 
 * @author Team 7
 *
 */
public class Profile extends JPanel
{
	
	private static MainPanel main;
	private static JButton logoutButton = new JButton("Logout");
	private static JButton editButton = new JButton("Edit");
	private static JLabel nameLabel = new JLabel("Name");
	private static JLabel emailLabel = new JLabel("Email");
	private static JLabel ageLabel = new JLabel("Age");
	private static JLabel academicStandingLabel = new JLabel("Academic Standing");
	//private static JLabel actualNameLabel = new JLabel(currentUser.getName);
	private static JLabel actualEmailLabel = new JLabel();
	private static JLabel actualAgeLabel = new JLabel();
	private static JLabel actualClassStandingLabel = new JLabel();
	public static JLabel headerLabel = new JLabel("Profile Panel");
	private static LinkedList <User> currentUser = new LinkedList();
	
	
	
	/**
	 * This constructor announces you are on the profile page
	 * 
	 * @param mainPanel
	 */
	public Profile(MainPanel mainPanel) 
	{
		this.main = mainPanel;
		this.logoutButton.addActionListener(new LogoutListener());
		this.add(headerLabel);
		this.headerLabel.setPreferredSize(new Dimension(700,40));
		this.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));
		
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);
		
		JPanel nameRow = new JPanel();
		nameRow.add(nameLabel);
		//nameRow.add(nameRow.getName());
		this.add(nameRow);
		
		JPanel emailRow = new JPanel();
		emailRow.add(emailLabel);
		//emailRow.add(emailRow.getEmail());
		this.add(emailRow);
		
		JPanel ageRow = new JPanel();
		ageRow.add(ageLabel);
		//ageRow.add(ageLabel.getAge());
		this.add(ageRow);
		
		JPanel academicStandingRow = new JPanel();
		academicStandingRow.add(academicStandingLabel);
		//academicStandingRow.add(academicStandingRow.getacademicStandingRow());
		this.add(academicStandingRow);
		
		this.nameLabel.setPreferredSize(new Dimension(150,25));
		this.emailLabel.setPreferredSize(new Dimension(150,25));
		this.ageLabel.setPreferredSize(new Dimension(150,25));
		this.academicStandingLabel.setPreferredSize(new Dimension(150,25));
		
		JPanel buttonRow = new JPanel();
		buttonRow.add(editButton);
		buttonRow.add(logoutButton);
		this.add(buttonRow);
		
		LogoutListener logoutButton = new LogoutListener();
		this.logoutButton.addActionListener(logoutButton);
	}
	
	  /**
     * This class deals with the edit button's logic when the user wants to edit 
     * their account.
     * 
     * @author Team 7
     *
     */
    private class editButtonListener implements ActionListener
    {
    	
    	/* (non-Javadoc)
    	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    	 */
    	public void actionPerformed(ActionEvent e) 
    	{
//    		String username = userNameText.getText();
//    		String email = emailText.getText();
//    		String sq = sqText.getText();
//    		String password = main.resetPassword(username, email, sq);
//    		passwordLabel.setText("Your new password is : " + password);

    	}
    }
	
	/**
	 * This class deals with the ActionListener when the user wants to logout 
	 * of their account.
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