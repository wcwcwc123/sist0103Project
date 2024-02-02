package kiosk;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

public class ReceiptTable extends JFrame {

    JLabel lblTitle;

    JLabel lblTitleName,lblTitlePrice,lblTitleQty,lblTitleTotal;

    JLabel lblA,lblB,lblC;
    JLabel lblTotal2;
    //테이블
    DefaultTableModel tableModel;
    JTable table;

    JButton btnToHome,btnFinish;


    public ReceiptTable(Vector<OrderDto> orderList,KioskSub sub) {
        super("주문내역");
        this.setBounds(715,158,600,800);
        //initDesign();
        this.setVisible(true);

        this.setLayout(null);

        int totalPrice = 0;



        lblTitle = new JLabel("주문내역");
        lblTitle.setBounds(200, 5, 300, 100);
        lblTitle.setFont(new Font("", Font.BOLD, 50));
        this.add(lblTitle);

        lblA = new JLabel("결제금액");
        lblA.setBounds(300,526,150,60);
        lblA.setFont(new Font("", Font.BOLD, 20));
        this.add(lblA);

        lblB = new JLabel("20,000");
        lblB.setBounds(427,526,150,60);
        lblB.setFont(new Font("", Font.PLAIN, 20));
        this.add(lblB);

        btnToHome = new JButton("처음으로");
        btnToHome.setBounds(80, 620, 200, 90);
        btnToHome.setFont(new Font("",Font.BOLD,20));
        btnToHome.setBorderPainted(false);
        btnToHome.setFocusPainted(false);
        this.add(btnToHome);

        btnToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                sub.setVisible(false);
                new MainFrame();
            }
        });

        btnFinish = new JButton("종료하기");
        btnFinish.setBounds(309,620,200,90);
        btnFinish.setFont(new Font("",Font.BOLD,20));
        btnFinish.setBorderPainted(false);
        btnFinish.setFocusPainted(false);

        this.add(btnFinish);

        btnFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(ReceiptTable.this,"종료");
                setVisible(false);
                sub.setVisible(false);
            }
        });


//        lblB = new JLabel("받음금액");
//        lblB.setBounds(300,596,150,60);
//        lblB.setFont(new Font("", Font.BOLD, 25));
//        this.add(lblB);
//
//        lblC = new JLabel("거스름돈");
//        lblC.setBounds(300,666,150,60);
//        lblC.setFont(new Font("", Font.BOLD, 25));
//        this.add(lblC);

        DecimalFormat decimalFormat = new DecimalFormat("#,###");


        Locale locale = new Locale("ko", "KR");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        lblB.setHorizontalAlignment(SwingConstants.CENTER);
        //lblTotal2.setText(currencyFormat.format(totalPrice));





        // 숫자 포맷팅
        //int number = 123456;
        //String formattedNumber = decimalFormat.format(number);




        //table
        String[] title = {"품명", "단가", "수량", "가격"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        // 헤더에 대한 폰트 설정
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14)); // 원하는 글자 크기 및 폰트 설정

        table.setRowHeight(35);



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

            int tmp = dto.getQty()*dto.getPrice();
            totalPrice += tmp;
            data.add(String.valueOf(tmp));
            //테이블 모델에 추가
            tableModel.addRow(data);
        }
//        // 글자 크기 설정을 위한 DefaultTableCellRenderer
//        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
//        cellRenderer.setFont(new java.awt.Font(Font.MONOSPACED, java.awt.Font.PLAIN, 50)); // 글자 크기 설정
//
//        // 모든 셀에 대해 DefaultTableCellRenderer 적용
//        for (int i = 0; i < table.getColumnCount(); i++) {
//            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
//        }


        lblB.setText(decimalFormat.format(totalPrice)+"원");
    }

    public static void main(String[] args) {


        //new ReceiptTable(new Vector<OrderDto>(),new KioskSub());

    }
}
