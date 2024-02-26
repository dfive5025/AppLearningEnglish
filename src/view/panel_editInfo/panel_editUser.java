/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panel_editInfo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class panel_editUser {

    private com.raven.datechooser.DateChooser dateChooser;

    public JButton bt_Save;
    public JTextField JTf_iduser, JTf_username, Jtf_password,
            JTf_nameUser, JTf_address, JTf_Gender, JTf_bd, JTf_Email, JTf_Phone, JTf_isAdmin;
    String work[] = {"Admin", "User"};
    private String gender[] = {"Male", "Female"};
    public JComboBox jComboBox = new JComboBox(work);
    public JComboBox jComboBox1 = new JComboBox(gender);
    public JFrame p3;

    public panel_editUser() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(8, 2));
        JTf_iduser = new JTextField();
        JTf_username = new JTextField();
        JTf_nameUser = new JTextField();
        JTf_Gender = new JTextField();
        JTf_bd = new JTextField();
        JTf_address = new JTextField();
        JTf_Email = new JTextField();
        JTf_Phone = new JTextField();
        JTf_isAdmin = new JTextField();
//        p.add(new JLabel("ID User:"));
//        p.add(JTf_iduser);
        p.add(new JLabel("User Name:"));
        p.add(JTf_username);
        p.add(new JLabel("Name:"));
        p.add(JTf_nameUser);
        
        p.add(new JLabel("Gender:"));
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Female")) {
                    JTf_Gender.setText("Female");
                } else {
                    JTf_Gender.setText("Male");
                }
            }
        });
        p.add(jComboBox1);
        
        p.add(new JLabel("Birthday:"));
        p.add(JTf_bd);
        p.add(new JLabel("Address:"));
        p.add(JTf_address);
        p.add(new JLabel("Email:"));
        p.add(JTf_Email);
        p.add(new JLabel("Phone:"));
        p.add(JTf_Phone);

        dateChooser = new com.raven.datechooser.DateChooser();
        dateChooser.setTextRefernce(JTf_bd);

//        p.add(new JLabel("Total Score:"));
//        p.add(JTf_TotalScore);
        p.add(new JLabel("Admin:"));
        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                JTf_isAdmin.setText(jComboBox.getSelectedItem().toString());
                if (jComboBox.getSelectedItem().toString().equalsIgnoreCase("Admin")) {
                    JTf_isAdmin.setText("Admin");
                } else {
                    JTf_isAdmin.setText("User");
                }
                System.out.println(jComboBox.getSelectedItem().toString());
            }
        });
        p.add(jComboBox);
        p.setBackground(new Color(250,240,230));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        bt_Save = new JButton("Save");
        p1.add(bt_Save);
        p3 = new JFrame();
        p3.setTitle("Edit User");
        p3.setSize(500, 350);
        p3.setLayout(new BorderLayout());
        p3.add(p, BorderLayout.CENTER);
        p3.add(p1, BorderLayout.SOUTH);
        p3.setVisible(true);
        p3.setLocationRelativeTo(null);
    }
}
