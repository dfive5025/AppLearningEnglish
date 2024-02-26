/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hoaianh_Kyros
 */
public class GameArrangeCtl {
    public ArrayList<String> getRandomWordList() // Chon 10 tu ngau nhien trong danh sach tu vung cua user de on tap
    {
        ArrayList<String> arr = new ArrayList<>();
        String sql = "SELECT TOP 10 EN FROM WORD\n" +
                "INNER JOIN PERSONWORD ON WORD.IDWORD = PERSONWORD.IDWORD\n" +
                "WHERE IDPERSON = '" + TopicCtl.idperson + "'"   +
                     "\nORDER BY NEWID()";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                arr.add(rs.getString("en").trim());
            }
        } catch (SQLException e) {
        }
        return arr;
    }
    
    public boolean checkAnswer(String a) // Kiem tra dap an nhap cua user 
    {
//        String sql = "SELECT EN FROM WORD\n" +
//                "INNER JOIN PERSONWORD ON WORD.IDWORD = PERSONWORD.IDWORD\n" +
//                "WHERE IDPERSON = '" + TopicCtl.idperson + "'";
         String sql = "SELECT EN FROM WORD\n" +
                "INNER JOIN PERSONWORD ON WORD.IDWORD = PERSONWORD.IDWORD\n" +
                "WHERE IDPERSON = ?";
        try {
            DAO d = new DAO();
            PreparedStatement pst = d.conn.prepareStatement(sql);
             pst.setInt(1, TopicCtl.idperson);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                if(a.equalsIgnoreCase(rs.getString("en")))
                    return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
}
