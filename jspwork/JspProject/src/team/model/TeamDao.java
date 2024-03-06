package team.model;

import mysql.db.SqlDbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeamDao {

    SqlDbConnect db = new SqlDbConnect();

    public void updateTeam(TeamDto dto) {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "update team set name=?,driver=?,addr=? where num=? ";
        System.out.println("sql: "+sql);

        try {
            System.out.println(dto.getNum()+dto.getDriver());
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2,dto.getDriver());
            pstmt.setString(3, dto.getAddr());
            pstmt.setString(4,dto.getNum());
            System.out.println(dto.getNum()+dto.getDriver()+dto.getAddr()+dto.getNum());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }

    }

    //insert
    public void insertTeam(TeamDto dto) {

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into team(name,driver,addr,writeday) values(?,?,?,now())";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2,dto.getDriver());
            pstmt.setString(3,dto.getAddr());

            pstmt.execute();
            System.out.println("save success");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }

    }

    //출력
    public ArrayList<TeamDto> getAllTeams() {
        ArrayList<TeamDto> list = new ArrayList<TeamDto>();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from team order by num";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                TeamDto dto = new TeamDto();

                dto.setNum(rs.getString("num"));
                dto.setName(rs.getString("name"));
                dto.setDriver(rs.getString("driver"));
                dto.setAddr(rs.getString("addr"));
                dto.setWriteday(rs.getTimestamp("writeday"));

                //list에 추가
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
        return list;
    }

    // 삭제
    public void deleteTeam(String num) {
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;

        String sql="delete from team where num=?";
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
    public TeamDto getOndeData(String num) {
        TeamDto dto=new TeamDto();
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from team where num=?";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, num); // 바인딩
            rs=pstmt.executeQuery(); // 쿼리문 조회

            // 수정하려는 1개의 데이터 조회
            if(rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setName(rs.getString("name"));
                dto.setDriver(rs.getString("driver"));
                dto.setAddr(rs.getString("addr"));
                dto.setWriteday(rs.getTimestamp("writeday"));

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
