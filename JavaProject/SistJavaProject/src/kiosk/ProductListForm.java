package kiosk;




import com.sun.tools.javac.Main;
import day0131.ShopDto;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class ProductListForm extends JFrame {

    ProductDbModel dbModel = new ProductDbModel();

    //이미지 출력 위한 내부클래스

    ImageDraw draw = new ImageDraw();
    String imageName;
    String imageName2;

    JButton btnDelMenu;
    JButton btnGoHome;

    //JComboBox<String>


    //테이블
    DefaultTableModel tableModel;
    JTable table;
    Vector<ProductDto> list;


    public ProductListForm() {
        super("상품메뉴 조회");
        this.setBounds(349,0,1306,1047);
        initDesign();
        this.setVisible(true);

    }

    public void initDesign() {

        this.setLayout(null);

        list = dbModel.getAllMenus();

        JLabel lblTitle = new JLabel("상품메뉴 조회");
        lblTitle.setBounds(425,13,450,135);
        lblTitle.setFont(new Font("",Font.BOLD,50));
        this.add(lblTitle);

        JLabel lblSearch = new JLabel("                                               ");
        lblSearch.setBounds(44,210,350,130);
        lblSearch.setFont(new Font("", Font.BOLD, 25));
        TitledBorder border = new TitledBorder(new LineBorder(Color.black), "검색");
        border.setTitleFont(new Font("", Font.BOLD, 25));
        lblSearch.setBorder(border);
        this.add(lblSearch);

        //검색 "메뉴명" 라벨
        JLabel lblSearchMenu = new JLabel("메뉴명");
        lblSearchMenu.setBounds(58,259,100,50);
        lblSearchMenu.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
        this.add(lblSearchMenu);

        //검색 필드
        JTextField tfSearch = new JTextField();
        tfSearch.setBounds(115, 260, 150, 50);
        this.add(tfSearch);


        //검색 버튼
        JButton btnSearch = new JButton("검색");
        btnSearch.setBounds(277,264,100,40);
        this.add(btnSearch);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchName = tfSearch.getText();
                Vector<ProductDto> slist = dbModel.getSearchMenus(searchName);
                dataSearch(slist);
                tfSearch.setText("");


            }
        });

        //전체보기
        JButton btnReset = new JButton("전체메뉴 보기");
        btnReset.setBounds(52, 149, 150, 50);
        btnReset.setBorderPainted(false);
        btnReset.setFocusPainted(false);
        this.add(btnReset);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list = dbModel.getAllMenus();
                dataWrite();
            }
        });
        //처음으로
        btnGoHome = new JButton("처음으로");
        btnGoHome.setBounds(52, 50, 150, 50);
        btnGoHome.setBorderPainted(false);
        btnGoHome.setFocusPainted(false);
        this.add(btnGoHome);

        btnGoHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                setVisible(false);
            }
        });



        //table
        String[] title = {"상품번호", "종류", "메뉴명", "가격"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        JScrollPane js = new JScrollPane(table);
        table.setRowHeight(30);

        // 테이블 컬럼 모델 가져오기
        TableColumnModel columnModel = table.getColumnModel();

        // 각 컬럼의 크기 조절 (예제에서는 각 컬럼에 따로 설정)
        columnModel.getColumn(0).setPreferredWidth(30); // 상품번호 폭
        columnModel.getColumn(1).setPreferredWidth(40); // 종류
        columnModel.getColumn(2).setPreferredWidth(300); // 메뉴명 폭
        columnModel.getColumn(3).setPreferredWidth(100); // 가격 폭

        // 헤더에 대한 폰트 설정
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("", Font.BOLD, 18)); // 원하는 글자 크기 및 폰트 설정

        js.setBounds(433,201,792,755);
        this.add(js);

        //이미지
        draw.setBounds(49, 374, 340, 500);
        this.add(draw);


        //데이터 출력해주는 메서드
        this.dataWrite();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = table.getSelectedRow();
                Object value = table.getValueAt(row, 0);
                int num = Integer.parseInt(String.valueOf(value))-1;

                //list에서 row에 해당하는 dto를 꺼내서 거기에서 이미지명 얻는다
                //imageName = list.get(num).getImg();

                //imageName = list.get(row).getImg();

                //이미지 나오게 하는 메서드 호출
                //draw.repaint();

                int pnum = Integer.parseInt(String.valueOf(value));


                for (int i = 0; i < list.size(); i++) {

                    if (Integer.parseInt(list.get(i).getMenu_id()) == pnum) {
                        imageName2 = list.get(i).getImg();
                        break;
                    }
                }
                draw.repaint();

                //int col = table.getSelectedColumn();
                //System.out.println(row);
                //Object value = table.getValueAt(row, 0);
                //System.out.println("Clicked value: " + value);

            }
        });



    }



    //데이터 출력해주는 메서드
    public void dataWrite() {

        //테이블 기존 데이터 삭제
        tableModel.setRowCount(0);

        //테이블에 데이터 추가하기
        for (ProductDto dto : list) {
            Vector<String> data = new Vector<String>();

            data.add(dto.getMenu_id());
            data.add(dto.getMenu_type());
            data.add(dto.getName());
            data.add(String.valueOf(dto.getPrice()));

            //테이블 모델에 추가
            tableModel.addRow(data);

        }
    }

    //검색 결과 출력해주는 메서드
    public void dataSearch(Vector<ProductDto> searchList) {

        //테이블 기존 데이터 삭제
        tableModel.setRowCount(0);

        //테이블에 데이터 추가하기
        for (ProductDto dto : searchList) {
            Vector<String> data = new Vector<String>();

            data.add(dto.getMenu_id());
            data.add(dto.getMenu_type());
            data.add(dto.getName());
            data.add(String.valueOf(dto.getPrice()));

            //테이블 모델에 추가
            tableModel.addRow(data);

        }
        //
    }


    //내부클래스
    class ImageDraw extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            if (imageName2 != null) {
                Image image = new ImageIcon(imageName2).getImage();
                g.drawImage(image, 0, 0,272 , 400, this);
            }
        }
    }



    public static void main(String[] args) {

        new ProductListForm();

    }
}
