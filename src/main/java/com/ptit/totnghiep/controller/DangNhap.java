package com.ptit.totnghiep.controller;

import com.ptit.totnghiep.entity.NhanVien;
import com.ptit.totnghiep.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class DangNhap {
    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("/dangnhap")
    public String login(){
        return "GDDangNhap";
    }

    @GetMapping("/GDNhanVienKho")
    public String index(HttpSession session,ModelMap modelMap){
        String s=(String) session.getAttribute("Success");
        modelMap.addAttribute("s",s);
        session.removeAttribute("Success");
        return "NhanVienKho/GDNhanVienKho";
    }

    @PostMapping("/doDangNhap")
    public String doLogin(@ModelAttribute("tendangnhap") String tendangnhap, @ModelAttribute("matkhau") String matkhau,
                          ModelMap modelMap , HttpSession session){
        Optional<NhanVien> nhanVien=nhanVienService.findByTenDangNhap(tendangnhap);
        if(nhanVien.isPresent() && nhanVien.get().getMatkhau().equals(matkhau) && nhanVien.get().getVaitro().equals("NHANVIENKHO") ){
            session.setAttribute("TENDANGNHAPNVK",tendangnhap);
            return "redirect:/GDNhanVienKho";
        }else{
            modelMap.addAttribute("ERROR","Tên đăng nhập hoặc mật khẩu không chính xác");
            return "GDDangNhap";
        }
    }

    @GetMapping("/dangxuat")
    public String logout(HttpSession session){
        session.removeAttribute("TENDANGNHAPNVK");
        return "redirect:/dangnhap";
    }
}
