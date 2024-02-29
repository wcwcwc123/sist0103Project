package infoModel;

import oracleDB.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InfoDao {

    DbConnect db = new DbConnect();

    public void infoInsert(InfoDto dto) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into info values(seq_1.nextval,?,?,sysdate)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,dto.getName());
            pstmt.setString(2,dto.getAddr());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }
    }
    public static void main(String[] args) {
        InfoDao tt = new InfoDao();
        InfoDto dto = new InfoDto();
        dto.setName("1239");
        dto.setAddr("addrtest");
        tt.infoInsert(dto);

    }
}
