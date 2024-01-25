package day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;


public class QuizJdbcFoodOrder {


    static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String user = "c##stud";
    static final String password = "a1234";

    public void foodOrder() {
        Connection conn =null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql="select j.order_num,f.fno,j.order_name,f.food_name,f.price,f.shop_loc,j.order_addr " +
                "from jumun j, foodshop f " +
                "where j.fno = f.fno";


        try {
            //connection 연결
            conn = DriverManager.getConnection(URL, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            Locale locale = new Locale("ko", "KR");
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);


            System.out.println("주문번호\t\t음식번호\t\t주문자\t\t음식명\t\t가격\t\t상호명\t\t상점위치\t\t주문자위치");
            System.out.println("--------------------------------------------------------------------");
            while (rs.next()) {
                int orderNum = rs.getInt("order_num");
                int fno = rs.getInt("fno");
                String orderName = rs.getString("order_name");
                String foodName = rs.getString("food_name");
                int price = rs.getInt("price");
                String shopLoc = rs.getString("shop_loc");
                String orderAddr = rs.getString("order_addr");

                System.out.println(orderNum+"\t\t"+fno+"\t\t"+orderName+"\t\t"+foodName+"\t\t"+currencyFormat.format(price)+"\t\t"+shopLoc+"\t\t"+orderAddr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql 연결 실패");
        }

    }


    public static void main(String[] args) {
        QuizJdbcFoodOrder fo = new QuizJdbcFoodOrder();
        fo.foodOrder();

    }
}
