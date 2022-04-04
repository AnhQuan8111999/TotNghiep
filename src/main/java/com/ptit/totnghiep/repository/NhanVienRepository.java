package com.ptit.totnghiep.repository;

import com.ptit.totnghiep.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Long> {

    @Query("select u from NhanVien u where u.tendangnhap= :tendangnhap")
    Optional<NhanVien> findByTenDangNhap(String tendangnhap);
}
