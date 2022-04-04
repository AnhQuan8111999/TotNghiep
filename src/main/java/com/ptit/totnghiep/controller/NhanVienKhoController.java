package com.ptit.totnghiep.controller;

import com.ptit.totnghiep.entity.NguyenLieu;
import com.ptit.totnghiep.entity.NguyenLieuNhaCC;
import com.ptit.totnghiep.entity.NhaCungCap;
import com.ptit.totnghiep.service.NguyenLieuNhaCCService;
import com.ptit.totnghiep.service.NguyenLieuService;
import com.ptit.totnghiep.service.NhaCungCapService;
import com.ptit.totnghiep.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/Nvk")
public class NhanVienKhoController {
    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    NhaCungCapService nhaCungCapService;

    @Autowired
    NguyenLieuService nguyenLieuService;

    @Autowired
    NguyenLieuNhaCCService nguyenLieuNhaCCService;

    @GetMapping("/timnhacungcap")
    public String timNhaCungCap(){
        return "NhanVienKho/GDTimNhaCungCap";
    }

    @PostMapping("/doTimNhaCungCap")
    public String doTimNhaCungCap(@ModelAttribute("tennhacungcap") String tennhacc, ModelMap modelMap){
        if(tennhacc.equals("")){


            modelMap.addAttribute("ERROR1","Không được để trống ô nhập");
            return "NhanVienKho/GDTimNhaCungCap";
        }
        else{
            List<NhaCungCap> nccs=nhaCungCapService.findByTenNcc(tennhacc);
            modelMap.addAttribute("nccs",nccs);
            return"NhanVienKho/GDChonNhaCungCap";
        }

    }

    @GetMapping("/Themnhacungcap")
    public String themNhaCungCap(ModelMap modelMap){

        NhaCungCap ncc=new NhaCungCap();
        modelMap.addAttribute("ncc",ncc);
        return "/NhanVienKho/GDThemNhaCungCap";
    }

    @PostMapping("/doThemnhacungcap")
    public String doThemNhaCungCap(ModelMap modelMap, @ModelAttribute(name="ncc") NhaCungCap ncc){
        boolean check=nhaCungCapService.themNhaCungCap(ncc);
        if(check== true){
            return "redirect:/Nvk/timnhacungcap";
        }else{
            modelMap.addAttribute("ERROR1","Không được để trống ô nhập");
            return "/NhanVienKho/GDThemNhaCungCap";
        }
    }
}
