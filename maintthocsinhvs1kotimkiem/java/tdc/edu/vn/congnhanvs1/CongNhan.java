package tdc.edu.vn.congnhanvs1;

public class CongNhan {
    String ngayChamCong;
    String soSanPham;
    String loaiCongNhan;
    String loaiSanPham;

    public CongNhan(String ngayChamCong, String soSanPham, String loaiCongNhan, String loaiSanPham) {
        this.ngayChamCong = ngayChamCong;
        this.soSanPham = soSanPham;
        this.loaiCongNhan = loaiCongNhan;
        this.loaiSanPham = loaiSanPham;
    }

    public CongNhan() {
    }

    public String getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(String ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public String getSoSanPham() {
        return soSanPham;
    }

    public void setSoSanPham(String soSanPham) {
        this.soSanPham = soSanPham;
    }

    public String getLoaiCongNhan() {
        return loaiCongNhan;
    }

    public void setLoaiCongNhan(String loaiCongNhan) {
        this.loaiCongNhan = loaiCongNhan;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "ngayChamCong='" + ngayChamCong + '\'' +
                ", soSanPham='" + soSanPham + '\'' +
                ", loaiCongNhan='" + loaiCongNhan + '\'' +
                ", loaiSanPham='" + loaiSanPham + '\'' +
                '}';
    }
}
