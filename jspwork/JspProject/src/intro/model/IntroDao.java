package intro.model;

import mysql.db.SqlDbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IntroDao {

    SqlDbConnect db = new SqlDbConnect();

    public void delteIntro(String num) {
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;

        String sql="delete from intro where num=?";
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


    public void updateIntro(IntroDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update intro set name=?,age=?,photo=?, birthday=?, hometown=?, hobby=?, memo=? where num=? ";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getAge());
            pstmt.setString(3, dto.getPhoto());
            pstmt.setString(4, dto.getBirthday());
            pstmt.setString(5, dto.getHometown());
            pstmt.setString(6, dto.getHobby());
            pstmt.setString(7, dto.getMemo());
            pstmt.setString(8, dto.getNum());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }

    }

    public void insertIntro(IntroDto dto) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into intro(name,age,photo,birthday,hometown,hobby,memo) values(?,?,?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getAge());
            pstmt.setString(3, dto.getPhoto());
            pstmt.setString(4, dto.getBirthday());
            pstmt.setString(5, dto.getHometown());
            pstmt.setString(6, dto.getHobby());
            pstmt.setString(7, dto.getMemo());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }
    }

    public ArrayList<IntroDto> getAllIntros() {

        ArrayList<IntroDto> list = new ArrayList<IntroDto>();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from intro order by num";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                IntroDto dto = new IntroDto();

                dto.setNum(rs.getString("num"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getString("age"));
                dto.setPhoto(rs.getString("photo"));
                dto.setBirthday(rs.getString("birthday"));
                dto.setHometown(rs.getString("hometown"));
                dto.setHobby(rs.getString("hobby"));
                dto.setMemo(rs.getString("memo"));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;
    }
    // 수정버튼 누르면 하나의 데이터 조회
    public IntroDto getOneData(String num) {
        IntroDto dto=new IntroDto();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from intro where num=?";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, num); // 바인딩
            rs=pstmt.executeQuery(); // 쿼리문 조회

            // 수정하려는 1개의 데이터 조회
            if(rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getString("age"));
                dto.setPhoto(rs.getString("photo"));
                dto.setBirthday(rs.getString("birthday"));
                dto.setHometown(rs.getString("hometown"));
                dto.setHobby(rs.getString("hobby"));
                dto.setMemo(rs.getString("memo"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return dto;
    }


}
