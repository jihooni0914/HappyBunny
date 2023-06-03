package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login {

    JFrame frame;
//    public MultiLoginFrame multi;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setBounds(100, 100, 720, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JButton button = new JButton("SinglePlay");
        button.setText("SinglePlay");
        button.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
        button.setBounds(10, 274, 250, 85);
        frame.getContentPane().add(button);

        JLabel lblNewLabel = new JLabel("Happy Banny");
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 50));
        lblNewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewLabel.setBounds(190, 41, 321, 150);
        frame.getContentPane().add(lblNewLabel);

        JButton button2 = new JButton("MultiPlay");
        button2.setFont(new Font("Maiandra GD", Font.PLAIN, 20));
        button2.setBounds(444, 274, 250, 85);
        frame.getContentPane().add(button2);

        button.addActionListener(new EventHandler());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // Hide the frame
            }
        });
        button2.addActionListener(new EventHandler());
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MultiLoginFrame multi = new MultiLoginFrame();
                
                multi.button.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				SingleNormalUI window = new SingleNormalUI();
        				window.frame.setVisible(true);
        				multi.setVisible(false);
        				frame.setVisible(false);
        			}
        		});
        		
                multi.setVisible(true);
            }
        });
    }
}

class MultiLoginFrame extends JFrame {
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

