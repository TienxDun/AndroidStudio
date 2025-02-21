package com.example.lab01.modun;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String maSV;
    private String tenSV;
    private String diaChiSV;
    private MonHoc monHoc;
    public SinhVien() {}
    public SinhVien(String maSV, String tenSV, String diaChi, MonHoc monHoc) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diaChiSV = diaChi;
        this.monHoc = monHoc;
    }

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

    public String getDiaChi() {
        return diaChiSV;
    }

    public void setDiaChi(String diaChi) {
        this.diaChiSV = diaChi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    @Override
    public String toString() {
        return getMaSV()+"\t\t"+getTenSV()+"\t\t"+getDiaChi();
    }
}
