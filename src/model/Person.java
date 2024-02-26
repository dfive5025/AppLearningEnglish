/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Person {
    private int idperson;
    private String uusername;
    private String upassword;
    private String uname;
    private String ugender;
    private Date ubirthday;
    private String uaddress;
    private String utelephone;
    private String uemail;
    private int uMyrank;
    private int uTotalScore;
    private int uIsAdmin;
 
    public Person() {
    }

    public Person(String uname, String ugender, Date ubirthday, String uaddress, String utelephone, String uemail) {
        this.uname = uname;
        this.ugender = ugender;
        this.ubirthday = ubirthday;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
    }

    public Person(int idperson, String uusername, String upassword, String uname, String ugender, Date ubirthday, String uaddress, String utelephone, String uemail, int uMyrank, int uTotalScore, int uIsAdmin) {
        this.idperson = idperson;
        this.uusername = uusername;
        this.upassword = upassword;
        this.uname = uname;
        this.ugender = ugender;
        this.ubirthday = ubirthday;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
        this.uMyrank = uMyrank;
        this.uTotalScore = uTotalScore;
        this.uIsAdmin = uIsAdmin;
    }
    
    public Person(int idperson ,String uusername, String upassword, String uname, String ugender, String uaddress, String utelephone, String uemail, int myrank, int highscore,int Ismyadmin) {
        this.idperson = idperson;
        this.uusername = uusername;
        this.upassword = upassword;
        this.uname = uname;
        this.ugender = ugender;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
        this.uMyrank = myrank;
        this.uTotalScore = highscore;
        this.uIsAdmin = Ismyadmin;
    }
      public Person(int idperson ,String uusername, String uname, String ugender, String uaddress, String utelephone, String uemail,int Ismyadmin) {
        this.idperson = idperson;
        this.uusername = uusername;
        this.uname = uname;
        this.ugender = ugender;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
        this.uIsAdmin = Ismyadmin;
    }
     public Person(int idperson ,String uusername, String upassword, String uname, String ugender, String uaddress, String utelephone, String uemail, int highscore,int Ismyadmin) {
        this.idperson = idperson;
        this.uusername = uusername;
        this.upassword = upassword;
        this.uname = uname;
        this.ugender = ugender;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
        this.uTotalScore = highscore;
        this.uIsAdmin = Ismyadmin;
    }
      public Person(int idperson ,String uusername, String uname, String ugender, String uaddress, String utelephone, String uemail) {
        this.idperson = idperson;
        this.uusername = uusername;
        this.uname = uname;
        this.ugender = ugender;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
    }
        public Person(int idperson , String uusername, String uname, String ugender,Date bd, String uaddress, String utelephone, String uemail, int Ismyadmin) {
        this.idperson = idperson;
        this.uusername = uusername;
        this.upassword = upassword;
        this.uname = uname;
        this.ugender = ugender;
        this.ubirthday = bd;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
        this.uIsAdmin = Ismyadmin;
    }
    
     public Person(String uusername, String upassword, String uname, String ugender,Date bd, String uaddress, String utelephone, String uemail, int Ismyadmin) {
        this.uusername = uusername;
        this.upassword = upassword;
        this.uname = uname;
        this.ugender = ugender;
        this.ubirthday = bd;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
        this.uIsAdmin = Ismyadmin;
    }
    

    public Person(int idperson, String Name, String gender, String address, String phone, String email, int myrank, int totalscore, int admin) {
       this.idperson = idperson;
        this.uname = uname;
        this.ugender = ugender;
        this.uaddress = uaddress;
        this.utelephone = utelephone;
        this.uemail = uemail;
        this.uMyrank = myrank;
        this.uTotalScore = totalscore;
        this.uIsAdmin = admin;
    }

    public Person(int idperson) {
        this.idperson = idperson;
    }


    public String getUusername() {
        return uusername;
    }

    public void setUusername(String uusername) {
        this.uusername = uusername;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUgender() {
        return ugender;
    }

    public void setUgender(String ugender) {
        this.ugender = ugender;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUtelephone() {
        return utelephone;
    }

    public void setUtelephone(String utelephone) {
        this.utelephone = utelephone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public int getuMyrank() {
        return uMyrank;
    }

    public void setuMyrank(int uMyrank) {
        this.uMyrank = uMyrank;
    }

    public int getuTotalScore() {
        return uTotalScore;
    }

    public void setuTotalScore(int uTotalScore) {
        this.uTotalScore = uTotalScore;
    }

    public int getuIsAdmin() {
        return uIsAdmin;
    }

    public void setuIsAdmin(int uIsAdmin) {
        this.uIsAdmin = uIsAdmin;
    }

    public Date getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(java.util.Date ubirthday) {
        this.ubirthday = ubirthday;
    }

   
    
}