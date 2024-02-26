/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import view.GameHomeView;
import view.VocabularyGameView;

/**
 *
 * @author Administrator
 */
public class question9 extends javax.swing.JFrame {

    String dung;
    int giay;
    Timer timer;
    
    Data data = new Data();
    /**
     * Creates new form cau9
     */
    public question9() {
        initComponents();
        this.setSize(1215, 720);
        this.setLocationRelativeTo(null);
        setBtn();
        
        giay = 10;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jLabel2.setText("" + giay);
                if(giay == 0){
                    JOptionPane.showMessageDialog(rootPane, "Overtime");
                    timer.stop();
                    question10 c10 = new question10();
                    c10.setVisible(true);
                    dispose();
                } else{
                    giay--;
                }
                 if(dung == ""){
                    timer.stop();
                }
            }
        });
        if(giay > 0)
            timer.start();
    }
    
    public void setBtnNoBorder(JButton button)
    {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // Especially important
    }
    
    public void setBtn()
    {
        setBtnNoBorder(btnExit);
        setBtnNoBorder(btnNext);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        btnNext = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Question 9");
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/question9new.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(740, 170, 340, 220);

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox1.setText("A. Spouse");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(740, 440, 120, 40);

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox2.setText("C. Grandparents");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(960, 440, 155, 31);

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox3.setText("B. Uncle");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox3);
        jCheckBox3.setBounds(740, 520, 120, 31);

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox4.setText("D. Stepparent");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox4);
        jCheckBox4.setBounds(960, 510, 150, 31);

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(970, 570, 170, 80);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1090, 60, 56, 50);

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(630, 50, 160, 80);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/PHOTO9.png"))); // NOI18N
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        data.cau9 = "A";
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        data.cau9 = "B";
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        data.cau9 = "C";
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        data.cau9 = "D";
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.dung = "";
        question10 c10 = new question10();
        c10.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dung = "";
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
            java.util.logging.Logger.getLogger(question9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(question9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(question9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(question9.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new question9().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
