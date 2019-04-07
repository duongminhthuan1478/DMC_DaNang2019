package com.example.android.dmc_danang2019.DAO;

import com.example.android.dmc_danang2019.Database.ConnectionDB;
import com.example.android.dmc_danang2019.Model.ThongBao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ThongBaoDAO {
    Connection connection=null;
    ConnectionDB connectionDB = new ConnectionDB();
    public ThongBaoDAO(){
        connection = connectionDB.CONN();
    }


    public ThongBao getListThongBao(String email) {

        String sql=	String.format("SELECT TOP 1* from QuanLyThongBao \n" +
                "where Email='"+email+"'\n" +
                "order by id_TB DESC");
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ThongBao  thongBao=new  ThongBao();
        try {

            while(rs.next()){
                thongBao.setId(rs.getInt("id_TB"));
                thongBao.setNam(rs.getInt("Nam"));
                thongBao.setThang(rs.getInt("Thang"));
                thongBao.setTienDien(rs.getInt("TienDien"));
                thongBao.setTienNuoc(rs.getInt("TienNuoc"));
                thongBao.setTongCong(rs.getInt("TongCong"));
                thongBao.setEmail(rs.getString("Email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongBao;
    }


}
