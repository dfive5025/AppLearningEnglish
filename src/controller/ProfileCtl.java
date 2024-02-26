/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import model.Person;

/**
 *
 * @author hoaianh_Kyros
 */
public class ProfileCtl {
    public Person getPersonInformation()// Lấy thông tin người dùng
    {
        Person person = null;
        String sql = "Select * from person where idperson = '" + TopicCtl.idperson + "'" ;
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
}
