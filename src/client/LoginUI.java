package client;

import javax.swing.*;
import java.awt.*;

class LoginUI extends JFrame {
    public JTextField usernameField;
    public JButton loginButton;
    
    public JButton printUsersButton;
    
    public JTextField bustNumField;
    public JButton bustButton;
    

    public LoginUI() {
        setTitle("Login");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 위치

        // 컴포넌트 초기화
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        loginButton = new JButton("Login");
        printUsersButton = new JButton("Print Users");
        
        JLabel bustNumLabel = new JLabel("Bust Num:");
        bustNumField = new JTextField(20);
        bustButton = new JButton("!BUST TIME!");

        // 레이아웃 설정
        setLayout(new GridLayout(7, 1, 10, 20));
        add(usernameLabel);
        add(usernameField);
        add(loginButton);
        
        add(printUsersButton);
        
        add(bustNumLabel);
        add(bustNumField);
        add(bustButton);
    }
}
