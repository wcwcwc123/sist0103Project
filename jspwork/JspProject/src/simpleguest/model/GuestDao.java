package simpleguest.model;

import mysql.db.SqlDbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestDao {
    SqlDbConnect db = new SqlDbConnect();

    public void insertGuest(GuestDto dto) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into simpleguest values(null,?,?,?,?,now())";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,dto.getImage());
            pstmt.setString(2,dto.getNickname());
            pstmt.setString(3,dto.getPass());
            pstmt.setString(4,dto.getContent());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }
    }
    public ArrayList<GuestDto> getAllDatas() {

        ArrayList<GuestDto> list = new ArrayList<GuestDto>();

        SqlDbConnect db = new SqlDbConnect();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from simpleguest order by num desc";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                GuestDto dto =new GuestDto();

                dto.setNum(rs.getString("num"));
                dto.setImage(rs.getString("image"));
                dto.setNickname(rs.getString("nickname"));
                dto.setPass(rs.getString("pass"));
                dto.setContent(rs.getString("content"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
        }
        return list;

    }

    //num에 해당하는 dto반환
    public GuestDto getData(String num) {

        GuestDto dto = new GuestDto();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs =null;

        String sql = "select * from simpleguest where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setImage(rs.getString("image"));
                dto.setContent(rs.getString("content"));
                dto.setNickname(rs.getString("nickname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return dto;
    }

    //비밀번호가 맞으면 true 틀리면 false반환
    public boolean isEqualPass(String num,String pass) {

        boolean flag = false;

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from simpleguest where num=? and pass=?";


        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.setString(2, pass);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }

        return flag;

    }

    //데이터 수정
    public void updateGuest(GuestDto dto) {

        //수정(닉네임,컨텐츠,이미지).. 비번은 맞을경우에만 호출하므로 조건에 안써도됨

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update simpleguest set nickname=?,content=?,image=? where num=?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dto.getNickname());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getImage());
            pstmt.setString(4, dto.getNum());

            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }

    }

    public void deleteGuest(String num) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "delete from simpleguest where num=?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }

    }
}
