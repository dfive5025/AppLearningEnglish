/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ListCtl;
import controller.LoginCtl;
import controller.SearchCtl;
import controller.TopicCtl;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Admin
 */
public class SearchView extends javax.swing.JFrame {

    /**
     * Creates new form SearchView
     */
    
    SearchCtl search = new SearchCtl();
    TopicCtl tp = new TopicCtl(); 
    ListCtl listCtl = new ListCtl();
    String result;
    DefaultListModel defaultlist = new DefaultListModel();
    public SearchView() {
//        comboSearch.setEditable(true);
        initComponents();
        this.setSize(1215, 730); // Kích cỡ Frame
        this.setTitle("Search");// Tiêu đề
        this.setVisible(true);// Hiển thị
        this.setLocationRelativeTo(null);// Chính giữa màn hình
        txtEn.setText("English");
        txtVietnamese.setText("Vietnamese");
        txtVietnamese.setEditable(false);
        btnRemember.setVisible(false);
        lbMute.setVisible(false);
        lbHighVolume.setVisible(false);
        star1.setVisible(false);
        star2.setVisible(false);
        setBtn();// Xóa viền button
        getContentPane().remove(jScrollPane1);
        jListSearch.setVisible(false);
       ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        showcomboSearch();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRemember = new javax.swing.JToggleButton();
        btnBack = new javax.swing.JToggleButton();
        star1 = new javax.swing.JLabel();
        lbVn = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        txtVietnamese = new javax.swing.JTextField();
        txtEn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSearch = new javax.swing.JList<>();
        lbMute = new javax.swing.JLabel();
        lbHighVolume = new javax.swing.JLabel();
        JbableOne = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnRemember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRememberMouseClicked(evt);
            }
        });
        btnRemember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRememberActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemember);
        btnRemember.setBounds(1050, 210, 70, 80);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 20, 100, 100);

        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/yellowStar.png"))); // NOI18N
        getContentPane().add(star1);
        star1.setBounds(1050, 210, 70, 80);

        lbVn.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbVn.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbVn);
        lbVn.setBounds(430, 530, 640, 80);

        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blackStar.png"))); // NOI18N
        getContentPane().add(star2);
        star2.setBounds(1050, 220, 70, 70);

        txtVietnamese.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        txtVietnamese.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVietnameseMouseClicked(evt);
            }
        });
        txtVietnamese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVietnameseActionPerformed(evt);
            }
        });
        txtVietnamese.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVietnameseKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVietnameseKeyReleased(evt);
            }
        });
        getContentPane().add(txtVietnamese);
        txtVietnamese.setBounds(430, 530, 640, 90);

        txtEn.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        txtEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEnMouseClicked(evt);
            }
        });
        txtEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnActionPerformed(evt);
            }
        });
        txtEn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEnKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEnKeyReleased(evt);
            }
        });
        getContentPane().add(txtEn);
        txtEn.setBounds(430, 350, 640, 90);

        jListSearch.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSearchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListSearch);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 440, 640, 60);

        lbMute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mute.png"))); // NOI18N
        lbMute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMuteMouseClicked(evt);
            }
        });
        getContentPane().add(lbMute);
        lbMute.setBounds(1090, 350, 80, 80);

        lbHighVolume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/high-volume.png"))); // NOI18N
        lbHighVolume.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHighVolumeMouseClicked(evt);
            }
        });
        getContentPane().add(lbHighVolume);
        lbHighVolume.setBounds(1100, 350, 80, 80);

        JbableOne.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JbableOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/DICTIONARY_1.png"))); // NOI18N
        JbableOne.setText("ENTERTREXXT");
        getContentPane().add(JbableOne);
        JbableOne.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    


    public void setBtnNoBorder(JToggleButton button) {//Xóa viền button
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }

    public void setBtn() {// Xóa viền button Back và button Remeber
        setBtnNoBorder(btnBack);
        setBtnNoBorder(btnRemember);
    }

    public boolean checkBlack()// Kiểm tra Jtext nhập từ tiếng anh có trống không?
    {
        return txtEn.getText().trim().equals("");
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
    
    
    public void setStar()//Hiện thị Star
    {
        if(search.checkWordExits(TopicCtl.idperson, txtEn.getText()))
        {
            this.star1.setVisible(true); 
            this.star2.setVisible(false);
        }
        else
        {
            this.star1.setVisible(false);
            this.star2.setVisible(true);
        }
    }
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new HomeView();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRememberActionPerformed
        if(search.checkWordExits(TopicCtl.idperson, txtEn.getText()))// Kiem tra tu vung ton tai chua
        {
            listCtl.removeWord(txtEn.getText()); // Neu ton tai thi xoa khoi ds tu vung cua user
        }
        else
        {
            tp.addWordToPersonList(TopicCtl.idperson, tp.getIDword(txtEn.getText()));// Chua ton tai thi add vào danh sách từ vựng của bản thân
        }
        setStar(); // Hiển thị Star
        
    }//GEN-LAST:event_btnRememberActionPerformed

    private void btnRememberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRememberMouseClicked
        
    }//GEN-LAST:event_btnRememberMouseClicked

    private void txtEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnActionPerformed
//         if(!txtEn.getText().equals("")){
//        String t = txtEn.getText().toString();
//        SearchCtl s = new SearchCtl();
//        ArrayList<String> wordL = s.getWordFromDB();
//        for (String l : wordL) {
//            comboSearch.addItem(l);
//            System.out.println(l);
//            }
//        }
    }//GEN-LAST:event_txtEnActionPerformed
    
    private void txtEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEnMouseClicked
//        txtEn.setText("");// Bắt sự kiện ấn chuột vào mục tìm kiếm từ vựng bằng tiếng anh
        if (txtEn.getText().equalsIgnoreCase("ENGLISH")) {
            txtEn.setText("");
        }
        txtEn.setText("");
        txtVietnamese.setText("");
        jListSearch.setVisible(false);
        btnRemember.setVisible(false);
        lbHighVolume.setVisible(false);
        lbMute.setVisible(false);
        star1.setVisible(false);
        star2.setVisible(false);
    }//GEN-LAST:event_txtEnMouseClicked

    private void txtEnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)// Bắt sự kiện ấn phím enter
        {
                if(!checkBlack())// Nếu các trường đều khác rỗng
                { 
                    result = search.wordResult(txtEn.getText());// Kết quả của từ vựng tìm kiếm tiếng anh
                    if(result == null)
                    {
                        WarningtAnnounce("No result");
                        txtVietnamese.setText("");
                    }
                    else
                    {
                        txtVietnamese.setText(result);
                        setStar();
                        lbMute.setVisible(true);
                        btnRemember.setVisible(true);
                    }
                }
                else
                {
                    WarningtAnnounce("Please enter english word");
                }
        }
    }//GEN-LAST:event_txtEnKeyPressed

    private void txtEnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnKeyReleased
        if (txtEn.getText() != "") {
            getContentPane().add(jScrollPane1);
            jListSearch.setVisible(true);
             searchFilter(txtEn.getText());
        }else{
            getContentPane().remove(jScrollPane1);
             jListSearch.setVisible(false);
        }
    }//GEN-LAST:event_txtEnKeyReleased

    private void jListSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSearchMouseClicked
        String data = jListSearch.getSelectedValue();
        txtEn.setText(data);
        result = search.wordResult(txtEn.getText());// Kết quả của từ vựng tìm kiếm tiếng anh
                    if(result == null)
                    {
                        WarningtAnnounce("No result");
                        jListSearch.setVisible(false);
                        txtEn.setText("");
                    }
                    else
                    {
                        txtVietnamese.setText(result);
                        setStar();
                        lbMute.setVisible(true);
                        btnRemember.setVisible(true);
                    }
        jListSearch.setVisible(false);
        txtEn.requestFocus();
    }//GEN-LAST:event_jListSearchMouseClicked

    private void lbMuteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMuteMouseClicked
        lbHighVolume.setVisible(true);
        lbMute.setVisible(false);
        WarningtAnnounce("This function is being developed");
    }//GEN-LAST:event_lbMuteMouseClicked

    private void lbHighVolumeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHighVolumeMouseClicked
        lbHighVolume.setVisible(false);
        lbMute.setVisible(true);
        WarningtAnnounce("This function is being developed");
    }//GEN-LAST:event_lbHighVolumeMouseClicked

    private void txtVietnameseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVietnameseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVietnameseMouseClicked

    private void txtVietnameseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVietnameseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVietnameseActionPerformed

    private void txtVietnameseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVietnameseKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVietnameseKeyPressed

    private void txtVietnameseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVietnameseKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVietnameseKeyReleased
    public void bindData(){
          SearchCtl s = new SearchCtl();
       ArrayList<String> wordL = s.getWordFromDB();
       for (String l : wordL) {
            defaultlist.addElement(l);
            }
       jListSearch.setModel(defaultlist);
       jListSearch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    public void searchFilter(String searchT){
        DefaultListModel fil = new DefaultListModel();
        SearchCtl s = new SearchCtl();
       ArrayList stars = s.getWordFromDB();
       stars.stream().forEach((star)->{
            String starName = star.toString().toLowerCase();
            if(starName.contains(searchT.toLowerCase())){
                fil.addElement(star);
            }
       });
       defaultlist = fil;
       jListSearch.setModel(defaultlist);
    }
    public void showcomboSearch(){
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
            java.util.logging.Logger.getLogger(SearchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JbableOne;
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JToggleButton btnRemember;
    private javax.swing.JList<String> jListSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHighVolume;
    private javax.swing.JLabel lbMute;
    private javax.swing.JLabel lbVn;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JTextField txtEn;
    private javax.swing.JTextField txtVietnamese;
    // End of variables declaration//GEN-END:variables
}
