package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public JFrame frame;
    public MultiLoginFrame multi;

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
        
        multi = new MultiLoginFrame();

        JLabel backgroundLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("images/farm.jpg").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getContentPane().add(backgroundLabel);

        JButton button = new JButton("SinglePlay");
        button.setText("SinglePlay");
        button.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        button.setBounds(10, 274, 250, 85);
        backgroundLabel.add(button);

        JLabel lblNewLabel = new JLabel("Happy Banny");
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 50));
        lblNewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewLabel.setBounds(190, 41, 321, 150);
        backgroundLabel.add(lblNewLabel);

        JButton button2 = new JButton("MultiPlay");
        button2.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        button2.setBounds(444, 274, 250, 85);
        backgroundLabel.add(button2);

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


