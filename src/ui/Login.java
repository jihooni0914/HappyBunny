package ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

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
                Image image = new ImageIcon("images/main.jpg").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getContentPane().add(backgroundLabel);


        JButton singleButton = new JButton("SinglePlay");
        singleButton.setText("SinglePlay");
        singleButton.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        singleButton.setBounds(15, 275, 250, 85);
        backgroundLabel.add(singleButton);
        singleButton.setBackground(new Color(0x66, 0xcd, 0xaa));


        JLabel lblNewLabel = new JLabel("Happy          Bunny");
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 60));
        
        lblNewLabel.setForeground(new Color(0xff, 0x80, 0x9c, 200)); 
        lblNewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 50, 720, 150);
        backgroundLabel.add(lblNewLabel);

        JButton multiButton = new JButton("MultiPlay");
        multiButton.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
        multiButton.setBounds(455, 275, 250, 85);
        multiButton.setBackground(new Color(0x66, 0xcd, 0xaa)); 
        backgroundLabel.add(multiButton);

        singleButton.addActionListener(new EventHandler());
        singleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // Hide the frame
            }
        });
        
//        multiButton.addActionListener(new EventHandler());
        multiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multi.button.addActionListener(new ActionListener() {
        			@Override
        			public void actionPerformed(ActionEvent e) {
//        				SingleNormalUI window = new SingleNormalUI();
//        				window.frame.setVisible(true);
        				multi.setVisible(false);
        				frame.setVisible(false);
        			}
        		});
        		
                multi.setVisible(true);
            }
        });
    }
}


