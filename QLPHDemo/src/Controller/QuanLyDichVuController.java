/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import models.DichVu;

import service.DichVuService;
import service.DichVuServiceImpl;

import utility.ClassTableModel;
import view.DichVuJFrame;

/**
 *
 * @author ASUS
 */
public class QuanLyDichVuController {
    
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private DichVuService dichVuService = null;
    
    private String[] listColumn = {"STT", "Mã dịch vụ", "Tên dịch vụ", "Đơn giá"};
    
    private TableRowSorter<TableModel> rowSorter =  null;
    
    public QuanLyDichVuController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.dichVuService = new DichVuServiceImpl();
    }
    
    public void setDateToTable(){
        List<DichVu> listItem = dichVuService.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableDichVu(listItem, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                 String text = jtfSearch.getText();
                 if(text.trim().length() == 0){
                     rowSorter.setRowFilter(null);
                 }else{
                     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                 }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 String text = jtfSearch.getText();
                 if(text.trim().length() == 0){
                     rowSorter.setRowFilter(null);
                 }else{
                     rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                 }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                    
                    
                    DichVu dichVu=new DichVu();
                    dichVu.setMaDichVu(model.getValueAt(selectedRowIndex, 1).toString());
                    dichVu.setTenDichVu(model.getValueAt(selectedRowIndex, 2).toString());
                    dichVu.setDonGia((double) model.getValueAt(selectedRowIndex, 3));
                    
                    DichVuJFrame frame = new DichVuJFrame(dichVu);
                    frame.setTitle("Thông tin dịch vụ");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                    
                }
            }
           
        });
        
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
        
    }
    
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter() {
             @Override
            public void mouseClicked(MouseEvent e) {
                DichVuJFrame frame = new DichVuJFrame(new DichVu());
                frame.setTitle("Thông tin dịch vụ");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
    }
    
    
}
