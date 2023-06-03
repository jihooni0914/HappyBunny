package ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MultiLoginFrame extends JFrame {
	public JButton button;
	public JTextField textbox;
	
	public MultiLoginFrame() {
		setBounds(100, 100, 300, 200);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Login");
		
		setLayout(new GridLayout(3, 1, 10, 20));
		
		JLabel label = new JLabel("ID: ");
		add(label);
		
		textbox = new JTextField();
		add(textbox);
		
		button = new JButton("Login");
		add(button);
	}
}
