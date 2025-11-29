/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.model;

import studentinfo.util.Kulay;

/**
 * CardData - Model class para sa dashboard cards
 * Nag-store ng title, value, at color ng bawat card
 */
public class CardData {
    
    // Fields
    private String title;   // label ng card (e.g., "Total Students")
    private String value;   // value na ipapakita (e.g., "1,245")
    private Kulay color;    // color ng value text

    /**
     * Constructor - Gumagawa ng bagong CardData object
     * @param title - label ng card
     * @param value - value na ipapakita
     * @param color - color ng value text
     * @param icon - reserved for future icon use (hindi ginagamit for now)
     */
    public CardData(String title, String value, Kulay color, String icon) {
        this.title = title;
        this.value = value;
        this.color = color;
        // icon parameter reserved for future use
    }

    // Getter methods
    public String getTitle() { return title; }
    public String getValue() { return value; }
    public Kulay getColor() { return color; }

    // Setter methods - useful kung dynamic yung data
    public void setTitle(String title) { this.title = title; }
    public void setValue(String value) { this.value = value; }
    public void setColor(Kulay color) { this.color = color; }
}
