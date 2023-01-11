/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import models.TaiKhoan;
import service.TaiKhoanService;
import service.TaiKhoanServiceImple;
import view.MainJFrame;

/**
 *
 * @author datnguyen
 */
public class TKController {
    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JTextField jtfMatKhau;
    private JLabel jlbMsg;
    
    private TaiKhoanService taiKhoanService=null;

    public TKController(JDialog dialog, JButton btnSubmit, JTextField jtfTenDangNhap, JTextField jtfMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMsg = jlbMsg;
        
        taiKhoanService=new TaiKhoanServiceImple();
    }
    
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfTenDangNhap.getText().length() == 0 || jtfMatKhau.getText().length() == 0){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!!!");
                }else{
                    TaiKhoan taiKhoan=taiKhoanService.login(jtfTenDangNhap.getText(),jtfMatKhau.getText());
                    if(taiKhoan==null){
                        jlbMsg.setText("Vui lòng nhập dữ liệu!");
                    }else{
                       dialog.dispose();
                        MainJFrame frame=new MainJFrame();
                        frame.setTitle("Quản lý phòng họp");
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame.setVisible(true);
                    }
                    
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
