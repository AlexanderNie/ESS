/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.service;

/**
 *
 * @author Alexander
 */
public class Configuration {
    public static final String FILE_NAME = "com/welearn/resources/questions.xlsx";
    public static final Integer QUESTION = 0;
    public static final Integer ANSWER = 1;
    public static final Integer USERS = 3;
    public static final Integer QUIZ_STRUCTURE = 4;
    public static final Integer QUIZ_SIZE = 20;
    public static final Integer QUIZ_MAX_TIME = 20*60;
    public static final Integer WARNING_LEVEL_1 = 15*60;
    public static final Integer WARNING_LEVEL_2 = 5*60;
    public static final Integer HINT_TIME = 10;
    
    public static final String ALGO = "AES";
    public static final byte[] keyValue =
    new byte[]{'.','.','T', 'i', 'm', 'e', 'i', 's', 'c', 'o', 'm', 'i', 'n', 'g',',',','};
    public static final String AUTHOR ="AlexanderNie";
    
}
