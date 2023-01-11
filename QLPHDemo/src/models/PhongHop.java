/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ADMIN
 */
public class PhongHop {
    public String MaPhongHop;
    public String MaLoaiPhong;
    public boolean TinhTrang;

    public String getMaPhongHop() {
        return MaPhongHop;
    }

    public void setMaPhongHop(String MaPhongHop) {
        this.MaPhongHop = MaPhongHop;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    @Override
    public String toString() {
        return MaPhongHop+"-"+MaLoaiPhong+"-"+TinhTrang;
    }
    
    
}
