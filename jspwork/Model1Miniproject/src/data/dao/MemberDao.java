package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.MemberDto;
import mysql.db.DbConnect;
import org.mindrot.jbcrypt.BCrypt;
import oracle.jdbc.proxy.annotation.Pre;

public class MemberDao {

    DbConnect db=new DbConnect();

    //아이디 체크
    public int isIdCheck(String id)
    {
        int isid=0;

        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select count(*) from member where id=?";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs=pstmt.executeQuery();

            if(rs.next())
            {

                if(rs.getInt(1)==1)
                    isid=1;


            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }


        return isid;
    }
    //insert
    public void insertMember(MemberDto dto)
    {
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;


        String sql="insert into member values(null,?,?,?,?,?,?,now())";

        try {
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getId());
            pstmt.setString(3, hashPassword(dto.getPass()));
            pstmt.setString(4, dto.getHp());
            pstmt.setString(5, dto.getAddr());
            pstmt.setString(6, dto.getEmail());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
    }
    //아이디에 대한 이름반환
    public String getName(String id)
    {
        String name="";

        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from member where id=?";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs=pstmt.executeQuery();

            if(rs.next())
                name=rs.getString("name");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }


        return name;
    }

    public List<MemberDto> getAllMembers() {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<MemberDto> list = new ArrayList<MemberDto>();

        String sql = "select * from member ";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberDto dto = new MemberDto();

                dto.setNum(rs.getString("num"));
                dto.setName(rs.getString("name"));
                dto.setId(rs.getString("id"));
                dto.setHp(rs.getString("hp"));
                dto.setAddr(rs.getString("addr"));
                dto.setEmail(rs.getString("email"));
                dto.setGaipday(rs.getTimestamp("gaipday"));

                list.add(dto);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;
    }

    //삭제
    public int  deleteMember(String num) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        int delCount =0;

        String sql = "delete from member where num=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            delCount =  pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
        return delCount;
    }

    //일괄삭제
    public int  delteBatchMembers(String nums[]){


        int delCount =0;

        String sql = "delete from member where num=?";


        try(Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            for (String num : nums) {
                pstmt.setString(1, num);
                pstmt.addBatch();
            }
            int counts[] = pstmt.executeBatch();

            for (int count : counts) {
                if (count != PreparedStatement.EXECUTE_FAILED) {
                    delCount += count;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return delCount;
    }

    //비밀번호 체크
    public boolean isEqualPass(String num,String pass)
    {
        boolean b=false;

        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from member where num=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs=pstmt.executeQuery();

            if(rs.next()){
                String storedHashedPassword = rs.getString("pass");
                b = checkPassword(pass, storedHashedPassword);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }


        return b;
    }



    //로그인시  아이디와 비번체크
    public boolean isIdPass(String id,String pass)
    {
        boolean b=false;

        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from member where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs=pstmt.executeQuery();

            if(rs.next()){
                String storedHashedPassword = rs.getString("pass");
                b = checkPassword(pass, storedHashedPassword);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }


        return b;
    }



    // 비밀번호를 해싱하는 메소드
    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    //비밀번호 체크
    public static boolean checkPassword(String plainTextPassword, String storedHashedPassword) {
        return BCrypt.checkpw(plainTextPassword, storedHashedPassword);
    }





    public MemberDto getOneMember(String num) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        MemberDto dto = new MemberDto();

        String sql = "select * from member where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                dto.setName(rs.getString("name"));
                dto.setId(rs.getString("id"));
                dto.setHp(rs.getString("hp"));
                dto.setEmail(rs.getString("email"));
                dto.setAddr(rs.getString("addr"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return dto;
    }


    public void updateMember(MemberDto dto) {

        String sql = "update member set name=?, id=?, pass=?,hp=?,addr=?,email=? where num=?";



        try(Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getId());
            pstmt.setString(3, dto.getPass());
            pstmt.setString(4, dto.getHp());
            pstmt.setString(5, dto.getAddr());
            pstmt.setString(6, dto.getEmail());
            pstmt.setString(7, dto.getNum());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








//    public static void main(String[] args) {
//        MemberDao dao = new MemberDao();
//
//        for (int i = 0; i < 30; i++) {
//            MemberDto dto = new MemberDto();
//            dto.setName("아무개"+(i+1));
//            dto.setId("id"+(i+1));
//            dto.setPass("1234");
//            dto.setHp("010-11"+(i)+"1251");
//            dto.setAddr("서울시 강남구 " + (i + 1) + "길");
//            dto.setEmail("id"+(i+1)+"@naver.com");
//
//            dao.insertMember(dto);
//        }
//    }
}