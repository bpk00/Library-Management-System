package learning.librarymanagementsystem;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Login extends javax.swing.JFrame {

    // For importing username and password from config.properties
    private String configUsername;
    private String configPassword;

    public Login() {
        initComponents();
        setTitle("Login - Library Management System");
        loadConfig(); // Load credentials from config file
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 0, 153));
        setResizable(false);
        setSize(new java.awt.Dimension(1153, 606));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 66, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 66, -1));
        getContentPane().add(jTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 250, 33));
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 250, 33));

        jButtonLogin.setBackground(new java.awt.Color(33, 57, 114));
        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 110, 40));

        jButtonClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonClose.setForeground(new java.awt.Color(33, 57, 114));
        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, 110, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Login");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 280, 100));

        jLabel4.setBackground(new java.awt.Color(51, 51, 255));
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/b.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 610));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 770, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Import username and password from config.properties
    private void loadConfig() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties");) { 
            props.load(fis); 
            configUsername = props.getProperty("sys.username");
            configPassword = props.getProperty("sys.password");

            // Check if properties are missing
            if (configUsername == null || configPassword == null) {
                JOptionPane.showMessageDialog(this, "Error: Missing required properties (username or password).");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading config file:\n" + e.getMessage());
        }
    } 

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // Get password as a char[] for better security
        char[] inputPassword = jPasswordField.getPassword();
        String inputPasswordStr = new String(inputPassword);
        
        // Validate credentials
        if (jTextField.getText().equals(configUsername) && inputPasswordStr.equals(configPassword)) {
            setVisible(false);
            new Home().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextField;
    // End of variables declaration//GEN-END:variables
}
