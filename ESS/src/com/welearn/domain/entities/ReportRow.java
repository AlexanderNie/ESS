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
public class ReportRow {
    private String type;
    private String level;
    private Integer pass;
    private Integer fail;
    private Integer score;

    public ReportRow(String type, String level, Integer pass, Integer fail, Integer score)
    {
        setType(type);
        setLevel(level);
        setPass(pass);
        setFail(fail);
        setScore(score);
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
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the pass
     */
    public Integer getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(Integer pass) {
        this.pass = pass;
    }

    /**
     * @return the fail
     */
    public Integer getFail() {
        return fail;
    }

    /**
     * @param fail the fail to set
     */
    public void setFail(Integer fail) {
        this.fail = fail;
    }

    /**
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}
