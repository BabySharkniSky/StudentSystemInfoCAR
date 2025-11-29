package studentinfo.controller;

/**
 *
 * @author Maine
 */

import javax.swing.*;
import java.awt.*;

// Ito yung RoundPanel class natin.
// Para lang siyang regular JPanel pero may rounded corners.
// Ginagamit natin ito para sa mga UI sections na kailangan ng mas malinis at modern look.
public class RoundPanel extends JPanel {

    // Corner radius (gano ka-curve yung kanto). Default: 15 pixels.
    private int cornerRadius = 15;
    
    // Constructor #1 – walang parameters.
    // Default panel na may rounded corners.
    public RoundPanel() {
        super();
        // Hindi opaque para makita yung custom na pag-paint natin ng rounded shape.
        setOpaque(false);
    }
    
    // Constructor #2 – may layout manager.
    // Useful kung gusto mo agad mag-set ng layout habang gumagawa ng panel.
    public RoundPanel(LayoutManager layout) {
        super(layout);
        setOpaque(false);
    }
    
    // Constructor #3 – may custom radius.
    // Para ma-adjust kung gaano ka-round yung corners.
    public RoundPanel(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false);
    }
    
    // Pinapaint natin yung mismong panel dito.
    // Ni-ooverride natin kasi custom shape (rounded rectangle) yung gusto natin.
    @Override
    protected void paintComponent(Graphics g) {
        // Tawagin muna yung original paintComponent.
        super.paintComponent(g);
        
        // Gagamit tayo ng Graphics2D para mas smooth at maganda yung drawing.
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Anti-aliasing para hindi sabog or jagged yung curves.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Kulay ng background ng panel ang gagamitin pang-fill.
        g2.setColor(getBackground());
        
        // Draw ng rounded rectangle na may width/height ng panel.
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        
        // Linisin yung graphics object para iwas memory leak.
        g2.dispose();
    }
}
