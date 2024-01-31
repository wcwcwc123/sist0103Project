package day0131;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

//시퀀스   상품명     수량      단가      총금액     출력
//테이블에서 상품명을 클릭하면 우측에 이미지 나오게 Canvas내부클래스 구현
public class ShopListForm extends JFrame {


    ShopDbModel dbModel = new ShopDbModel();

    //이미지 출력 위한 내부클래스(image draw)선언
    ImageDraw draw = new ImageDraw();
    String imageName;

    //테이블
    DefaultTableModel tableModel;
    JTable table;
    Vector<ShopDto> list;


    public ShopListForm() {
        super("상품 조회폼");
        this.setBounds(600, 0, 900, 900);
        initDesign();
        this.setVisible(true);

    }

    void initDesign() {
        this.setLayout(null);

        //db로부터 목록부터 얻기
        list = dbModel.getAllSangpums();

        //table
        String[] title = {"No.", "상품명", "수량", "단가", "총금액", "구입일"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(10,10,500,270);
        this.add(js);

        //이미지
        draw.setBounds(520, 10, 400, 270);
        this.add(draw);


        //데이터 출력해주는 메서드
        this.dataWrite();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = table.getSelectedRow();

                //list에서 row에 해당하는 dto를 꺼내서 거기에서 이미지명 얻는다
                imageName = list.get(row).getPhoto();

                //이미지 나오게 하는 메서드 호출
                draw.repaint();


                int col = table.getSelectedColumn();
                System.out.println(row);
                Object value = table.getValueAt(row, 0);
                System.out.println("Clicked value: " + value);
            }
        });



        //출력된 데이터에 이벤트..익명내부클래스

    }
    //데이터 출력해주는 메서드
    public void dataWrite() {

        //테이블 기존 데이터 삭제
        tableModel.setRowCount(0);

        //테이블에 데이터 추가하기
        for (ShopDto dto : list) {
            Vector<String> data = new Vector<String>();

            data.add(dto.getNum());
            data.add(dto.getSangpum());
            data.add(String.valueOf(dto.getSu()));
            data.add(String.valueOf(dto.getDan()));
            data.add(String.valueOf(dto.getSu() * dto.getDan()));
            data.add(String.valueOf(dto.getGuipday()));

            //테이블 모델에 추가
            tableModel.addRow(data);

        }
    }

    //내부클래스
    class ImageDraw extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            if (imageName != null) {
                Image image = new ImageIcon(imageName).getImage();
                g.drawImage(image, 0, 0,250 , 156, this);
            }
        }
    }

    public static void main(String[] args) {

        new ShopListForm();
    }
}
