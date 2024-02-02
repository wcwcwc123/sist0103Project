package kiosk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {


    ImageDraw draw = new ImageDraw();


    public MainFrame() {
        super("초기화면");

        this.setBounds(349,0,1306,1047);

        initDesign();
        this.setVisible(true);
    }

    public void initDesign() {

        this.setLayout(null);

        draw.setBounds(0, 0, 1306, 847);
        this.add(draw);


        //주문하기 버튼
        JButton btnOrder = new JButton("주문하기");
        btnOrder.setBounds(394,870,450,120);
        btnOrder.setFont(new Font(Font.DIALOG,Font.BOLD,35));
        btnOrder.setFocusPainted(false);
        btnOrder.setBorderPainted(false);
        this.add(btnOrder);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new KioskSub("커피");
                setVisible(false);
            }
        });

        //상품 추가 버튼
        JButton btnAdd = new JButton("메뉴 추가");
        btnAdd.setBounds(1118,868,120,55);
        btnAdd.setBorderPainted(false);
        this.add(btnAdd);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductAddForm();
            }
        });

        //상폼 목록 버튼
        JButton btnList = new JButton("메뉴 관리");
        btnList.setBounds(1118, 933, 120, 55);
        btnList.setBorderPainted(false);
        this.add(btnList);

        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ProductListForm();
                setVisible(false);
            }
        });




    }



    //내부클래스
    class ImageDraw extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            String imageName = "C:\\Users\\user\\Downloads\\main_image.JPG";

            Image image = new ImageIcon(imageName).getImage();
            g.drawImage(image, 0, 0,1306 , 847, this);


        }
    }

    public static void main(String[] args) {

        new MainFrame();
    }


}