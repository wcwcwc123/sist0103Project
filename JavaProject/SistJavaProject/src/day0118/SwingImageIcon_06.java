package day0118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingImageIcon_06 extends JFrame {

    Container cp;

    //이미지 아이콘 가져온
    ImageIcon icon1 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\45-pandadog.gif");
    ImageIcon icon2 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\img_msn_i10.gif");
    ImageIcon icon3 = new ImageIcon("C:\\Users\\user\\Downloads\\gameimage\\kim1.png");
    ImageIcon icon4 = new ImageIcon("C:\\Users\\user\\Downloads\\gameimage\\yellowbird.png");
    ImageIcon icon5 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\chick.gif");

    JButton btn1,btn2,btn3, btn4;


    public SwingImageIcon_06(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 300, 300);
        cp.setBackground(new Color(255, 204, 204));

        initDesign();
        this.setVisible(true);
    }

    public void initDesign() {

        //2행2열
        this.setLayout(new GridLayout(2, 2));
        btn1 = new JButton("hello", icon1);
        btn1.setHorizontalTextPosition(JButton.CENTER);
        btn1.setVerticalTextPosition(JButton.BOTTOM);
        btn2 = new JButton("hello", icon2);
        btn3 = new JButton("hello", icon5);
        btn4 = new JButton("hello", icon5);

        this.add(btn1);
        btn1.setRolloverIcon(icon5);
        btn1.setPressedIcon(icon3);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btn1,"click");

            }
        });
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);


    }

    public static void main(String[] args) {

        new SwingImageIcon_06("이미지버튼6");

    }

}
