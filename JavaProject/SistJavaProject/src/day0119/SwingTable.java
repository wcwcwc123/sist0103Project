package day0119;

import day0118.SwingTextF_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingTable extends JFrame {

    Container cp;

    JTable table;
    JLabel lblTitle, lblOut;


    public void initDesign() {

        String[][] data={
                {"송혜교","서울","010-1111-2222"},
                {"전지현","인천","010-2222-3333"},
                {"이효리","부산","010-3333-4444"},
        };
        String[] title = {"이름", "주소", "연락처"};

        lblTitle = new JLabel("JTable연습", JLabel.CENTER);
        lblOut = new JLabel("결과출력하는곳", JLabel.CENTER);

        table = new JTable(data, title);
        JScrollPane pane = new JScrollPane(table);

        //테이블에 마우스 이벤트 추가
        table.addMouseListener(new TableEvent());


        this.add("North", lblTitle);
        this.add("Center", pane);
        this.add("South", lblOut);

    }

    class TableEvent extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            //System.out.println("ggg");

            //선택한 행번호 얻기
            int rowNum = table.getSelectedRow();
            //JOptionPane.showMessageDialog(SwingTable.this,"행번호:"+rowNum);
            String str = "이름: " + table.getValueAt(rowNum, 0) +
                    ", 주소: " + table.getValueAt(rowNum, 1) +
                    ", 핸드폰: " + table.getValueAt(rowNum, 2);

            lblOut.setText(str);
        }
    }


    public SwingTable(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 300, 300);
        cp.setBackground(new Color(255, 204, 204));


        initDesign();
        this.setVisible(true);

    }


    public static void main(String[] args) {
        new SwingTable("swing table");


    }
}
