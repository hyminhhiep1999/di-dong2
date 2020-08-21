package tdc.edu.vn.myapplication.Model;

public class CongNhan {
    String maCN,tenCN,phanXuong;


    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public String getTenCN() {
        return tenCN;
    }

    public void setTenCN(String tenCN) {
        this.tenCN = tenCN;
    }

    public String getPhanXuong() {
        return phanXuong;
    }

    public void setPhanXuong(String phanXuong) {
        this.phanXuong = phanXuong;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maCN='" + maCN + '\'' +
                ", tenCN='" + tenCN + '\'' +
                ", phanXuong='" + phanXuong + '\'' +
                '}';
    }
}
