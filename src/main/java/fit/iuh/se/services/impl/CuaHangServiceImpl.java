package fit.iuh.se.services.impl;

import fit.iuh.se.entities.CuaHang;
import fit.iuh.se.repositories.CuaHangRepository;
import fit.iuh.se.services.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangServiceImpl  implements CuaHangService {
    private CuaHangRepository cuaHangRepository;

    @Autowired
    public CuaHangServiceImpl(CuaHangRepository cuaHangRepository) {
        this.cuaHangRepository = cuaHangRepository;
    }

    @Override
    public List<CuaHang> findAll() {
        return cuaHangRepository.findAll();
    }
}
