package day0119;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class JTable_05 extends JFrame {

    Container cp;
    JTable tb1,tb2,tb3;
    TextArea area;

    public JTable_05(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 300, 300);
        cp.setBackground(new Color(255, 204, 204));

        initDesign();
        this.setVisible(true);

    }

    public void initDesign() {
        //2행2열의 grid레이아웃
        this.setLayout(new GridLayout(2, 2, 5, 5));

        //1번째 tb 행,열만 지정
        tb1 = new JTable(5, 4);
        this.add(new JScrollPane(tb1));

        //2 tb 생성할때 데이터 넣기
        String[] title1 = {"이름", "나이", "주소"};
        String[][] data1 = {
                {"김모씨", "22", "경기"},
                {"덱모씨", "26", "서울"},
                {"최모씨", "30", "대구"},
        };

        tb2 = new JTable(data1, title1);
        this.add(new JScrollPane(tb2)); //JScrollPane에 넣어서 추가해야 제목이랑 스크롤바가 나타남

        //3
        DefaultTableModel model1 = new DefaultTableModel(data1, title1);
        tb3 = new JTable(model1);
        this.add(new JScrollPane(tb3));

        //추가기능?
        String[] addData1 = {"현무", "44", "서울시"};
        model1.addRow(addData1);

        //이벤엔 벡터 생성후 추가
        Vector<String> addData2  = new Vector<String>();
        addData2.add("유재석");
        addData2.add("33");
        addData2.add("제주");
        model1.addRow(addData2);

        //area
        area = new TextArea();
        this.add(new JScrollPane(area));

        //JTable과 model 메서드 확인
        int rowCount = tb3.getRowCount();
        area.append("tb3의 행갯수: " + rowCount+"\n");

        int rowCount2 = model1.getRowCount();
        area.append("tb3의 행갯수: " + rowCount2+"\n");

        int columnCount = tb3.getColumnCount();
        area.append("tb3의 열갯수: " + rowCount2+"\n");

        area.append("1행 1열의 값: " + tb3.getValueAt(1, 1) + "\n");
        area.append("3행 2열의 값: " + tb3.getValueAt(3, 2) + "\n");

        //tb3에 마우스클릭 이벤트를 추가해서 area에 출력
        tb3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //클릭한 행번호 얻기
                int row = tb3.getSelectedRow();

                //클릭한 열번호 얻기
                int col = tb3.getSelectedColumn();

                //해당 행,열에 있는 데이터를 얻어서 area에 출력
                area.append(row + "," + col + "==>" + tb3.getValueAt(row, col) + "\n");

            }
        });



    }

    public static void main(String[] args) {
        new JTable_05("swing table5");
    }
}
