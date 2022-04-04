package com.ptit.totnghiep.repository;

import com.ptit.totnghiep.entity.HoaDonNhapHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface HoaDonNhapHangRepository  extends JpaRepository<HoaDonNhapHang,Long> {
    @Query ("select hdnh from  HoaDonNhapHang hdnh where hdnh.thoigian = :time")
    Optional<HoaDonNhapHang> getHDNH(Date time);
}
