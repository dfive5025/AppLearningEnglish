/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panel_editInfo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class panel_editTopic {
     public JButton bt_Save;
    public JTextField JTf_idtopic, JTf_nametopic;
    public panel_editTopic(){
        JPanel p= new JPanel();
         p.setBackground(new Color(250,240,230));
        p.setLayout(new GridLayout(2, 2));
        JTf_idtopic = new JTextField();
        JTf_nametopic= new JTextField();
        p.add(new JLabel("ID Topic:"));
        p.add(JTf_idtopic);
        JTf_idtopic.setEditable(false);
        p.add(new JLabel("Name Topic:"));
        p.add(JTf_nametopic);
        JPanel p1= new JPanel();
        p1.setLayout(new GridLayout(1,1));
        bt_Save = new JButton("Save");
        p1.add(bt_Save);
        JFrame p3= new JFrame();
        p3.setSize(250,150);
        p3.setTitle("Edit Topic");
        p3.setLayout(new BorderLayout());
        p3.add(p, BorderLayout.CENTER);
        p3.add(p1, BorderLayout.SOUTH);
        p3.setVisible(true);
        p3.setLocationRelativeTo(null);
    }
}
