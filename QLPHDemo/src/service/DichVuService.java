/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import models.DichVu;


/**
 *
 * @author ASUS
 */
public interface DichVuService {
    
    public List<DichVu> getList();
       public int createOrUpdate(DichVu dichVu);
    
}
