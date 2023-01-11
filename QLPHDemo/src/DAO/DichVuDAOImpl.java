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
import models.DichVu;


/**
 *
 * @author datnguyen
 */
public class DichVuDAOImpl implements DichVuDAO {

    @Override
    public List<DichVu> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM dich_vu";
            List<DichVu> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DichVu dichVu=new DichVu();
                dichVu.setMaDichVu(rs.getString("MaDichVu"));
                dichVu.setTenDichVu(rs.getString("TenDichVu"));
                dichVu.setDonGia(rs.getDouble("DonGia"));
                list.add(dichVu);
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
    public int createOrUpdate(DichVu dichVu) {
            try {
                Connection cons = DBConnect.getConnection();
                String sql = "INSERT INTO dich_vu(MaDichVu,TenDichVu,DonGia) VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE MaDichVu = VALUES(MaDichVu), TenDichVu = VALUES(TenDichVu), DonGia = VALUES(DonGia);";

                PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, dichVu.getMaDichVu());
                ps.setString(2, dichVu.getTenDichVu());
                ps.setDouble(3, dichVu.getDonGia());
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
