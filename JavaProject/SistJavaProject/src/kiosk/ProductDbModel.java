package kiosk;

import day0131.ShopDto;
import oracleDB.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProductDbModel {

    DbConnect db = new DbConnect();


    void insertProduct(ProductDto dto) {

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;

        String sql = "insert into menu values(seq_menu.nextval,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setString(1, dto.getMenu_type());
            pstmt.setString(2, dto.getName());
            pstmt.setString(3,dto.getImg());
            pstmt.setInt(4,dto.getPrice());
            //업데이트
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }

    }


    //전체조회
    public Vector<ProductDto> getAllMenus() {

        Vector<ProductDto> list = new Vector<ProductDto>();

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from menu order by menu_id";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                //db에서 하나의 레코드를 읽어서 dto에 넣는다
                ProductDto dto = new ProductDto();
                dto.setMenu_id(rs.getString("menu_id"));
                dto.setMenu_type(rs.getString("menu_type"));
                dto.setName(rs.getString("name"));
                dto.setImg(rs.getString("img"));
                dto.setPrice(rs.getInt("price"));

                //dto 추가
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
            return list;
        }
    }

    //검색
    public Vector<ProductDto> getSearchMenus(String searchName) {

        Vector<ProductDto> list = new Vector<ProductDto>();

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from menu where name like ? order by menu_id";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%%"+searchName+"%%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                //db에서 하나의 레코드를 읽어서 dto에 넣는다
                ProductDto dto = new ProductDto();
                dto.setMenu_id(rs.getString("menu_id"));
                dto.setMenu_type(rs.getString("menu_type"));
                dto.setName(rs.getString("name"));
                dto.setImg(rs.getString("img"));
                dto.setPrice(rs.getInt("price"));

                //dto 추가
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
            return list;
        }
    }

    //키오스크 메인
    public Vector<ProductDto> getKioskMenu(String type) {

        Vector<ProductDto> list = new Vector<ProductDto>();

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from menu where menu_type =? ";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, type);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                //db에서 하나의 레코드를 읽어서 dto에 넣는다
                ProductDto dto = new ProductDto();
                dto.setMenu_id(rs.getString("menu_id"));
                dto.setMenu_type(rs.getString("menu_type"));
                dto.setName(rs.getString("name"));
                dto.setImg(rs.getString("img"));
                dto.setPrice(rs.getInt("price"));

                //dto 추가
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
            return list;
        }
    }



}
