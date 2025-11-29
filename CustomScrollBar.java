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
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

// Alright guys, so ito yung CustomScrollBar class
// Ginagamit natin to para gumawa ng modern-looking scrollbar
// Yung default na scrollbar ng Java pangit eh, so customize natin
public class CustomScrollBar extends JScrollBar {
    
    // Constructor - walang parameter kasi default settings lang
    public CustomScrollBar() {
        // I-set yung UI to custom ModernScrollBarUI class natin
        // Ito yung mag-hahandle ng actual painting ng scrollbar
        setUI(new ModernScrollBarUI());
        
        // I-set yung preferred size - 8 pixels lang width and height
        // Para slim lang yung scrollbar, hindi bulky
        setPreferredSize(new Dimension(8, 8));
        
        // I-set yung background color - light gray
        setBackground(Kulay.LIGHT_GRAY);
        
        // I-set yung unit increment - 16 pixels per scroll
        // Ito yung distance ng pag-scroll pag nag-arrow key or scroll wheel ka
        setUnitIncrement(16);
    }
    
    // Ito yung inner class - custom UI para sa scrollbar
    // Nag-extend siya ng BasicScrollBarUI para override natin yung appearance
    private static class ModernScrollBarUI extends BasicScrollBarUI {
        
        // Method para i-configure yung colors ng scrollbar
        @Override
        protected void configureScrollBarColors() {
            // thumbColor - yung kulay ng draggable part (yung slider mismo)
            this.thumbColor = Kulay.CHARCOAL_LIGHT;
            
            // thumbDarkShadowColor - yung shadow ng thumb para may depth
            this.thumbDarkShadowColor = Kulay.CHARCOAL_DARK;
            
            // thumbHighlightColor - yung highlight color ng thumb
            this.thumbHighlightColor = Kulay.CAVIAR;
            
            // trackColor - yung background track kung saan nag-slide yung thumb
            this.trackColor = Kulay.LIGHT_GRAY;
        }
        
        // Method para gumawa ng decrease button (yung arrow pataas)
        // Pero gusto natin walang buttons, so zero size lang gagawin natin
        @Override
        protected JButton createDecreaseButton(int orientation) {
            // I-return yung zero-size button
            return createZeroButton();
        }
        
        // Same concept para sa increase button (yung arrow pababa)
        @Override
        protected JButton createIncreaseButton(int orientation) {
            // I-return din yung zero-size button
            return createZeroButton();
        }
        
        // Helper method para gumawa ng invisible button
        // Para tanggalin yung arrow buttons sa scrollbar
        private JButton createZeroButton() {
            // Gumawa ng blank button
            JButton button = new JButton();
            
            // I-set lahat ng dimensions to 0 - invisible siya
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            
            // I-return yung button
            return button;
        }
        
        // Method para i-paint yung thumb (yung draggable slider)
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            // Gumawa ng Graphics2D object - mas advanced na drawing API
            Graphics2D g2 = (Graphics2D) g.create();
            
            // I-enable yung anti-aliasing - para smooth yung edges, hindi pixelated
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // I-set yung color ng thumb
            g2.setColor(thumbColor);
            
            // I-draw yung rounded rectangle - yung actual thumb
            // Parameters: x position, y position, width, height, arc width, arc height
            // 5, 5 yung arc para may rounded corners
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 5, 5);
            
            // I-dispose yung graphics object - para ma-free yung memory
            g2.dispose();
        }
        
        // Method para i-paint yung track (yung background ng scrollbar)
        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            // Gumawa ulit ng Graphics2D object
            Graphics2D g2 = (Graphics2D) g.create();
            
            // I-set yung track color
            g2.setColor(trackColor);
            
            // I-draw yung rectangle - plain lang, walang rounded corners
            // Kasi background lang naman to
            g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            
            // I-dispose yung graphics
            g2.dispose();
        }
    }
}