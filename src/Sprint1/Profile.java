package login;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Profile extends JPanel{

	private MainPanel main;
	private JButton logoutButton = new JButton("Logout");
	private JButton editButton = new JButton("Edit");

	private JLabel usernameLabel = new JLabel("User Name");
	private JLabel emailLabel = new JLabel("Email");
	private JLabel sqLabel = new JLabel("Animal name");

	public JLabel headerLabel = new JLabel("Profile Panel");
	
	private JLabel usernameDisplayLabel = new JLabel();
	private JLabel emailDisplayLabel = new JLabel();
	private JLabel sqDisplayLabel = new JLabel();



	public Profile(MainPanel mainPanel) {
		this.main = mainPanel;
		this.logoutButton.addActionListener(new LogoutListener());
		this.add(this.logoutButton);
		this.add(headerLabel);
		this.headerLabel.setPreferredSize(new Dimension(700,40));
		this.headerLabel.setFont(new Font("Serif", Font.BOLD, 25));

		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(box);

		JPanel usernameRow = new JPanel();
		usernameRow.add(usernameLabel);
		usernameRow.add(usernameDisplayLabel);
		this.add(usernameRow);

		JPanel emailRow = new JPanel();
		emailRow.add(emailLabel);
		emailRow.add(emailDisplayLabel);
		this.add(emailRow);

		JPanel sqRow = new JPanel();
		sqRow.add(sqLabel);
		sqRow.add(sqDisplayLabel);
		this.add(sqRow);

		this.usernameLabel.setPreferredSize(new Dimension(150,25));
		this.emailLabel.setPreferredSize(new Dimension(150,25));
		this.sqLabel.setPreferredSize(new Dimension(150,25));

		this.usernameDisplayLabel.setPreferredSize(new Dimension(150,25));
		this.emailDisplayLabel.setPreferredSize(new Dimension(150,25));
		this.sqDisplayLabel.setPreferredSize(new Dimension(150,25));

		JPanel buttonRow = new JPanel();
		buttonRow.add(editButton);
		buttonRow.add(logoutButton);
		this.add(buttonRow);

		LogoutListener logoutButton = new LogoutListener();
		this.logoutButton.addActionListener(logoutButton);
		EditListener editButton = new EditListener();
		this.editButton.addActionListener(editButton);
		

	}
	public void setUserData(){
		User tempUser =  main.getCurrentUser();
		this.usernameDisplayLabel.setText(tempUser.getUserName());
		this.emailDisplayLabel.setText(tempUser.getEmail());
		this.sqDisplayLabel.setText(tempUser.getSq());
	}
	
	private class EditListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			main.sendEvent("edit");
		}
	}

	private class LogoutListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			main.sendEvent("logout");
		}
	}
}
