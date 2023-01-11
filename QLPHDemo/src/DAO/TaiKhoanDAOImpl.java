/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import models.TaiKhoan;






/**
 *
 * @author datnguyen
 */
public class TaiKhoanDAOImpl implements TaiKhoanDAO{

    @Override
    public TaiKhoan login(String tdn, String mk) {
        try {
            Connection cons=DBConnect.getConnection();
            String sql="";
            TaiKhoan taiKhoan=null;
            PreparedStatement ps=(PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1,tdn);
            ps.setString(2,mk);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                taiKhoan=new TaiKhoan();
                taiKhoan.setTenTK(rs.getString("TenTK"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setTenNV(rs.getString("TenNV"));
                taiKhoan.setDiaChi(rs.getString("DiaChi"));
                taiKhoan.setSDT(rs.getString("SDT"));
                taiKhoan.setCMND(rs.getString("CMND"));
            }
            ps.close();
            cons.close();
            return taiKhoan;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
        
    }
   
    
}
