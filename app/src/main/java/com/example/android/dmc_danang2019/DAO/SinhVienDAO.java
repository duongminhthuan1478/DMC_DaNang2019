package com.example.android.dmc_danang2019.DAO;

import com.example.android.dmc_danang2019.Database.ConnectionDB;
import com.example.android.dmc_danang2019.Model.SinhVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SinhVienDAO {
    Connection connection = null;
    ConnectionDB connectionDB = new ConnectionDB();

    public SinhVienDAO() {
        connection = connectionDB.CONN();
    }


    public SinhVien getListSinhVien(String email, int year, int month) {

        String sql = String.format(" select  sv.MaSV,sv.HoTen,sv.Email,HOADON.MaHD,ph.TenPhong,kn.MaKhuNha,kn.TenKhuNha,HOADON.NgayLapPhieu,HOADON.Thang,HOADON.ChiSoDienCu,HOADON.ChiSoDienMoi,((HOADON.ChiSoDienMoi-HOADON.ChiSoDienCu)*gdn.GiaNuoc) TienNuoc,(HOADON.ChiSoDienMoi-HOADON.ChiSoDienCu)*gdn.GiaDien as TienDien,MONTH(HOADON.Thang) as Thanglap,year(HOADON.Thang) as Namlap,\n" +
                "\t\t\t\t (gp.Gia+((HOADON.ChiSoDienMoi-HOADON.ChiSoDienCu)*gdn.GiaDien+(HOADON.ChiSoDienMoi-HOADON.ChiSoDienCu)*gdn.GiaNuoc)*ph.SoSinhVien)  as TongCong \n" +
                "\t\t\t\tfrom HOADON inner join  PHONG ph on HOADON.MaPhong=ph.MaPhong inner join KHUNHA kn on ph.MaKhuNha=kn.MaKhuNha inner join HOPDONG on HOPDONG.MaPhong=ph.MaPhong inner join SINHVIEN sv on HOPDONG.MaSV=sv.MaSV \n" +
                "\t\t\t\tinner join GIAPHONG gp on gp.MaGia=HOADON.MaGiaPhong inner join GiaDienNuoc gdn on HOADON.MaDienNuoc=gdn.MaDienNuoc\n" +
                "\t\t\t\t where sv.Email='" + email + "' and year(HOADON.Thang)='" + year + "' and MONTH(HOADON.Thang)='" + month + "'");
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SinhVien sinhVien = new SinhVien();
        try {

            while (rs.next()) {

                sinhVien.setMaSV(rs.getString("MaSV"));
                sinhVien.setTenSV(rs.getString("HoTen"));
                sinhVien.setEmail(rs.getString("Email"));
                sinhVien.setTenPhong(rs.getString("TenPhong"));
                sinhVien.setTenKhuNha(rs.getString("TenKhuNha"));
                sinhVien.setNgayLapPhieu(rs.getString("NgayLapPhieu"));
                sinhVien.setThang(rs.getString("Thang"));
                sinhVien.setChiSoDienCu(rs.getInt("ChiSoDienCu"));
                sinhVien.setChiSoDienMoi(rs.getInt("ChiSoDienMoi"));
                sinhVien.setTienDien(rs.getInt("TienDien"));
                sinhVien.setTienNuoc(rs.getInt("TienNuoc"));
                sinhVien.setTongCong(rs.getInt("TongCong"));
                sinhVien.setThangLap(rs.getInt("Thanglap"));
                sinhVien.setNamLap(rs.getInt("Namlap"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sinhVien;
    }


}
