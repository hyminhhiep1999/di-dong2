package tdc.edu.vn.denamngoaidd1;

import java.util.Arrays;

public class Persion {
    String hovaten,tuoi,gioitinh;
    String arrSothich;

    public Persion(String hovaten, String tuoi, String gioitinh, String arrSothich) {
        this.hovaten = hovaten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.arrSothich = arrSothich;
    }

    public Persion() {
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }


    public String getArrSothich() {
        return arrSothich;
    }

    public void setArrSothich(String arrSothich) {
        this.arrSothich = arrSothich;
    }


}
