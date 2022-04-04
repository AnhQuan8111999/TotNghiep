package com.ptit.totnghiep.service;

import com.ptit.totnghiep.entity.HoaDonNguyenLieu;
import com.ptit.totnghiep.repository.HoaDonNguyenLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonNguyenLieuService {
    @Autowired
    HoaDonNguyenLieuRepository hoaDonNguyenLieuRepository;

    public void add(HoaDonNguyenLieu hoaDonNguyenLieu){
        hoaDonNguyenLieuRepository.save(hoaDonNguyenLieu);
    }
}
