package day0119;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingLabelRandom_0101 extends JFrame{

    Container cp;
    JLabel[] lblLabel = new JLabel[9];
    String[] str = {"샌드위치", "햄버거", "콜라", "스프라이트", "요거트", "스파게티"
            , "피자", "고르곤졸라", "리조또"};
    JButton btn;


    public void initDesign() {

        //패널을 프레임의 센터에 추가
        Panel pCenter = new Panel(new GridLayout(3, 3));
        this.add(pCenter, BorderLayout.CENTER);

        //라벨을 패널에 추가
        for (int i = 0; i < lblLabel.length; i++) {
            lblLabel[i] = new JLabel(str[i], JLabel.CENTER);


            //패널에 라벨추가
            pCenter.add(lblLabel[i]);
            //글꼴변경
            lblLabel[i].setFont(new Font("궁서체", Font.BOLD, 15));
            lblLabel[i].setOpaque(true);
        }

        //프레임의 하단에 버튼생성후 추가
        btn = new JButton("라벨색상변경");

        //버튼에 이벤트 추가.. 하단에
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lblLabel.length; i++) {
                    int r= (int)(Math.random()*256);
                    int g= (int)(Math.random()*256);
                    int b= (int)(Math.random()*256);
                    lblLabel[i].setBackground(new Color(r,g,b));
                    lblLabel[i].setForeground(new Color(255 - r, 255 - g, 255 - b));
                }

            }
        });

        this.add(btn,BorderLayout.SOUTH);
    }


    public SwingLabelRandom_0101(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 300, 300);
        cp.setBackground(new Color(255, 204, 204));


        initDesign();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new SwingLabelRandom_0101("랜덤컬러생성_1");

    }
}
