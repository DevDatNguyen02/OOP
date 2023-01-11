/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import DAO.PhongHopDAO;
import DAO.PhongHopDAOImpl;
import java.util.List;
import models.PhongHop;

/**
 *
 * @author ASUS
 */
public class PhongHopServiceImpl implements PhongHopService {
    
    private PhongHopDAO phongHopDAO = null;
    
    public PhongHopServiceImpl(){
        phongHopDAO = new PhongHopDAOImpl();
    }
    
    @Override
    public List<PhongHop> getList(){
        return phongHopDAO.getList();
    }

    @Override
    public int createOrUpdate(PhongHop phongHop) {
        return phongHopDAO.createOrUpdate(phongHop);
    }
}
