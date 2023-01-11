package DAO;


import java.util.List;
import models.PhongHop;

/**
 *
 * @author ASUS
 */
public interface PhongHopDAO {
    
        public List<PhongHop> getList();

    public int createOrUpdate(PhongHop phongHop);
}
