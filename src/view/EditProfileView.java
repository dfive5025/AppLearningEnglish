/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;

import java.awt.Color;
import controller.EditProfileCtl;
import controller.ProfileCtl;
import controller.RegisterCtl;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import model.Person;

/**
 *
 * @author Admin
 */
public class EditProfileView extends javax.swing.JFrame {

    /**
     * Creates new form AccounInformationFrm
     */
    RegisterCtl rg = RegisterCtl.getinstance();
    public EditProfileView() {
        initComponents();
        dateChooser = new com.raven.datechooser.DateChooser();
        dateChooser.setTextRefernce(txtDate);
        this.setSize(1215, 725);
        this.setTitle("Register");
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/logoapp.png"));
        Image image = icon.getImage();
        setIconImage(image);
        setBtn();
        setInformation();
        
          dateChooser.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
        });
        this.setVisible(true);
        
    }
    
       public void setInformation()
    {
            ProfileCtl editCtl1 = new ProfileCtl();
            Person person = editCtl1.getPersonInformation();
            txtName.setText(person.getUname());
            if(person.getUgender().equalsIgnoreCase("Female"))
            {
                rdFemale.setSelected(true);
            }
            else
            {
                rdMale.setSelected(true);
            }
            txtDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(person.getUbirthday()));
            txtAddress.setText(person.getUaddress());
            txtTelephone.setText(person.getUtelephone());
            txtEmail.setText(person.getUemail());

    }
    
    public boolean checkBlankField() // Kiểm tra các trường nhập có rỗng hay không?
    {
        return txtName.getText().trim().equals("") || txtAddress.getText().trim().equals("") || txtTelephone.getText().trim().equals("")
                || txtEmail.getText().trim().equals(""); 
    }
    
        public boolean checkPhone(String str){
        // Bieu thuc chinh quy mo ta dinh dang so dien thoai
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";   
        return str.matches(reg);
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
    
    
    public void setBtnNoBorder(JToggleButton button)
    {
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0)); // Especially important
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
        setBtnNoBorder(btnDate);
        setBtnNoBorder(btnBack);
        setBtnNoBorder(btnSave);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnBack = new javax.swing.JToggleButton();
        txtName = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSave = new javax.swing.JToggleButton();
        rdFemale = new javax.swing.JRadioButton();
        rdMale = new javax.swing.JRadioButton();
        txtAddress = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        btnDate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(0, 20, 110, 110);

        txtName.setFont(new java.awt.Font("DejaVu Serif", 0, 30)); // NOI18N
        getContentPane().add(txtName);
        txtName.setBounds(450, 160, 520, 50);

        txtTelephone.setFont(new java.awt.Font("DejaVu Serif", 0, 30)); // NOI18N
        getContentPane().add(txtTelephone);
        txtTelephone.setBounds(450, 430, 530, 50);

        txtEmail.setFont(new java.awt.Font("DejaVu Serif", 0, 30)); // NOI18N
        getContentPane().add(txtEmail);
        txtEmail.setBounds(450, 500, 530, 50);

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(630, 570, 200, 70);

        rdFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdFemale);
        rdFemale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemaleActionPerformed(evt);
            }
        });
        getContentPane().add(rdFemale);
        rdFemale.setBounds(690, 240, 20, 30);

        rdMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdMale);
        rdMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(rdMale);
        rdMale.setBounds(510, 240, 20, 30);

        txtAddress.setFont(new java.awt.Font("DejaVu Serif", 0, 30)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtAddress);
        txtAddress.setBounds(450, 370, 530, 50);

        txtDate.setFont(new java.awt.Font("DejaVu Serif", 0, 30)); // NOI18N
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        getContentPane().add(txtDate);
        txtDate.setBounds(450, 300, 530, 50);

        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });
        getContentPane().add(btnDate);
        btnDate.setBounds(990, 300, 50, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/change_profile_update.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1, -4, 1200, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new ProfileView();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(!checkBlankField())  
        {
            try {
                String name = txtName.getText();
                String gender = rdFemale.isSelected()?"Female":"Male";
                Date bd = new SimpleDateFormat("dd-MM-yyyy").parse(txtDate.getText());;
                String address = txtAddress.getText();
                String telephone = txtTelephone.getText();
                String email = txtEmail.getText();
                if(checkPhone(telephone))
                {
                    new EditProfileCtl().updateInformation(name, gender,bd, telephone, address, email);
                    SuccessAnnouunce("Edit profile successfully");
                    this.dispose();
                    new ProfileView();
                }
                else
                {
                    WarningtAnnounce("Wrong format of phone number");
                    txtTelephone.setText("");
                }
            } catch (ParseException ex) {
                Logger.getLogger(EditProfileView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            WarningtAnnounce("Must have complete all fields ");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_btnDateActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void rdFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemaleActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProfileView().setVisible(true);
            }
        });
    }
     private com.raven.datechooser.DateChooser dateChooser;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JButton btnDate;
    private javax.swing.JToggleButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
