/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AdminManagerCtl;
import controller.HomeCtl;
import controller.ListCtl;
import controller.StatisticalCtl;
import controller.TopicCtl;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import model.Person;

import java.awt.Image;

/**
 *
 * @author Admin
 */
public class HomeView extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    ListCtl listCtl = new ListCtl();
    HomeCtl a = new HomeCtl();

    public HomeView() {
        initComponents();
        this.setSize(1220, 715);
        this.setTitle("Home");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        setBtn();
        Updaterank();
    }

    public void setBtnNoBorder(JButton button) {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }

    public void setBtnNoBorder(JToggleButton button) {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }

    public void setBtn() {
        setBtnNoBorder(btnSearch);
        setBtnNoBorder(btnTopic);
        setBtnNoBorder(btnMyList);
        setBtnNoBorder(btnGame);
        setBtnNoBorder(btnProfile);
        setBtnNoBorder(btnRank);
        setBtnNoBorder(btnLogout);
    }

    public void WarningtAnnounce(String str) {// Hiện thị thông báo
        Icon icon = new javax.swing.ImageIcon(getClass().getResource("/image/warning.png"));
        JOptionPane.showMessageDialog(null, str, "Warning", JOptionPane.WARNING_MESSAGE, icon);
    }
    ArrayList<Person> personList;
    StatisticalCtl rankCtl = new StatisticalCtl();

    private void Updaterank() {
        personList = rankCtl.getRank2();
        int rank = 0;
        for (Person x : personList) {
            if (TopicCtl.idperson == x.getIdperson()) {
                rank = x.getuMyrank();
                a.updateRank(x.getIdperson(), rank);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        btnRank = new javax.swing.JButton();
        btnTopic = new javax.swing.JButton();
        btnMyList = new javax.swing.JButton();
        btnGame = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(150, 120, 230, 270);

        btnRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankActionPerformed(evt);
            }
        });
        getContentPane().add(btnRank);
        btnRank.setBounds(820, 400, 230, 260);

        btnTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopicActionPerformed(evt);
            }
        });
        getContentPane().add(btnTopic);
        btnTopic.setBounds(510, 120, 230, 270);

        btnMyList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyListActionPerformed(evt);
            }
        });
        getContentPane().add(btnMyList);
        btnMyList.setBounds(830, 120, 230, 270);

        btnGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnGame);
        btnGame.setBounds(160, 410, 230, 250);

        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        getContentPane().add(btnProfile);
        btnProfile.setBounds(510, 400, 230, 260);

        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout);
        btnLogout.setBounds(1100, 0, 90, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home_screen.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -30, 1220, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankActionPerformed
        this.dispose();
        new RankView();
    }//GEN-LAST:event_btnRankActionPerformed

    private void btnGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameActionPerformed
        this.dispose();
        new GameHomeView();
    }//GEN-LAST:event_btnGameActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        this.dispose();
        new ProfileView();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.dispose();
        new SearchView();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopicActionPerformed
        this.dispose();
        new TopicView();
    }//GEN-LAST:event_btnTopicActionPerformed

    private void btnMyListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyListActionPerformed
        ListCtl a = new ListCtl();
        if (a.checkIDperson(TopicCtl.idperson)) {
            this.dispose();
            new ListView();
        } else {
            WarningtAnnounce("Your list is empty");
        }
    }//GEN-LAST:event_btnMyListActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int input = JOptionPane.showConfirmDialog(rootPane, "Do you want to log out", "Log out", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (input == 0) {
            this.dispose();
            new LoginView();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGame;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyList;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnRank;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTopic;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
