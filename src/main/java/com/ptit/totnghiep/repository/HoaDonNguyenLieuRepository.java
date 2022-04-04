package com.ptit.totnghiep.repository;

import com.ptit.totnghiep.entity.HoaDonNguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonNguyenLieuRepository extends JpaRepository<HoaDonNguyenLieu,Long> {
}
