package kiosk;




import day0131.ShopDto;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
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

    JButton btnDelMenu;

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
        lblSearchMenu.setFont(new Font("",Font.ITALIC,15));
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


            }
        });

        //전체보기
        JButton btnReset = new JButton("전체메뉴 보기");
        btnReset.setBounds(52, 149, 150, 50);
        this.add(btnReset);

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list = dbModel.getAllMenus();
                dataWrite();
            }
        });

        btnDelMenu = new JButton("삭제");
        btnDelMenu.setBounds(220, 149, 100, 50);

        btnDelMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        //table
        String[] title = {"상품번호", "종류", "메뉴명", "가격"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        JScrollPane js = new JScrollPane(table);

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
                imageName = list.get(num).getImg();

                //imageName = list.get(row).getImg();

                //이미지 나오게 하는 메서드 호출
                draw.repaint();


                //int col = table.getSelectedColumn();
                System.out.println(row);
                //Object value = table.getValueAt(row, 0);
                System.out.println("Clicked value: " + value);
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

            if (imageName != null) {
                Image image = new ImageIcon(imageName).getImage();
                g.drawImage(image, 0, 0,272 , 400, this);
            }
        }
    }



    public static void main(String[] args) {

        new ProductListForm();

    }
}
