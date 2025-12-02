package studentinfo.controller;

import studentinfo.util.Kulay;
import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    
    public CustomButton(String text) {
        super(text);
        
        setFont(new Font("Tahoma", Font.PLAIN, 14));
        setForeground(Color.WHITE);
        setBackground(Kulay.GREEN);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(true);
        setOpaque(true);
    }
    
    public void setButtonColor(Color color) {
        setBackground(color);
    }
}
