/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Word {
    private int idword;
    private String en;
    private String vn;
    private int idtopic;

    public Word() {
    }
      public Word( String en, String vn, int idtopic) {
        this.en = en;
        this.vn = vn;
        this.idtopic = idtopic;
    }

    public Word(int idword, String en, String vn, int idtopic) {
        this.idword = idword;
        this.en = en;
        this.vn = vn;
        this.idtopic = idtopic;
    }
    

    public Word(int idword) {
           this.idword =idword;
    }



    public int getIdword() {
        return idword;
    }

    public void setIdword(int idword) {
        this.idword = idword;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public int getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(int idtopic) {
        this.idtopic = idtopic;
    }


    
}
