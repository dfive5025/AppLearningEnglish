/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.Person;

/**
 *
 * @author hoaianh_Kyros
 */
public class StatisticalCtl {
    public void updateScore(float score)
    {
        ProfileCtl profileCtl = new ProfileCtl();
        float totalScore = profileCtl.getPersonInformation().getuTotalScore();
        totalScore += score;
        DAO d = new DAO();
        String sql = "UPDATE PERSON SET uTotalScore = ? WHERE IDPERSON = '" + TopicCtl.idperson + "'";
        try {
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ps.setFloat(1,totalScore);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Person> getRank()
    {
        ArrayList<Person> personList = new ArrayList<>();
        String sql = "Select * from person where uIsAdmin = 0 order by uTotalScore desc" ;
        try 
        {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int idPerson = rs.getInt("idperson");
                String uusername = rs.getString("uusername");
                String upassword = rs.getString("upassword");
                String uname = rs.getString("uname");
                String ugender = rs.getString("ugender");
                String uaddress = rs.getString("uaddress");
                String utelephone = rs.getString("utelephone");
                String uemail = rs.getString("uemail");
                int uscore = rs.getInt("uTotalScore");
                int uAdmin = rs.getInt("uIsAdmin");
                Person person = new Person(idPerson, uusername,upassword, uname, ugender, uaddress, utelephone, uemail,uscore, uAdmin); 
                personList.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
        return personList;
    }
    
    public ArrayList<Person> getRank2()
    {   int r = 0;
        ArrayList<Person> personList = new ArrayList<>();
        String sql = "Select * from person where uIsAdmin = 0 order by uTotalScore desc" ;
        try 
        {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int idPerson = rs.getInt("idperson");
                String uusername = rs.getString("uusername");
                String upassword = rs.getString("upassword");
                String uname = rs.getString("uname");
                String ugender = rs.getString("ugender");
                String uaddress = rs.getString("uaddress");
                String utelephone = rs.getString("utelephone");
                String uemail = rs.getString("uemail");
                r = r+1;
                int uscore = rs.getInt("uTotalScore");
                int uAdmin = rs.getInt("uIsAdmin");
                Person person = new Person(idPerson, uusername,upassword, uname, ugender, uaddress, utelephone, uemail,r,uscore, uAdmin); 
                personList.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
        return personList;
    }
    
    public Person getPersonInfor(String name)
    {
        Person person = null;
        String sql = "Select * from person where uusername = '" + name + "'";
        try 
        {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int idPerson = rs.getInt("idperson");
                String uusername = rs.getString("uusername");
                String upassword = rs.getString("upassword");
                String uname = rs.getString("uname");
                String ugender = rs.getString("ugender");
                Date uBd = rs.getDate("uBirthday");
                String uaddress = rs.getString("uaddress");
                String utelephone = rs.getString("utelephone");
                String uemail = rs.getString("uemail");
                int myrank = rs.getInt("uMyrank");
                int uscore = rs.getInt("uTotalScore");
                int uAdmin = rs.getInt("uIsAdmin");
                person = new Person(idPerson, uusername,upassword, uname, ugender,uBd, uaddress, utelephone, uemail,myrank, uscore, uAdmin);
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
        return person;
    }
    
    
    public int countSilverMember()
    {
        int silverMember = 0;
        String sql = "select idperson, count (idperson) as [total] from personword group by idperson " + 
                        "having count(idperson) >= 10 and count(idperson) <= 20";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                silverMember++;
            }
        } catch (Exception e) {
        }
        return silverMember;
    }
    
    public int countGoldMember()
    {
        int goldMember = 0;
        String sql = "select idperson, count (idperson) as [total] from personword group by idperson " + 
                        "having count(idperson) >= 20 and count(idperson) <= 50";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                goldMember++;
            }
        } catch (Exception e) {
        }
        return goldMember;
    }
    
    
    public int countDiamondMember()
    {
        int diamondMember = 0;
        String sql = "select idperson, count (idperson) as [total] from personword group by idperson " + 
                        "having  count(idperson) >= 50";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                diamondMember++;
            }
        } catch (Exception e) {
        }
        return diamondMember;
    }
    
    public int countMember()
    {
        int totalMember = 0;
        String sql = "select count(*) as [total_member] from person";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                totalMember = rs.getInt("total_member");
            }
        } catch (Exception e) {
        }
        return totalMember;
    } 
}
