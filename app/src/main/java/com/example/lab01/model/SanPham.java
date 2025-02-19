package com.example.lab01.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int hinh;
    private String tenSP;
    private String moTa;
    private int giaSP;

    public SanPham() {
    }
    public SanPham(int hinh, String tenSP, String moTa, int giaSP) {
        this.hinh = hinh;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.giaSP = giaSP;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }
}
