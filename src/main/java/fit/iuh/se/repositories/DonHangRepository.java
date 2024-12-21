package fit.iuh.se.repositories;

import fit.iuh.se.entities.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang,Integer> {

    @Query(value = "select * from don_hang where ma_don_hang like %:ma% and ma_cua_hang  in (select ma_cua_hang from cua_hang where ten like %:ten%)",nativeQuery = true)
    List<DonHang> findByMaDonHangAndTen(@Param("ma") String maDonHang,@Param("ten") String ten);
}
