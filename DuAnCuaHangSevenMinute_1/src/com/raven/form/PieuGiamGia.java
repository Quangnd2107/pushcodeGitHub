/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.DBConnect;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import repository.PhieuGiamGiaRepository;
import response.PhieuGiamGiaResponse;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class PieuGiamGia extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private PhieuGiamGiaRepository Pggrp;

    /**
     * Creates new form Form_1
     */
    public PieuGiamGia() {
        initComponents();
        dtm = (DefaultTableModel) tblPgg.getModel();
        Pggrp = new PhieuGiamGiaRepository();
        showDataTable(Pggrp.getAll());
        runThreadCheckNgayKetThuc();
    }

    private void showDataTable(ArrayList<PhieuGiamGiaResponse> a) {
        dtm.setRowCount(0);
        AtomicInteger index = new AtomicInteger(1);
        a.forEach(s -> dtm.addRow(new Object[]{
            index.getAndIncrement(), s.getMaGG(), s.getTenGG(), s.getNgayBatDau(), s.getNgayKetThuc(), s.getGiamToiDa(),
            s.getGiaTriToiThieu(), s.getSoLuong(), s.getTinhTrang()
        }));

    }

    private void runThreadCheckNgayKetThuc() {
        Thread checkNgayKetThuc = new Thread() {
            @Override
            public void run() {
                while (true) {
                    Date currentDate = new Date();
                    for (PhieuGiamGiaResponse pggr : Pggrp.getAll()) {
                        if (currentDate.after(pggr.getNgayKetThuc())) {
                            Pggrp.updateNgayHetHan(pggr.getId_GG());
                        }
                    }
                }
            }
        };
        checkNgayKetThuc.start();
    }

  private boolean validateFormData() {
    String maGG, tenGG, giamToiDa, giaTriToiThieu, soLuong;
    Date ngayBD, ngayKT;

    // Kiểm tra mã giảm giá
    if (txtMaGG.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập mã giảm giá");
        txtMaGG.requestFocus();
        return false;
    } else {
        maGG = txtMaGG.getText().trim();
        if (!maGG.matches("^GG[0-9]+$")) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng phải bắt đầu bằng GG");
            txtMaGG.requestFocus();
            return false;
        }
        // Kiểm tra mã giảm giá trùng lặp
        if (isDuplicateMaGG(maGG)) {
            JOptionPane.showMessageDialog(this, "Mã giảm giá đã tồn tại");
            txtMaGG.requestFocus();
            return false;
        }
    }

    // Kiểm tra tên giảm giá
    if (txtTenGG.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập tên phiếu giảm giá");
        txtTenGG.requestFocus();
        return false;
    } else {
        tenGG = txtTenGG.getText().trim();
    }

    // Kiểm tra số tiền giảm tối đa
    if (txtGiamToiDa.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập số tiền giảm tối đa");
        txtGiamToiDa.requestFocus();
        return false;
    } else {
        giamToiDa = txtGiamToiDa.getText().trim();
        if (!giamToiDa.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Số tiền giảm tối đa chỉ được nhập số");
            txtGiamToiDa.requestFocus();
            return false;
        }
    }

    // Kiểm tra hoá đơn tối thiểu
    if (txtGiamToiThieu.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập hoá đơn tối thiểu");
        txtGiamToiThieu.requestFocus();
        return false;
    } else {
        giaTriToiThieu = txtGiamToiThieu.getText().trim();
        if (!giaTriToiThieu.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Hoá đơn tối thiểu phải là số nguyên");
            txtGiamToiThieu.requestFocus();
            return false;
        }
    }

    // Kiểm tra số lượng
    if (txtSoLuong.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Chưa nhập số lượng");
        txtSoLuong.requestFocus();
        return false;
    } else {
        soLuong = txtSoLuong.getText().trim();
        if (!soLuong.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên");
            txtSoLuong.requestFocus();
            return false;
        }
    }

    // Kiểm tra ngày bắt đầu
    if (txtNgayBD.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Chưa chọn ngày bắt đầu");
        txtNgayBD.requestFocus();
        return false;
    } else {
        ngayBD = txtNgayBD.getDate();
    }

    // Kiểm tra ngày kết thúc
    if (txtNgayKT.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Chưa chọn ngày kết thúc");
        txtNgayKT.requestFocus();
        return false;
    } else {
        ngayKT = txtNgayKT.getDate();
    }

    // Kiểm tra ngày kết thúc phải sau ngày bắt đầu
    if (ngayKT.before(ngayBD)) {
        JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu");
        txtNgayKT.requestFocus();
        return false;
    }

    return true; // Trả về true nếu tất cả kiểm tra đều hợp lệ
}

private boolean isDuplicateMaGG(String maGG) {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean isDuplicate = false;

    try {
        // Kết nối cơ sở dữ liệu
        con = DBConnect.getConnection(); // Thay đổi cho phù hợp với cách kết nối của bạn

        String query = "SELECT COUNT(*) FROM Giam_Gia WHERE MaGG = ?";
        ps = con.prepareStatement(query);
        ps.setString(1, maGG);
        rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            isDuplicate = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Đóng kết nối cơ sở dữ liệu
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return isDuplicate;
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        txtMaGG = new javax.swing.JTextField();
        txtGiamToiDa = new javax.swing.JTextField();
        txtTenGG = new javax.swing.JTextField();
        txtGiamToiThieu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPgg = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        btnTImKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 255, 255));
        jLabel2.setFont(new java.awt.Font("Academy Engraved LET", 2, 48)); // NOI18N
        jLabel2.setText("Phiếu Giảm Giá");
        jLabel2.setToolTipText(""); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        jPanel1.setForeground(new java.awt.Color(0, 255, 255));
        jPanel1.setBounds(new java.awt.Rectangle(2, 2, 0, 0));

        jLabel3.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 18)); // NOI18N
        jLabel3.setText("Mã giảm giá");

        jLabel4.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 18)); // NOI18N
        jLabel4.setText("Tên giảm giá");

        jLabel5.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 18)); // NOI18N
        jLabel5.setText("Ngày bắt đầu");

        jLabel6.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 18)); // NOI18N
        jLabel6.setText("Giảm tối đa");

        jLabel7.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 18)); // NOI18N
        jLabel7.setText("Ngày kết thúc");

        jLabel8.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 18)); // NOI18N
        jLabel8.setText("HoaDonToiThieu");

        cbbTrangThai.setFont(new java.awt.Font("Al Bayan", 0, 13)); // NOI18N
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp diễn ra", "Đang diễn ra", "Đã kết thúc" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        txtMaGG.setFont(new java.awt.Font("Al Bayan", 0, 13)); // NOI18N
        txtMaGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaGGActionPerformed(evt);
            }
        });

        txtGiamToiDa.setFont(new java.awt.Font("Al Bayan", 0, 13)); // NOI18N

        txtTenGG.setFont(new java.awt.Font("Al Bayan", 0, 13)); // NOI18N

        txtGiamToiThieu.setFont(new java.awt.Font("Al Bayan", 0, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 18)); // NOI18N
        jLabel1.setText("Trạng thái");

        jLabel10.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 18)); // NOI18N
        jLabel10.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("Al Bayan", 0, 13)); // NOI18N

        txtNgayBD.setDateFormatString("dd-MM-yyyy");

        txtNgayKT.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(747, 747, 747))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtMaGG, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtTenGG))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(128, 128, 128)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtGiamToiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(128, 128, 128)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiamToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiamToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiamToiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        jPanel2.setForeground(new java.awt.Color(153, 255, 255));

        tblPgg.setFont(new java.awt.Font(".AppleSystemUIFont", 2, 18)); // NOI18N
        tblPgg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Ma GG", "Ten GG", "NgayBatDaua", "NgayKetThuc", "GiamToiDa", "HoaDonToiThieu", "So luong", "TInh trang"
            }
        ));
        tblPgg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPggMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPgg);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnThem.setFont(new java.awt.Font(".AppleSystemUIFont", 2, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font(".AppleSystemUIFont", 2, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font(".AppleSystemUIFont", 2, 18)); // NOI18N
        btnXoa.setText("Chuyển đổi");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLammoi.setFont(new java.awt.Font(".AppleSystemUIFont", 2, 18)); // NOI18N
        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnTImKiem.setFont(new java.awt.Font("Al Bayan", 2, 18)); // NOI18N
        btnTImKiem.setText("Tìm kiếm");
        btnTImKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTImKiemActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Al Bayan", 0, 18)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLammoi))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTImKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTImKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLammoi))
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblPggMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPggMouseClicked
        // TODO add your handling code here:
        detail(tblPgg.getSelectedRow());
    }//GEN-LAST:event_tblPggMouseClicked
    private PhieuGiamGiaResponse getFormData() {
        return PhieuGiamGiaResponse.builder()
                .maGG(txtMaGG.getText())
                .tenGG(txtTenGG.getText())
                .ngayBatDau(txtNgayBD.getDate())
                .ngayKetThuc(txtNgayKT.getDate())
                .giamToiDa(txtGiamToiDa.getText())
                .giaTriToiThieu(txtGiamToiThieu.getText())
                .soLuong(txtSoLuong.getText())
                .tinhTrang(cbbTrangThai.getSelectedItem().toString())
                .build();

    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        int index = tblPgg.getSelectedRow();
        if (index >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa khong?", "Xac nhan xoa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                PhieuGiamGiaResponse pgg = Pggrp.getAll().get(index);
                Pggrp.delete(Pggrp.getAll().get(index).getId_GG());
                showDataTable(Pggrp.getAll());
                JOptionPane.showMessageDialog(this, "Xoa thanh cong", "Thong bao", JOptionPane.YES_NO_OPTION);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (validateFormData()) {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Bạn có muốn thêm không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                PhieuGiamGiaResponse newPhieu = getFormData();
                Pggrp.add(newPhieu);
                showDataTable(Pggrp.getAll());
                JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
                
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
    int index = tblPgg.getSelectedRow();
        if (index >= 0 && validateFormData()) {
            int confirmed = JOptionPane.showConfirmDialog(null,
                    "Bạn có muốn sửa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                PhieuGiamGiaResponse updatedPhieu = getFormData();
                updatedPhieu.setId_GG(Pggrp.getAll().get(index).getId_GG());
                Pggrp.update(updatedPhieu,updatedPhieu.getId_GG());
                showDataTable(Pggrp.getAll());
                JOptionPane.showMessageDialog(this, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

            
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        txtMaGG.setText(null);
        txtTenGG.setText(null);
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null);
        txtGiamToiDa.setText(null);
        txtGiamToiThieu.setText(null);
        txtSoLuong.setText(null);
        txtTimKiem.setText(null);
        cbbTrangThai.setSelectedIndex(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnTImKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTImKiemActionPerformed
        showDataTable(Pggrp.search(txtTimKiem.getText(),
                cbbTrangThai.getSelectedIndex()));
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTImKiemActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void txtMaGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaGGActionPerformed
    private void detail(int index ) {
        if (index >= 0) {
            PhieuGiamGiaResponse pggResponse = Pggrp.getAll().get(index);
        txtMaGG.setText(pggResponse.getMaGG());
        txtTenGG.setText(pggResponse.getTenGG());
        txtNgayBD.setDate(pggResponse.getNgayBatDau());
        txtNgayKT.setDate(pggResponse.getNgayKetThuc());
        txtGiamToiDa.setText(pggResponse.getGiamToiDa());
        txtGiamToiThieu.setText(pggResponse.getGiaTriToiThieu());
        txtSoLuong.setText(pggResponse.getSoLuong());
        cbbTrangThai.setSelectedItem(pggResponse.getTinhTrang());
        }
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTImKiem;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPgg;
    private javax.swing.JTextField txtGiamToiDa;
    private javax.swing.JTextField txtGiamToiThieu;
    private javax.swing.JTextField txtMaGG;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenGG;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
//PhieuGiamGiaResponse readForm(){
//    String maGG, tenGG, giamToiDa, giaTriToiThieu, soLuong;
//    Date ngayBD, ngayKT;
//        if (txtMaGG.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Chưa nhập mã ");
//            txtMaGG.requestFocus();
//            return null;
//        } else {
//            maGG = txtMaGG.getText().trim();
//            if (!maGG.matches("^GG[0-9]+$")) {
//                JOptionPane.showMessageDialog(this, "Mã khách hàng phải bắt đầu bằng GG");
//                return null;
//            }
//        }
//        if (txtTenGG.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Chwa nhap ten phieu giam gia");
//            txtTenGG.requestFocus();
//            return null;
//        
//    }else{
//            tenGG = txtTenGG.getText().trim();
//        }
//          if (txtGiamToiDa.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Chưa nhập so tien giam toi da");
//            txtGiamToiDa.requestFocus();
//            return null;
//        } else {
//            giamToiDa = txtGiamToiDa.getText().trim();
//            if (!giamToiDa.matches("[0-9]+")) {
//                JOptionPane.showMessageDialog(this, "So tien giam toi da chi duoc nhap so ");
//                return null;
//            }
//        }
//           if (txtGiamToiThieu.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Chưa nhập hoa don toi thieu");
//            txtGiamToiThieu.requestFocus();
//            return null;
//        } else {
//            giaTriToiThieu = txtGiamToiThieu.getText().trim();
//            if (!giaTriToiThieu.matches("[0-9]+")) {
//                JOptionPane.showMessageDialog(this, "Gia tri");
//                return null;
//            }
//        }
//            if (txtSoLuong.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Chưa nhập số luong");
//            txtSoLuong.requestFocus();
//            return null;
//        } else {
//            soLuong = txtSoLuong.getText().trim();
//            if (!soLuong.matches("[0-9]+")) {
//                JOptionPane.showMessageDialog(this, "So luong phai la so nguyen duong");
//                return null;
//            }
//        }
//       if (txtNgayBD.getDate().equals("")) {
//           JOptionPane.showMessageDialog(this, "chua chon ngaybd");
//           txtNgayBD.requestFocus();
//           return null;
//        
//    }else{
//           ngayBD = txtNgayBD.getDate();
//           
//       }
//        if (txtNgayKT.getDate().equals("")) {
//           JOptionPane.showMessageDialog(this, "chua chon ngayKT");
//           txtNgayKT.requestFocus();
//           return null;
//        
//    }else{
//           ngayKT = txtNgayKT.getDate();
//       }
//    return new PhieuGiamGiaResponse();
//    
//}

}
