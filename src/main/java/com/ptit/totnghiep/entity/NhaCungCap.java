package com.ptit.totnghiep.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="nhacungcap")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="tenNcc")
    @NotNull
    private String tenNcc;

    @Column(name="sdt")
    @NotNull
    private  String sdt;

    @Column(name="mota")
    private  String mota;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diachi_id", referencedColumnName = "id")
    private  DiaChi diaChi;

    @OneToMany(mappedBy = "nhaCungCap",cascade = CascadeType.ALL)
    private List<NguyenLieuNhaCC> nguyenLieuNhaCCs;

    public NhaCungCap(long id, String tenNcc, String sdt, String mota, DiaChi diaChi) {
        this.id = id;
        this.tenNcc = tenNcc;
        this.sdt = sdt;
        this.mota = mota;
        this.diaChi = diaChi;
    }

    public NhaCungCap() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenNcc() {
        return tenNcc;
    }

    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }
}
