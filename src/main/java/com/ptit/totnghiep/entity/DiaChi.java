package com.ptit.totnghiep.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name= "diachi")
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="sonha")
    @NotNull
    private String sonha;

    @Column(name="xaphuong")
    @NotNull
    private String xaphuong;

    @Column (name="quanhuyen")
    @NotNull
    private String quanhuyen;

    @Column (name="thanhpho")
    @NotNull
    private String thanhpho;

    public DiaChi(long id, String sonha, String xaphuong, String quanhuyen, String thanhpho) {
        this.id = id;
        this.sonha = sonha;
        this.xaphuong = xaphuong;
        this.quanhuyen = quanhuyen;
        this.thanhpho = thanhpho;
    }

    public DiaChi() {

    }

    public long getId() {
        return id;
    }

    public String getSonha() {
        return sonha;
    }

    public String getXaphuong() {
        return xaphuong;
    }

    public String getQuanhuyen() {
        return quanhuyen;
    }

    public String getThanhpho() {
        return thanhpho;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSonha(String sonha) {
        this.sonha = sonha;
    }

    public void setXaphuong(String xaphuong) {
        this.xaphuong = xaphuong;
    }

    public void setQuanhuyen(String quanhuyen) {
        this.quanhuyen = quanhuyen;
    }

    public void setThanhpho(String thanhpho) {
        this.thanhpho = thanhpho;
    }
}
