/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import view.DangNhapJDialog;

/**
 *
 * @author datnguyen
 */
public class Main {
    public static void main(String[] args) {
       DangNhapJDialog dialog=new DangNhapJDialog(null, true);
       dialog.setTitle("Đăng nhập");
       dialog.setResizable(false);
       dialog.setLocationRelativeTo(null);
       dialog.setVisible(true);
       
    }
}
