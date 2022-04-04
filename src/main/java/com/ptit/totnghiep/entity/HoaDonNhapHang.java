package com.ptit.totnghiep.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="hoadonnhaphang")
public class HoaDonNhapHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nhacungcap")
    private  String nhacungcap;

    @Column(name="thoigian")
    private Date thoigian ;

    @Column(name ="mota")
    private String mota;

    @OneToMany(mappedBy = "hoaDonNhapHang",cascade = CascadeType.ALL)
    private List<HoaDonNguyenLieu> hoaDonNguyenLieus;

    public HoaDonNhapHang(long id, String nhacungcap, Date thoigian, String mota) {
        this.id = id;
        this.nhacungcap = nhacungcap;
        this.thoigian = thoigian;
        this.mota = mota;
    }

    public HoaDonNhapHang() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }
}
