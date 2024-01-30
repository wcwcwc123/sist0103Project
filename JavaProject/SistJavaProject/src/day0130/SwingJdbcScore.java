package day0130;

import oracleDB.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class SwingJdbcScore {

    //DbConnect db = new DbConnect();
    Container cp;

    DefaultTableModel model;
    JTable table;

    JButton btnAdd,btnDel,btnUpdate;






    //생성장
    /*public SwingJdbcScore(String title) {

        super(title);
        cp = this.getContentPane();
        this.setBounds(300, 100, 400, 300);
        cp.setBackground(new Color(255, 255, 200));


        this.initDesign();
        //this.tableWrite();
        this.setVisible(true);
    }*/

    //디자인
    /*public void initDesign() {
        String[] title = {"번호", "이름", "반", "Java", "Jsp", "Spring", "총점", "평균"};

        model = new DefaultTableModel(title,0);
        table = new JTable(model);
        this.add("Center", new JScrollPane(table));

        //테이블에 db데이터 출력
        model.setRowCount(0); // ==> 테이블행 하나도 없다 (0행)

        // db 연결
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null; // ResultSet: 조회/출력에서만 사용, db를 테이블형태로 가지고 오는것

        String sql="select * from stuinfo0130 order by num";
        System.out.println("test1");

        conn=db.getOracle();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("try");
            System.out.println(rs.next());

            while(rs.next()) {
                Vector<String> data=new Vector<String>(); // 벡터: 배열은 고정형이므로 벡터/arraylist 같은 컬렉션 객체를 통해 데이터를 무한대로 추가 가능
                // 데이터화, 벡터에 꾸러미로 묶음
                System.out.println("while");
                data.add(rs.getString("num"));
                data.add(rs.getString("name"));
                data.add(rs.getString("ban"));
                data.add(rs.getString("java"));
                data.add(rs.getString("jsp"));
                data.add(rs.getString("spring"));
                data.add(rs.getString("total"));
                data.add(rs.getString("average"));

                System.out.println("test");
                // 테이블에 추가
                model.addRow(data);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("오류");
        } finally {
            db.dbClose(rs, pstmt, conn);
        }


        
        

        //버튼 3개 올릴 패널
        JPanel pBottom = new JPanel();
        this.add("South", pBottom);

        //추가버튼
        btnAdd = new JButton("추가");
        pBottom.add(btnAdd);
        btnAdd.addActionListener(this);

        btnDel = new JButton("삭제");
        btnDel.addActionListener(this);
        pBottom.add(btnDel);

        btnUpdate = new JButton("수정");
        btnUpdate.addActionListener(this);
        pBottom.add(btnUpdate);
    }*/

    //테이블에 출력하는 메소드
    /*public void tableWrite() {

        //테이블초기화
        model.setRowCount(0);

        //db연결
        Connection conn =db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from stuinfo order by num";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Vector<String> data = new Vector<String>();

                data.add(rs.getString("num"));
                data.add(rs.getString("name"));
                data.add(rs.getString("ban"));
                data.add(rs.getString("java"));
                data.add(rs.getString("jsp"));
                data.add(rs.getString("spring"));
                data.add(rs.getString("total"));
                data.add(rs.getString("average"));

                System.out.println("test");
                System.out.println(data);

                //테이블에 추가
                model.addRow(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
    }
*/

    /*public void tableWrite() {
        // 테이블 초기화
        model.setRowCount(0); // ==> 테이블행 하나도 없다 (0행)

        // db 연결
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null; // ResultSet: 조회/출력에서만 사용, db를 테이블형태로 가지고 오는것

        String sql="select * from stuinfo0130 order by num";

        conn=db.getOracle();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                Vector<String> data=new Vector<String>(); // 벡터: 배열은 고정형이므로 벡터/arraylist 같은 컬렉션 객체를 통해 데이터를 무한대로 추가 가능
                // 데이터화, 벡터에 꾸러미로 묶음
                data.add(rs.getString("num"));
                data.add(rs.getString("name"));
                data.add(rs.getString("ban"));
                data.add(rs.getString("java"));
                data.add(rs.getString("jsp"));
                data.add(rs.getString("spring"));
                data.add(rs.getString("total"));
                data.add(rs.getString("average"));

                System.out.println("test");
                // 테이블에 추가
                model.addRow(data);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("오류");
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
    }*/


    public static void main(String[] args) {

        DbConnect db = new DbConnect();
        Connection conn = db.getOracle();

        PreparedStatement pstmt = null;
        ResultSet rs = null;


        String sql = "select * from stutest";
        try {
            pstmt = conn.prepareStatement(sql);
            rs =  pstmt.executeQuery();

            System.out.println(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //new SwingJdbcScore("학생성적관리DB");

    }

    /*@Override
    public void actionPerformed(ActionEvent e) {

        Object ob = e.getSource();

        if (ob == btnAdd) {
            System.out.println("add");
        } else if (ob == btnDel) {
            System.out.println("del");
        } else if (ob == btnUpdate) {
            System.out.println("update");
        }

    }*/
}
