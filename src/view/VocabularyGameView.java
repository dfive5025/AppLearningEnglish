/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

/**
 *
 * @author hoaianh_Kyros
 */
public class VocabularyGameView extends javax.swing.JFrame {

    /**
     * Creates new form VocabularyGameFrm
     */
    public VocabularyGameView() {
        initComponents();
        this.setSize(1210,698);//Kích thước
        this.setVisible(true);// Hiện thị Jframe
        this.setLocationRelativeTo(null);// Hiện thị giữa màn hình
        this.setTitle("Vocabulary's Game");// Tiêu đề
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        setBtn();
    }

    public void setBtnNoBorder(JButton button)// Xóa viền button
    {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // Especially important
    }
    
    public void setBtn()// Xóa viền các button có trong Jframe
    {
        setBtnNoBorder(btnGameArrangeWord);
        setBtnNoBorder(btnGameSelectWord);
        setBtnNoBorder(btnGameCompleteWord);
        setBtnNoBorder(btnGameSolveItOut);
        setBtnNoBorder(btnBack);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGameArrangeWord = new javax.swing.JButton();
        btnGameSelectWord = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnGameCompleteWord = new javax.swing.JButton();
        btnGameSolveItOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnGameArrangeWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameArrangeWordActionPerformed(evt);
            }
        });
        getContentPane().add(btnGameArrangeWord);
        btnGameArrangeWord.setBounds(680, 100, 320, 280);

        btnGameSelectWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameSelectWordActionPerformed(evt);
            }
        });
        getContentPane().add(btnGameSelectWord);
        btnGameSelectWord.setBounds(200, 120, 330, 260);

        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(1090, 10, 90, 100);

        btnGameCompleteWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameCompleteWordActionPerformed(evt);
            }
        });
        getContentPane().add(btnGameCompleteWord);
        btnGameCompleteWord.setBounds(190, 390, 330, 260);

        btnGameSolveItOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameSolveItOutActionPerformed(evt);
            }
        });
        getContentPane().add(btnGameSolveItOut);
        btnGameSolveItOut.setBounds(700, 390, 320, 260);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vocabulary_screen.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // bắt sự kiện nút Back
        this.dispose();
        new GameHomeView();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGameArrangeWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameArrangeWordActionPerformed
        // Bắt sự kiện nút game sắp xếp từ
        this.dispose();
        new RearrangeIntroView();
    }//GEN-LAST:event_btnGameArrangeWordActionPerformed

    private void btnGameSelectWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameSelectWordActionPerformed
        // Bắt sự kiện nút game chọn từ
        this.dispose();
        new SelectWordView();
    }//GEN-LAST:event_btnGameSelectWordActionPerformed

    private void btnGameCompleteWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameCompleteWordActionPerformed
        this.dispose();
        new CompleteWordView();
    }//GEN-LAST:event_btnGameCompleteWordActionPerformed

    private void btnGameSolveItOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameSolveItOutActionPerformed
        this.dispose();
        new SolveItOutIntroView();
    }//GEN-LAST:event_btnGameSolveItOutActionPerformed

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
            java.util.logging.Logger.getLogger(VocabularyGameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VocabularyGameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VocabularyGameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VocabularyGameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new VocabularyGameView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGameArrangeWord;
    private javax.swing.JButton btnGameCompleteWord;
    private javax.swing.JButton btnGameSelectWord;
    private javax.swing.JButton btnGameSolveItOut;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
