package ajaxboard.model;

import mysql.db.SqlDbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AjaxBoardDao {

    SqlDbConnect db = new SqlDbConnect();


    public void updateBoard(AjaxBoardDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update ajaxboard set writer=?,subject=?,content=?, avata=? where num=? ";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getContent());
            pstmt.setString(4, dto.getAvata());
            pstmt.setString(5, dto.getNum());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }

    }


    //insert
    public void insertBoard(AjaxBoardDto dto) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into ajaxboard values(null,?,?,?,?,now())";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getContent());
            pstmt.setString(4, dto.getAvata());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }

    }
    //print
    public List<AjaxBoardDto> getAllDatas() {

        List<AjaxBoardDto> list = new ArrayList<AjaxBoardDto>();

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from ajaxboard order by num desc";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                AjaxBoardDto dto = new AjaxBoardDto();

                dto.setNum(rs.getString("num"));
                dto.setWriter(rs.getString("writer"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setAvata(rs.getString("avata"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;
    }

    public AjaxBoardDto getData(String num) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from ajaxboard where num=?";

        AjaxBoardDto dto = new AjaxBoardDto();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs =  pstmt.executeQuery();

            while (rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setWriter(rs.getString("writer"));
                dto.setSubject(rs.getString("subject"));
                dto.setContent(rs.getString("content"));
                dto.setAvata(rs.getString("avata"));
                dto.setWriteday(rs.getTimestamp("writeday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return dto;
    }

    public AjaxBoardDto deleteBoard(String num) {

        AjaxBoardDto dto = getData(num);

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "delete from ajaxboard where num=?";



        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
        return dto;
    }

}
