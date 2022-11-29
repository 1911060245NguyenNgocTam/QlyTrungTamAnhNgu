/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytrungtamanhngu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class DiemDanh extends javax.swing.JInternalFrame {
     private int index;
    public Connection conn;
    public PreparedStatement ps;
    public ResultSet rs;
    DefaultTableModel tableModel;
    /**                   
     * Creates new form DiemDanh
     */
    public DiemDanh() {
        
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        tableModel = (DefaultTableModel) jtableDiemDanh.getModel();
        jtxtTrangThai.grabFocus();
        hienThiDuLieu();
      
    }
    private Connection ConnectToServer() {
        String user = "sa";
        String pass = "123456";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=quanlytrungtamanhngu",user,pass);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void hienThiDuLieu() {
        try {
            conn = ConnectToServer();
            String sql = "select *"+
                            "from DIEMDANH";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            //
            tableModel.setRowCount(0);
            while (rs.next()) {
                String[] row = new String[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                  
                   };
                tableModel.addRow(row);
            }

            // 
            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

      public void refresh() {      
        jtxtMaLop.setText("");
        jtxtMaHocVien.setText("");
        jtxtMaNgayHoc.setText("");
        jtxtNgayBatDau.setText("");
        jtxtNgayKetThuc.setText(""); 
        jtxtTrangThai.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableDiemDanh = new javax.swing.JTable();
        jtxtMaLop = new javax.swing.JTextField();
        jtxtMaHocVien = new javax.swing.JTextField();
        jtxtMaNgayHoc = new javax.swing.JTextField();
        jtxtTrangThai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnThem = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jbtnSua = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtxtTimKiem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtNgayBatDau = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtNgayKetThuc = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(659, 580));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ XẾP LỚP");

        jtableDiemDanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Lớp", "Mã Học Viên", "Ngày Nhập Học", "Giờ Bắt Đầu", "Giờ Kết Thúc", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtableDiemDanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableDiemDanhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableDiemDanh);

        jLabel2.setText("Mã Lớp");

        jLabel3.setText("Mã Học Viên");

        jLabel4.setText(" Ngày Học");

        jLabel5.setText("Trạng Thái");

        jbtnThem.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnThem.setText("Thêm");
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        jbtnXoa.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnXoa.setText("Xóa ");
        jbtnXoa.setPreferredSize(new java.awt.Dimension(60, 28));
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });

        jbtnSua.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnSua.setText("Sửa");
        jbtnSua.setPreferredSize(new java.awt.Dimension(60, 28));
        jbtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSuaActionPerformed(evt);
            }
        });

        jLabel6.setText("Tìm Kiếm");

        jtxtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtTimKiemKeyReleased(evt);
            }
        });

        jLabel7.setText("Giờ Bắt Đầu");

        jLabel8.setText("Giờ Kết Thúc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtnThem)
                        .addGap(16, 16, 16)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtxtTrangThai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(jtxtMaNgayHoc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtMaHocVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtMaLop, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtTimKiem)
                            .addComponent(jtxtNgayBatDau)
                            .addComponent(jtxtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jbtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel1)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jtxtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtMaHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jtxtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtMaNgayHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jtxtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnThem)
                    .addComponent(jbtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        // TODO add your handling code here:
        try {
            StringBuffer sb = new StringBuffer();
            Validation.check(jtxtTrangThai, sb, "Trạng thái không được để trống");
            //Validation.check(jtxtSDT, sb, "Sđt không được để trống");

//            while (true) {
//                if (jtxtSDT.getText().trim().equals("")) {
//                    JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
//                    jtxtSDT.grabFocus();
//                    return;
//                } else if (jtxtSDT.getText().trim().length() > 11 || jtxtSDT.getText().trim().length() < 10) {
//                    JOptionPane.showMessageDialog(this, "SĐT chứa từ 10-11 số.");
//                    jtxtSDT.grabFocus();
//                    return;
//                } else if (!jtxtSDT.getText().trim().matches("0[1-9]{1}\\d{8,9}")) {
//                    JOptionPane.showMessageDialog(this, "SĐT chưa đúng định dạng.");
//                    jtxtSDT.grabFocus();
//                    return;
//                } else {
//                    break;
//                }
//            }

            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString(), "Invalidation", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //Thêm vào csdl
            conn = ConnectToServer();
            String sql =  "INSERT INTO DIEMDANH (MALOP,MAHOCVIEN,NGAYHOC,GIOBATDAU,GIOKETTHUC,TRANGTHAI)" + "VALUES(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            tableModel.setRowCount(0);
//            while(rs.next()){
//                
//            String[]row  = new String[]{
//            rs.getString(1),
//            rs.getString(2), 
//            rs.getString(3),
//            rs.getString(4),
//            rs.getString(5),
//            };
//         }
            ps.setString(1,jtxtMaLop.getText());
            ps.setString(2,jtxtMaHocVien.getText());
            ps.setString(3,jtxtMaNgayHoc.getText());
            ps.setString(4,jtxtNgayBatDau.getText()); 
            ps.setString(5,jtxtNgayKetThuc.getText());
            ps.setString(6,jtxtTrangThai.getText());        
            ps.executeUpdate();
            hienThiDuLieu();
            
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
            refresh();
//            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtnThemActionPerformed

    private void jtableDiemDanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableDiemDanhMouseClicked
        // TODO add your handling code here:
        try {
            int row = jtableDiemDanh.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn vào dòng cần hiển thị");
                return;
            } else {
                jtxtMaLop.setText(jtableDiemDanh.getValueAt(row, 0).toString());
                jtxtMaHocVien.setText(jtableDiemDanh.getValueAt(row, 1).toString());
                jtxtMaNgayHoc.setText(jtableDiemDanh.getValueAt(row, 2).toString());
                jtxtNgayBatDau.setText(jtableDiemDanh.getValueAt(row, 3).toString());  
                jtxtNgayKetThuc.setText(jtableDiemDanh.getValueAt(row, 4).toString());   
                jtxtTrangThai.setText(jtableDiemDanh.getValueAt(row, 5).toString());

             
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jtableDiemDanhMouseClicked

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        // TODO add your handling code here:
        int row = jtableDiemDanh.getSelectedRow();
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa thông tin này không ?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            String MaLop = jtableDiemDanh.getValueAt(row, 0).toString();
            conn = ConnectToServer();
            //Xóa tt csdl từ mã kh
            String sql = "  DELETE FROM DIEMDANH WHERE MALOP = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, MaLop);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Xóa thông tin thành công");
            hienThiDuLieu();
            refresh();
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jbtnXoaActionPerformed

    private void jbtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSuaActionPerformed
        // TODO add your handling code here:
         if (JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật lớp này không ?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = ConnectToServer();
            int row =jtableDiemDanh.getSelectedRow();
            //Câp nhật vào csdl , lấy từ mã KH
            String sql = "update  DIEMDANH set  MALOP = ?, NGAYHOC = ?, GIOBATDAU = ?, GIOKETTHUC = ?, TRANGTHAI = ?"
                     +" where  MAHOCVIEN = ?  ";
            
            ps = conn.prepareStatement(sql);

            ps.setString(1, jtxtMaLop.getText());
            ps.setString(6, jtxtMaHocVien.getText());           
            ps.setString(2,jtxtMaNgayHoc.getText());      
            ps.setString(3, jtxtNgayBatDau.getText()); 
            ps.setString(4, jtxtNgayKetThuc.getText());   
            ps.setString(5, jtxtTrangThai.getText());
           
           
            //ps.setString(4,dtmKH.getValueAt(row,0 ).toString());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật lớp thành công");
            hienThiDuLieu();
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtnSuaActionPerformed

    
      private int getIndex() {
        return index;
    }

    private void setIndex(int index) {
        this.index = index;
    }
    
    private void jtxtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtTimKiemKeyReleased
        // TODO add your handling code here:
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//              String url = "jdbc:sqlserver://localhost:1433;databaseName=quanlytrungtamanhngu", user, pass; 
//              Connection con = DriverManager.getConnection(url);
              conn = ConnectToServer();
              String sql = "Select *from [DiemDanh] where [MaHocVien] = ?";
              PreparedStatement pst = conn.prepareStatement(sql);
              pst.setString(1, jtxtTimKiem.getText());
              ResultSet rs = pst.executeQuery();
              
              String getIndex = "SELECT [MaHocVien], ROW_NUMBER() OVER (ORDER BY MaHocVien) AS [MaHocVien]\n"
                                + "FROM [DiemDanh]";
              PreparedStatement ps = conn.prepareStatement(getIndex);
              ResultSet rt = ps.executeQuery();
              
            if (rs.next()) {
                String setidhocvien = rs.getString(2);
                jtxtMaHocVien.setText(setidhocvien);

                String setidlop = rs.getString(1);
                jtxtMaLop.setText(setidlop);

                String setngayhoc = rs.getString(3);
                jtxtMaNgayHoc.setText(setngayhoc);

                String setngaybatdau= rs.getString(4);
                jtxtNgayBatDau.setText(setngaybatdau);

                String setngayketthuc = rs.getString(5);
                jtxtNgayKetThuc.setText(setngayketthuc);
                
                String settrangthai = rs.getString(6);
                jtxtTrangThai.setText(settrangthai);
            }
            
            int index = 0;
            while (rt.next()){                
                if (rt.getString(1).equalsIgnoreCase(jtxtMaHocVien.getText())){
                    System.out.println(rt.getString(1) + " " + rt.getString(2));
                    index = Integer.parseInt(rt.getString(2));
                }
            }
            if (index >= 0) {
                setIndex(index - 1);
                System.out.println(index);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jtxtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnSua;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JTable jtableDiemDanh;
    private javax.swing.JTextField jtxtMaHocVien;
    private javax.swing.JTextField jtxtMaLop;
    private javax.swing.JTextField jtxtMaNgayHoc;
    private javax.swing.JTextField jtxtNgayBatDau;
    private javax.swing.JTextField jtxtNgayKetThuc;
    private javax.swing.JTextField jtxtTimKiem;
    private javax.swing.JTextField jtxtTrangThai;
    // End of variables declaration//GEN-END:variables
}
