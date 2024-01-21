package day0118;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz_11 extends JFrame {

    Container cp;

    Color[] colorList = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.GRAY};
    String[] labelList = {"빨강색", "초록색", "파랑색", "노랑색", "회색"};

    JButton[] btnList = new JButton[5];
    JLabel lbl;

    public Quiz_11() {
        super("quiz11");

        cp = this.getContentPane();

        this.setBounds(300, 100, 800, 300);
        this.setBackground(Color.BLACK);

        initDesign();
        this.setVisible(true);
    }
    public void initDesign() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        this.add(panel, BorderLayout.NORTH);// 프레임의 상단에 패널 배치

        lbl = new JLabel("안녕하세요",JLabel.CENTER);
        lbl.setBounds(20,170,30,30);
        lbl.setFont(new FontUIResource("", Font.BOLD, 30));

        this.add(lbl);

        for (int i = 0; i < btnList.length; i++) {
            btnList[i] = new JButton(labelList[i]);

            btnList[i].setBackground(colorList[i]);
            Color c = colorList[i];
            btnList[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lbl.setForeground(c);
                    //cp.setBackground(c);
                }
            });

            panel.add(btnList[i]);
        }

    }



    public static void main(String[] args) {
        new Quiz_11();

    }
}
