/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.StatisticalCtl;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import view.GameHomeView;
import view.RankView;
import view.VocabularyGameView;

/**
 *
 * @author Administrator
 */
public class Result extends javax.swing.JFrame {

    /**
     * Creates new form Result
     */
    
    Data data = new Data();
    
    public Result() {
        initComponents();
        this.setDefaultCloseOperation(3);
        this.setSize(1130, 700);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        btnExit.setOpaque(false);
        btnExit.setFocusPainted(false);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        int score = 10;
        if(data.cau1.equalsIgnoreCase("A"))
            score+=10;
        if(data.cau2.equalsIgnoreCase("C"))
            score+=10;
        if(data.cau3.equalsIgnoreCase("B"))
            score+=10;
        if(data.cau4.equalsIgnoreCase("C"))
            score+=10;
        if(data.cau5.equalsIgnoreCase("D"))
            score+=10;
        if(data.cau6.equalsIgnoreCase("B"))
            score+=10;
        if(data.cau7.equalsIgnoreCase("A"))
            score+=10;
        if(data.cau8.equalsIgnoreCase("C"))
            score+=10;
        if(data.cau9.equalsIgnoreCase("A"))
            score+=10;
        if(data.cau10.equalsIgnoreCase("D"))
            score+=10;
        
        txtScore.setText(score + "");
        new StatisticalCtl().updateScore(score);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtScore = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Summary");
        getContentPane().setLayout(null);

        txtScore.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtScore);
        txtScore.setBounds(330, 270, 224, 170);

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(530, 580, 150, 72);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/RESULT_1.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1110, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        new GameHomeView();
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtScore;
    // End of variables declaration//GEN-END:variables
}
