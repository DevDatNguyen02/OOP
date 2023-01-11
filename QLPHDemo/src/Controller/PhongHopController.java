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
import models.PhongHop;
import service.PhongHopService;
import service.PhongHopServiceImpl;

/**
 *
 * @author ASUS
 */
public class PhongHopController {
    
    private JButton btnSubmit;
    private JTextField jtfMaPhong;
    private JTextField jtfMaLoaiPhong;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;
    
    private PhongHop phongHop = null;
    
    private PhongHopService phongHopService = null;

    public PhongHopController(JButton btnSubmit, JTextField jtfMaPhong, JTextField jtfMaLoaiPhong, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaPhong = jtfMaPhong;
        this.jtfMaLoaiPhong = jtfMaLoaiPhong;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        
        this.phongHopService = new PhongHopServiceImpl();
    }
   
    public void setView(PhongHop phongHop){
        this.phongHop = phongHop;
//        jtfMaPhong.setText("PH" + phongHop.getMaPhongHop());
//        jtfMaLoaiPhong.setText("LP" + phongHop.getMaLoaiPhong());
        jtfMaPhong.setText(phongHop.getMaPhongHop());
        jtfMaLoaiPhong.setText(phongHop.getMaLoaiPhong());
        jcbTinhTrang.setSelected(phongHop.isTinhTrang());
        
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfMaPhong.getText().length() == 0 || jtfMaLoaiPhong.getText().length() == 0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!!!");
                }else{
                    phongHop.setMaPhongHop(jtfMaPhong.getText());
                    phongHop.setMaLoaiPhong(jtfMaLoaiPhong.getText());
                    phongHop.setTinhTrang(jcbTinhTrang.isSelected());
                    int ID = phongHopService.createOrUpdate(phongHop);
                    phongHop.setMaPhongHop(String.valueOf(ID));
                    jtfMaPhong.setText(String.valueOf(ID));
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
