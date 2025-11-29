/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentinfo.form;

/**
 *
 * @author Maine
 */
    
import javax.swing.*;
import studentinfo.util.Kulay;
import studentinfo.controller.CustomButton;
import studentinfo.controller.RoundPanel;
import java.awt.*;

// Okay guys, so ito yung LoginForm class natin
// Nag-extend siya ng JPanel para makagawa tayo ng custom panel para sa login screen
public class LoginForm extends JPanel {
    
    // So meron tayong four main components dito sa login form
    // Una, yung usernameField - dito mag-type yung user ng username
    private JTextField usernameField;
    
    // Pangalawa, yung passwordField - dito naman yung password, naka-hidden yung characters
    private JPasswordField passwordField;
    
    // Pangatlo, yung signInButton - yung button na iki-click para mag-login
    private CustomButton signInButton;
    
    // At lastly, yung messageLabel - dito lalabas yung success or error messages
    private JLabel messageLabel;
    
    // Alright, so ito yung constructor ng LoginForm
    // Notice ha, may parameter tayo na Runnable - ito yung callback function
    // Tatawagan natin to kapag successful yung login
    public LoginForm(Runnable onSuccessfulLogin) {
        // First thing, i-set natin yung layout to GridBagLayout
        // Ginagamit natin to para flexible yung positioning ng components
        setLayout(new GridBagLayout());
        
        // Tapos i-set natin yung background color to white
        // Para clean and professional yung look
        setBackground(Kulay.WHITE);
        
        // Then tawagin natin yung initComponents method
        // Doon natin gagawin lahat ng UI elements
        initComponents(onSuccessfulLogin);
    }
    
    // Okay, so ito na yung main method kung saan gagawin natin lahat ng UI components
    // Medyo mahaba to pero step by step lang tayo
    private void initComponents(Runnable onSuccessfulLogin) {
        
        // STEP 1: Setup ng main container constraints
        // Gumawa muna tayo ng GridBagConstraints para sa positioning
        GridBagConstraints gbc = new GridBagConstraints();
        
        // I-set yung insets - ito yung spacing around ng components
        // Format: top, left, bottom, right - lahat 10 pixels
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // STEP 2: Create ng login panel container
        // So gumawa tayo ng RoundPanel - ito yung custom component natin with rounded corners
        // Yung 30 is yung radius ng corners in pixels
        RoundPanel loginPanel = new RoundPanel(30);
        
        // I-set yung background color to light gray
        loginPanel.setBackground(Kulay.LIGHT_GRAY);
        
        // I-set din yung layout nito to GridBagLayout
        loginPanel.setLayout(new GridBagLayout());
        
        // Tapos i-set yung preferred size - 400 pixels wide, 450 pixels tall
        // Perfect size para sa login form
        loginPanel.setPreferredSize(new Dimension(400, 450));
        
        // STEP 3: Setup ng panel constraints
        // Gumawa ulit tayo ng constraints pero ito para sa loob ng login panel
        GridBagConstraints panelGbc = new GridBagConstraints();
        
        // I-set yung insets - 15 sa top/bottom, 30 sa left/right
        // Mas malaki yung horizontal padding para maganda tignan
        panelGbc.insets = new Insets(15, 30, 15, 30);
        
        // I-set yung fill to HORIZONTAL - meaning mag-stretch horizontally yung components
        panelGbc.fill = GridBagConstraints.HORIZONTAL;
        
        // I-set yung gridx to 0 - meaning lahat ng components nasa column 0
        // One column lang kasi lahat vertically aligned
        panelGbc.gridx = 0;
        
        // STEP 4: Create ng title label
        // So gumawa tayo ng label para sa title - "Student Information System"
        JLabel titleLabel = new JLabel("STUDENT INFORMATION SYSTEM");
        
        // I-set yung font - Tahoma, bold, size 22
        // Bold para emphasized, size 22 para malaki at clear
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        // I-set yung foreground color - ito yung text color
        titleLabel.setForeground(Kulay.CAVIAR);
        
        // I-set na naka-center yung text
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // I-set yung position - row 0 (pinakataas)
        panelGbc.gridy = 0;
        
        // I-set custom insets para sa title - 30 sa top, 10 sa bottom
        // Mas malaki yung top padding para may breathing room
        panelGbc.insets = new Insets(30, 30, 10, 30);
        
        // Finally, i-add yung title label sa login panel
        loginPanel.add(titleLabel, panelGbc);
        
        // STEP 5: Create ng subtitle label
        // Ito yung "Sign in to continue" text
        JLabel subtitleLabel = new JLabel("Sign in to start?");
        
        // I-set yung font - Tahoma, plain (not bold), size 14
        // Smaller and plain para hindi competing sa main title
        subtitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // I-set yung color to charcoal - lighter gray, para subtle lang
        subtitleLabel.setForeground(Kulay.CHARCOAL);
        
        // I-set din na center aligned
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // I-set yung position - row 1 (below ng title)
        panelGbc.gridy = 1;
        
        // I-set yung insets - 0 sa top, 30 sa bottom
        // Malaki yung bottom space para may gap before ng input fields
        panelGbc.insets = new Insets(0, 30, 30, 30);
        
        // I-add yung subtitle sa login panel
        loginPanel.add(subtitleLabel, panelGbc);
        
        // STEP 6: Create ng username label
        // Ito yung label na nagsasabing "Username"
        JLabel usernameLabel = new JLabel("Username");
        
        // I-set yung font - size 14, plain style
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // I-set yung text color
        usernameLabel.setForeground(Kulay.CAVIAR);
        
        // I-set yung position - row 2
        panelGbc.gridy = 2;
        
        // I-set yung insets - 15 sa top, 5 lang sa bottom
        // Maliit lang yung bottom kasi malapit lang dapat sa input field
        panelGbc.insets = new Insets(15, 30, 5, 30);
        
        // I-add sa panel
        loginPanel.add(usernameLabel, panelGbc);
        
        // STEP 7: Create ng username text field
        // Ito na yung actual input field kung saan mag-type yung user
        usernameField = new JTextField();
        
        // I-set yung font ng text na ita-type
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // I-set yung size - 340 pixels wide, 40 pixels tall
        // 340 para perfect fit sa 400-wide panel with padding
        usernameField.setPreferredSize(new Dimension(340, 40));
        
        // I-set yung background color ng input field
        usernameField.setBackground(Kulay.LIGHT_GRAY);
        
        // I-set yung text color pag nag-type na yung user
        usernameField.setForeground(Kulay.CAVIAR);
        
        // I-set yung caret color - yung blinking cursor
        usernameField.setCaretColor(Kulay.CHARCOAL);
        
        // Okay, so ito medyo complicated - compound border
        // Parang layered border siya - may outer at inner border
        usernameField.setBorder(BorderFactory.createCompoundBorder(
            // Outer border - ito yung visible line around ng field
            // 1 pixel thick, dark border color
            BorderFactory.createLineBorder(Kulay.BORDER_DARK, 1),
            
            // Inner border - ito naman yung padding sa loob
            // 5 pixels top/bottom, 10 pixels left/right
            // Para hindi dumikit yung text sa border
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        // I-set yung position - row 3 (below ng username label)
        panelGbc.gridy = 3;
        
        // I-set yung insets - 0 sa top, 15 sa bottom
        panelGbc.insets = new Insets(0, 30, 15, 30);
        
        // I-add yung username field sa panel
        loginPanel.add(usernameField, panelGbc);
        
        // STEP 8: Create ng password label
        // Same concept lang sa username label
        JLabel passwordLabel = new JLabel("Password");
        
        // I-set yung font
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // I-set yung color
        passwordLabel.setForeground(Kulay.CAVIAR);
        
        // I-set yung position - row 4
        panelGbc.gridy = 4;
        
        // I-set yung insets - 15 top, 5 bottom
        panelGbc.insets = new Insets(15, 30, 5, 30);
        
        // I-add sa panel
        loginPanel.add(passwordLabel, panelGbc);
        
        // STEP 9: Create ng password field
        // Same lang ito sa username field pero naka-hide yung characters
        // Pag nag-type ka, dots or asterisks lang makikita instead ng actual text
        passwordField = new JPasswordField();
        
        // I-set yung font
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // I-set yung size - same dimensions sa username field
        passwordField.setPreferredSize(new Dimension(340, 40));
        
        // I-set yung background
        passwordField.setBackground(Kulay.LIGHT_GRAY);
        
        // I-set yung text color
        passwordField.setForeground(Kulay.CAVIAR);
        
        // I-set yung cursor color
        passwordField.setCaretColor(Kulay.CHARCOAL);
        
        // I-set yung border - same compound border setup
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            // Outer border - 1 pixel line
            BorderFactory.createLineBorder(Kulay.BORDER_DARK, 1),
            
            // Inner padding - 5 top/bottom, 10 left/right
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        // I-set yung position - row 5
        panelGbc.gridy = 5;
        
        // I-set yung insets - 0 top, 20 bottom
        // Medyo malaki yung bottom space before ng button
        panelGbc.insets = new Insets(0, 30, 20, 30);
        
        // I-add sa panel
        loginPanel.add(passwordField, panelGbc);
        
        // STEP 10: Create ng message label
        // Ito yung label kung saan lalabas yung error or success messages
        // Initially blank lang siya
        messageLabel = new JLabel("");
        
        // I-set yung font - smaller size, 12 lang
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        // I-set yung color
        messageLabel.setForeground(Kulay.CAVIAR);
        
        // I-set na centered
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // I-set yung position - row 6
        panelGbc.gridy = 6;
        
        // I-set yung insets - 0 top, 10 bottom
        panelGbc.insets = new Insets(0, 30, 10, 30);
        
        // I-add sa panel
        loginPanel.add(messageLabel, panelGbc);
        
        // STEP 11: Create ng sign in button
        // Ito yung main button para mag-login
        signInButton = new CustomButton("Sign In");
        
        // I-set yung size - 340 wide (same width sa input fields), 45 tall
        signInButton.setPreferredSize(new Dimension(340, 45));
        
        // I-set yung font - bold para emphasized, size 14
        signInButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        // Now ito yung action listener - ano mangyayari pag na-click yung button
        // Tatawagin natin yung handleSignIn method
        // Yung "e ->" is lambda expression - shorthand way ng writing listener
        signInButton.addActionListener(e -> handleSignIn(onSuccessfulLogin));
        
        // I-set yung position - row 7 (last row)
        panelGbc.gridy = 7;
        
        // I-set yung insets - 10 top, 30 bottom
        panelGbc.insets = new Insets(10, 30, 30, 30);
        
        // I-add yung button sa panel
        loginPanel.add(signInButton, panelGbc);
        
        // STEP 12: Add Enter key support
        // So gusto natin na pag nag-type ng password tapos nag-press ng Enter,
        // mag-trigger din yung sign in, hindi kailangan i-click pa yung button
        // Kaya nag-add tayo ng action listener sa password field
        passwordField.addActionListener(e -> handleSignIn(onSuccessfulLogin));
        
        // STEP 13: Add login panel to main panel
        // So tapos na tayong gumawa ng lahat ng components sa login panel
        // I-add na natin yung login panel sa main LoginForm panel
        
        // I-set yung position sa center
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        // I-add yung login panel - ito na yung final step sa initComponents
        add(loginPanel, gbc);
    }
    
    // Okay guys, so ito yung method na nag-hahandle ng sign in logic
    // Tatawagin ito kapag na-click yung sign in button or nag-press ng Enter
    private void handleSignIn(Runnable onSuccessfulLogin) {
        
        // STEP 1: Get user input
        // Kunin natin yung username na in-type ng user
        // Yung trim() is para tanggalin yung extra spaces sa start at end
        String username = usernameField.getText().trim();
        
        // Kunin din yung password
        // Yung getPassword() nag-rereturn ng char array for security
        // Kaya kailangan natin i-convert to String
        String password = new String(passwordField.getPassword());
        
        // STEP 2: Validate na may laman
        // I-check natin kung empty yung username or password
        if (username.isEmpty() || password.isEmpty()) {
            // Kung empty, ipakita yung error message
            // Yung false parameter means error message siya (not success)
            showMessage("Please enter username and password", false);
            
            // Return agad para hindi mag-proceed sa login validation
            return;
        }
        
        // STEP 3: Validate credentials
        // I-check natin kung tama yung username and password
        // For now, simple lang - "admin" and "admin"
        // Pero later pwede natin i-connect sa database for real authentication
        if (username.equals("basta") && password.equals("basta")) {
            
            // STEP 3A: Successful login
            // Kung tama yung credentials, ipakita success message
            // Yung true parameter means success message siya
            showMessage("Login successfully!", true);
            
            // Gumawa tayo ng timer para may delay before mag-open yung main window
            // 500 milliseconds or 0.5 seconds yung delay
            // Para makita muna ng user yung success message
            Timer timer = new Timer(500, e -> {
                // I-check kung may callback function
                if (onSuccessfulLogin != null) {
                    // Tawagin yung callback - ito yung mag-oopen ng main application
                    // At isa-sara yung login window
                    onSuccessfulLogin.run();
                }
            });
            
            // I-set na one-time lang yung timer, hindi mag-repeat
            timer.setRepeats(false);
            
            // I-start yung timer
            timer.start();
            
        } else {
            // STEP 3B: Failed login
            // Kung mali yung credentials, ipakita error message
            showMessage("Invalid username or password", false);
            
            // I-clear yung password field for security
            // Para hindi na-expose yung password kung mali
            passwordField.setText("");
        }
    }
    
    // Helper method para i-display yung messages
    // Ginagamit natin to para ipakita yung success or error messages
    private void showMessage(String message, boolean isSuccess) {
        
        // I-set yung text ng message label
        messageLabel.setText(message);
        
        // I-set yung color depending kung success or error
        // Sa case natin, same color lang both - Colors.CAVIAR
        // Pero pwede natin i-customize later - green for success, red for error
        messageLabel.setForeground(isSuccess ? Kulay.CAVIAR : Kulay.CAVIAR);
        // Note: Ternary operator yan - shorthand ng if-else
        // Kung true yung isSuccess, gamitin Colors.CAVIAR, kung false, Colors.CAVIAR din
    }
}