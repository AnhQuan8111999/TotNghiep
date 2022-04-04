package com.ptit.totnghiep.repository;

import com.ptit.totnghiep.entity.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap , Long> {
    @Query ("select ncc from NhaCungCap ncc where ncc.tenNcc like %:tenncc%")
    List<NhaCungCap> findNhaCungCapByName (String tenncc);
}
