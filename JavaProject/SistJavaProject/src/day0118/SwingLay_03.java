package day0118;

import javax.swing.*;
import java.awt.*;

public class SwingLay_03 extends JFrame {

    Container cp;
    JButton btn1;

    public SwingLay_03(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 540, 480);
        cp.setBackground(new Color(0xff0066));

        //버튼생성
        btn1 = new JButton("버튼1");

        this.setVisible(true);

        //프레임에 버튼추가
        //프레임은 기본이 BorderLayout
        //이경우는 위치지정필수

        this.add("East",btn1);

        this.add("South", new JButton("아래버튼"));
        this.add("West", new JButton("왼쪽버튼"));
        this.add("North", new JButton("위"));
        this.add("Center", new JButton("위"));

        //버튼1에 속성추가
        btn1.setBackground(new Color(0xf6ab23));
        btn1.setForeground(new Color(0xbb2233));
    }

    public static void main(String[] args) {

        new SwingLay_03("기본 레이아웃");
    }

}
