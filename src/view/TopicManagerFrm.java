/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AdminManagerCtl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.Topic;
import model.Word;
import view.panel_editInfo.panel_editTopic;

/**
 *
 * @author Admin
 */
public class TopicManagerFrm extends javax.swing.JFrame {

    /**
     * Creates new form TopicManagerFrm
     */
    public DefaultTableModel model;
    ArrayList<Topic> topicList;
    AdminManagerCtl a = new AdminManagerCtl();
    public static int k;

    public TopicManagerFrm() {
        initComponents();
        this.setSize(1210, 720);// Kích thước
        this.setVisible(true);// Hiện thị Jframe
        this.setTitle("ADD TOPIC"); // Tiêu đề
        this.setLocationRelativeTo(null);// Hiển thị ở chính giữa màn hình
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        tbl_topic.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tbl_topic.getTableHeader().setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
        tbl_topic.getTableHeader().setOpaque(false);
        tbl_topic.getTableHeader().setBackground(new Color(32, 136, 203));
        tbl_topic.getTableHeader().setForeground(new Color(255,255,255));
        tbl_topic.setRowHeight(25);
        setBtn();
        loadDataIntoJTable();
//        getCheckTbl();

    }

    public void setBtnNoBorder(JButton button) {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Especially important
    }
    public void setBtnNoBorder(JToggleButton button)
    {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // Especially important
    }
    
    public void setBtn() {
           setBtnNoBorder(btnBack);
        setBtnNoBorder(btn_SubmitAddTopic);
        setBtnNoBorder(btn_deleteTopic);
        setBtnNoBorder(btn_editTopic);
    }

    private void showTable() {//Hiển thị danh sách từ vựng theo chủ đề
        model = (DefaultTableModel) tbl_topic.getModel();
        topicList = a.getTopicInfo();
        for (Topic x : topicList) {
            model.addRow(new Object[]{
                x.getIdtopic(), x.getTopicname()
            });
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

        txtADDnametopic = new javax.swing.JTextField();
        btn_SubmitAddTopic = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_topic = new javax.swing.JTable();
        btn_deleteTopic = new javax.swing.JButton();
        btn_editTopic = new javax.swing.JButton();
        btnBack = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        txtADDnametopic.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtADDnametopic);
        txtADDnametopic.setBounds(670, 310, 490, 80);

        btn_SubmitAddTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SubmitAddTopicActionPerformed(evt);
            }
        });
        getContentPane().add(btn_SubmitAddTopic);
        btn_SubmitAddTopic.setBounds(840, 420, 170, 50);

        tbl_topic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID TOPIC", "Name Topic"
            }
        ));
        jScrollPane1.setViewportView(tbl_topic);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(82, 160, 520, 420);

        btn_deleteTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteTopicActionPerformed(evt);
            }
        });
        getContentPane().add(btn_deleteTopic);
        btn_deleteTopic.setBounds(130, 590, 160, 50);

        btn_editTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editTopicActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editTopic);
        btn_editTopic.setBounds(392, 592, 160, 50);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 10, 110, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addtopic.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1210, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean checkBlack()// Kiểm tra Jtext nhập từ tiếng anh có trống không?
    {
        if (txtADDnametopic.getText().trim().equals("")) {
            return true; //có trông
        }
        return false; //
    }

    private void announcement(String str) { // Thông báo
        JOptionPane.showMessageDialog(null, str);
    }
    private void btn_SubmitAddTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SubmitAddTopicActionPerformed
        Topic t = new Topic();
          AdminManagerCtl actl = new AdminManagerCtl();
        if (!checkBlack()) {
             if(actl.checkTopicExist(txtADDnametopic.getText().toString())!=0){
                 announcement("Topic exist...Input topic another please!!!");
            }else{
//            t.setIdtopic(Integer.parseInt(txtADDidtopic.getText().trim()));
            t.setTopicname(txtADDnametopic.getText().trim());
            AdminManagerCtl a = new AdminManagerCtl();
            a.AddTopic(t);
            announcement("Add Topic Successfully!!!");
            loadDataIntoJTable();
             }
        } else {
            announcement("Please enter fully information.");
        }
    }//GEN-LAST:event_btn_SubmitAddTopicActionPerformed

    public void getCheckTbl() {
        tbl_topic.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                k = tbl_topic.getSelectedRow();
            }

            public void mousePressed(MouseEvent e) {
                k = tbl_topic.getSelectedRow();
            }

            public void mouseReleased(MouseEvent e) {
                k = tbl_topic.getSelectedRow();
            }

            public void mouseEntered(MouseEvent e) {
                k = tbl_topic.getSelectedRow();
            }

            public void mouseExited(MouseEvent e) {
                k = tbl_topic.getSelectedRow();
            }
        });
    }
    private void btn_deleteTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteTopicActionPerformed
        int x = tbl_topic.getSelectedRow();
        if (x != -1) {
            String iddelete = model.getValueAt(x, 0).toString().trim();
            Topic t1 = new Topic(Integer.parseInt(iddelete));
            a.delete_topic(t1);
            announcement("Delete successfully");
            loadDataIntoJTable();
        } else {
            announcement("Choose 1 Row Please!!!");
        }

    }//GEN-LAST:event_btn_deleteTopicActionPerformed


    private void btn_editTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editTopicActionPerformed
        int x = tbl_topic.getSelectedRow();
        if (x != -1) {
            final panel_editTopic pTopic = new panel_editTopic();
            pTopic.JTf_idtopic.setText(model.getValueAt(x, 0).toString().trim());
            pTopic.JTf_nametopic.setText(model.getValueAt(x, 1).toString().trim());
            pTopic.bt_Save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    Topic t = new Topic(Integer.parseInt(pTopic.JTf_idtopic.getText()), pTopic.JTf_nametopic.getText());
                    a.edit_topic(t);
                    announcement("Edit successfully");
                    loadDataIntoJTable();
                }
            });
        } else {
            announcement("Choose 1 Row Please!!!");
        }
    }//GEN-LAST:event_btn_editTopicActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Bắt sự kiện nút Back
        this.dispose();
         new AdminManagerView();
    }//GEN-LAST:event_btnBackActionPerformed
    private void loadDataIntoJTable() {
        model = new DefaultTableModel();
        //Set Column Title
        Vector column = new Vector();
        column.add("ID Topic");
        column.add("Name Topic");
        model.setColumnIdentifiers(column);
        ArrayList<Topic> list = a.getTopicInfo();
        for (int i = 0; i < list.size(); i++) {
            Topic t = (Topic) list.get(i);
            Vector row = new Vector();
            row.add(t.getIdtopic());
            row.add(t.getTopicname());
            model.addRow(row);
        }

        tbl_topic.setModel(model);

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
            java.util.logging.Logger.getLogger(TopicManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TopicManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TopicManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TopicManagerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TopicManagerFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JButton btn_SubmitAddTopic;
    private javax.swing.JButton btn_deleteTopic;
    private javax.swing.JButton btn_editTopic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_topic;
    private javax.swing.JTextField txtADDnametopic;
    // End of variables declaration//GEN-END:variables
}
