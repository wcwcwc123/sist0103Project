package day0118;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gpttest1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Swing 디자인 예제");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 패널 생성
        JPanel panel = new JPanel();

        // 레이블 생성 및 패널에 추가
        JLabel label = new JLabel("안녕하세요, Java Swing!");
        panel.add(label);

        // 버튼 생성 및 패널에 추가
        JButton button = new JButton("클릭하세요");
        panel.add(button);

        // 버튼에 대한 이벤트 처리 추가
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("버튼이 클릭되었습니다!");
            }
        });

        // 패널을 프레임에 추가
        frame.add(panel, BorderLayout.CENTER);

        // 프레임을 화면에 표시
        frame.setVisible(true);
    }
}
