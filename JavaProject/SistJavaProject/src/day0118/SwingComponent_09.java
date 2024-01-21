package day0118;

import javax.swing.*;
import java.awt.*;

public class SwingComponent_09 extends JFrame {


    Container cp;
    JTextField text1,text2;
    JLabel lbl1,lbl2,lbl3,lbl4;

    public SwingComponent_09(String title) {
        super(title);

        cp = this.getContentPane();


        ImageIcon icon1 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\45-pandadog.gif");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\user\\Downloads\\swingimage\\img_msn_i10.gif");


        this.setBounds(300, 100, 300, 300);
        cp.setBackground(new Color(255, 204, 204));

        initDesign();
        this.setVisible(true);
    }
    public void initDesign() {
        this.setLayout(null);

        text1 = new JTextField();
        text1.setBounds(10, 20, 80, 30);
        this.add(text1);

        text2 = new JTextField("Have a Nice Day");
        text2.setBounds(10, 60, 80, 30);
        this.add(text2);

        lbl1 = new JLabel("안녕하세요", JLabel.CENTER);
        lbl1.setBounds(10, 100, 80, 30);
        lbl1.setBackground(Color.orange);
        lbl1.setOpaque(true);
        this.add(lbl1);

    }

    public static void main(String[] args) {
        new SwingComponent_09("swing09");
    }
}
