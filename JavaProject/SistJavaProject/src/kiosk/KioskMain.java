package kiosk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//주문화면
public class KioskMain extends JFrame {

    JButton btnCoffee,btnFlatccino,btnAde,btnTea,btnIce; // 메뉴종류 버튼(커피,플랫치노,에이드,티,빙수)

    JButton btnBuy; // 결제하기 버튼
    JButton btnHome; // 홈 버튼(처음으로)
    JButton[] btnTemp = new JButton[8];
    JPanel[] pnlTemp = new JPanel[8];

    Container cp;
    JScrollPane scrollPane,orderPane; // 상품목록, 주문(장바구니)팬
    JPanel pnl1,pnl2,pnl3,pnl4,pnl5,pnl6,pnl7,pnl8,pnl9,pnl10,pnl11;

    JLabel lblTotal1,lblTotal2;


    //테이블
    DefaultTableModel tableModel;
    JTable table;



    public KioskMain() {
        super("주문 메뉴화면");

        //this.setBounds(600, 0, 600, 600);

        this.initdesign();
        this.setVisible(true);

    }

    public void initdesign() {

        this.setLayout(new BorderLayout());
        this.setBounds(349,0,1306,1047);

        btnCoffee = new JButton("커피");
        btnFlatccino = new JButton("플랫치노");
        btnAde = new JButton("에이드");
        btnTea = new JButton("티");
        btnIce = new JButton("빙수");
        btnHome = new JButton("처음으로");

        pnl1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); //처음으로 버튼 패널
        pnl1.add(btnHome);
        this.add("North",pnl1);

        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new MainFrame();
            }
        });



        pnl2 = new JPanel(new BorderLayout()); // 메뉴종류와, 메뉴 판넬
        this.add("Center", pnl2);

        pnl3 = new JPanel(new GridLayout(1,5)); // 메뉴종류 버튼5개가 들어갈 판넬
        pnl3.add(btnCoffee);
        pnl3.add(btnFlatccino);
        pnl3.add(btnAde);
        pnl3.add(btnTea);
        pnl3.add(btnIce);


        pnl4 = new JPanel(new GridLayout(2, 4));  //메뉴(그리드) 판넬 생성

        for (int i = 0; i < 8; i++) {
            btnTemp[i] = new JButton(""+i);
            pnlTemp[i] = new JPanel();
            btnTemp[i].setPreferredSize(new Dimension(150,40));

            pnlTemp[i].add(btnTemp[i]);
            pnl4.add(pnlTemp[i]);
        }
        //btnTemp[0].setVisible(false);

        scrollPane = new JScrollPane(pnl4); // 스크롤팬 안에 메뉴판넬 삽입

        pnl2.add("North",pnl3); // 메뉴종류,메뉴 판넬에 메뉴버튼5개 판넬 삽입
        pnl2.add("Center",scrollPane); // 스크롤 메뉴판넬 삽입

        pnl5 = new JPanel(new BorderLayout()); //장바구니,결제금액,결제하기 전체 바탕 판넬
        this.add("South", pnl5);

        //table
        String[] title = {"상품명", "단가","수량","금액"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);

//        table.setBounds(new Rectangle(1000,400));
        orderPane = new JScrollPane(table);
        orderPane.setPreferredSize(new Dimension(950, 350));
        //orderPane.setBounds(10,10,500,270);
        pnl5.add("West",orderPane);


        pnl9 = new JPanel(new GridLayout(2, 1));//총결제금액,결제하기 바탕 판넬
        pnl10 = new JPanel(new BorderLayout()); // 총결제 금액 판넬

        lblTotal1 = new JLabel("총 결제금액");
//        lblTotal1.setPreferredSize(new Dimension(150,50));
        lblTotal1.setFont(new Font("",Font.BOLD, 25));
        //lblTotal1.setOpaque(true);

        //lblTotal1.setBounds(10,10,40,40);
        lblTotal2 = new JLabel("23,000원");
        lblTotal2.setForeground(Color.red);
        lblTotal2.setFont(new Font("",Font.BOLD,35));
        pnl10.add("North",lblTotal1);
        pnl10.add("Center",lblTotal2);
        lblTotal2.setHorizontalAlignment(SwingConstants.CENTER);


        btnBuy = new JButton("결제하기");
        btnBuy.setPreferredSize(new Dimension(340, 180));
        //pnl11 = new JPanel(); // 결제하기 판넬
        //pnl11.add(btnBuy);
        pnl9.add(pnl10);
        pnl9.add(btnBuy);
        pnl5.add("East", pnl9);

    }




    public static void main(String[] args) {


        new KioskMain();
    }


}
