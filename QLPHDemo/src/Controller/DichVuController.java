/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import models.DichVu;
import service.DichVuService;
import service.DichVuServiceImpl;



/**
 *
 * @author ASUS
 */
public class DichVuController {
    
    private JButton btnSubmit;
    private JTextField jtfMaDichVu;
    private JTextField jtfTenDichVu;
    private JTextField jtfDonGia;
    private JLabel jlbMsg;
    
    private DichVu dichVu = null;
    
    private DichVuService dichVuService = null;

    public DichVuController(JButton btnSubmit, JTextField jtfMaDichVu, JTextField jtfTenDichVu, JTextField jtfDonGia, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaDichVu = jtfMaDichVu;
        this.jtfTenDichVu = jtfTenDichVu;
        this.jtfDonGia = jtfDonGia;
        this.jlbMsg = jlbMsg;
        this.dichVuService=new DichVuServiceImpl();
    }

   

    
   
    public void setView(DichVu dichVu){
        this.dichVu = dichVu;
        jtfMaDichVu.setText(dichVu.getMaDichVu());
        jtfTenDichVu.setText(dichVu.getTenDichVu());
        
        
    }
    
   public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfMaDichVu.getText().length() == 0 || jtfTenDichVu.getText().length() == 0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!!!");
                }else{
                    dichVu.setMaDichVu(jtfMaDichVu.getText());
                    dichVu.setTenDichVu(jtfTenDichVu.getText());
                    dichVu.setDonGia(Double.parseDouble(jtfDonGia.getText()));
                    int ID = dichVuService.createOrUpdate(dichVu);
                    dichVu.setMaDichVu(String.valueOf(ID));
                    jtfMaDichVu.setText(String.valueOf(ID));
                    jlbMsg.setText("Cập nhật dữ liệu thành công!!!");
                    
                    
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               btnSubmit.setBackground(new Color(100, 221, 23));
            }
            
        });
    }
    
}
