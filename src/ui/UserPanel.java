package ui;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserPanel extends JPanel {
	public JLabel userIdLabel;
	public boolean isAlive = false;
	public int cthid;
	
	public UserPanel(int x, int y, int usernum) {
		setLayout(null);
		
		ImageIcon userIcon = new ImageIcon("images/user" + usernum + ".png");
		userIcon = new ImageIcon(userIcon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
		JLabel userIconLabel = new JLabel(userIcon);
		userIconLabel.setBounds(0, 0, x, y);
		userIconLabel.setVerticalAlignment(JLabel.CENTER);
		
		userIdLabel = new JLabel("No User");
		userIdLabel.setBounds(x + 10, 0, 2 * x, y - 10);
		userIdLabel.setVerticalAlignment(JLabel.CENTER);
		userIdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(userIconLabel);
		add(userIdLabel);
	}
}