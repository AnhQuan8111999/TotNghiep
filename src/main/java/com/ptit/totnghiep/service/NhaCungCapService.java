package com.ptit.totnghiep.service;


import com.ptit.totnghiep.entity.NhaCungCap;
import com.ptit.totnghiep.repository.NhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapService {
    @Autowired
    NhaCungCapRepository nhaCungCapRepository;

    public  List<NhaCungCap> findByTenNcc(String tenNcc){
        List<NhaCungCap> nccs=nhaCungCapRepository.findNhaCungCapByName(tenNcc);
        return  nccs;
    }

    public Optional<NhaCungCap> getNhaCungCapByid(long id){
        Optional<NhaCungCap> ncc= nhaCungCapRepository.findById(id);
        return ncc;
    }

    public boolean themNhaCungCap(NhaCungCap ncc){
        nhaCungCapRepository.save(ncc);
        return true;
    }

}
