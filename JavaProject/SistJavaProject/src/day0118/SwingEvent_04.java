package day0118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEvent_04 extends JFrame implements ActionListener {

    Container cp;
    JButton btn1,btn2,btn3;

    public SwingEvent_04(String title) {
        super(title);

        cp = this.getContentPane();
        this.setBounds(300, 100, 300, 300);
        cp.setBackground(new Color(255, 204, 204));

        initDesign();


        this.setVisible(true);
    }
    public void initDesign() {

        //레이아웃변경
        this.setLayout(new FlowLayout());

        //버튼 3개 생성
        btn1 = new JButton("버튼 #1");
        btn2 = new JButton("버튼 #2");
        btn3 = new JButton("버튼 #3");

        btn1.setBackground(Color.BLACK);
        btn2.setBackground(Color.BLUE);
        btn3.setBackground(Color.GREEN);

        //버튼에 이벤트 발생..이벤트 핸들러와 이벤트발생객체 연결
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        //프레임에 추가
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
    }


    public static void main(String[] args) {

        new SwingEvent_04("sw04");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object ob = e.getSource(); // 버튼의 어떤 메서드 호출인지 정확히 지정해주어야함

        //메세지를 다이얼로그형태로 보여준다
        //JOptionPane.showMessageDialog(this,"버튼클릭!!!");

        //버튼마다 다른 메세지 출력하려면?
        if (ob == btn1) {
            JOptionPane.showMessageDialog(this, "1번째 버튼클릭!!!");
        } else if (ob == btn2) {
            JOptionPane.showMessageDialog(this,"2번째 버튼!!");
        } else if (ob == btn3) {
            JOptionPane.showMessageDialog(this,"3번째 버튼!!!");
        }

    }
}
