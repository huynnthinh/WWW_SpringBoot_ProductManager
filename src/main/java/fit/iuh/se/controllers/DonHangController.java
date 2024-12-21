package fit.iuh.se.controllers;

import fit.iuh.se.entities.DonHang;
import fit.iuh.se.repositories.CuaHangRepository;
import fit.iuh.se.services.CuaHangService;
import fit.iuh.se.services.DonHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class DonHangController {
    private DonHangService donHangService;
    private CuaHangService cuaHangService;
    private final CuaHangRepository cuaHangRepository;

    @Autowired
    public DonHangController(DonHangService donHangService,CuaHangService cuaHangService,
                             CuaHangRepository cuaHangRepository) {
        this.donHangService = donHangService;
        this.cuaHangService = cuaHangService;
        this.cuaHangRepository = cuaHangRepository;
    }

    @GetMapping("")
    private String listDonHangs(Model model){
        model.addAttribute("donHangs",donHangService.getAllDonHangs());
        System.out.println(donHangService.getAllDonHangs()); // Log the list for debugging
        return "lists";
    }
    @PostMapping("/search")
    private String search(@RequestParam(name="ma")String ma,@RequestParam(name = "ten")String ten,Model model) {
        System.out.println(ma + ten);
        model.addAttribute("donHangs",donHangService.findByMaDonHangAndTen("%"+ma+"%","%"+ten+"%"));
        return "lists";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable("id") int id){
        donHangService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/them")
    private String formThem(Model model){
        DonHang donHang = new DonHang();

        donHang.setTrangThai(true);
        model.addAttribute("donhang",donHang);
        model.addAttribute("cuahangs",cuaHangService.findAll());
        return "them";
    }

    @PostMapping("/them")
    private String them(@Valid @ModelAttribute("donhang") DonHang donHang, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("cuahangs",cuaHangService.findAll());
            return "them";
        }
        donHang.setMaDonHang(generateCode());
        donHangService.addDonHang(donHang);
        return "redirect:/";
    }
    private String generateCode(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return now.format(formatter);
    }
    @GetMapping("/update/{id}")
    private String formSua(@PathVariable("id")int id, Model model){
        DonHang donHang =  donHangService.findById(id);
        System.out.println(donHang.getNgayDatHang());
        donHang.setId(id);
        model.addAttribute("cuahangs",cuaHangService.findAll());
        model.addAttribute("donhang",donHang);
        return "sua";
    }

    @PostMapping("/update/{id}")
    private String update(Model model,@PathVariable("id")int id,@Valid @ModelAttribute("donhang") DonHang donHang,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("cuahangs",cuaHangService.findAll());
            return "sua";
        }
        donHangService.update(donHang);
        return "redirect:/";
    }


}
