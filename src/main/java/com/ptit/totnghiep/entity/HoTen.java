package com.ptit.totnghiep.entity;

import javax.persistence.*;

@Entity
@Table(name="hoten")
public class HoTen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "ho")
    private  String ho;

    @Column(name= "dem")
    private  String dem;

    @Column(name= "ten")
    private  String ten;

    public HoTen(long id, String ho, String dem, String ten) {
        this.id = id;
        this.ho = ho;
        this.dem = dem;
        this.ten = ten;
    }

    public HoTen() {

    }

    public long getId() {
        return id;
    }

    public String getHo() {
        return ho;
    }

    public String getDem() {
        return dem;
    }

    public String getTen() {
        return ten;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setDem(String dem) {
        this.dem = dem;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
