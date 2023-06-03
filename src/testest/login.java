package testest;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class login {

    JFrame frame;
    


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public login() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setBounds(100, 100, 720, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel backgroundLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("C:\\\\Users\\\\User\\\\eclipse-workspace\\\\testest\\\\Image\\\\farm.jpg").getImage();
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
                frame.setVisible(false); // Hide the frame
            }
        });
    }
}


