package com.ptit.totnghiep.controller;

import com.ptit.totnghiep.entity.HoaDonNguyenLieu;
import com.ptit.totnghiep.entity.HoaDonNhapHang;
import com.ptit.totnghiep.entity.NhaCungCap;
import com.ptit.totnghiep.service.HoaDonNguyenLieuService;
import com.ptit.totnghiep.service.HoaDonNhapHangService;
import com.ptit.totnghiep.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/Nvk")
public class HoaDonController {
    @Autowired
    HoaDonNguyenLieuService hoaDonNguyenLieuService;

    @Autowired
    HoaDonNhapHangService hoaDonNhapHangService;

    @Autowired
    NhaCungCapService nhaCungCapService;

    @GetMapping("/Hoadonnhaphang")
    public String hoaDon(HttpSession session, ModelMap modelMap){
        Object obj=session.getAttribute("hDNLS");
        List<HoaDonNguyenLieu> hdnls=(List<HoaDonNguyenLieu>) obj;


        Double tongtien=0D;
        for(HoaDonNguyenLieu hdnl: hdnls){
            tongtien+=hdnl.getThanhtien();
        }
        System.out.println(tongtien);

        long idNCC =(long) session.getAttribute("idNCC");
        Optional<NhaCungCap> ncc = nhaCungCapService.getNhaCungCapByid(idNCC);

        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String datenow = current.format(formatter);

        System.out.println(datenow);

        modelMap.addAttribute("datenow",datenow);
        modelMap.addAttribute("hdnls",hdnls);
        //modelMap.addAttribute("hdnh",hdnh);
        modelMap.addAttribute("ncc",ncc);
        modelMap.addAttribute("tongtien",tongtien);

        return "NhanVienKho/GDHoaDon";
    }

    @GetMapping("/InHoaDon")
    public String inHoaDon(HttpSession session,ModelMap modelMap){
        long idNCC=(long)session.getAttribute("idNCC");
        Optional<NhaCungCap> ncc=nhaCungCapService.getNhaCungCapByid(idNCC);
        Object obj=session.getAttribute("hDNLS");
        List<HoaDonNguyenLieu> hdnls=(List<HoaDonNguyenLieu>) obj;
        HoaDonNhapHang hdnh=new HoaDonNhapHang();
        hdnh.setNhacungcap(ncc.get().getTenNcc());
        Date time=new Date();
        hdnh.setThoigian(time);
        hoaDonNhapHangService.add(hdnh);

        Optional<HoaDonNhapHang > hdnh1=hoaDonNhapHangService.getHDNH(time);
        for(HoaDonNguyenLieu hdnl: hdnls){
            hdnl.setHoaDonNhapHang(hdnh1.get());
            hoaDonNguyenLieuService.add(hdnl);
        }

        session.removeAttribute("hDNLS");
        session.removeAttribute("idNCC");

        session.setAttribute("Success","In hoá đơn thành công");
        return "redirect:/GDNhanVienKho";
    }
}
