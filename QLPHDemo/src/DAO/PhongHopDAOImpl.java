/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.PhongHop;

/**
 *
 * @author ASUS
 */
public class PhongHopDAOImpl implements PhongHopDAO {

    @Override
    public List<PhongHop> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM phong_hop";
            List<PhongHop> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhongHop phongHop = new PhongHop();
                phongHop.setMaPhongHop(rs.getString("maphonghop"));
                phongHop.setMaLoaiPhong(rs.getString("maloaiphong"));
                phongHop.setTinhTrang(rs.getBoolean("tinhtrang"));
                list.add(phongHop);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
        
    }
    
        @Override
    public int createOrUpdate(PhongHop phongHop) {
            try {
                Connection cons = DBConnect.getConnection();
                String sql = "INSERT INTO phong_hop(maphonghop, maloaiphong, tinhtrang) VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE maphonghop = VALUES(maphonghop), maloaiphong = VALUES(maloaiphong), tinhtrang = VALUES(tinhtrang);";

                PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, phongHop.getMaPhongHop());
                ps.setString(2, phongHop.getMaLoaiPhong());
                ps.setBoolean(3, phongHop.isTinhTrang());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                int generatedKey = 0;
                if(rs.next()){
                    generatedKey = rs.getInt(1);
                }
                ps.close();
                cons.close();
                return generatedKey;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return 0;
    }
    
    
    
}
