/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StatisticalCtl;
import controller.GameArrangeCtl;
import controller.GameSelectWordCtl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
//import jdk.nashorn.internal.parser.TokenType;
import model.Word;

/**
 *
 * @author hoaianh_Kyros
 */
public class GameSolveItOut extends javax.swing.JFrame {

    /**
     * Creates new form GameRearrangeTheWord
     */
    GameArrangeCtl gameCtl = new GameArrangeCtl();
    ArrayList<String> wordList = gameCtl.getRandomWordList();
    int a = 0, score = 0;
    int timeLeft;
    int randomIndex;
    Timer timer;

    String word;
    ArrayList<JButton> btnList;
    int btnIndex;
    ArrayList<JButton> btnDeleteList;

    public GameSolveItOut() {
        initComponents();
        this.setSize(1215, 700); // Kích thước
        this.setLocationRelativeTo(null); // Hiển thị Jframe ở chính giữa màn hình
        this.setTitle("Game rearrange word"); // Tiêu đề
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        txtScore.setText("0 point");
        goodjob.setVisible(false);
        tryAgain.setVisible(false);
        txtName.setText(new GameSelectWordCtl().getNamePerson());
        txtContent.setLayout(new FlowLayout());
        setBtn();
        Time();
        this.setVisible(true); // Hiển thị Jfram
    }

    public void setBtnNoBorder(JButton button) { // Xóa viền button
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }

    public void setBtn() { // Xóa viền các button Back, Next, Check
        setBtnNoBorder(btnBack);
        setBtnNoBorder(btnNext);
        setBtnNoBorder(btnUndo);
        setBtnNoBorder(btnCheck);
    }

    public void question() { // Hiển thị số câu 
        btnDeleteList = new ArrayList<>();
        if (a < 10) {
            word = wordList.get(a);
        }
        btnList = this.setWordItem();
        int min = 0;
        int max = btnList.size();
        int randomIndex = (int) (Math.random() * (max - min + 1) + min);
        JButton btnRandom = new JButton();
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        JButton randomBtn = new JButton(String.valueOf(c));
        randomBtn.setForeground(Color.red);
        randomBtn.setFont(new Font("Arial", Font.PLAIN, 35));
        randomBtn.setPreferredSize(new Dimension(60, 60));
        btnList.add(randomIndex, randomBtn);
        txtContent.removeAll();
        for (int i = 0; i < btnList.size(); i++) {
            txtContent.add(btnList.get(i));
            addActionItem(btnList.get(i));
        }
        System.out.println(word);
        goodjob.setVisible(false);
        tryAgain.setVisible(false);
        a++;
    }

    public boolean checkAnswer() { //Kiểm tra đáp án
        String result = "";
        for (JButton x : btnList) {
            result += x.getText();
        }
        if (result.equals(word)) {
            return true;
        } else {
            return false;
        }
    }

    public void Time() { // Set up thời gian 15s một câu
        timeLeft = 15;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtTime.setText(timeLeft + "");
                if (timeLeft == 15) {
                    question();
                }
                if (timeLeft == 0) {
                    if (a < 10) {
                        timeLeft = 15;
                    } else {
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "You have " + score + " points");
                    }
                } else {
                    timeLeft--;
                }
            }
        });
        if (timeLeft != 0) {
            timer.start();
        }
    }

    public void exit() {
        timer.stop();
        JOptionPane.showMessageDialog(null, "You have " + score + " points");
        new StatisticalCtl().updateScore(score);
        this.dispose();
        new VocabularyGameView();
    }

    public ArrayList<JButton> setWordItem() {
        ArrayList<JButton> btnList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            String a = "";
            a += word.charAt(i);
            JButton btn = new JButton(a);
            btnList.add(btn);
            btn.setForeground(Color.red);
            btn.setFont(new Font("Arial", Font.PLAIN, 35));
            btn.setPreferredSize(new Dimension(60, 60));
        }
        return btnList;
    }

    public void addActionItem(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    btnDeleteList.add(btn);
                    btn.setVisible(false);
                    btnIndex = btnList.indexOf(btn);
                    btnList.remove(btn);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        goodjob = new javax.swing.JLabel();
        tryAgain = new javax.swing.JLabel();
        txtContent = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtScore = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 10, 100, 90);

        goodjob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/GOODJOB.png"))); // NOI18N
        getContentPane().add(goodjob);
        goodjob.setBounds(960, 190, 160, 160);

        tryAgain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/OOPS.png"))); // NOI18N
        getContentPane().add(tryAgain);
        tryAgain.setBounds(960, 180, 170, 170);

        txtContent.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtContent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtContent);
        txtContent.setBounds(190, 230, 850, 110);

        txtName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtName.setText("Vu Hoai Anh");
        getContentPane().add(txtName);
        txtName.setBounds(80, 100, 240, 40);

        txtTime.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtTime.setText("10");
        getContentPane().add(txtTime);
        txtTime.setBounds(100, 145, 90, 25);

        txtScore.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtScore.setText("100");
        getContentPane().add(txtScore);
        txtScore.setBounds(110, 185, 120, 25);

        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(860, 520, 220, 100);

        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        getContentPane().add(btnCheck);
        btnCheck.setBounds(510, 530, 240, 80);

        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUndo);
        btnUndo.setBounds(190, 530, 220, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/solve_it_out_screen.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        exit();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // Bắt sự kiện check
        if (a == 10)// Kiểm tra nếu là câu 11 
        {
            exit();
        } else {
            if (checkAnswer()) {
                goodjob.setVisible(true);
                score += 10;
                txtScore.setText(this.score + " points");
            } else {
                tryAgain.setVisible(true);
            }
            timer.stop();
            Time();
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        if (a == 10) {
            exit();
        }
        {
            timer.stop();
            Time();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        if (btnDeleteList.size() != 0) {
            btnDeleteList.get(btnDeleteList.size() - 1).setVisible(true);
            btnList.add(btnIndex, btnDeleteList.get(btnDeleteList.size() - 1));
            btnDeleteList.remove(btnDeleteList.get(btnDeleteList.size() - 1));
        }
    }//GEN-LAST:event_btnUndoActionPerformed

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
            java.util.logging.Logger.getLogger(GameSolveItOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameSolveItOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameSolveItOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameSolveItOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new GameSolveItOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnUndo;
    private javax.swing.JLabel goodjob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel tryAgain;
    private javax.swing.JLabel txtContent;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtScore;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables
}
