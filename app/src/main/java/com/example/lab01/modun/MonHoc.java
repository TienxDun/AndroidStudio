package com.example.lab01.modun;

public class MonHoc {
    private String tenMocHoc;
    public MonHoc() {}

    public MonHoc(String tenMocHoc) {
        this.tenMocHoc = tenMocHoc;
    }

    public String getTenMocHoc() {
        return tenMocHoc;
    }

    public void setTenMocHoc(String tenMocHoc) {
        this.tenMocHoc = tenMocHoc;
    }

    @Override
    public String toString() {
        return getTenMocHoc();
    }
}
