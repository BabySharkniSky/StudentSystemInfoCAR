/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.form;

import javax.swing.*;
import studentinfo.util.Kulay;
import studentinfo.controller.CustomButton;
import studentinfo.controller.RoundPanel;
import java.awt.*;

public class LoginForm extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private CustomButton signInButton;
    private JLabel messageLabel;

    public LoginForm(Runnable onSuccessfulLogin) {
        setLayout(new GridBagLayout());
        setBackground(Kulay.WHITE);
        initComponents(onSuccessfulLogin);
    }

    private void initComponents(Runnable onSuccessfulLogin) {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        RoundPanel loginPanel = new RoundPanel(30);
        loginPanel.setBackground(Kulay.LIGHT_GRAY);
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setPreferredSize(new Dimension(400, 450));

        GridBagConstraints panelGbc = new GridBagConstraints();
        panelGbc.insets = new Insets(15, 30, 15, 30);
        panelGbc.fill = GridBagConstraints.HORIZONTAL;
        panelGbc.gridx = 0;

        JLabel titleLabel = new JLabel("STUDENT INFORMATION SYSTEM");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleLabel.setForeground(Kulay.CAVIAR);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelGbc.gridy = 0;
        panelGbc.insets = new Insets(30, 30, 10, 30);
        loginPanel.add(titleLabel, panelGbc);

        JLabel subtitleLabel = new JLabel("Sign in to start?");
        subtitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        subtitleLabel.setForeground(Kulay.CHARCOAL);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelGbc.gridy = 1;
        panelGbc.insets = new Insets(0, 30, 30, 30);
        loginPanel.add(subtitleLabel, panelGbc);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameLabel.setForeground(Kulay.CAVIAR);
        panelGbc.gridy = 2;
        panelGbc.insets = new Insets(15, 30, 5, 30);
        loginPanel.add(usernameLabel, panelGbc);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameField.setPreferredSize(new Dimension(340, 40));
        usernameField.setBackground(Kulay.LIGHT_GRAY);
        usernameField.setForeground(Kulay.CAVIAR);
        usernameField.setCaretColor(Kulay.CHARCOAL);
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Kulay.BORDER_DARK, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        panelGbc.gridy = 3;
        panelGbc.insets = new Insets(0, 30, 15, 30);
        loginPanel.add(usernameField, panelGbc);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordLabel.setForeground(Kulay.CAVIAR);
        panelGbc.gridy = 4;
        panelGbc.insets = new Insets(15, 30, 5, 30);
        loginPanel.add(passwordLabel, panelGbc);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setPreferredSize(new Dimension(340, 40));
        passwordField.setBackground(Kulay.LIGHT_GRAY);
        passwordField.setForeground(Kulay.CAVIAR);
        passwordField.setCaretColor(Kulay.CHARCOAL);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Kulay.BORDER_DARK, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        panelGbc.gridy = 5;
        panelGbc.insets = new Insets(0, 30, 20, 30);
        loginPanel.add(passwordField, panelGbc);

        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        messageLabel.setForeground(Kulay.CAVIAR);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelGbc.gridy = 6;
        panelGbc.insets = new Insets(0, 30, 10, 30);
        loginPanel.add(messageLabel, panelGbc);

        signInButton = new CustomButton("Sign In");
        signInButton.setPreferredSize(new Dimension(340, 45));
        signInButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        signInButton.addActionListener(e -> handleSignIn(onSuccessfulLogin));
        panelGbc.gridy = 7;
        panelGbc.insets = new Insets(10, 30, 30, 30);
        loginPanel.add(signInButton, panelGbc);

        passwordField.addActionListener(e -> handleSignIn(onSuccessfulLogin));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(loginPanel, gbc);
    }

    private void handleSignIn(Runnable onSuccessfulLogin) {

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            showMessage("Please enter username and password", false);
            return;
        }

        if (username.equals("basta") && password.equals("basta")) {

            showMessage("Login successfully!", true);

            Timer timer = new Timer(500, e -> {
                if (onSuccessfulLogin != null) {
                    onSuccessfulLogin.run();
                }
            });

            timer.setRepeats(false);
            timer.start();

        } else {
            showMessage("Invalid username or password", false);
            passwordField.setText("");
        }
    }

    private void showMessage(String message, boolean isSuccess) {
        messageLabel.setText(message);
        messageLabel.setForeground(isSuccess ? Kulay.CAVIAR : Kulay.CAVIAR);
    }
}
