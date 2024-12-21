package fit.iuh.se.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CuaHang")
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maCuaHang;
    private String ten;

    @OneToMany(mappedBy = "cuaHang",cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private Set<DonHang> donHangs;

    public int getMaCuaHang() {
        return maCuaHang;
    }

    public void setMaCuaHang(int maCuaHang) {
        this.maCuaHang = maCuaHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<DonHang> getDonHangs() {
        return donHangs;
    }

    public void setDonHangs(Set<DonHang> donHangs) {
        this.donHangs = donHangs;
    }
}
