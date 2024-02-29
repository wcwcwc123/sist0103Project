package quiz.model;

import oracle.db.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class QuizDao {

    DbConnect db = new DbConnect();

    public void quizInsert(QuizDto dto) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into quizinfo values(quiz_seq.nextval,?,?,?,?,sysdate)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPhone());
            pstmt.setString(3, dto.getAge());
            pstmt.setString(4, dto.getHasDriver());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
    }
    public Vector<QuizDto> getAllDatas(){
        Vector<QuizDto> list = new Vector<QuizDto>();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from quizinfo";

        try {
            pstmt = conn.prepareStatement(sql);
            rs =pstmt.executeQuery();

            while (rs.next()) {
                QuizDto dto = new QuizDto();
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getString("age"));
                dto.setPhone(rs.getString("hp"));
                dto.setHasDriver(rs.getString("driver"));
                dto.setDate(rs.getTimestamp("writeday"));
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
