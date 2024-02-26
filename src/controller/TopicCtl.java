/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Word;

/**
 *
 * @author Admin
 */
public class TopicCtl {
    public static int idperson; // Tao mot bien tinh Idperson ==> Dung nhieu
     public static int uIsAdmin;
    public ArrayList<Word> getTopic(String topicname) //Lay danh sach tu vung theo chu de
    {
        ArrayList<Word> topicList = new ArrayList<>();
        String sql = "select idword, en, vn, word.idtopic from word\n" +
                      "inner join topic on word.idtopic = topic.idtopic\n" +
                       "where topicname = '" + topicname +"'";
        try {
            DAO d = new DAO();
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int idword = rs.getInt("idword");
                String en = rs.getString("en");
                String vn = rs.getString("vn");
                int idtopic = rs.getInt("idtopic");
                Word a = new Word(idword, en, vn, idtopic);
                topicList.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topicList;
    }
    
    public boolean checkTopicName(String str) // Check topic name in database
    {
        String sql = "Select topicname from topic";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(str.equalsIgnoreCase(rs.getString("topicname")))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<String> getTopicName() // Lay danh sach chu de trong co so du lieu
    {
        ArrayList<String> list = new ArrayList<>();
        String sql = "Select topicname from topic";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                String str = rs.getString("topicname");
                list.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int getIndexTopicName(String str)
    {
        int n = 0;
        for(String topicName: this.getTopicName())
        {
            if(topicName.equalsIgnoreCase(str))
            {
                n = this.getTopicName().indexOf(topicName);
            }
        }
        return n;
    }
    
    public int getIDword(String en) // Lay Id cua tu vung 
    {
        int idWord = 0;
        String sql = "Select * from word";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(en.equalsIgnoreCase(rs.getString("en")))
                    idWord = rs.getInt("idword");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idWord;
    }
    
    public void addWordToPersonList(int idperson, int idword)// Them tu vung vao danh sanh tu vung user
    {
        String sql ="insert into personword\n" +
                    "values (?,?)";
        try {
            DAO d = new DAO();
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ps.setInt(1, idperson);
            ps.setInt(2, idword);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
