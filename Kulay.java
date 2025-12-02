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

public class Kulay {

    public static final Color CHARCOAL = new Color(60, 60, 60);
    public static final Color CHARCOAL_DARK = new Color(40, 40, 40);
    public static final Color CHARCOAL_LIGHT = new Color(100, 100, 100);

    public static final Color VAPOROUS_GRAY = new Color(230, 224, 218);
    public static final Color WHITE = Color.WHITE;
    public static final Color LIGHT_GRAY = new Color(245, 245, 245);
    public static final Color ACCENT_GRAY = new Color(240, 240, 240);

    public static final Color CAVIAR = new Color(44, 43, 44);
    public static final Color TEXT_WHITE = Color.WHITE;
    public static final Color BLUE = new Color(73, 118, 186);
    public static final Color GREEN = new Color(19, 134, 54);
    public static final Color YELLOW = new Color(255, 188, 17);
    public static final Color RED = new Color(201, 20, 50);

    public static final Color BORDER_NEUTRAL = new Color(210, 205, 200);
    public static final Color BORDER_LIGHT = new Color(240, 240, 240);
    public static final Color BORDER_DARK = new Color(160, 160, 160);

    public static Color getColor(String name) {
        return switch (name.toUpperCase()) {
            case "INFO" -> BLUE;
            case "SUCCESS" -> GREEN;
            case "WARNING" -> YELLOW;
            default -> CAVIAR;
        };
    }
}
