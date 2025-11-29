/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.util;

/**
 *
 * @author Maine
 */

import java.awt.Color;

// Kulay class - dito naka-store lahat ng color constants
// Para consistent ang colors sa buong system at madaling i-maintain
public class Kulay {

    // PRIMARY COLORS - main colors ng system
    public static final Color CHARCOAL = new Color(60, 60, 60);        // dark gray, pang buttons at important elements
    public static final Color CHARCOAL_DARK = new Color(40, 40, 40);   // mas dark version, pang shadows at emphasis
    public static final Color CHARCOAL_LIGHT = new Color(100, 100, 100); // lighter version, pang subtle elements

    // BACKGROUND COLORS - pang mga panels at forms
    public static final Color VAPOROUS_GRAY = new Color(230, 224, 218); // soft gray, main dashboard background
    public static final Color WHITE = Color.WHITE;                       // clean background or cards
    public static final Color LIGHT_GRAY = new Color(245, 245, 245);    // very light gray, pang alternating rows
    public static final Color ACCENT_GRAY = new Color(240, 240, 240);   // another light gray variant

    // TEXT COLORS - pang lahat ng text
    public static final Color CAVIAR = new Color(44, 43, 44);           // almost black, main text
    public static final Color TEXT_WHITE = Color.WHITE;                 // text on dark backgrounds
    public static final Color BLUE = new Color(73, 118, 186);           // info indicators
    public static final Color GREEN = new Color(19, 134, 54);           // success messages
    public static final Color YELLOW = new Color(255, 188, 17);         // warnings
    public static final Color RED = new Color(201, 20, 50);             // errors / danger

    // BORDER COLORS - pang borders ng components
    public static final Color BORDER_NEUTRAL = new Color(210, 205, 200); // neutral gray
    public static final Color BORDER_LIGHT = new Color(240, 240, 240);   // light border
    public static final Color BORDER_DARK = new Color(160, 160, 160);    // dark border

    // Helper method - kunin ang color base sa string name
    // Useful kung dynamic yung color assignment
    public static Color getColor(String name) {
        // I-check yung name, case-insensitive
        return switch (name.toUpperCase()) {
            case "INFO" -> BLUE;
            case "SUCCESS" -> GREEN;
            case "WARNING" -> YELLOW;
            default -> CAVIAR;
        }; // info color
        // success color
        // warning color
        // default ay dark text
    }
}
