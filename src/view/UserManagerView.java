package view;

import controller.AdminManagerCtl;
import controller.SercurityCtl;
import controller.StatisticalCtl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import model.Person;
import model.Topic;
import model.Word;
import static view.TopicManagerFrm.k;
import view.panel_adduser.panel_addUser;
import view.panel_editInfo.panel_editTopic;
import view.panel_editInfo.panel_editUser;
import view.panel_editInfo.panel_editWord;

/**
 *
 * @author Kyros
 */
public class UserManagerView extends javax.swing.JFrame {

    public DefaultTableModel model;
    AdminManagerCtl a = new AdminManagerCtl();
    public static int k;
    panel_editUser pUser;
    ArrayList<Person> personList;
    StatisticalCtl rankCtl = new StatisticalCtl();

    public UserManagerView() {
        initComponents();
        this.setSize(1214, 714);
        this.setTitle("Admin Mannager");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        tbl_user.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tbl_user.getTableHeader().setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
        tbl_user.getTableHeader().setOpaque(false);
        tbl_user.getTableHeader().setBackground(new Color(32, 136, 203));
        tbl_user.getTableHeader().setForeground(new Color(255, 255, 255));
        tbl_user.setRowHeight(25);

        setBtn();
        personList = rankCtl.getRank2();
        loadDataIntoJTable();
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
        setBtnNoBorder(btnBack);
        setBtnNoBorder(btn_DeleteUser);
        setBtnNoBorder(btn_adduser);
        setBtnNoBorder(btn_editUser);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_user = new javax.swing.JTable();
        btn_DeleteUser = new javax.swing.JButton();
        btn_editUser = new javax.swing.JButton();
        btn_adduser = new javax.swing.JButton();
        btnBack = new javax.swing.JToggleButton();
        anhAD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Gender", "Address", "Phone", "Email", "Rank", "Total Score", "Admin"
            }
        ));
        jScrollPane1.setViewportView(tbl_user);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 140, 1150, 350);

        btn_DeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteUserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_DeleteUser);
        btn_DeleteUser.setBounds(760, 520, 140, 60);

        btn_editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editUserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editUser);
        btn_editUser.setBounds(530, 520, 150, 60);

        btn_adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adduserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_adduser);
        btn_adduser.setBounds(300, 520, 150, 60);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(10, 0, 90, 100);

        anhAD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_managerment.png"))); // NOI18N
        getContentPane().add(anhAD);
        anhAD.setBounds(0, 0, 1210, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int role = 0;
//    int gender = 0;
    private void btn_editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editUserActionPerformed

        int x = tbl_user.getSelectedRow();
        if (x != -1) {
            pUser = new panel_editUser();
            pUser.JTf_iduser.setText(model.getValueAt(x, 0).toString().trim());
            pUser.JTf_username.setText(model.getValueAt(x, 1).toString().trim());
            pUser.JTf_nameUser.setText(model.getValueAt(x, 2).toString().trim());
//            pUser.JTf_Gender.setText(model.getValueAt(x, 3).toString().trim());
            String gender = model.getValueAt(x, 3).toString().trim();
            if (gender.equals("Male")) {
                pUser.jComboBox1.setSelectedIndex(0);
            } else if (gender.equals("Female")) {
                pUser.jComboBox1.setSelectedIndex(1);
            }
//            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            pUser.JTf_bd.setText(model.getValueAt(x, 4).toString().trim());
            pUser.JTf_address.setText(model.getValueAt(x, 5).toString().trim());
            pUser.JTf_Phone.setText(model.getValueAt(x, 6).toString().trim());
            pUser.JTf_Email.setText(model.getValueAt(x, 7).toString().trim());
            String rol = model.getValueAt(x, 10).toString().trim();
//            pUser.JTf_isAdmin.setText(model.getValueAt(x, 10).toString().trim());
            if (rol.equals("Admin")) {
                pUser.jComboBox.setSelectedIndex(0);
            } else if (rol.equals("User")) {
                pUser.jComboBox.setSelectedIndex(1);
            }

            pUser.bt_Save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String uname = a.getUsername(Integer.parseInt(pUser.JTf_iduser.getText().trim()));
                    String uname2 = pUser.JTf_username.getText().toString().trim();
                    if (pUser.JTf_username.getText().trim().equals("")
                            || pUser.JTf_nameUser.getText().trim().equals("")
                            || pUser.JTf_address.getText().trim().equals("")
                            || pUser.JTf_Phone.getText().trim().equals("")
                            || pUser.JTf_Email.getText().trim().equals("")) {
                        WarningtAnnounce("Fill fully infomation!!!");
                    } else if (a.checkUsername(pUser.JTf_username.getText().trim())&&!(uname2.equalsIgnoreCase(uname))) {
                       
                            WarningtAnnounce("Username already exists. Please enter another username!!!");
                        
                    } else {
                        try {
                            if(pUser.jComboBox.getSelectedItem().toString().equals("Admin")){
                                role = 1;
                            }else{
                                role =0;
                            }
                            System.out.println(pUser.JTf_isAdmin.getText());
                            Date bd = new SimpleDateFormat("dd-MM-yyyy").parse(pUser.JTf_bd.getText());;
                            Person w = new Person(Integer.parseInt(pUser.JTf_iduser.getText()), pUser.JTf_username.getText(),
                                    pUser.JTf_nameUser.getText(), pUser.jComboBox1.getSelectedItem().toString(), bd, pUser.JTf_address.getText(), pUser.JTf_Phone.getText(),
                                    pUser.JTf_Email.getText(), role);
                            a.edit_User(w);
                            //if jcombo mà khác thi
                            SuccessAnnouunce("Edit successfully");
                            loadDataIntoJTable();
                            pUser.p3.setVisible(false);

                        } catch (ParseException ex) {
                            Logger.getLogger(UserManagerView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } else {
            WarningtAnnounce("Choose 1 Row Please!!!");
        }
    }//GEN-LAST:event_btn_editUserActionPerformed

    private void btn_adduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adduserActionPerformed

        final panel_addUser pUser = new panel_addUser();
        pUser.bt_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pUser.JTf_username.getText().trim().equals("") || pUser.Jtf_password.getText().trim().equals("")
                        || pUser.JTf_nameUser.getText().trim().equals("")
                        || pUser.JTf_address.getText().trim().equals("")
                        || pUser.JTf_Phone.getText().trim().equals("") || pUser.JTf_Email.getText().trim().equals("")) {
                    WarningtAnnounce("Fill fully infomation!!!");
                } else if (a.checkUsername(pUser.JTf_username.getText().trim())) {
                    WarningtAnnounce("Username already exists. Please enter another username!!!");
                } else {
                    try {
                        if (pUser.JTf_Gender.getText().trim().equals("")) {
                            pUser.JTf_Gender.setText("Male");
                        }
                        if (pUser.JTf_isAdmin.getText().trim().equals("")) {
                            pUser.JTf_isAdmin.setText("1");
                        }
                        SercurityCtl serc = new SercurityCtl();
                        String hashPassword = serc.md5(pUser.Jtf_password.getText());
                        Person t = new Person(pUser.JTf_username.getText(), hashPassword, pUser.JTf_nameUser.getText(),
                                pUser.JTf_Gender.getText(), new SimpleDateFormat("dd-MM-yyyy").parse(pUser.JTf_bd.getText()), pUser.JTf_address.getText(), pUser.JTf_Phone.getText(), pUser.JTf_Email.getText(),
                                Integer.parseInt(pUser.JTf_isAdmin.getText()));
                        a.AddUser(t);
                        SuccessAnnouunce("Add successfully");
                        loadDataIntoJTable();
                        pUser.JTf_nameUser.setText("");
                        pUser.JTf_username.setText("");
                        pUser.Jtf_password.setText("");
                        pUser.JTf_Gender.setText("");
                        pUser.JTf_Email.setText("");
                        pUser.JTf_Phone.setText("");
                        pUser.JTf_address.setText("");
                    } catch (ParseException ex) {
                        Logger.getLogger(UserManagerView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_btn_adduserActionPerformed

    private void btn_DeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteUserActionPerformed
        int x = tbl_user.getSelectedRow();
        if (x != -1) {
            String iddelete = model.getValueAt(x, 0).toString().trim();
            Person w1 = new Person(Integer.parseInt(iddelete));
            a.delete_User(w1);
            SuccessAnnouunce("Delete successfully");
            loadDataIntoJTable();
        } else {
            WarningtAnnounce("Choose 1 Row Please!!!");
        }

    }//GEN-LAST:event_btn_DeleteUserActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new AdminManagerView();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserManagerView().setVisible(true);
            }
        });
    }

//    ArrayList<Person> personList;
//     StatisticalCtl rankCtl = new StatisticalCtl();
    public int RankgetbyID(int id) {
        int rank = 0;
        for (Person x : personList) {
            if (id == x.getIdperson()) {
                rank = x.getuMyrank();
            }
        }
        return rank;
    }

    public void loadDataIntoJTable() {
        model = new DefaultTableModel();
        //Set Column Title
        Vector column = new Vector();
        column.add("ID User");
        column.add("UserName");
        column.add("Name");
        column.add("Gender");
        column.add("Birthday");
        column.add("Address");
        column.add("Phone");
        column.add("Email");
        column.add("Rank");
        column.add("Total Score");
        column.add("Role");
        model.setColumnIdentifiers(column);
        ArrayList<Person> list = a.getUserInfo();
        for (int i = 0; i < list.size(); i++) {
            Person t = (Person) list.get(i);
            Vector row = new Vector();
            row.add(t.getIdperson());
            row.add(t.getUusername());
            row.add(t.getUname());
            row.add(t.getUgender());
            row.add(new SimpleDateFormat("dd-MM-yyyy").format(t.getUbirthday()));
            row.add(t.getUaddress());
            row.add(t.getUtelephone());
            row.add(t.getUemail());
            int rank = RankgetbyID(t.getIdperson());
            row.add(rank);
            row.add(t.getuTotalScore());
            String role;
            if (t.getuIsAdmin() == 1) {
                role = "Admin";
            } else {
                role = "User";
            }
            row.add(role);
            model.addRow(row);
        }
        tbl_user.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhAD;
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JButton btn_DeleteUser;
    private javax.swing.JButton btn_adduser;
    private javax.swing.JButton btn_editUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_user;
    // End of variables declaration//GEN-END:variables
}
