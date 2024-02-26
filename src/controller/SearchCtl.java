/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import model.Word;

/**
 *
 * @author Admin
 */
public class SearchCtl {
    public String wordResult(String en) // Tra lai nghia tieng viet cua tu tim kiem
    {
        String result = null;
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from word");
            while(rs.next())
            {
                if(en.equalsIgnoreCase(rs.getString("en")))
                {
                    result = rs.getString("vn");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean checkWordExits(int idperson, String en) // Kiem tra xem tu vung can tim kiem co trong tu dien hay khong?
    {
        String sql = "select en from word\n" +
                     "inner join personword on word.idword = personword.idword\n" +
                     "where idperson = " + idperson;
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                if(en.trim().equalsIgnoreCase(rs.getString("en")))
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<String> getWordFromDB(){ //search show recommend
         
            ArrayList<String> list1 = new ArrayList<>();
//          String sql = "select * from Word\n" 
//                  + "where en\n"
//                  + "like '" + en + "%'";
          String sql = "select en from word";
        try {
            DAO d = new DAO();
            Statement st = d.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                String a = rs.getString("en");
                list1.add(a);
 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list1;
    } 
    
//    public static void main(String[] args) {
////        Scanner s = new Scanner(System.in);
////        String a = s.nextLine();
//         SearchCtl g = new SearchCtl();
//        ArrayList<String> wordL = g.getWordFromDB();
//        for (String bc : wordL) {
//            System.out.println(bc);
//        }
//    }
//    public static void main(String[] args) {
//                 SearchCtl g = new SearchCtl();
//        ArrayList<String> wordL = g.getWordFromDB();
//        for (String bc : wordL) {
//            System.out.println(bc);
//        }
//    }
}
