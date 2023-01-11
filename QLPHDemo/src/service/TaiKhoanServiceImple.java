/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DAO.TaiKhoanDAO;
import DAO.TaiKhoanDAOImpl;
import models.TaiKhoan;

/**
 *
 * @author datnguyen
 */
public class TaiKhoanServiceImple implements TaiKhoanService{
  private TaiKhoanDAO taiKhoanDAO=null;
  public TaiKhoanServiceImple(){
      taiKhoanDAO=new TaiKhoanDAOImpl();
  }
    
  
    @Override
    public TaiKhoan login(String tdn, String mk) {
        
        return taiKhoanDAO.login(tdn, mk);
        
    }
    
}
