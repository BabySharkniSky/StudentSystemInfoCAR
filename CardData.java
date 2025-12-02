/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.model;

import studentinfo.util.Kulay;


public class CardData {
    
    // Fields
    private String title;   
    private String value;  
    private Kulay color;    

    /**
     * Constructor - Gumagawa ng bagong CardData object
     * @param title 
     * @param value
     * @param color
     * @param icon 
     */
    public CardData(String title, String value, Kulay color, String icon) {
        this.title = title;
        this.value = value;
        this.color = color;
 
    }

    public String getTitle() { return title; }
    public String getValue() { return value; }
    public Kulay getColor() { return color; }

    
    public void setTitle(String title) { this.title = title; }
    public void setValue(String value) { this.value = value; }
    public void setColor(Kulay color) { this.color = color; }
}


