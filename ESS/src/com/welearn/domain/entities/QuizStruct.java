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
public class QuizStruct {
    private String type;
    private Integer level;

    public QuizStruct(String type, Integer level)
    {
        setType(type);
        setLevel(level);
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

    @Override
    public String toString() {
        return " type => "+ type + ", level =>" + level;
    }
    
    
}
