package day0131;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopMain extends JFrame implements ActionListener {

    JButton btnAdd,btnDel,btnUpdate,btnList;

    public ShopMain() {
        super("ShopMain");
        this.setBounds(600, 0, 600, 600);

        this.initdesign();
        this.setVisible(true);

    }

    public void initdesign() {
        this.setLayout(new GridLayout(2, 2));
        btnAdd = new JButton("상품추가");
        btnDel = new JButton("상품삭제");
        btnUpdate = new JButton("상품수정");
        btnList = new JButton("상품목록");

        this.add(btnAdd);
        this.add(btnDel);
        this.add(btnUpdate);
        this.add(btnList);

        //이벤트
        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnList.addActionListener(this);
    }


    public static void main(String[] args) {
        new ShopMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object ob = e.getSource();

        if (ob == btnAdd) {
            System.out.println("btnAdd");
            ShopAddForm add = new ShopAddForm();
        } else if (ob == btnDel) {
            System.out.println("btnDel");
            ;
        } else if (ob == btnUpdate) {
            System.out.println("btnUpdate");

        } else if (ob == btnList) {
            System.out.println("btnList");
            new ShopListForm();
        }

    }
}
