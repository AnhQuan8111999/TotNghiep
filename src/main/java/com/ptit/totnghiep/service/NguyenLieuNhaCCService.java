package com.ptit.totnghiep.service;

import com.ptit.totnghiep.entity.NguyenLieuNhaCC;
import com.ptit.totnghiep.repository.NguyenLieuNhaCCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguyenLieuNhaCCService {
    @Autowired
    NguyenLieuNhaCCRepository nguyenLieuNhaCCRepository;

    public void themNguyenLieeuNhaCC(NguyenLieuNhaCC nlncc){
        nguyenLieuNhaCCRepository.save(nlncc);
    }
}
