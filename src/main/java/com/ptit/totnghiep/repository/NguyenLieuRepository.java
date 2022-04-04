package com.ptit.totnghiep.repository;

import com.ptit.totnghiep.entity.NguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NguyenLieuRepository extends JpaRepository<NguyenLieu, Long> {
    @Query ("select nl from NguyenLieu nl where nl.tenNL like :tennl")
    Optional<NguyenLieu> getNguyenLieuByName(String tennl);



    @Query("select NL from NguyenLieu NL " +
            "left join NguyenLieuNhaCC NLNCC on NL.id=NLNCC.nguyenLieu.id " +
            "where (NLNCC.nhaCungCap.id= :idNCC) and (NL.tenNL like %:tenNL%) ")
    List<NguyenLieu> getNguyenLieuByNhaCC( long idNCC, String tenNL);
}
