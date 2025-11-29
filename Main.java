/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.Main;

import studentinfo.ui.Mainframe;
import javax.swing.*;
import studentinfo.form.LoginForm;

// Main class ng program — ito ang pinaka-entry point.
// Ibig sabihin, ito ang unang tatakbong class pag shinart mo ang application.
public class Main {
    
    // Ito ang main method. Lahat ng Java applications kailangan nito.
    // Pag ni-run ang program, dito agad papasok ang execution.
    public static void main(String[] args) {
        
        // STEP 1: Set Look and Feel
        // Sinusubukan natin i-apply ang "system theme" ng OS.
        // Para magmukhang native ang UI (Windows style sa Windows, Mac style sa Mac, etc.)
        try {
            // Ina-apply ang system look and feel.
            // Kung mag-fail man, hindi naman titigil ang program.
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (Exception e) {
            // Kung sakaling may error sa pag-set ng look and feel,
            // i-print lang natin ang error para makita sa console.
            e.printStackTrace();
        }

        // STEP 2: Ipakita ang Login Window
        // Ginagamit ang invokeLater para siguradong UI thread ang magha-handle ng Swing components.
        SwingUtilities.invokeLater(() -> {
            
            // Gumagawa ng frame para sa Login screen.
            JFrame loginFrame = new JFrame("Student Information System - Login");
            
            // Kapag sinara ang window, sara na rin ang buong program.
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Size ng login window.
            loginFrame.setSize(700, 700);
            
            // I-center sa screen automatically.
            loginFrame.setLocationRelativeTo(null);

            // Gumagawa ng LoginForm instance.
            // May callback function na tatakbo kapag successful ang login.
            LoginForm loginForm = new LoginForm(() -> {
                
                // Isasara at i-re-release ang login window.
                loginFrame.dispose();
                
                // Bubuksan na ang main system window (Dashboard, Forms, etc.)
                Mainframe mainFrame = new Mainframe();
                
                // Ipapakita ang main application window.
                mainFrame.setVisible(true);
            });

            // Nilalagay ang login form sa loob ng login window.
            loginFrame.add(loginForm);
            
            // Ipapakita ang login window.
            loginFrame.setVisible(true);
        });
    }
}
