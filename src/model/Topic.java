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
public class Topic {
    private int idtopic;
    private String topicname;

    public Topic() {
    }
    
      public Topic(int idtopic) {
        this.idtopic = idtopic;
    }

    public Topic(int idtopic, String topicname) {
        this.idtopic = idtopic;
        this.topicname = topicname;
    }

    public int getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(int idtopic) {
        this.idtopic = idtopic;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

}
