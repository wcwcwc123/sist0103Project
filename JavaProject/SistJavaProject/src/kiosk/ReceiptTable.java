package kiosk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class ReceiptTable extends JFrame {

    JLabel lblTitle;

    JLabel lblTitleName,lblTitlePrice,lblTitleQty,lblTitleTotal;

    //테이블
    DefaultTableModel tableModel;
    JTable table;


    public ReceiptTable(Vector<OrderDto> orderList) {
        super("주문내역");
        this.setBounds(900,0,600,800);
        //initDesign();
        this.setVisible(true);

        this.setLayout(null);


        lblTitle = new JLabel("주문내역");
        lblTitle.setBounds(200, 10, 300, 100);
        lblTitle.setFont(new Font("", Font.BOLD, 50));
        this.add(lblTitle);

        //table
        String[] title = {"품명", "단가", "수량", "가격"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        JScrollPane js = new JScrollPane(table);

        js.setBounds(20,100,550,400);
        this.add(js);

        //테이블 기존 데이터 삭제
        tableModel.setRowCount(0);

        //테이블에 데이터 추가하기
        for (OrderDto dto : orderList) {
            Vector<String> data = new Vector<String>();

            data.add(dto.getMenu_name());
            data.add(String.valueOf(dto.getPrice()));
            data.add(String.valueOf(dto.getQty()));
            data.add(String.valueOf(dto.getQty()*dto.getPrice()));
            //테이블 모델에 추가
            tableModel.addRow(data);

        }

        JLabel lblTotal1;
        lblTotal1 = new JLabel("청구금액");
//        lblTotal1.setPreferredSize(new Dimension(150,50));
        lblTotal1.setFont(new Font("", Font.BOLD, 25));
        //lblTotal1.setOpaque(true);

        //lblTotal1.setBounds(10,10,40,40);
        lblTotal2 = new JLabel("₩ "+forePrice);
        lblTotal2.setForeground(Color.red);
        lblTotal2.setFont(new Font("", Font.BOLD, 35));
        pnl10.add("North", lblTotal1);
        pnl10.add("Center", lblTotal2);
        lblTotal2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotal2.setText(currencyFormat.format(forePrice));


    }

    public static void main(String[] args) {


        new ReceiptTable(new Vector<OrderDto>());

    }
}
