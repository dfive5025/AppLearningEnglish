package view;

import controller.LoginCtl;
import controller.SercurityCtl;
import controller.TopicCtl;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import model.Person;
import model.PersonWord;

/**
 *
 * @author Admin
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrm
     */
    public Preferences pref = Preferences.userRoot().node("Remember");

    public LoginView() {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Arial", Font.PLAIN, 18)));
        UIManager.put("OptionPane.titleFont", new FontUIResource(new Font(
                "Arial", Font.BOLD, 30)));
        initComponents();
        this.setSize(1215, 725);// Kích thước
        this.setTitle("Login"); // Tiêu đề
        this.setLocationRelativeTo(null); // Khi hiển thị thì Jframe ở chính giữa màn hình
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        String username = null;
        username = pref.get("username", username);
        String password = null;
        password = pref.get("password", password);
        if (username != null) {
            checkBoxRememberPw.setSelected(true);
        } else {
            checkBoxRememberPw.setSelected(false);
        }
        txtUsername.setText(username);
        txtPassword.setText(password);
        lbHide.setVisible(true);
        lbShow.setVisible(false);
        setBtn();
        btnLogin.setMnemonic(KeyEvent.VK_ENTER); //ATL+ENTER
        this.setVisible(true);// Hiển thị Jframe
    }

    public void setBtnNoBorder(JButton button) {// Xóa viền button
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    public void setBtn() {// Xóa viền button Register và button Login
        setBtnNoBorder(btnLogin);
        setBtnNoBorder(btnRegister);
        setBtnNoBorder(btnPower);
        setBtnNoBorder(btnForgot);
    }

    public void SuccessAnnouunce(String str) {// Hiện thị thông báo
        Icon icon = new javax.swing.ImageIcon(getClass().getResource("/image/success.png"));
        JOptionPane.showMessageDialog(null, str, "Success", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public void ErrorAnnounce(String str) {// Hiện thị thông báo
        Icon icon = new javax.swing.ImageIcon(getClass().getResource("/image/error.png"));
        JOptionPane.showMessageDialog(null, str, "Error", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public void WarningtAnnounce(String str) {// Hiện thị thông báo
        Icon icon = new javax.swing.ImageIcon(getClass().getResource("/image/warning.png"));
        JOptionPane.showMessageDialog(null, str, "Warning", JOptionPane.WARNING_MESSAGE, icon);
    }

    public boolean check() { // Kiểm tra các trường nhập có trường nào rỗng không?
        return txtUsername.getText().equals("") || txtPassword.getText().equals("");
    }

    public boolean checkEmailRegex(String str) {
        Pattern regex = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
        Matcher m = regex.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public boolean checkPhoneRegex(String str) {
        // Bieu thuc chinh quy mo ta dinh dang so dien thoai
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        return str.matches(reg);
    }

    public void reset() {// Làm trắng các trường nhập
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public void saveAccount(String username, String password) {
        pref.put("username", username);
        pref.put("password", password);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        lbHide = new javax.swing.JLabel();
        lbShow = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnPower = new javax.swing.JButton();
        btnForgot = new javax.swing.JButton();
        checkBoxRememberPw = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsername);
        txtUsername.setBounds(510, 250, 380, 50);

        lbHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hide_1.png"))); // NOI18N
        lbHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHideMouseClicked(evt);
            }
        });
        getContentPane().add(lbHide);
        lbHide.setBounds(910, 330, 60, 50);

        lbShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/show_1.png"))); // NOI18N
        lbShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbShowMouseClicked(evt);
            }
        });
        getContentPane().add(lbShow);
        lbShow.setBounds(910, 330, 40, 50);

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(txtPassword);
        txtPassword.setBounds(510, 330, 380, 50);

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(490, 450, 200, 60);

        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister);
        btnRegister.setBounds(610, 510, 260, 60);

        btnPower.setOpaque(false);
        btnPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPowerActionPerformed(evt);
            }
        });
        getContentPane().add(btnPower);
        btnPower.setBounds(1080, 50, 70, 60);

        btnForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotActionPerformed(evt);
            }
        });
        getContentPane().add(btnForgot);
        btnForgot.setBounds(790, 400, 190, 50);

        checkBoxRememberPw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRememberPwActionPerformed(evt);
            }
        });
        getContentPane().add(checkBoxRememberPw);
        checkBoxRememberPw.setBounds(525, 410, 20, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login8.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Bắt sự kiện button Login
        if (!check())// Nếu các trường đều được nhập
        {
            if (checkEmailRegex(txtUsername.getText()) || checkPhoneRegex(txtUsername.getText())) {
                SercurityCtl serc = new SercurityCtl();
                String hashPassword = serc.md5(txtPassword.getText());
                if (new LoginCtl().checkAccount(txtUsername.getText(), hashPassword))// Kiểm tra tài khoản, mật khẩu?
                {
                    if (checkBoxRememberPw.isSelected()) {
                        saveAccount(txtUsername.getText(), txtPassword.getText());
                    } else {
                        try {
                            pref.clear();
                        } catch (BackingStoreException ex) {
                            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    SuccessAnnouunce("Login successfully");
                    TopicCtl.idperson = new LoginCtl().getIDPerson(txtUsername.getText(), hashPassword);
                    this.dispose();
                    TopicCtl.uIsAdmin = new LoginCtl().getIsAdmin(TopicCtl.idperson);
                    if (TopicCtl.uIsAdmin == 1) {
                        new AdminManagerView();
                    } else {
                        new HomeView();
                    }
                } else {
                    ErrorAnnounce("Invalid username or password");
                    reset();
                }
            } else {
                WarningtAnnounce("Invalid username or password");
                reset();
            }
        } else {
            WarningtAnnounce("Must have complete all fields");
        }
    }//GEN-LAST:event_btnLoginActionPerformed


    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed

    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        this.dispose();
        new RegisterView();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowerActionPerformed
        Icon icon = new javax.swing.ImageIcon(getClass().getResource("/image/warning.png"));
        int input = JOptionPane.showConfirmDialog(rootPane, "Do you want to exit", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        if (input == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnPowerActionPerformed

    private void btnForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotActionPerformed
        this.dispose();
        new ForgotPasswordView();
    }//GEN-LAST:event_btnForgotActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!check())// Nếu các trường đều được nhập
            {
                if (checkEmailRegex(txtUsername.getText()) || checkPhoneRegex(txtUsername.getText())) {
                    SercurityCtl serc = new SercurityCtl();
                    String hashPassword = serc.md5(txtPassword.getText());
                    if (new LoginCtl().checkAccount(txtUsername.getText(), hashPassword))// Kiểm tra tài khoản, mật khẩu?
                    {
                        if (checkBoxRememberPw.isSelected()) {
                            saveAccount(txtUsername.getText(), txtPassword.getText());
                        } else {
                            try {
                                pref.clear();
                            } catch (BackingStoreException ex) {
                                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        SuccessAnnouunce("Login successfully");
                        TopicCtl.idperson = new LoginCtl().getIDPerson(txtUsername.getText(), hashPassword);
                        this.dispose();
                        TopicCtl.uIsAdmin = new LoginCtl().getIsAdmin(TopicCtl.idperson);
                        if (TopicCtl.uIsAdmin == 1) {
                            new AdminManagerView();
                        } else {
                            new HomeView();
                        }
                    } else {
                        ErrorAnnounce("Invalid username or password");
                        reset();
                    }
                } else {
                    WarningtAnnounce("Invalid username or password");
                    reset();
                }
            } else {
                WarningtAnnounce("Must have complete all fields");
            }
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void lbHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHideMouseClicked
        txtPassword.setEchoChar((char) 0);
        lbHide.setVisible(false);
        lbShow.setVisible(true);
    }//GEN-LAST:event_lbHideMouseClicked

    private void lbShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShowMouseClicked
        txtPassword.setEchoChar('*');
        lbHide.setVisible(true);
        lbShow.setVisible(false);
    }//GEN-LAST:event_lbShowMouseClicked

    private void checkBoxRememberPwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRememberPwActionPerformed

    }//GEN-LAST:event_checkBoxRememberPwActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForgot;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnPower;
    private javax.swing.JButton btnRegister;
    private javax.swing.JCheckBox checkBoxRememberPw;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbHide;
    private javax.swing.JLabel lbShow;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
