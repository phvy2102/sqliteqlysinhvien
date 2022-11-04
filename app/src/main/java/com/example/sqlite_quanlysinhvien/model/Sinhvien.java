package com.example.sqlite_quanlysinhvien.model;

import java.io.Serializable;

public class Sinhvien implements Serializable {
    private int masv112;
    private String hoten112;
    private int gioitinh112;
    private String dienthoai112, email112;

    public Sinhvien() {
    }

    public Sinhvien(int masv112, String hoten112, int gioitinh112, String dienthoai112, String email112) {
        this.masv112 = masv112;
        this.hoten112 = hoten112;
        this.gioitinh112 = gioitinh112;
        this.dienthoai112 = dienthoai112;
        this.email112 = email112;
    }

    public Sinhvien(String hoten112, int gioitinh112, String dienthoai112, String email112) {
        this.hoten112 = hoten112;
        this.gioitinh112 = gioitinh112;
        this.dienthoai112 = dienthoai112;
        this.email112 = email112;
    }

    public int getMasv112() {
        return masv112;
    }

    public void setMasv112(int masv112) {
        this.masv112 = masv112;
    }

    public String getHoten112() {
        return hoten112;
    }

    public void setHoten112(String hoten112) {
        this.hoten112 = hoten112;
    }

    public int getGioitinh112() {
        return gioitinh112;
    }

    public void setGioitinh112(int gioitinh112) {
        this.gioitinh112 = gioitinh112;
    }

    public String getDienthoai112() {
        return dienthoai112;
    }

    public void setDienthoai112(String dienthoai112) {
        this.dienthoai112 = dienthoai112;
    }

    public String getEmail112() {
        return email112;
    }

    public void setEmail112(String email115) {
        this.email112 = email112;
    }
}