package day0118;

import javax.swing.*;
import java.awt.*;

public class SwingGibon_01 extends JFrame {

    public SwingGibon_01(String title) {
        super(title);

        //시작위치, 너비, 높이
        this.setBounds(500, 100, 300, 300);

        //배경색(컬러 직접선택)
        /*this.getContentPane().setBackground(Color.MAGENTA);*/
        //배경색(RGB컬러)
        this.getContentPane().setBackground(new Color(0x111111));


        //프레임에 보이게
        this.setVisible(true);

    }


    public static void main(String[] args) {

        new SwingGibon_01("스윙기본");
    }
}
