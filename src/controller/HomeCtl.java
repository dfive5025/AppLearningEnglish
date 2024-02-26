/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Person;
import view.LoginView;

/**
 *
 * @author Admin
 */
public class HomeCtl {
    public void updateRank(int idperson, int rank) // Kiem tra tai khoan va mat khau dung?
    {
        DAO d = new DAO();
        String sql = "update person SET uMyrank=? where idperson=?";
        try 
        {   PreparedStatement pst = d.conn.prepareStatement(sql);
            pst.setInt(1, rank);
            pst.setInt(2, idperson);
//            Statement st = d.conn.createStatement();
            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
 
}
