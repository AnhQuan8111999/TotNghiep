package com.ptit.totnghiep.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "nhanvien" )
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tendangnhap")
    private String tendangnhap;

    @Column(name = "matkhau")
    private String matkhau;

    @Column (name ="ngaysinh")
    private Date ngaysinh;

    @Column(name ="email")
    private String email;

    @Column (name ="sdt")
    private  String sdt;

    @Column(name="vaitro")
    private  String vaitro;

    @Column(name="ghichu")
    private  String ghichu;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hoten_id", referencedColumnName = "id")
    private  HoTen hoTen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diachi_id", referencedColumnName = "id")
    private  DiaChi diaChi;

    public NhanVien(long id, String tendangnhap, String matkhau, Date ngaysinh, String email, String sdt, String vaitro, String ghichu, HoTen hoTen, DiaChi diaChi) {
        this.id = id;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.sdt = sdt;
        this.vaitro = vaitro;
        this.ghichu = ghichu;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
    }

    public NhanVien() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public HoTen getHoTen() {
        return hoTen;
    }

    public void setHoTen(HoTen hoTen) {
        this.hoTen = hoTen;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }
}
