/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panel_editInfo;

import controller.TopicCtl;
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
public class panel_editWord {
     public JButton bt_Save;
    public JTextField JTf_idword,JTf_en,JTf_vn, JTf_idtopic;
     TopicCtl tp = new TopicCtl();
     public JComboBox cb_choosetopic = new JComboBox(); 
    public panel_editWord(){
        JPanel p= new JPanel();
         p.setBackground(new Color(250,240,230));
        p.setLayout(new GridLayout(3, 2));
        JTf_idword= new JTextField();
        JTf_idtopic = new JTextField();
        JTf_en= new JTextField();
//         JTf_en.setFont(new java.awt.Font( "Times New Roman", 3, 18));
        JTf_vn= new JTextField();
//        JTf_vn.setFont(new java.awt.Font( "Times New Roman", 3, 18));
        
        JTf_idword.setVisible(false);
        p.add(new JLabel("English:"));
        p.add(JTf_en);
         p.add(new JLabel("Vietnamese:"));
        p.add(JTf_vn);
         p.add(new JLabel("ID topic:"));
         for (String str : tp.getTopicName()) {
            cb_choosetopic.addItem(str);
        }
        cb_choosetopic.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JTf_idtopic.setText(cb_choosetopic.getSelectedItem().toString());
                System.out.println(cb_choosetopic.getSelectedItem().toString());
            }
        });
        p.add(cb_choosetopic);
//        p.add(JTf_idtopic);
        JPanel p1= new JPanel();
        p1.setLayout(new GridLayout(1,1));
        bt_Save = new JButton("Save");
        p1.add(bt_Save);
        JFrame p3= new JFrame();
        p3.setSize(300,200);
        p3.setLayout(new BorderLayout());
        p3.add(p, BorderLayout.CENTER);
        p3.add(p1, BorderLayout.SOUTH);
        p3.setVisible(true);
        p3.setTitle("Edit word");
        p3.setLocationRelativeTo(null);
    }
}
