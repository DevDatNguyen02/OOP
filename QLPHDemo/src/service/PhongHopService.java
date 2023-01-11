/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import models.PhongHop;

/**
 *
 * @author ASUS
 */
public interface PhongHopService {
    
    public List<PhongHop> getList();

    public int createOrUpdate(PhongHop phongHop);
    
}
