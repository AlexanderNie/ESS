/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.entities;

import java.util.List;

/**
 *
 * @author weiwei2017
 */
public class Questions {
    private int qId;
    private String description;
    private List<Answers> answers;

    
    public Questions(int id, String desciption, List<Answers> answers)
    {
        this.qId = id;
        this.description = desciption;
        this.answers = answers;
    }
    /**
     * @return the QId
     */
    public int getQId() {
        return qId;
    }

    /**
     * @param QId the QId to set
     */
    public void setQId(int QId) {
        this.qId = QId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the answers
     */
    public List<Answers> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
    
}
