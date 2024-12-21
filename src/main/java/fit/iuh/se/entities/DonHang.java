package fit.iuh.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DonHang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String maDonHang = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));;
    @NotEmpty(message = "Tên khách hàng không được để trống")
    @Size(min = 5, max = 50, message = "Nhập không quá 50 ký tự, ít nhất là 5 ký tự")
    private String tenKhachHang;
    @Email(message = "Phải đúng định dạng email")
    @NotEmpty(message = "Email không được bỏ trống")
    private String email;
    @Future(message = "Phải lớn hơn ngày hiện tại")
    private LocalDate ngayDatHang;
    @NotEmpty(message = "Tên sản phẩm không được để trống")
    private String tenSP;
    private boolean trangThai;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "maCuaHang")
    private CuaHang cuaHang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(LocalDate ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public CuaHang getCuaHang() {
        return cuaHang;
    }

    public void setCuaHang(CuaHang cuaHang) {
        this.cuaHang = cuaHang;
    }
}
