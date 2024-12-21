package fit.iuh.se.services;

import fit.iuh.se.entities.DonHang;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonHangService {
    List<DonHang> getAllDonHangs();
    DonHang addDonHang(DonHang donHang);
    DonHang update(DonHang donHang);
    void deleteById(int id);
    List<DonHang> findByMaDonHangAndTen( String maDonHang, String ten);

    DonHang findById(int id);
}
