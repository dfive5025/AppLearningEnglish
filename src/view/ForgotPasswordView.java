/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ForgotPasswordCtl;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 *
 * @author hoaianh_Kyros
 */
public class ForgotPasswordView extends javax.swing.JFrame {

    /**
     * Creates new form ForgotPwFrm
     */
    ForgotPasswordCtl fg = new ForgotPasswordCtl();
    int OTP, timeLeft, failedCount = 3;
    Timer timer;

    public ForgotPasswordView() {
        initComponents();
        this.setSize(1210, 720);
        this.setTitle("Security Verification");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        btnSendAgain.setVisible(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        this.setBtn();
        lbSendAgain.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        btnGetOTP = new javax.swing.JButton();
        txtOTP = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lbTime = new javax.swing.JLabel();
        btnSendAgain = new javax.swing.JButton();
        lbSendAgain = new javax.swing.JLabel();
        lbGetCode = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(txtUsername);
        txtUsername.setBounds(480, 270, 300, 60);

        btnGetOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetOTPActionPerformed(evt);
            }
        });
        getContentPane().add(btnGetOTP);
        btnGetOTP.setBounds(800, 370, 200, 63);

        txtOTP.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(txtOTP);
        txtOTP.setBounds(480, 370, 300, 60);

        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        getContentPane().add(btnOK);
        btnOK.setBounds(530, 560, 160, 50);

        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(20, 60, 90, 80);

        lbTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(lbTime);
        lbTime.setBounds(480, 450, 80, 40);

        btnSendAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendAgainActionPerformed(evt);
            }
        });
        getContentPane().add(btnSendAgain);
        btnSendAgain.setBounds(800, 370, 200, 60);

        lbSendAgain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SEND-removebg-preview.png"))); // NOI18N
        getContentPane().add(lbSendAgain);
        lbSendAgain.setBounds(800, 380, 202, 46);

        lbGetCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/GET-removebg-preview.png"))); // NOI18N
        getContentPane().add(lbGetCode);
        lbGetCode.setBounds(790, 370, 200, 60);

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SERCURITYVERI.png"))); // NOI18N
        getContentPane().add(lbBackground);
        lbBackground.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setBtnNoBorder(JButton button) {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }

    public void setBtn() {
        setBtnNoBorder(btnBack);
        setBtnNoBorder(btnGetOTP);
        setBtnNoBorder(btnSendAgain);
        setBtnNoBorder(btnOK);
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
    private void btnGetOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetOTPActionPerformed
        if (txtUsername.getText().isEmpty())// Kiểm tra xem trường username có rỗng hay không?
        {
            JOptionPane.showMessageDialog(null, "Must have fill in username");
        } else {
            if (fg.checkUsername(txtUsername.getText()))//Kiểm tra tài khoản đúng hay chưa?
            {
                if (!checkLockUsername(txtUsername.getText()))// Kiểm tra xem tài khoản có bị khóa hay không?
                {
                    btnGetOTP.setVisible(false);
                    lbGetCode.setVisible(false);
                    OTP = this.getOTP();
                    Time();
                    System.out.println("Your OTP: " + OTP);
                } else {
                    JOptionPane.showMessageDialog(null, "Your account doesn't change password");
                    this.dispose();
                    new LoginView();
                }

            } else {// Sai tên tài khoản 
                JOptionPane.showMessageDialog(null, "Invalid username");
                txtUsername.setText("");
            }

        }
    }//GEN-LAST:event_btnGetOTPActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (txtOTP.getText().isEmpty() || txtUsername.getText().isEmpty()) {// Kiểm tra các trường có rỗng ko?
            JOptionPane.showMessageDialog(null, "Must have complete all fields");
        } else {
            if (timeLeft <= 60 && timeLeft > 0) {// Thời gian hoạt động của OTP
                if (Integer.parseInt(txtOTP.getText()) == OTP) {
                    ForgotPasswordCtl.username = txtUsername.getText();
                    this.dispose();
                    new ResetPasswordView();
                } else {
                    fail();// Hàm nhập OTP sai
                }
            } else {
                fail();
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Bắt sự kiện nút Back
        this.dispose();
        new LoginView();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSendAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendAgainActionPerformed
        // Bắt sự kiện nút sendAgain
        Time();
        btnSendAgain.setVisible(false);
        lbSendAgain.setVisible(false);
        lbTime.setVisible(true);
        OTP = this.getOTP();
        System.out.println("Your OTP: " + OTP);
    }//GEN-LAST:event_btnSendAgainActionPerformed

    public int getOTP() {// Random OTP
        int max = 999999;
        int min = 100000;
        int radom = (int) ((Math.random()) * ((max - min) + 1));
        return radom;
    }

    public boolean checkLockUsername(String str) {// Kiểm tra tài khoản có bị khóa không?
        for (String x : ForgotPasswordCtl.lockUsernamList) {
            if (str.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void Time() { // Set up thời gian 60s
        timeLeft = 60;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (timeLeft == 0) {
                    lbTime.setText("");
                    timer.stop();
                    lbTime.setVisible(false);
                    btnSendAgain.setVisible(true);
                    lbSendAgain.setVisible(true);
                } else {
                    lbTime.setText(timeLeft-- + "s");// Hiện thị số giây
                }
            }
        });
        if (timeLeft != 0) {
            timer.start();
        }
    }

    public void fail() {// Nhập OTP sai
        if (failedCount > 1) {
            WarningtAnnounce("You have " + --failedCount + " wrong entries");
            txtOTP.setText("");
        } else {
            ForgotPasswordCtl.lockUsernamList.add(txtUsername.getText().trim());
            for (String x : ForgotPasswordCtl.lockUsernamList) {// tai khoan co bi khoa hay khong?
                System.out.println(x);
            }
            ErrorAnnounce("Your account doesn't change password");
            this.dispose();
            new LoginView();
        }
    }

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
            java.util.logging.Logger.getLogger(ForgotPasswordView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPasswordView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGetOTP;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSendAgain;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbGetCode;
    private javax.swing.JLabel lbSendAgain;
    private javax.swing.JLabel lbTime;
    private javax.swing.JTextField txtOTP;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
