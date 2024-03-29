/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RegisterCtl;
import controller.SercurityCtl;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import model.Person;

/**
 *
 * @author Admin
 */
public class RegisterView extends javax.swing.JFrame {

    /**
     * Creates new form RegisterView
     */
    RegisterCtl rg = RegisterCtl.getinstance();

    public RegisterView() {
        initComponents();
        this.setSize(1215, 720); // tao size cho Frame
        this.setVisible(true); // Hien Frame
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        this.setTitle("Register"); // tieu de Frame
        this.setLocationRelativeTo(null); // Hien thi o chinh giua man hinh
        setBtn();
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

    public boolean check() //Kiem tra cac truong rong
    {
        return txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtPasswordAgain.getText().equals("");
    }

    public boolean regexPassword(String str) // Kiem tra password co hop le hay ko? (it nhat 8 ky tu, 1 chu cai, 1 chu thuong, 1 ky tu dac biet)
    {
        String pattern = "\\A(?=\\S*?[0-9])(?=\\S*?[a-z])(?=\\S*?[A-Z])(?=\\S*?[@#$%^&+=])\\S{8,}\\z";
        return str.matches(pattern);
    }

    public void resetPassword()// Làm trắng lại Jtext Password va Jtext password again
    {
        txtPassword.setText("");
        txtPasswordAgain.setText("");
    }

    public void resetAll() // Làm trắng lại các Jtext
    {
        txtUsername.setText("");
        resetPassword();
    }

    public void setField(String username, String password)// set lại các giá trị cho Field
    {
        txtUsername.setText(username);
        txtPassword.setText(password);
        txtPasswordAgain.setText(password);
    }

    public void setBtnNoBorder(JToggleButton button) {// xóa viền của các JToggleButton
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }

    public void setBtn() { // Xóa viền của button Signup và button Back
        setBtnNoBorder(btnSignup);
        setBtnNoBorder(BtnBack);
    }

    public boolean checkEmailRegex(String str) {
        Pattern regex = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
        Matcher m = regex.matcher(str);
        if (m.find()) {
            System.out.println("Oke");
            return true;
        }
        return false;
    }

    public boolean checkPhoneRegex(String str) {
        // Bieu thuc chinh quy mo ta dinh dang so dien thoai
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        return str.matches(reg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSignup = new javax.swing.JToggleButton();
        txtUsername = new javax.swing.JTextField();
        txtPasswordAgain = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        BtnBack = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        btnSignup.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignup);
        btnSignup.setBounds(150, 560, 180, 90);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername);
        txtUsername.setBounds(30, 220, 410, 70);

        txtPasswordAgain.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPasswordAgain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordAgainKeyPressed(evt);
            }
        });
        jPanel1.add(txtPasswordAgain);
        txtPasswordAgain.setBounds(30, 460, 410, 70);

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(txtPassword);
        txtPassword.setBounds(30, 340, 410, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(600, 0, 610, 680);

        BtnBack.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });
        getContentPane().add(BtnBack);
        BtnBack.setBounds(10, 10, 120, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/REGISTERFRM.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        new LoginView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnBackActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        if (!check())// Kiểm tra xem các trường có trống hay không?
        {
            if (checkEmailRegex(txtUsername.getText()) || checkPhoneRegex(txtUsername.getText())) {
                if (!rg.checkUsername(txtUsername.getText()))// Kiểm tra tên đăng nhập đã tồn tại trong cơ sở dữ liệu chưa?
                {

                    if (txtPassword.getText().equals(txtPasswordAgain.getText()))// Kiểm tra xem nhập lại mật khẩu đã trùng khớp chưa?
                    {
                        if (regexPassword(txtPassword.getText()))// Kiểm tra mật khẩu đã phù hợp với chính sách mật khẩu chưa?
                        {
                            String username = txtUsername.getText();
                            String password = txtPassword.getText();
                            SercurityCtl serc = new SercurityCtl();
                            String hashPassword = serc.md5(password);
                            rg.setAcount(username, hashPassword);
                            this.dispose();
                            new AccounInformationView().setVisible(true);
                        } else {
                            WarningtAnnounce("Password must contain at least eight characters, "
                                    + "at least one number and both lower and uppercase letters and special characters");
                            resetPassword();
                        }
                    } else {
                        WarningtAnnounce("Password does not match. Please enter again");
                        resetPassword();
                    }
                } else {
                    WarningtAnnounce("Username is exits. Please enter again");
                    resetAll();
                }
            } else {
                WarningtAnnounce("Wrong format email or telephone");
            }
        } else {
            WarningtAnnounce("Must have complete all files ");
            resetAll();
        }
    }//GEN-LAST:event_btnSignupActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordAgainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordAgainKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!check())// Kiểm tra xem các trường có trống hay không?
            {
                if (checkEmailRegex(txtUsername.getText()) || checkPhoneRegex(txtUsername.getText())) {
                    if (!rg.checkUsername(txtUsername.getText()))// Kiểm tra tên đăng nhập đã tồn tại trong cơ sở dữ liệu chưa?
                    {

                        if (txtPassword.getText().equals(txtPasswordAgain.getText()))// Kiểm tra xem nhập lại mật khẩu đã trùng khớp chưa?
                        {
                            if (regexPassword(txtPassword.getText()))// Kiểm tra mật khẩu đã phù hợp với chính sách mật khẩu chưa?
                            {
                                String username = txtUsername.getText();
                                String password = txtPassword.getText();
                                SercurityCtl serc = new SercurityCtl();
                                String hashPassword = serc.md5(password);
                                rg.setAcount(username, hashPassword);
                                this.dispose();
                                new AccounInformationView().setVisible(true);
                            } else {
                                WarningtAnnounce("Password must contain at least eight characters, "
                                        + "at least one number and both lower and uppercase letters and special characters");
                                resetPassword();
                            }
                        } else {
                            WarningtAnnounce("Password does not match. Please enter again");
                            resetPassword();
                        }
                    } else {
                        WarningtAnnounce("Username is exits. Please enter again");
                        resetAll();
                    }
                } else {
                    WarningtAnnounce("Wrong format email or telephone");
                }
            } else {
                WarningtAnnounce("Must have complete all files ");
                resetAll();
            }
        }
    }//GEN-LAST:event_txtPasswordAgainKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnBack;
    private javax.swing.JToggleButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordAgain;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
