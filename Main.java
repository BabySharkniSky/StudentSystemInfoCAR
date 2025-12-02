package studentinfo.Main;

import studentinfo.ui.Mainframe;
import javax.swing.*;
import studentinfo.form.LoginForm;

public class Main {
    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            
            JFrame loginFrame = new JFrame("Student Information System - Login");
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setSize(700, 700);
            loginFrame.setLocationRelativeTo(null);

            LoginForm loginForm = new LoginForm(() -> {
                loginFrame.dispose();
                Mainframe mainFrame = new Mainframe();
                mainFrame.setVisible(true);
            });

            loginFrame.add(loginForm);
            loginFrame.setVisible(true);
        });
    }
}
