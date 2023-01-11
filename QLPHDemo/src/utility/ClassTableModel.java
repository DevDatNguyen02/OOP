/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;


import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.DichVu;
import models.PhongHop;

/**
 *
 * @author datnguyen
 */
public class ClassTableModel {
 
    public DefaultTableModel setTableDichVu(List<DichVu> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 8 ? Boolean.class : String.class;
            }
            
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        DichVu dichVu=null;
        
            for(int i = 0; i < rows; i++){
                dichVu = listItem.get(i);
                obj = new Object[columns];
                obj[0] = (i+1);
                obj[1] = dichVu.getMaDichVu();
                obj[2] = dichVu.getTenDichVu();
                obj[3] = dichVu.getDonGia();
                dtm.addRow(obj);
            }
        
       
        return dtm;
    }
    
    public DefaultTableModel setTablePhongHop(List<PhongHop> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 3 ? Boolean.class : String.class;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0){
            for(int i = 0; i < rows; i++){
                PhongHop phongHop = listItem.get(i);
                obj = new Object[columns];
                obj[0] = (i+1);
                obj[1] = phongHop.getMaPhongHop();
                obj[2] = phongHop.getMaLoaiPhong();
                obj[3] = phongHop.isTinhTrang();
                dtm.addRow(obj);
            }
        }
       
        return dtm;
    }
    
    
     

    
    
}
