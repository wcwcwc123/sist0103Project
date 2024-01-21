package day0118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingBtnEvent_05 extends JFrame implements ActionListener {

    Container cp;
    JButton btn1,btn2;

    public SwingBtnEvent_05(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300,100,300,300);
        this.setBackground(new Color(150, 200, 200));
        initDesign();

        this.setVisible(true);
    }

    public void initDesign() {
        this.setLayout(new FlowLayout());
        btn1=new JButton("◀");
        btn2=new JButton("▶");

        //버튼색상
        btn1.setBackground(new Color(255, 255, 255));
        btn2.setBackground(new Color(255, 255, 200));

        //글자색상
        btn1.setForeground(Color.black);
        btn2.setForeground(Color.black);

//        btn1.addActionListener(this);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btn1,"버튼1클릭!@$");
                setTitle("ghi");
                btn1.setText("버튼1 클릭완료");
            }
        });
        btn2.addActionListener(this);

        this.add(btn1);
        this.add(btn2);

    }


    public static void main(String[] args) {
        new SwingBtnEvent_05("버튼 이벤트5");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object ob = e.getSource();

        if (ob == btn1) {
            //JOptionPane.showMessageDialog(this, "왼쪽클릭");
        } else if (ob == btn2) {
            JOptionPane.showMessageDialog(this, "오른쪽클릭");

        }
    }
}
