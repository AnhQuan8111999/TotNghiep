package com.ptit.totnghiep.entity;

import javax.persistence.*;

@Entity
@Table(name="NguyenLieu_NhaCC")
public class NguyenLieuNhaCC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="nguyenlieu_id")
    private NguyenLieu nguyenLieu;

    @ManyToOne
    @JoinColumn(name="nhacungcap_id")
    private NhaCungCap nhaCungCap;

    public NguyenLieuNhaCC(long id, NguyenLieu nguyenLieu, NhaCungCap nhaCungCap) {
        this.id = id;
        this.nguyenLieu = nguyenLieu;
        this.nhaCungCap = nhaCungCap;
    }

    public NguyenLieuNhaCC() {

    }

    public long getId() {
        return id;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}
