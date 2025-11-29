/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.model;

/**
 * MenuData - Model class para sa side menu items
 * Nag-store lang ng pangalan ng bawat menu item
 */
public class MenuData {
    
    // Field
    private String name;   // pangalan ng menu item
    
    /**
     * Constructor - Gumagawa ng bagong MenuData object
     * @param name - pangalan ng menu item
     */
    public MenuData(String name) {
        this.name = name;
    }
    
    // Getter - kunin ang pangalan ng menu item
    public String getName() { return name; }
    
    // Setter - i-update ang pangalan ng menu item
    public void setName(String name) { this.name = name; }
}
