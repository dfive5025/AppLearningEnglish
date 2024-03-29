/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StatisticalCtl;
import controller.GameArrangeCtl;
import controller.GameSelectWordCtl;
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
import model.Word;

/**
 *
 * @author hoaianh_Kyros
 */
public class GameRearrangeView extends javax.swing.JFrame {

    /**
     * Creates new form GameRearrangeView
     */
    GameArrangeCtl gameCtl = new GameArrangeCtl();
    ArrayList<String> wordList = gameCtl.getRandomWordList();
    int a = 0, score = 0;
    int timeLeft;
    Timer timer;

    String word;
    ArrayList<Character> charWord;

    public GameRearrangeView() {
        initComponents();
        this.setSize(1215, 700); // Kích thước
        this.setLocationRelativeTo(null); // Hiển thị Jframe ở chính giữa màn hình
        this.setTitle("Game rearrange word"); // Tiêu đề
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        txtScore.setText("0 point");
        txtName.setText(new GameSelectWordCtl().getNamePerson());

        txtAnswer.requestFocus();
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
        setBtnNoBorder(btnCheck);
    }

    public ArrayList<Character> getCharWord() { // Lấy một chuỗi các ký tự từ từ vựng làm câu hỏi
        ArrayList<Character> randomChar = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            randomChar.add(word.charAt(i));
        }
        return randomChar;
    }

    public String setTxtConten() { // Hiển thị chuỗi random làm câu hỏi
        String result = "/";
        charWord = this.getCharWord();
        int j = charWord.size();
        for (int i = 0; i < j; i++) {
            Random general = new Random();
            int randonIndex = general.nextInt(charWord.size());
            if (Character.isSpace(charWord.get(randonIndex))) {
                result += "_/";
            } else {
                result += charWord.get(randonIndex) + "/";
            }
            charWord.remove(charWord.get(randonIndex));
        }
        return result;
    }

    public void question() { // Hiển thị số câu 
        String randomWord = null;
        if (a < 10) {
            randomWord = wordList.get(a);
        }
        word = randomWord;
        System.out.println(word);
        txtContent.setText(setTxtConten());
        txtQuestion.setText((a + 1) + "");
        txtAnswer.setText("");
        txtAnswer.requestFocusInWindow();
        goodjob.setVisible(false);
        tryAgain.setVisible(false);
        a++;
    }

    public boolean checkAnswer() { //Kiểm tra đáp án
        if (txtAnswer.getText().trim().equalsIgnoreCase(word)) {
            return true;
        }
        return false;
    }

    public void Time() { // Set up thời gian 15s một câu
        timeLeft = 15;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtTime.setText(timeLeft + "");// Hiện thị số giây
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

    public void exit() {// Thoát
        timer.stop();
        JOptionPane.showMessageDialog(null, "You have " + score + " points");
        new StatisticalCtl().updateScore(score);
        this.dispose();
        new VocabularyGameView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtContent = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        txtQuestion = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        goodjob = new javax.swing.JLabel();
        tryAgain = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtScore = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        txtName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtContent.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtContent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtContent);
        txtContent.setBounds(410, 220, 410, 190);

        txtAnswer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtAnswer.setText("YOUR ANSWER");
        txtAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAnswerMouseClicked(evt);
            }
        });
        txtAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswerActionPerformed(evt);
            }
        });
        txtAnswer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnswerKeyPressed(evt);
            }
        });
        getContentPane().add(txtAnswer);
        txtAnswer.setBounds(340, 440, 290, 70);

        txtQuestion.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        getContentPane().add(txtQuestion);
        txtQuestion.setBounds(720, 150, 140, 90);

        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 10, 100, 90);

        goodjob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/GOODJOB.png"))); // NOI18N
        getContentPane().add(goodjob);
        goodjob.setBounds(970, 190, 160, 160);

        tryAgain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/OOPS.png"))); // NOI18N
        getContentPane().add(tryAgain);
        tryAgain.setBounds(970, 180, 170, 170);

        txtTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(txtTime);
        txtTime.setBounds(120, 180, 120, 40);

        txtScore.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(txtScore);
        txtScore.setBounds(140, 240, 160, 30);

        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(940, 50, 160, 90);

        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        getContentPane().add(btnCheck);
        btnCheck.setBounds(710, 440, 160, 70);

        txtName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(txtName);
        txtName.setBounds(80, 110, 230, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/GAMEARRANGGE123456.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnswerMouseClicked
        this.txtAnswer.setText("");
    }//GEN-LAST:event_txtAnswerMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        exit();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        // Bắt sự kiện check
         if (!txtAnswer.getText().isEmpty()) 
        {
            if (a == 10)// Kiểm tra nếu là câu 11 
            {
                exit();
            }
            else 
            {
                if (checkAnswer()) 
                {
                    goodjob.setVisible(true);
                    score += 10;
                    txtScore.setText(this.score + " points");
                } 
                else
                {
                    tryAgain.setVisible(true);
                }
                timer.stop();
                Time();
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Please fill your answer");
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

    private void txtAnswerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnswerKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtAnswer.getText().isEmpty()) {
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
            } else {
                JOptionPane.showMessageDialog(null, "Please fill your answer");
            }
        }
    }//GEN-LAST:event_txtAnswerKeyPressed

    private void txtAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswerActionPerformed

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
            java.util.logging.Logger.getLogger(GameRearrangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameRearrangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameRearrangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameRearrangeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new GameRearrangeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel goodjob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel tryAgain;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JLabel txtContent;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtQuestion;
    private javax.swing.JLabel txtScore;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables
}
