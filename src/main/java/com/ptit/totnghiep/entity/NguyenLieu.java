package com.ptit.totnghiep.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="nguyenlieu")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="theloai")
    @NotNull
    private  String theloai;

    @Column(name="tenNL")
    @NotNull
    private  String tenNL;

    @Column(name="mota")
    private String mota;

    @OneToMany(mappedBy = "nguyenLieu",cascade = CascadeType.ALL)
    private List<NguyenLieuNhaCC> nguyenLieuNhaCCs;

    @OneToMany(mappedBy = "nguyenLieu",cascade = CascadeType.ALL)
    private List<HoaDonNguyenLieu> hoaDonNguyenLieus;

    public NguyenLieu(long id, String theloai, String tenNL, String mota) {
        this.id = id;
        this.theloai = theloai;
        this.tenNL = tenNL;
        this.mota = mota;
    }

    public NguyenLieu() {

    }

    public long getId() {
        return id;
    }

    public String getTheloai() {
        return theloai;
    }

    public String getTenNL() {
        return tenNL;
    }

    public String getMota() {
        return mota;
    }

    public List<NguyenLieuNhaCC> getNguyenLieuNhaCCs() {
        return nguyenLieuNhaCCs;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setNguyenLieuNhaCCs(List<NguyenLieuNhaCC> nguyenLieuNhaCCs) {
        this.nguyenLieuNhaCCs = nguyenLieuNhaCCs;
    }
}
