package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuteChatUI extends JFrame {
    public JTextArea chatArea;
    public JTextField inputField;

    public CuteChatUI() {
        setTitle("Cute Chat");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 채팅창 텍스트 영역
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // 입력 필드와 전송 버튼
        inputField = new JTextField();
        JButton sendButton = new JButton("Send");
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // 전송 버튼 이벤트 처리
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                appendMessage("You: " + message);
                inputField.setText("");
            }
        });

        setVisible(true);
    }

    // 메시지를 채팅창에 추가
    public void appendMessage(String message) {
        chatArea.append(message + "\n");
    }
}