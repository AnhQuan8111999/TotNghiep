package com.ptit.totnghiep.service;

import com.ptit.totnghiep.entity.HoaDonNhapHang;
import com.ptit.totnghiep.repository.HoaDonNhapHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class HoaDonNhapHangService {

    @Autowired
    HoaDonNhapHangRepository hoaDonNhapHangRepository;

    public void add(HoaDonNhapHang hdnh){
        hoaDonNhapHangRepository.save(hdnh);
    }

    public Optional<HoaDonNhapHang> getHDNH(Date time){
        Optional<HoaDonNhapHang> hdnh=hoaDonNhapHangRepository.getHDNH(time);
        return hdnh;

    }
}
