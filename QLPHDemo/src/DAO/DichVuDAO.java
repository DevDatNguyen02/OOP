package DAO;

import java.util.List;
import models.DichVu;




/**
 *
 * @author datnguyen
 */
public interface DichVuDAO {
    
        public List<DichVu> getList();
        public int createOrUpdate(DichVu dichVu);
    
}
