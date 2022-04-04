package com.ptit.totnghiep.service;

import com.ptit.totnghiep.entity.NguyenLieu;
import com.ptit.totnghiep.repository.NguyenLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguyenLieuService {

    @Autowired
    NguyenLieuRepository nguyenLieuRepository;

    public void themNguyenLieu(NguyenLieu nl){
        nguyenLieuRepository.save(nl);
    }

    public  Optional<NguyenLieu> getNguyeLieuByName(String tenNl){
       Optional<NguyenLieu> nl=nguyenLieuRepository.getNguyenLieuByName(tenNl);
       return nl;
    }

    public List<NguyenLieu> getNguyenLieuByIdNhaCC(long idNCC, String tenNguyenLieu){
        List<NguyenLieu> nguyenLieus=nguyenLieuRepository.getNguyenLieuByNhaCC(idNCC,tenNguyenLieu);
        return nguyenLieus;
    }

    public Optional<NguyenLieu> getNguyenLieuById(long idNL){
        Optional<NguyenLieu> nguyenLieu=nguyenLieuRepository.findById(idNL);
        return nguyenLieu;
    }
}
