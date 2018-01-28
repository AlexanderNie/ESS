/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.service;

import com.welearn.domain.entities.Questions;
import java.util.List;

/**
 *
 * @author weiwei2017
 */
public class QuestionService {
    private   List<Questions> questions;
    
    QuestionService()
    {
        Questions q = new Questions(1, " is it 1+1 =2 ?", null);
        questions.add(q);
    }
}
