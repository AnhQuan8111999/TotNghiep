package com.ptit.totnghiep.repository;

import com.ptit.totnghiep.entity.NguyenLieuNhaCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguyenLieuNhaCCRepository extends JpaRepository<NguyenLieuNhaCC,Long> {
}
