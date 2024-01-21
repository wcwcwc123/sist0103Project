package day0118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEvent_07 extends JFrame {
    Container cp;
    JButton btn1,btn2;


    public SwingEvent_07(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 300, 300);
        cp.setBackground(new Color(0x123456));

        initDesign();
        this.setVisible(true);
    }

    public void initDesign() {

        //Flow레이아웃으로 버튼2개 생성
        this.setLayout(new FlowLayout());

        //버튼색상 그레이로 변경, 버튼색상 그린으로 변경
        btn1 = new JButton("btn1");
        btn2 = new JButton("btn2");

        btn1.setBackground(Color.gray);
        btn2.setBackground(Color.green);

        this.add(btn1);
        this.add(btn2);

        //버튼1생성 및 이벤트 주기(익명내부 클래스 형식)
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.gray);
//                cp.setBackground(Color.gray);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn2.setBackground(Color.blue);
            }
        });
    }

    public static void main(String[] args) {

        new SwingEvent_07("swing07");

    }
}
