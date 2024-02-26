/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StatisticalCtl;
import controller.ListCtl;
import controller.LoginCtl;
import controller.SearchCtl;
import controller.TopicCtl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import model.Person;
import model.Word;

/**
 *
 * @author Admin
 */
public class RankView extends javax.swing.JFrame { //sua mvc

    /**
     * Creates new form TopicFrm
     */
    StatisticalCtl rankCtl = new StatisticalCtl();
    DefaultTableModel model;
    ArrayList<Person> personList; //Word list by topic

    public RankView() {
        initComponents();
        this.setSize(1210, 695);// Kích thước
        this.setVisible(true);// Hiện thị Jframe
        this.setTitle("Topic"); // Tiêu đề
        this.setLocationRelativeTo(null);// Hiển thị ở chính giữa màn hình
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        
        
        setBtn(); // Xóa viền các button 
        model = (DefaultTableModel) rankTable.getModel();
        rankTable.getTableHeader().setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
        rankTable.getTableHeader().setOpaque(false);
        rankTable.getTableHeader().setBackground(new Color(32, 136, 203));
        rankTable.getTableHeader().setForeground(new Color(255,255,255));
        showTable();
    }



    private void announcement(String str) { // Thông báo
        JOptionPane.showMessageDialog(null, str);
    }

    private void showTable() {//Hiển thị danh sách từ vựng theo chủ đề
        personList = rankCtl.getRank();
        int i = 1;
        for (Person x : personList) {
            model.addRow(new Object[]{
                i++ , x.getUusername(), x.getuTotalScore()
            });
        }
    }
    public void setBtnNoBorder(JToggleButton button) // Xóa viền button
    {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // Especially important
    }
    
    public void setBtn()// Xóa viền button add, back and search
    {
        setBtnNoBorder(btnBack);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupMenu = new javax.swing.JPopupMenu();
        Detail = new javax.swing.JMenuItem();
        Follow = new javax.swing.JMenuItem();
        UserInformation = new javax.swing.JFrame();
        lbTotalScore = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbBirthday = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rankTable = new javax.swing.JTable();
        btnBack = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        Detail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Detail.setText("Detail");
        Detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailActionPerformed(evt);
            }
        });
        PopupMenu.add(Detail);

        Follow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Follow.setText("Follow");
        PopupMenu.add(Follow);

        UserInformation.getContentPane().setLayout(null);

        lbTotalScore.setFont(new java.awt.Font("DejaVu Serif", 0, 32)); // NOI18N
        lbTotalScore.setText("1000");
        UserInformation.getContentPane().add(lbTotalScore);
        lbTotalScore.setBounds(360, 400, 320, 40);

        lbName.setFont(new java.awt.Font("DejaVu Serif", 0, 32)); // NOI18N
        lbName.setText("Vu Hoai Anh");
        UserInformation.getContentPane().add(lbName);
        lbName.setBounds(360, 150, 320, 40);

        lbGender.setFont(new java.awt.Font("DejaVu Serif", 0, 32)); // NOI18N
        lbGender.setText("Female");
        UserInformation.getContentPane().add(lbGender);
        lbGender.setBounds(360, 230, 320, 40);

        lbBirthday.setFont(new java.awt.Font("DejaVu Serif", 0, 32)); // NOI18N
        lbBirthday.setText("20-10-2001");
        UserInformation.getContentPane().add(lbBirthday);
        lbBirthday.setBounds(360, 310, 320, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_infor.png"))); // NOI18N
        UserInformation.getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 580);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        rankTable.setAutoCreateRowSorter(true);
        rankTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rankTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rank", "Username", "Total Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rankTable.setOpaque(false);
        rankTable.setRowHeight(25);
        rankTable.setSurrendersFocusOnKeystroke(true);
        rankTable.getTableHeader().setReorderingAllowed(false);
        rankTable.setUpdateSelectionOnSort(false);
        rankTable.setVerifyInputWhenFocusTarget(false);
        rankTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rankTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(rankTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 160, 880, 390);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 10, 110, 110);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rank_screen.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1210, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Bắt sự kiện nút Back
        this.dispose();
         if(TopicCtl.uIsAdmin == 1){
                new AdminManagerView();;
                }else{
                     new HomeView();
                }
    }//GEN-LAST:event_btnBackActionPerformed

    private void DetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailActionPerformed
        int row = rankTable.getSelectedRow();
        String username = rankTable.getValueAt(row, 1).toString();
        Person person = rankCtl.getPersonInfor(username);
        lbName.setText(person.getUname());
        lbBirthday.setText(new SimpleDateFormat("dd-MM-yyyy").format(person.getUbirthday()));
        lbGender.setText(person.getUgender());
        lbTotalScore.setText(person.getuTotalScore() + "");
        UserInformation.setTitle("User information");
        UserInformation.setSize(900, 600);
        UserInformation.setLocationRelativeTo(null);
        UserInformation.show();
    }//GEN-LAST:event_DetailActionPerformed

    private void rankTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rankTableMouseReleased
        if(evt.getButton() == MouseEvent.BUTTON3)
        {
            if(evt.isPopupTrigger() && rankTable.getSelectedRowCount()!=0)
            {
                PopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_rankTableMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RankView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Detail;
    private javax.swing.JMenuItem Follow;
    private javax.swing.JPopupMenu PopupMenu;
    private javax.swing.JFrame UserInformation;
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBirthday;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbTotalScore;
    private javax.swing.JTable rankTable;
    // End of variables declaration//GEN-END:variables

}
