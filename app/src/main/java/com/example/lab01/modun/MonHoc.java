package com.example.lab01.modun;

import java.util.ArrayList;

public class MonHoc {
    private String tenMonHoc;
    private ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
    public ArrayList<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }
    public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }
    public MonHoc() {}
    public MonHoc(String tenMocHoc) {
        this.tenMonHoc = tenMocHoc;
    }
    public String getTenMonHoc() {
        return tenMonHoc;
    }
    public void setTenMocHoc(String tenMocHoc) {
        this.tenMonHoc = tenMocHoc;
    }
    @Override
    public String toString() {
        return getTenMonHoc();
    }
}
