/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import DAO.DichVuDAO;
import DAO.DichVuDAOImpl;
import java.util.List;
import models.DichVu;


/**
 *
 * @author datnguyen
 */
public class DichVuServiceImpl implements DichVuService {
    
    private DichVuDAO dichVuDAO = null;
    
    public DichVuServiceImpl(){
        this.dichVuDAO = new DichVuDAOImpl();
    }
    
    @Override
    public List<DichVu> getList(){
        return dichVuDAO.getList();
    }

     @Override
    public int createOrUpdate(DichVu dichVu) {
        return dichVuDAO.createOrUpdate(dichVu);
    }
}
