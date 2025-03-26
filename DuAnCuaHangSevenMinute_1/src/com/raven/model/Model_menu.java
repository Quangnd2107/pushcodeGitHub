/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Model_menu {

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public MenuType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_menu() {
    }
    
    
    private String icon;
    private String name;
    private MenuType type;
 
    
    
    public Icon toIcon() {
        URL iconURL = getClass().getResource("/com/raven/icon/" +icon + ".png");
        if (iconURL != null) {
            return new ImageIcon(iconURL);
        } else {
            return null;  // hoặc trả về một biểu tượng mặc định nếu muốn
        }
    }

    public static enum MenuType{
        TITLE,MENU,EMPTY
    }
}
