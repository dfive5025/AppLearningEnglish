/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Person;
import model.Word;

/**
 *
 * @author Admin
 */
public class MyprofileCtl {
      public Person getPersonInfo(int idperson) 
    {
        ArrayList<Person> P1 = new ArrayList<>();
        Person p = null;
        String sql = "select * from person\n" +
                       "where idperson = '" + idperson +"'";
        try {
            DAO d = new DAO();
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                int idper = rs.getInt("idperson");
                String username = rs.getString("uusername");
                 String upass = rs.getString("upassword");
                String uname = rs.getString("uname");
                String ugender = rs.getString("ugender");
                String uaddress = rs.getString("uaddress");
                String uphone = rs.getString("utelephone");
                String uemail = rs.getString("uemail");
                int umyrank = rs.getInt("uMyrank");
                int uhighscore = rs.getInt("uTotalScore");
//                p = new Person(idper, username, upass, uname,ugender,uaddress,uphone, uemail,umyrank,uhighscore);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
      
        public void changPass(int idperson, String pass) // doi pass
    {
        String sql = "UPDATE person SET upassword = '" + pass +"'\n"
                + " WHERE idperson = '" + idperson + "'";

        try {
            DAO d = new DAO();
             PreparedStatement ps = d.conn.prepareStatement(sql);
            ps.setString(1,pass);
            ps.setInt(2,idperson);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
