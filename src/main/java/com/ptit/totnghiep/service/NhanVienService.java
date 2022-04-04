package com.ptit.totnghiep.service;

import com.ptit.totnghiep.entity.NhanVien;
import com.ptit.totnghiep.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    NhanVienRepository nhanVienRepository;

    public Optional<NhanVien> findByTenDangNhap(String tendangnhap){
        Optional<NhanVien> nhanVien=nhanVienRepository.findByTenDangNhap(tendangnhap);
        return nhanVien;
    }
}
