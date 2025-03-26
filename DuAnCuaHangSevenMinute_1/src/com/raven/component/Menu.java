/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

import com.raven.envent.EventMenu;
import com.raven.model.Model_menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;


public class Menu extends javax.swing.JPanel {
    
    private EventMenu event;
    public void addEvent(EventMenu event){
        this.event= event;
        listMenu1.addEvent(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
       init();
    }

    private void init(){
        listMenu1.addItem(new Model_menu("1","Nhân Viên",Model_menu.MenuType.MENU));
        listMenu1.addItem(new Model_menu("2","Bán Hàng",Model_menu.MenuType.MENU));
        listMenu1.addItem(new Model_menu("3","Hóa Đơn",Model_menu.MenuType.MENU));
        listMenu1.addItem(new Model_menu("4","Sản Phẩm",Model_menu.MenuType.MENU));
        listMenu1.addItem(new Model_menu("","",Model_menu.MenuType.MENU));

        listMenu1.addItem(new Model_menu("5","Phiếu Giảm Giá",Model_menu.MenuType.MENU));
        listMenu1.addItem(new Model_menu("6","Khách Hàng",Model_menu.MenuType.MENU));
        listMenu1.addItem(new Model_menu("7","Đăng nhập",Model_menu.MenuType.MENU));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelmoving = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listMenu1 = new com.raven.swing.ListMenu<>();

        panelmoving.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/logo.png"))); // NOI18N
        jLabel2.setText("Seven Minute");

        javax.swing.GroupLayout panelmovingLayout = new javax.swing.GroupLayout(panelmoving);
        panelmoving.setLayout(panelmovingLayout);
        panelmovingLayout.setHorizontalGroup(
            panelmovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        );
        panelmovingLayout.setVerticalGroup(
            panelmovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelmovingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelmoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelmoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 =(Graphics2D)grphcs; 
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#70e1f5"), 0, getHeight(), Color.decode("#ffd194"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs); 
    }
    private int x;
    private int y;
public void initMoving(JFrame fram){
    panelmoving.addMouseListener(new MouseAdapter(){
        @Override
        public void mousePressed(MouseEvent me) {
        x = me.getX();
        y =me.getY();
        }
    
});
    panelmoving.addMouseMotionListener(new MouseMotionAdapter(){
        @Override
        public void mouseDragged(MouseEvent me) {
          fram.setLocation(me.getXOnScreen()-x, me.getYOnScreen()-y);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private com.raven.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelmoving;
    // End of variables declaration//GEN-END:variables
}
