/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import model.Person;

/**
 *
 * @author hoaianh_Kyros
 */
public class EditProfileCtl {
    public void updateInformation(String uname, String ugender, String utelephone, String uaddress, String uemail)
    {
        DAO d = new DAO();
//        String sql = "UPDATE PERSON SET UNAME = ?, UGENDER = ?, UTELEPHONE = ? , UADDRESS = ?, UEMAIL = ?"
//                + " WHERE IDPERSON = '" + TopicCtl.idperson + "'";
         String sql = "UPDATE PERSON SET UNAME = ?, UGENDER = ?, UTELEPHONE = ? , UADDRESS = ?, UEMAIL = ?"
                + " WHERE IDPERSON = ?";
        try {
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ps.setString(1,uname );
            ps.setString(2, ugender);
            ps.setString(3, utelephone);
            ps.setString(4, uaddress);
            ps.setString(5, uemail);
            ps.setInt(6,TopicCtl.idperson );
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateInformation(String uname, String ugender,Date bd, String utelephone, String uaddress, String uemail)
    {
        DAO d = new DAO();
//        String sql = "UPDATE person SET uname = ?, ugender = ?,uBirthday=?, utelephone = ? , uaddress = ?, uemail = ?"
//                + " WHERE idperson = '" + TopicCtl.idperson + "'";
 String sql = "UPDATE person SET uname = ?, ugender = ?,uBirthday=?, utelephone = ? , uaddress = ?, uemail = ?"
                + " WHERE idperson = ?";
        try {
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2, ugender);
            ps.setTimestamp(3, new java.sql.Timestamp(bd.getTime()));
            ps.setString(4, utelephone);
            ps.setString(5, uaddress);
            ps.setString(6, uemail);
             ps.setInt(7,TopicCtl.idperson );
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkCurrentPassword(String password) // Kiem tra tai khoan va mat khau dung?
    {
        DAO d = new DAO();
//        String sql = "Select Upassword from person where idperson = '" + TopicCtl.idperson +"'";
         String sql = "Select Upassword from person where idperson = ?";
        try 
        {
           PreparedStatement pst = d.conn.prepareStatement(sql);
             pst.setInt(1, TopicCtl.idperson);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                if(password.equals(rs.getString("Upassword")))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } 
    public void changePassword(String password)
    {
        DAO d = new DAO();
//        String sql = "UPDATE PERSON SET UPASSWORD = ? WHERE IDPERSON = '" + TopicCtl.idperson + "'";
        String sql = "UPDATE PERSON SET UPASSWORD = ? WHERE IDPERSON = ?";
        try {
            PreparedStatement ps = d.conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setInt(2,TopicCtl.idperson);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
