/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.swing;

import com.raven.model.Model_menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class MenuItem extends javax.swing.JPanel {


    /**
     * @param selected the selected to set
     */
   private boolean selected;
   private boolean over;
   
    public MenuItem(Model_menu data) {
        initComponents();
        setOpaque(false);
        if(data.getType()== Model_menu.MenuType.MENU){
            lbIcon.setIcon(data.toIcon());
            lbname.setText(data.getName());
        }else if(data.getType()==Model_menu.MenuType.TITLE){
            lbIcon.setText(data.getName());
            lbIcon.setFont(new Font("sansserif", 1, 12));
            lbname.setVisible(false);
        }else{
            lbname.setText("");
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
     
    public void setOver(boolean over){
        this.over=over;
        repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();

        lbIcon.setForeground(new java.awt.Color(255, 255, 255));

        lbname.setForeground(new java.awt.Color(255, 255, 255));
        lbname.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addComponent(lbname))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lbname, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
     if(selected || over){
        Graphics2D g2 =(Graphics2D)grphcs; 
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if(selected){
            g2.setColor(new Color(255,255,255,80));
        }else{
            g2.setColor(new Color(255,255,255,20));
     }
        g2.fillRoundRect(10, 0, getWidth()-20, getHeight(), 5, 5);
     }
        super.paintComponent(grphcs); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbname;
    // End of variables declaration//GEN-END:variables
}
