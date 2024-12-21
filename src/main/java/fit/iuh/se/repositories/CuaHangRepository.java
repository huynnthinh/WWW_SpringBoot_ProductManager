package fit.iuh.se.repositories;

import fit.iuh.se.entities.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang,Integer> {
}
