package intro.model;

import mysql.db.SqlDbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IntroDao {

    SqlDbConnect db = new SqlDbConnect();

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


}
