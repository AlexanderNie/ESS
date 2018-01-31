/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Alexander
 */
public class FileService {

    
    private static final FileService INSTANCE = new FileService();
    private static Workbook filebook;

    private FileService() {
        try {
            Path temp;
            temp = Files.createTempFile(String.valueOf(System.currentTimeMillis()), ".ext");
            Files.copy(FileService.class.getClassLoader().getResourceAsStream(Configuration.FILE_NAME), temp, StandardCopyOption.REPLACE_EXISTING);
            filebook = new XSSFWorkbook(new FileInputStream(temp.toFile()));
        } catch (IOException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static FileService getInstance() {
        return INSTANCE;
    }
    
    
    public static Sheet getQuestionSheet()
    {
        return filebook.getSheetAt(Configuration.QUESTION);
    }
    
    public static Sheet getAnswerSheet()
    {
        return filebook.getSheetAt(Configuration.ANSWER);
    }
    
    public static Sheet getQuizStructSheet()
    {
        return filebook.getSheetAt(Configuration.QUIZ_STRUCTURE);
    }
    
    public static Sheet getUserSheet()
    {
        return filebook.getSheetAt(Configuration.USERS);
    }
}
