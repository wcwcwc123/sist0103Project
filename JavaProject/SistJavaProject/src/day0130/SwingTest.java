package day0130;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import day0118.SwingTextF_10;
import oracleDB.DbConnect;


public class SwingTest extends JFrame implements ActionListener{


    //db연결 모듈 선언
    DbConnect db = new DbConnect();
    Container cp; // 컨테이너 변수 생성

    //모델, 테이블, 버튼 변수 생성
    DefaultTableModel model;
    JTable table;
    JButton btnAdd,btnDel,btnUpdate;

    Object value; //행 객체

    //추가 버튼을 눌렀을때의 창(addForm 창) 변수 초기화
    AddStuInfo addForm = new AddStuInfo("성적추가");
    UpdateStuInfo updateForm = new UpdateStuInfo("성적 수정");


    //	 생성자
    public SwingTest(String title) {

        super(title);   //제목 지정
        cp = this.getContentPane();  //컨테이너 변수에 ContentPane담기
        this.setBounds(270,100,400,300); //위치,크기 지정
        cp.setBackground(new Color(255,255,200)); //배경 지정



        initDesingn();  // 디자인 함수 호출

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 완전종료
        this.setVisible(true); // visible True

    }
    public void tableWrite() {
//		테이블초기화
        model.setRowCount(0);

//		db연결
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from stuinfo order by num ";

        conn = db.getOracle();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Vector<String> data = new Vector<String>();

                data.add(rs.getString("num"));
                data.add(rs.getString("name"));
                data.add(rs.getString("ban"));
                data.add(rs.getString("java"));
                data.add(rs.getString("jsp"));
                data.add(rs.getString("spring"));
                data.add(rs.getString("total"));
                data.add(rs.getString("average"));

//				테이블에 추가
                model.addRow(data);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);

        }
    }
    public void insertData()
    {
        String name 	= addForm.tfName.getText();
        int java = Integer.parseInt(addForm.tfJava.getText());
        int jsp = Integer.parseInt(addForm.tfJsp.getText());
        int spring = Integer.parseInt(addForm.tfSpring.getText());
        String ban =(String)addForm.cbBan.getSelectedItem();

        int tot = java + jsp + spring;
        double avg =tot/3.0;

        String sql = "insert into stuinfo values (seq1.nextval,?,?,?,?,?,?,?)";

        //	db연결.sql문 전송
        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, java);
            pstmt.setInt(3, jsp);
            pstmt.setInt(4, spring);
            pstmt.setInt(5, tot);
            pstmt.setDouble(6, avg);
            pstmt.setString(7, ban);

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }

    }


    public void initDesingn()
    {
        String [] title  = {"번호","이름","반","Java","Jsp","Spring","총점","평균"}; //제목(컬럼) 배열 초기화

        model = new DefaultTableModel(title,0); // 모델 변수에 모델 담기
        table = new JTable(model);      // 테이블 변수에 테이블 담기
        this.add("Center",new JScrollPane(table));  //컨테이너에 스크롤형 테이블 가운데에 넣기


        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                //int col = table.getSelectedColumn();
                //System.out.println(row);
                value = table.getValueAt(row, 0);
                //System.out.println("Clicked value: " + value);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        updateForm.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData2(value.toString());
                System.out.println("updatedata2("+value.toString()+")");
                tableWrite();
                updateForm.setVisible(false);

            }
        });

//	테이블에 db데이터 출력
        tableWrite();

//	 버튼 3개 올릴 패널
        JPanel pTop = new JPanel();
        this.add("North",pTop);

//	추가버튼
        btnAdd = new JButton("추가");
        btnAdd.addActionListener(this);
        pTop.add(btnAdd);

//	추가폼에 있는 추가버튼에 액션 추가
        addForm.btnAdd.addActionListener(this);


        btnDel = new JButton("삭제");
        btnDel.addActionListener(this);
        pTop.add(btnDel);




        btnUpdate = new JButton("수정");
        btnUpdate.addActionListener(this);
        pTop.add(btnUpdate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object ob= e.getSource();

        if(ob==btnAdd)
        {
//		System.out.println("add");
            addForm.setVisible(true);

        } else if (ob==addForm.btnAdd) { //학생추가폼의 버튼이벤트
            //입력하는 데이터를 읽어서 db추가
            insertData();

            //테이블 다시 출력
            this.tableWrite();

            //초기화 하면서 추가폼은 사라지게
            addForm.tfName.setText("");
            addForm.tfJava.setText("");
            addForm.tfJsp.setText("");
            addForm.tfSpring.setText("");

            addForm.setVisible(false);


        } else if (ob==btnDel)
        {
            deleteData(value.toString());
            //String num = JOptionPane.showInputDialog("삭제할 시퀀스는?");

        }else if(ob==btnUpdate)
        {
            System.out.println("update");
            updateData(value.toString());
            updateForm.setVisible(true);

        } else if (ob == updateForm.btnUpdate) {
            updateData2(value.toString());
            System.out.println("updatedata2("+value.toString()+")");

            this.tableWrite();
            updateForm.setVisible(false);

        }

    }

    public void deleteData(String num) {
        String sql = "delete from stuinfo where num="+num;
        String sql2 = "select * from stuinfo where num=?";

        //sql문 실행후 해당번호 없으면 메세지 삭제되면 tableWrite()호출
        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        String delName = null;

        try {
            pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1,num);
            rs =  pstmt.executeQuery();

            while (rs.next()) {
                rs.getInt("num");
                delName =  rs.getString("name");
                rs.getInt("java");
                rs.getInt("jsp");
                rs.getInt("spring");
                rs.getInt("total");
                rs.getDouble("average");
                rs.getString("ban");

            }
            int b =JOptionPane.showConfirmDialog(this,num+"번 "+delName+ "님을 삭제하시겠습니까?");

            if (b == 0) {
                try {

                    //System.out.println(conn);
                    pstmt = conn.prepareStatement(sql);
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    db.dbClose(pstmt, conn);
                    this.tableWrite();
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //db.dbClose(rs,pstmt2,conn);
        }
    }

    public void updateData(String num) {

        String sql = "select * from stuinfo where num=?";


        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        String name = null;
        int java = 0;
        int jsp = 0;
        int spring = 0;
        String ban =null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                rs.getInt("num");
                name =  rs.getString("name");
                java =  rs.getInt("java");
                jsp = rs.getInt("jsp");
                spring =  rs.getInt("spring");
                rs.getInt("total");
                rs.getDouble("average");
                ban = rs.getString("ban");
            }

            updateForm.tfName.setText(name);
            updateForm.tfJava.setText(String.valueOf(java));
            updateForm.tfJsp.setText(String.valueOf(jsp));
            updateForm.tfSpring.setText(String.valueOf(spring));
            updateForm.cbBan.setSelectedItem(ban);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
    }
    public void updateData2(String num)
    {
        String name = updateForm.tfName.getText();
        int java = Integer.parseInt(updateForm.tfJava.getText());
        int jsp = Integer.parseInt(updateForm.tfJsp.getText());
        int spring = Integer.parseInt(updateForm.tfSpring.getText());
        String ban =(String)updateForm.cbBan.getSelectedItem();
        int tot = java + jsp + spring;
        double avg =tot/3.0;

        //String sql = "insert into stuinfo values (seq1.nextval,?,?,?,?,?,?,?)";
        String sql = "update stuinfo set name=?,java=?,jsp=?,spring=?,ban=?,total=?,average=? where num=?";


        //	db연결.sql문 전송
        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, java);
            pstmt.setInt(3, jsp);
            pstmt.setInt(4, spring);
            pstmt.setString(5, ban);
            pstmt.setInt(6, tot);
            pstmt.setDouble(7, avg);
            pstmt.setString(8, num);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }

    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

        new SwingTest("학생성적관리DB");
    }


}