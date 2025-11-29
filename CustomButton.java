/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.controller;

/**
 *
 * @author Maine
 */

import studentinfo.util.Kulay;
import javax.swing.*;
import java.awt.*;

// Eto naman yung CustomButton class.
// Purpose nito: gumawa ng buttons na pare-pareho ang style sa buong system
// para uniform at hindi sabog yung design ng UI.
public class CustomButton extends JButton {
    
    // Constructor ng button.
    // 'text' yung label na ipapakita sa mismong button.
    public CustomButton(String text) {
        // Tawag muna sa parent constructor (JButton) para ma-set yung text.
        super(text);
        
        // Set ng font na gagamitin ng button.
        // Tahoma, plain style, size 14 — simple at clean tingnan.
        setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // Kulay ng text sa button.
        // White para kitang-kita sa colored background.
        setForeground(Color.WHITE);
        
        // Background color ng button.
        // Galing sa Kulay class para consistent yung theme sa buong system.
        setBackground(Kulay.GREEN);
        
        // I-off yung default focus indicator (yung dotted outline),
        // para mas neat at hindi "default Java" tingnan.
        setFocusPainted(false);
        
        // I-off din yung default border ng JButton.
        // Gumagamit tayo ng custom style instead.
        setBorderPainted(false);
        
        // Palitan yung cursor kapag hover.
        // Hand cursor = obvious na clickable.
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Ensure na yung background color ay fully drawn.
        setContentAreaFilled(true);
        
        // Gawin solid yung background (walang transparency).
        setOpaque(true);
    }
    
    // Pang-change ng kulay ng button kung kailangan,
    // halimbawa red pag delete, green pag save, etc.
    public void setButtonColor(Color color) {
        setBackground(color);
    }
}
