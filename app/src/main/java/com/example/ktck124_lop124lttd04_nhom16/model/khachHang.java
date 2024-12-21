package com.example.ktck124_lop124lttd04_nhom16.model;

public class khachHang {
    private int makh;
    private String tenkhachhang;
    private int gioitinh;
    private String diachi;
    private String email;

    public khachHang(int makh, String tenkhachhang, int gioitinh, String diachi, String email) {
        this.makh = makh;
        this.tenkhachhang = tenkhachhang;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.email = email;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
