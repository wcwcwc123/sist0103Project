package day0126;

import oracleDB.DbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SawonGroup {

    DbConnect db = new DbConnect();

    public void connectSawonGroup() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "select gender,count(buseo) count,to_char(round(avg(pay),0),'L999,999,999') avgpay" +
                ",to_char(max(pay),'L999,999,999') maxpay,to_char(min(pay),'L999,999,999') minpay " +
                "from sawon group by gender";

        conn=db.getOracle();
        if (conn != null) {
            System.out.println("오라클 계정 연결 성공");
        }

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("\t***회사 남녀별 급여통계***");
            System.out.println();
            System.out.println("성별\t인원수\t평균급여\t최고급여\t최저급여");
            System.out.println("-------------------------------------------");


            while (rs.next()) {
                String gender = rs.getString("gender");
                int count = rs.getInt("count");
                String avgpay = rs.getString("avgpay");
                String maxpay = rs.getString("maxpay");
                String minpay = rs.getString("minpay");

                System.out.println(gender+"\t"+count+"\t"+avgpay+"\t"+maxpay+"\t"+minpay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,stmt,conn);
        }

    }

    public void personGroup() {
        //job별 인원수와 평균나이 구해주세요

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        int maxLength=0;

        String sql="select job,count(*) count,round(avg(age),1) avgAge " +
                "from person " +
                "group by job";

        try {
            conn = db.getOracle();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("직업      \t인원수\t평균나이");
            System.out.println("----------------------------");

            while (rs.next()) {
                String job = rs.getString("job");
                int count = rs.getInt("count");
                double avgAge = rs.getDouble("avgAge");

                for (int i = job.length(); i <= 6; i++) {
                    job+=" ";
                }
                System.out.println(job+"\t"+" "+count+"명\t"+avgAge+"세");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,stmt,conn);
        }


    }

    public static void main(String[] args) {
        SawonGroup sg = new SawonGroup();
        //sg.connectSawonGroup();
        sg.personGroup();

    }
}
