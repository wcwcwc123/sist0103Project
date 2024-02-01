package kiosk;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Receipt extends JFrame {

    JLabel lblTitle;

    JLabel lblTitleName,lblTitlePrice,lblTitleQty,lblTitleTotal;



    public Receipt(Vector<OrderDto> orderList) {
        super("주문내역");
        this.setBounds(900,0,600,800);
        initDesign();
        this.setVisible(true);

    }

    public void initDesign() {

        this.setLayout(null);

//        JLabel lblTitle = new JLabel("상품메뉴 조회");
//        lblTitle.setBounds(425,13,450,135);
//        lblTitle.setFont(new Font("",Font.BOLD,50));
//        this.add(lblTitle);


        lblTitle = new JLabel("주문내역");
        lblTitle.setBounds(200, 10, 300, 100);
        lblTitle.setFont(new Font("", Font.BOLD, 50));
        this.add(lblTitle);

        lblTitleName = new JLabel("품명");
        lblTitleName.setBounds(30,70,100,100);
        lblTitleName.setFont(new Font("",Font.BOLD,20));
        this.add(lblTitleName);


        lblTitlePrice = new JLabel("단가");
        lblTitlePrice.setBounds(230,70,100,100);
        lblTitlePrice.setFont(new Font("",Font.BOLD,20));
        this.add(lblTitlePrice);


        lblTitleQty = new JLabel("수량");
        lblTitleQty.setBounds(300,70,100,100);
        lblTitleQty.setFont(new Font("",Font.BOLD,20));
        this.add(lblTitleQty);


        lblTitleTotal = new JLabel("금액");
        lblTitleTotal.setBounds(400,70,100,100);
        lblTitleTotal.setFont(new Font("",Font.BOLD,20));
        this.add(lblTitleTotal);

    }


    public static void main(String[] args) {
        new Receipt(new Vector<OrderDto>());
    }
}
