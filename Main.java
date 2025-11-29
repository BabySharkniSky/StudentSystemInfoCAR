/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.Main;

import studentinfo.ui.Mainframe;
import javax.swing.*;
import studentinfo.form.LoginForm;

// Main class ng program — ito ang entry point ng application.
// Ibig sabihin, dito magsisimula ang execution ng buong program.
public class Main {
    
    // Main method — required sa lahat ng Java applications.
    // Pag ni-run ang program, dito agad papasok ang execution.
    public static void main(String[] args) {
        
        // STEP 1: Set Look and Feel
        // Sinusubukan natin i-apply yung system theme ng OS.
        // Para native look yung UI (Windows sa Windows, Mac sa Mac, etc.)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Kung may error sa pag-set ng look and feel,
            // i-print lang natin sa console para ma-check.
            e.printStackTrace();
        }

        // STEP 2: Ipakita ang Login Window
        // Ginagamit ang invokeLater para siguradong UI thread ang nagha-handle ng Swing components.
        SwingUtilities.invokeLater(() -> {
            
            // Gumagawa ng JFrame para sa Login screen
            JFrame loginFrame = new JFrame("Student Information System - Login");
            
            // Kapag sinara ang login window, sasara rin ang buong program
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Set size ng login window
            loginFrame.setSize(700, 700);
            
            // I-center sa screen
            loginFrame.setLocationRelativeTo(null);

            // Gumagawa ng LoginForm instance
            // May callback na tatakbo kapag successful ang login
            LoginForm loginForm = new LoginForm(() -> {
                
                // Isasara ang login window
                loginFrame.dispose();
                
                // Bubuksan na ang main system window (Dashboard at iba pang forms)
                Mainframe mainFrame = new Mainframe();
                
                // Ipapakita ang main application window
                mainFrame.setVisible(true);
            });

            // Idadagdag ang login form sa login window
            loginFrame.add(loginForm);
            
            // Ipapakita ang login window
            loginFrame.setVisible(true);
        });
    }
}

