package kiosk;

import day0131.ShopDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

//주문화면
public class KioskSub extends JFrame {

    JButton btnCoffee,btnFlatccino,btnAde,btnTea,btnIce; // 메뉴종류 버튼(커피,플랫치노,에이드,티,빙수)

    JButton btnBuy; // 결제하기 버튼
    JButton btnHome; // 홈 버튼(처음으로)
    JButton[] btnTemp = new JButton[8];
    JPanel[] pnlTemp = new JPanel[8];
    JLabel[] lblName = new JLabel[8];
    JLabel[] lblPrice = new JLabel[8];

    int totalPrice =0;


    Container cp;
    JScrollPane scrollPane,orderPane; // 상품목록, 주문(장바구니)팬
    JPanel pnl1,pnl2,pnl3,pnl4,pnl5,pnl6,pnl7,pnl8,pnl9,pnl10,pnl11;

    JLabel lblTotal1,lblTotal2;


    //테이블
    DefaultTableModel tableModel;
    JTable table;


    ProductDbModel dbModel = new ProductDbModel();
    //종류별 메뉴 담아올 리스트
    Vector<ProductDto> list;



    Vector<OrderDto> orderBox = new Vector<OrderDto>();


    public KioskSub(String type) {
        super("주문 메뉴화면");

        //this.setBounds(600, 0, 600, 600);

        this.initdesign(type, new Vector<OrderDto>(),0);
        this.setVisible(true);

    }
    public KioskSub(String type,Vector<OrderDto> orderList) {
        super("주문 메뉴화면");

        //this.setBounds(600, 0, 600, 600);

        this.initdesign(type, orderList,0);
        this.setVisible(true);

    }
    public KioskSub(String type,Vector<OrderDto> orderList, int forePrice) {
        super("주문 메뉴화면");

        //this.setBounds(600, 0, 600, 600);

        this.initdesign(type, orderList,forePrice);
        this.setVisible(true);

    }

    public void initdesign(String type, Vector<OrderDto> orderList, int forePrice) {

        this.setLayout(new BorderLayout());
        this.setBounds(349, 0, 1306, 1047);

        orderBox = orderList;

        btnCoffee = new JButton("커피");
        btnFlatccino = new JButton("플랫치노");
        btnAde = new JButton("에이드");
        btnTea = new JButton("티");
        btnIce = new JButton("빙수");
        btnHome = new JButton("처음으로");

        pnl1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); //처음으로 버튼 패널
        pnl1.add(btnHome);
        this.add("North", pnl1);

        list = dbModel.getKioskMenu(type);

        Locale locale = new Locale("ko", "KR");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        // 숫자를 형식화하여 출력
//        String formattedAmount = currencyFormat.format(amount);
        //System.out.println(formattedAmount); // 결과: ₩1,234,567.89


        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new MainFrame();
            }
        });


        pnl2 = new JPanel(new BorderLayout()); // 메뉴종류와, 메뉴 판넬
        this.add("Center", pnl2);

        pnl3 = new JPanel(new GridLayout(1, 5)); // 메뉴종류 버튼5개가 들어갈 판넬
        pnl3.add(btnCoffee);
        pnl3.add(btnFlatccino);
        pnl3.add(btnAde);
        pnl3.add(btnTea);
        pnl3.add(btnIce);

        //메뉴종류 버튼별 액션

        btnCoffee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                KioskSub.this.setVisible(false);
                new KioskSub("커피",orderBox,totalPrice);
                //new KioskSub("에이드");

            }
        });

        btnFlatccino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                KioskSub.this.setVisible(false);
                new KioskSub("플랫치노",orderBox,totalPrice);
            }
        });

        btnAde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KioskSub.this.setVisible(false);

                new KioskSub("에이드",orderBox,totalPrice);
            }
        });
        btnTea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                KioskSub.this.setVisible(false);

                new KioskSub("티",orderBox,totalPrice);
            }
        });
        btnIce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                KioskSub.this.setVisible(false);

                new KioskSub("빙수",orderBox,totalPrice);
            }
        });


        pnl4 = new JPanel(new GridLayout(2, 4));  //메뉴(그리드) 판넬 생성


        for (int i = 0; i < list.size(); i++) {
            ImageIcon icon = new ImageIcon(list.get(i).getImg());

            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(img);
            btnTemp[i] = new JButton("", resizedIcon);

            int index = i;
            btnTemp[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    OrderDto tmpOrder = new OrderDto();
                    //orderBox.add(list.get(index).getName());

                    Vector<String> rowData = new Vector<>();
                    //int qty = 0;
                    boolean flag = false;

                    tmpOrder.setMenu_name(list.get(index).getName());
                    tmpOrder.setPrice(list.get(index).getPrice());

                    for (int j = 0; j < orderBox.size(); j++) {
                        if (list.get(index).getName().equals(orderBox.get(j).getMenu_name())) {
                            //qty = orderBox.get(j).getQty()+1;
                            tmpOrder.setQty(orderBox.get(j).getQty()+1);
                            flag = true;
                            orderBox.remove(j);
                        }
                    }

                    if (flag == false) {
                        tmpOrder.setQty(1);
                    }

                    tmpOrder.setTotal(list.get(index).getPrice());
                    orderBox.add(tmpOrder);

//                    OrderDto tmpOrder = new OrderDto();
//                    //orderBox.add(list.get(index).getName());
//
//                    Vector<String> rowData = new Vector<>();
//                    int qty = 1;
//
//                    tmpOrder.setMenu_name(list.get(index).getName());
//                    tmpOrder.setPrice(list.get(index).getPrice());
//
//                    for (int j = 0; j < orderBox.size(); j++) {
//                        if (list.get(index).getName().equals(orderBox.get(j).getMenu_name())) {
//
//                        }
//                    }
//
//                    tmpOrder.setQty(1);
//                    tmpOrder.setTotal(list.get(index).getPrice());
//
//                    orderBox.add(tmpOrder);




                    tableModel.setRowCount(0);
                    //테이블에 데이터 추가하기
                    totalPrice = 0;
                    for (OrderDto dto : orderBox) {
                        Vector<String> data = new Vector<String>();

                        data.add(dto.getMenu_name());
                        data.add(String.valueOf(dto.getPrice()));
                        data.add(String.valueOf(dto.getQty()));
                        data.add(String.valueOf(dto.getQty()*dto.getPrice()));

                        //테이블 모델에 추가
                        tableModel.addRow(data);

                        totalPrice += (dto.getPrice()*dto.getQty());

                    }

                    lblTotal2.setText(currencyFormat.format(totalPrice));
                    //lblTotal2.setText(String.valueOf(totalPrice));



//                    rowData.add(list.get(index).getName()); // 상품명
//                    rowData.add(String.valueOf(list.get(index).getPrice())); // 단가 (예시로 1500원으로 설정)
//                    rowData.add("1"); // 수량 (예시로 1개로 설정)
//                    rowData.add(String.valueOf(list.get(index).getPrice())); // 금액 (단가 * 수량으로 계산)
//                    tableModel.addRow(rowData);
                }
            });


            //btnTemp[i].setPreferredSize(new Dimension(icon.getIconWidth() -50, icon.getIconHeight() -50));
            pnlTemp[i] = new JPanel(new BorderLayout());
            btnTemp[i].setPreferredSize(new Dimension(150, 40));

            lblName[i] = new JLabel(list.get(i).getName());
            lblName[i].setFont(new Font("", Font.BOLD, 20));
            lblName[i].setHorizontalAlignment(SwingConstants.CENTER);

            lblPrice[i] = new JLabel("￦ " + i + i + i + i);
            lblPrice[i] = new JLabel("￦ " + list.get(i).getPrice());
            lblPrice[i].setFont(new Font("", Font.BOLD, 12));
            lblPrice[i].setHorizontalAlignment(SwingConstants.RIGHT);

            pnlTemp[i].add("North", lblName[i]);
            pnlTemp[i].add("South", lblPrice[i]);
            pnlTemp[i].add("Center", btnTemp[i]);
            pnl4.add(pnlTemp[i]);

        }
        for (int i = list.size(); i < 8; i++) {
            btnTemp[i] = new JButton("" + i + i + i + i + i + i + i);


            //btnTemp[i].setPreferredSize(new Dimension(icon.getIconWidth() -50, icon.getIconHeight() -50));
            pnlTemp[i] = new JPanel(new BorderLayout());
            btnTemp[i].setPreferredSize(new Dimension(150, 40));

            lblName[i] = new JLabel("");
            lblName[i].setFont(new Font("", Font.BOLD, 20));
            lblName[i].setHorizontalAlignment(SwingConstants.CENTER);

            lblPrice[i] = new JLabel("");
            lblPrice[i].setFont(new Font("", Font.BOLD, 12));
            lblPrice[i].setHorizontalAlignment(SwingConstants.RIGHT);

            pnlTemp[i].add("North", lblName[i]);
            pnlTemp[i].add("South", lblPrice[i]);
            pnlTemp[i].add("Center", btnTemp[i]);
            pnl4.add(pnlTemp[i]);
            btnTemp[i].setVisible(false);

        }


        //btnTemp[0].setVisible(false);

        scrollPane = new JScrollPane(pnl4); // 스크롤팬 안에 메뉴판넬 삽입

        pnl2.add("North", pnl3); // 메뉴종류,메뉴 판넬에 메뉴버튼5개 판넬 삽입
        pnl2.add("Center", scrollPane); // 스크롤 메뉴판넬 삽입

        pnl5 = new JPanel(new BorderLayout()); //장바구니,결제금액,결제하기 전체 바탕 판넬
        this.add("South", pnl5);

        //table
        String[] title = {"상품명", "단가", "수량", "금액"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);

//        table.setBounds(new Rectangle(1000,400));
        orderPane = new JScrollPane(table);
        orderPane.setPreferredSize(new Dimension(950, 350));
        //orderPane.setBounds(10,10,500,270);
        pnl5.add("West", orderPane);


        tableModel.setRowCount(0);
        /*===================화면시작시 장바구니============================*/
        //테이블에 데이터 추가하기
        for (OrderDto dto : orderBox) {
            Vector<String> data = new Vector<String>();

            data.add(dto.getMenu_name());
            data.add(String.valueOf(dto.getPrice()));
            data.add(String.valueOf(dto.getQty()));
            data.add(String.valueOf(dto.getQty()*dto.getPrice()));
            //테이블 모델에 추가
            tableModel.addRow(data);
        }
//        totalPrice = 0;
//        for (OrderDto dto : orderBox) {
//            Vector<String> data = new Vector<String>();
//
//            data.add(dto.getMenu_name());
//            data.add(String.valueOf(dto.getPrice()));
//            data.add(String.valueOf(dto.getQty()));
//            data.add(String.valueOf(dto.getQty()*dto.getPrice()));
//
//            //테이블 모델에 추가
//            //tableModel.addRow(data);
//
//            totalPrice += (dto.getPrice()*dto.getQty());
//
//        }

        /*===============================================*/


        //테이블에 데이터 추가하기
        /*Vector<String> data = new Vector<String>();
        data.add("test1");
        data.add("4500");
        data.add("2");
        data.add("9000");
        tableModel.addRow(data);*/





        pnl9 = new JPanel(new GridLayout(2, 1));//총결제금액,결제하기 바탕 판넬
        pnl10 = new JPanel(new BorderLayout()); // 총결제 금액 판넬

        lblTotal1 = new JLabel("총 결제금액");
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


        btnBuy = new JButton("결제하기");
        btnBuy.setPreferredSize(new Dimension(340, 180));
        //pnl11 = new JPanel(); // 결제하기 판넬
        //pnl11.add(btnBuy);
        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReceiptTable(orderBox);

            }
        });


        pnl9.add(pnl10);
        pnl9.add(btnBuy);
        pnl5.add("East", pnl9);
    }






    public static void main(String[] args) {


        new KioskSub("커피");
    }
}
