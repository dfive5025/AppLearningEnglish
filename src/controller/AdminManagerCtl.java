/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;
import model.Topic;
import model.Word;

/**
 *
 * @author Admin
 */
public class AdminManagerCtl {
      public ArrayList<Person> getUserInfo() // lay Topic info
    {
        ArrayList<Person> listperson = new ArrayList();
        String sql = "Select * from person";
        try {
            DAO d = new DAO();
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idperson = rs.getInt("idperson");
                String username = rs.getString("uusername");
                String pass =  rs.getString("upassword");
                String Name = rs.getString("uname");
                String gender = rs.getString("ugender");
                 Date bd = rs.getDate("uBirthday");
                 String address = rs.getString("uaddress");
                  String phone = rs.getString("utelephone");
                   String email = rs.getString("uemail");
                    int myrank = rs.getInt("uMyrank");
                     int totalscore = rs.getInt("uTotalScore");
                      int isadmin = rs.getInt("uIsAdmin");
                Person t = new Person(idperson,username,pass,Name,gender,bd,address,phone,email,myrank,totalscore,isadmin);
                listperson.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listperson;
    }
       public void AddUser(Person t) //them Topic
    {
        ArrayList<Person> personList = new ArrayList<>();
        String sql = "insert into person (uusername,upassword,uname,ugender,uBirthday,uaddress,utelephone,uemail,uIsAdmin) "
                + "values (?,?,?,?,?,?,?,?,?)";
//        Date b = new SimpleDateFormat("dd-MM-yyyy").parse(t.getUbirthday().getTime());
        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
//            pst.setInt(1, t.getIdtopic());
            pst.setString(1, t.getUusername());
            pst.setString(2, t.getUpassword());
            pst.setString(3, t.getUname());
            pst.setString(4, t.getUgender());
             pst.setTimestamp(5, new java.sql.Timestamp(t.getUbirthday().getTime()));
//            pst.setTimestamp(5, new java.sql.Timestamp(t.getUbirthday().getTime()));
            pst.setString(6, t.getUaddress());
            pst.setString(7, t.getUtelephone());
            pst.setString(8, t.getUemail());
             pst.setInt(9, t.getuIsAdmin());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void edit_User(Person a){
        String sql = "UPDATE person SET uusername=?,uname=?,ugender=?,uBirthday=?,uaddress=?,utelephone=?"
                + ",uemail=?, uIsAdmin=? WHERE idperson=?";
   
        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
            pst.setString(1, a.getUusername());
//            pst.setString(2, a.getUpassword());
            pst.setString(2, a.getUname());
             pst.setString(3, a.getUgender());
             pst.setTimestamp(4, new java.sql.Timestamp(a.getUbirthday().getTime()));
              pst.setString(5, a.getUaddress());
              pst.setString(6, a.getUtelephone());
            pst.setString(7, a.getUemail());
            pst.setInt(8, a.getuIsAdmin());
             pst.setInt(9, a.getIdperson());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete_User(Person a) {
//        String sql = "DELETE FROM Person WHERE idperson = '" + a.getIdperson() + "'"
//                + " AND IDPERSON = '" + topicCtl.idperson +"'";
        String sql = "DELETE FROM person WHERE idperson=?";
        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
            pst.setInt(1, a.getIdperson());
            pst.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void AddTopic(Topic t) //them Topic
    {
        ArrayList<Word> topicList = new ArrayList<>();
        String sql = "insert into topic (topicname) values (?)";

        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
//            pst.setInt(1, t.getIdtopic());
            pst.setString(1, t.getTopicname());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddWord(Word w) //them Word
    {

        String sql = "insert into word (en,vn,idtopic) values (?,?,?)";

        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
            
            pst.setString(1, w.getEn());
            pst.setString(2, w.getVn());
            pst.setInt(3, w.getIdtopic());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getTopicName() // Lay danh sach chu de trong co so du lieu
    {
        ArrayList<String> list = new ArrayList<>();
        String sql = "Select topicname from topic";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String str = rs.getString("topicname");
                list.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int checkWordExist(String en) {
        int checkw = 0;
        String sql="SELECT COUNT(en) as [QUANLITY] FROM word where en= ?"; 
        try {
            
            DAO d = new DAO();
            
//            PreparedStatement st = d.conn.prepareStatement(sql);
////            st.setString(1, en);
//            ResultSet rs = st.executeQuery();
//            int count = rs.getInt(sql);
//            if(count>0){
//            return true;
//            }
            PreparedStatement pst = d.conn.prepareStatement(sql);
             pst.setString(1, en);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                checkw = rs.getInt("QUANLITY");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkw;
    }
    
      public boolean checkUsername(String username)// Kiem tra ten nguoi dung
    {
        String sql = "Select * from person";
        try 
        {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(username.equalsIgnoreCase(rs.getString("uusername")))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public int checkTopicExist(String nametopic) {
        int checkw = 0;
        String sql="SELECT COUNT(topicname) as [QUANLITY] FROM topic where topicname= ?"; 
        try {
            
            DAO d = new DAO();
              PreparedStatement pst = d.conn.prepareStatement(sql);
             pst.setString(1, nametopic);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                checkw = rs.getInt("QUANLITY");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkw;
    }
    
//     public String getTopicNameSingle(int idtp)// Kiem tra xem nguoi dung co tu vung nao chua?
//    {    String tpname = null;
//        String sql = "Select topicname from Topic where idtopic = '+";
//        try {
//            
//            DAO d = new DAO();
//            
//            Statement st = d.conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next())
//            {
//                tpname = rs.getString("topicname");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return tpname;
//    }
       public String getUsername(int id) // Lay Id nguoi dung
    {
        String uname = null;
        String sql = "Select * from person";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(id == (rs.getInt("idperson")))
                    uname = rs.getString("uusername");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uname;
    }
        public int getIDtopic(String name) // Lay Id cua tu vung 
    {
        int idtp = 0;
        String sql = "Select * from topic";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(name.equalsIgnoreCase(rs.getString("topicname")))
                    idtp = rs.getInt("idtopic");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idtp;
    }
     public String getTopicNameSingle(int idtp) // Lay danh sach chu de trong co so du lieu
    {
        String tpname = null;
//        String sql = "Select topicname from Topic where idtopic = ?";
        try {
            DAO d = new DAO();
             Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from topic");
            while(rs.next())
            {
                if(idtp==(rs.getInt("idtopic")))
                {
                    tpname = rs.getString("topicname");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tpname;
    }

    public ArrayList<Topic> getTopicInfo() // lay Topic info
    {
        ArrayList<Topic> listTP = new ArrayList();
        String sql = "Select * from topic";
        try {
            DAO d = new DAO();
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idtopic = rs.getInt("idtopic");
                String topicname = rs.getString("topicname");
                Topic t = new Topic(idtopic, topicname);
                listTP.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTP;
    }
    public void edit_topic(Topic a){
        String sql = "UPDATE topic SET topicname=? WHERE idtopic=?";
   
        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
            pst.setString(1, a.getTopicname());
            pst.setInt(2, a.getIdtopic());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void delete_topic(Topic a) {
        String sql = "DELETE FROM topic WHERE idtopic=?";
        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
            pst.setInt(1, a.getIdtopic());
            pst.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    
         
    public ArrayList<Word> getWordInfo() // lay Topic info
    {
        ArrayList<Word> listw = new ArrayList();
        String sql = "Select idword,en,vn,idtopic from word";
//        String sql = "Select idword,en,vn,idtopic,topicname from Word INNER JOIN Topic ON idtopic = Topic.idtopic";
        try {
            DAO d = new DAO();
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idword = rs.getInt("idword");
                String en = rs.getString("en");
                String vn = rs.getString("vn");
                 int idtopic = rs.getInt("idtopic");
//                String nametopic = rs.getString("topicname");
                Word w = new Word(idword,en,vn, idtopic); //sua
                listw.add(w);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listw;
    }
    
      public void edit_word(Word a){
        String sql = "UPDATE word SET en=?,vn=?, idtopic=? WHERE idword=?";
   
        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
            pst.setString(1, a.getEn());
            pst.setString(2, a.getVn());
            pst.setInt(3, a.getIdtopic());
             pst.setInt(4, a.getIdword());
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
    public void delete_word(Word a) {
        String sql = "DELETE FROM word WHERE idword=?";
        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
            pst.setInt(1, a.getIdword());
            pst.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
