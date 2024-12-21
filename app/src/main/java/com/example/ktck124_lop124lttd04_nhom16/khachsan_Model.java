package com.example.ktck124_lop124lttd04_nhom16;

import java.math.BigDecimal;

public class khachsan_Model {
    private int makhachsan;
    private  int madiadiemks;
    private  String mota;
    private String tenkhachsan;
    private String hinhanh;
    private BigDecimal gia;

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getMadiadiemks() {
        return madiadiemks;
    }

    public void setMadiadiemks(int madiadiemks) {
        this.madiadiemks = madiadiemks;
    }

    public int getMakhachsan() {
        return makhachsan;
    }

    public void setMakhachsan(int makhachsan) {
        this.makhachsan = makhachsan;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTenkhachsan() {
        return tenkhachsan;
    }

    public void setTenkhachsan(String tenkhachsan) {
        this.tenkhachsan = tenkhachsan;
    }
}
