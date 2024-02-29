package info.model;

import oracle.db.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class InfoDao {
    DbConnect db=new DbConnect();


    public void infoUpdate(InfoDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update info set name=?,addr=? where num=? ";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getAddr());
            pstmt.setString(3,dto.getNum());
            System.out.println(dto.getNum()+dto.getAddr()+dto.getNum());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }

    }

    public void infoInsert(InfoDto dto) {
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;

        String sql="insert into info values(seq_1.nextval, ?, ?, sysdate)";

        try {
            pstmt=conn.prepareStatement(sql);
            // ? 바인딩
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getAddr());

            // 업데이트
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 전체 데이터 조회
    public Vector<InfoDto> getAllDatas(){
        Vector<InfoDto> list=new Vector<InfoDto>();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from info order by num";

        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            // 여러 개의 데이터를 얻을 땐 while
            while(rs.next()) {
                InfoDto dto=new InfoDto();
                dto.setNum(rs.getString("num"));
                dto.setName(rs.getString("name"));
                dto.setAddr(rs.getString("addr"));
                dto.setSdate(rs.getTimestamp("sdate"));

                // 벡터에 추가
                list.add(dto);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return list;
    }

    // 삭제
    public void infoDelete(String num) {
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;

        String sql="delete from info where num=?";
        try {
            pstmt=conn.prepareStatement(sql);

            // 바인딩
            pstmt.setString(1, num);

            // 업데이트
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 수정버튼 누르면 하나의 데이터 조회
    public InfoDto getData(String num) {
        InfoDto dto=new InfoDto();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from info where num=?";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, num); // 바인딩
            rs=pstmt.executeQuery(); // 쿼리문 조회

            // 수정하려는 1개의 데이터 조회
            if(rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setName(rs.getString("name"));
                dto.setAddr(rs.getString("addr"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return dto;
    }

    public static void main(String[] args) {
        System.out.println("안녕");
    }

}
