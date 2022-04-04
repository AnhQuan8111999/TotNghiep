package com.ptit.totnghiep.entity;

import javax.persistence.*;

@Entity
@Table
public class HoaDonNguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="soluong")
    private long soluong;

    @Column(name="donggia")
    private Double dongia;

    @Column(name="thanhtien")
    private Double thanhtien;

    @ManyToOne
    @JoinColumn(name="nguyenlieu_id")
    private NguyenLieu nguyenLieu;

    @ManyToOne
    @JoinColumn(name="hoaDonNhapHang_id")
    private HoaDonNhapHang hoaDonNhapHang;

    public HoaDonNguyenLieu(long id, long soluong, Double dongia, Double thanhtien, NguyenLieu nguyenLieu, HoaDonNhapHang hoaDonNhapHang) {
        this.id = id;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.nguyenLieu = nguyenLieu;
        this.hoaDonNhapHang = hoaDonNhapHang;
    }

    public HoaDonNguyenLieu() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSoluong() {
        return soluong;
    }

    public void setSoluong(long soluong) {
        this.soluong = soluong;
    }

    public Double getDongia() {
        return dongia;
    }

    public void setDongia(Double dongia) {
        this.dongia = dongia;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public HoaDonNhapHang getHoaDonNhapHang() {
        return hoaDonNhapHang;
    }

    public void setHoaDonNhapHang(HoaDonNhapHang hoaDonNhapHang) {
        this.hoaDonNhapHang = hoaDonNhapHang;
    }

    public Double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Double thanhtien) {
        this.thanhtien = thanhtien;
    }
}
