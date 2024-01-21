package day0118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingArrEvent_08 extends JFrame {

    Container cp;
    JButton[] btn = new JButton[6];
    String[] btnLabel = {"Red", "Green", "Blue", "Magenta", "Gray", "Yellow"};
    Color[] btnColors = {Color.red, Color.green, Color.BLUE, Color.magenta, Color.gray, Color.yellow};

    public SwingArrEvent_08(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 600, 300);
        cp.setBackground(new Color(255, 204, 204));


        initDesign();
        this.setVisible(true);

    }

    public void initDesign() {

        //Panel은 기본이 FlowLayout
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        this.add(panel, BorderLayout.NORTH);// 프레임의 상단에 패널 배치

        //버튼생성
        for (int i = 0; i < 6; i++) {
            //버튼 6개 생성
            btn[i] = new JButton("버튼" + (i + 1));
            JButton tmp = btn[i];
            //버튼6개에 각각의 버튼색 변경
            btn[i].setBackground(new Color((int)Math.pow(i+2,i+2)%255,(int)Math.pow(i+3,i+3)%255,(int)Math.pow(i+4,i+4)%255));
            Color complement = new Color(255-(int)Math.pow(i+2,i+2)%255,255-(int)Math.pow(i+3,i+3)%255,255-(int)Math.pow(i+4,i+4)%255);
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(tmp,tmp.getBackground());
                    cp.setBackground(tmp.getBackground());
                    tmp.setForeground(complement);
                    panel.setBackground(complement);
                    setTitle((tmp.getBackground()).toString().substring(9));
                }
            });
            panel.add(btn[i]);
        }
    }

    public static void main(String[] args) {
        new SwingArrEvent_08("swing 8");
    }
}
