package com.example.android.dmc_danang2019.Model;

import com.example.android.dmc_danang2019.common.NumberFormatCommon;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private String Email;
    private String tenPhong;
    private String tenKhuNha;
    private String ngayLapPhieu;
    private String thang;
    private int thangLap;
    private int namLap;
    private int chiSoDienCu;
    private int chiSoDienMoi;
    private int tienNuoc;
    private int tienDien;
    private int TongCong;
    private String reNumberTong;
    private String reNumberTienDien;
    private String reNumberTienNuoc;

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenKhuNha() {
        return tenKhuNha;
    }

    public void setTenKhuNha(String tenKhuNha) {
        this.tenKhuNha = tenKhuNha;
    }

    public String getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(String ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public int getChiSoDienCu() {
        return chiSoDienCu;
    }

    public void setChiSoDienCu(int chiSoDienCu) {
        this.chiSoDienCu = chiSoDienCu;
    }

    public int getChiSoDienMoi() {
        return chiSoDienMoi;
    }

    public void setChiSoDienMoi(int chiSoDienMoi) {
        this.chiSoDienMoi = chiSoDienMoi;
    }

    public int getTienNuoc() {
        return tienNuoc;
    }

    public void setTienNuoc(int tienNuoc) {
        this.tienNuoc = tienNuoc;
    }

    public int getTienDien() {
        return tienDien;
    }

    public void setTienDien(int tienDien) {
        this.tienDien = tienDien;
    }

    public int getTongCong() {
        return TongCong;
    }

    public void setTongCong(int tongCong) {
        TongCong = tongCong;
    }

    public String getReNumberTong() {
        return NumberFormatCommon.reNumberInt(TongCong);
    }

    public void setReNumberTong(String reNumberTong) {
        this.reNumberTong = reNumberTong;
    }

    public String getReNumberTienDien() {
        return NumberFormatCommon.reNumberInt(tienDien);
    }

    public void setReNumberTienDien(String reNumberTienDien) {
        this.reNumberTienDien = reNumberTienDien;
    }

    public String getReNumberTienNuoc() {
        return NumberFormatCommon.reNumberInt(tienNuoc);
    }

    public void setReNumberTienNuoc(String reNumberTienNuoc) {
        this.reNumberTienNuoc = reNumberTienNuoc;
    }

    public int getThangLap() {
        return thangLap;
    }

    public void setThangLap(int thangLap) {
        this.thangLap = thangLap;
    }

    public int getNamLap() {
        return namLap;
    }

    public void setNamLap(int namLap) {
        this.namLap = namLap;
    }
}