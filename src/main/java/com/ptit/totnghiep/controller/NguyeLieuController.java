package com.ptit.totnghiep.controller;

import com.ptit.totnghiep.entity.HoaDonNguyenLieu;
import com.ptit.totnghiep.entity.NguyenLieu;
import com.ptit.totnghiep.entity.NguyenLieuNhaCC;
import com.ptit.totnghiep.entity.NhaCungCap;
import com.ptit.totnghiep.service.NguyenLieuNhaCCService;
import com.ptit.totnghiep.service.NguyenLieuService;
import com.ptit.totnghiep.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Nvk")
public class NguyeLieuController {
    @Autowired
    NguyenLieuService nguyenLieuService;

    @Autowired
    NhaCungCapService nhaCungCapService;

    @Autowired
    NguyenLieuNhaCCService nguyenLieuNhaCCService;


    @GetMapping("/timnguyenlieu")
    public String timNguyenLieu(HttpSession session, @ModelAttribute("id") long idNCC, ModelMap modelMap){
        Object obj=session.getAttribute("hDNLS");
        List<HoaDonNguyenLieu> hdnl=(List<HoaDonNguyenLieu>) obj;
        modelMap.addAttribute("hdnl",hdnl);


        session.setAttribute("idNCC",idNCC);
        return "NhanVienKho/GDTimNguyenLieu";
    }


    @PostMapping("/dotimnguyenlieu")
    public String doTimNguyenLieu(HttpSession session,
                                  //@ModelAttribute("id") long idNCC,
                                  @ModelAttribute("tennguyenlieu") String tenNguyenLieu,
                                  ModelMap modelMap){
        if(tenNguyenLieu.equals("")){
            modelMap.addAttribute("ERROR1","Không được để trống ô nhập");
            return "NhanVienKho/GDTimNguyenLieu";
        }else{
            long idNCC=(long)session.getAttribute("idNCC");
            List<NguyenLieu> nguyenLieus=nguyenLieuService.getNguyenLieuByIdNhaCC(idNCC,tenNguyenLieu);
            modelMap.addAttribute("nguyenLieus",nguyenLieus);

            return "NhanVienKho/GDChonNguyenLieu";
        }
    }



    @GetMapping("/Themnguyenlieu")
    public String themNguyenLieu(ModelMap modelMap){

        NguyenLieu nl= new NguyenLieu();
        modelMap.addAttribute("nl",nl);
        return "/NhanVienKho/GDThemNguyenLieu";
    }

    @PostMapping("/doThemnguyenlieu")
    public String doThemNguyenLieu(HttpSession session, ModelMap modelMap, @ModelAttribute(name="nl")NguyenLieu nl){

        nguyenLieuService.themNguyenLieu(nl);
        Optional<NguyenLieu> nguyenLieu=nguyenLieuService.getNguyeLieuByName(nl.getTenNL());


        long idNCC=(long)session.getAttribute("idNCC");
        Optional<NhaCungCap> ncc =nhaCungCapService.getNhaCungCapByid(idNCC);


        NguyenLieuNhaCC nlncc=new NguyenLieuNhaCC();
        nlncc.setNhaCungCap(ncc.get());
        nlncc.setNguyenLieu(nguyenLieu.get());
        nguyenLieuNhaCCService.themNguyenLieeuNhaCC(nlncc);

        return "redirect:/Nvk/timnguyenlieu?id=" + idNCC;
    }


    @GetMapping("/Nhapsoluongdongia")
    public String nhapSoLuongDonGia(HttpSession session, @ModelAttribute("idNL") long idNL,ModelMap modelMap){
        Optional<NguyenLieu> nguyenLieu=nguyenLieuService.getNguyenLieuById(idNL);
        modelMap.addAttribute("nguyenLieu",nguyenLieu);

        return "NhanVienKho/GDNhapSoLuongDonGia";
    }


    @PostMapping("/doNhapsoluongdongia")
    public String doNhapsoluongdongia(HttpSession session,ModelMap modelMap, @ModelAttribute("idNL") long idNL,
                                      @ModelAttribute("soluong" )  long soLuong ,@ModelAttribute("dongia") Double donGia){


            long idNCC =(long)session.getAttribute("idNCC");

            Optional<NguyenLieu> nguyenLieu=nguyenLieuService.getNguyenLieuById(idNL);

            Object obj=session.getAttribute("hDNLS");
            System.out.println(session.getAttribute("hDNLS"));
            if(obj==null){
                List<HoaDonNguyenLieu> hDNLS=new ArrayList<>();

                HoaDonNguyenLieu hoaDonNguyenLieu=new HoaDonNguyenLieu();
                hoaDonNguyenLieu.setNguyenLieu(nguyenLieu.get());
                hoaDonNguyenLieu.setSoluong(soLuong);
                hoaDonNguyenLieu.setDongia(donGia);
                Double thanhtien1=soLuong*donGia;
                hoaDonNguyenLieu.setThanhtien(thanhtien1);
                hDNLS.add(hoaDonNguyenLieu);
                session.setAttribute("hDNLS",hDNLS);

            }else{
                List<HoaDonNguyenLieu> hDNLS=(List<HoaDonNguyenLieu>) obj;

                HoaDonNguyenLieu hoaDonNguyenLieu=new HoaDonNguyenLieu();
                hoaDonNguyenLieu.setNguyenLieu(nguyenLieu.get());
                hoaDonNguyenLieu.setSoluong(soLuong);
                hoaDonNguyenLieu.setDongia(donGia);
                Double thanhtien1=soLuong*donGia;
                hoaDonNguyenLieu.setThanhtien(thanhtien1);
                hDNLS.add(hoaDonNguyenLieu);
                session.setAttribute("hDNLS",hDNLS);
            }
            return "redirect:/Nvk/timnguyenlieu?id=" + idNCC;
    }
}
