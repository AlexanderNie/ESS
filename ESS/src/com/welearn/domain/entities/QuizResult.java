/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.entities;

/**
 *
 * @author Alexander
 */
public class QuizResult {
    private Integer qid;
    private String type;
    private Integer level;
    private Integer weight;
    private boolean pass;

    
    public QuizResult(Integer qid, String type, Integer level, Integer weight, boolean pass)
    {
        setQid(qid);
        setType(type);
        setLevel(level);
        setWeight(weight);
        setPass(pass);
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return the weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return the pass
     */
    public boolean isPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(boolean pass) {
        this.pass = pass;
    }

    /**
     * @return the qid
     */
    public Integer getQid() {
        return qid;
    }

    /**
     * @param qid the qid to set
     */
    public void setQid(Integer qid) {
        this.qid = qid;
    }

    @Override
    public String toString() {
        return "question " +  getQid() + " answered  " +( isPass() ? "Right" : "Wrong");
    }
    
}
