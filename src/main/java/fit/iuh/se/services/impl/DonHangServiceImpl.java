package fit.iuh.se.services.impl;

import fit.iuh.se.entities.DonHang;
import fit.iuh.se.repositories.DonHangRepository;
import fit.iuh.se.services.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DonHangServiceImpl implements DonHangService {
    private DonHangRepository donHangRepository;
    @Autowired
    public DonHangServiceImpl(DonHangRepository donHangRepository) {
        this.donHangRepository = donHangRepository;
    }


    @Override
    public List<DonHang> getAllDonHangs() {
        return donHangRepository.findAll();
    }

    @Transactional
    @Override
    public DonHang addDonHang(DonHang donHang) {
        return donHangRepository.save(donHang);
    }
    @Transactional
    @Override
    public DonHang update(DonHang donHang) {
        return findById(donHang.getId()) != null ? donHangRepository.save(donHang):null;
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        donHangRepository.deleteById(id);
    }

    @Override
    public List<DonHang> findByMaDonHangAndTen(String maDonHang, String ten) {
        return donHangRepository.findByMaDonHangAndTen(maDonHang, ten);
    }

    @Override
    public DonHang findById(int id) {
        return donHangRepository.findById(id).get();
    }
}
