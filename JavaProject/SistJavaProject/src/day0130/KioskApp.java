package day0130;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KioskApp extends JFrame implements ActionListener {

    private JTextField textField;

    public KioskApp() {
        setTitle("Kiosk Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Enter your name:");
        panel.add(label, BorderLayout.NORTH);

        textField = new JTextField(20);
        panel.add(textField, BorderLayout.CENTER);

        JButton button = new JButton("Submit");
        button.addActionListener(this);
        panel.add(button, BorderLayout.SOUTH);

        add(panel);

        setLocationRelativeTo(null); // 화면 중앙에 위치
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();
        JOptionPane.showMessageDialog(this, "Hello, " + name + "!", "Greeting", JOptionPane.PLAIN_MESSAGE);
        textField.setText(""); // 텍스트 필드 초기화
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KioskApp());
    }
}