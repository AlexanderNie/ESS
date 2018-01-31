/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.service;

import com.welearn.domain.entities.QuizResult;
import com.welearn.domain.entities.QuizStruct;
import com.welearn.domain.entities.ReportRow;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Alexander
 */
public class SummaryService {
    
    private Sheet structSheet;
    
    
    private List<QuizResult> _progress = new ArrayList<QuizResult>();
    private List<QuizStruct> structs = new ArrayList<QuizStruct>();
    
    private Integer TYPE = 0;
    private Integer LEVEL = 1;
    
    public SummaryService()
    {
        structSheet = FileService.getQuizStructSheet();
    }

    public void updateProgress(List<QuizResult> progress)
    {
        Iterator<QuizResult> itProgress = progress.iterator();
        while (itProgress.hasNext())
        {
            QuizResult qr = itProgress.next();
            _progress.add(qr);
        }
    }
    public void load()
    {
        Iterator<Row> iterator = structSheet.iterator();
        iterator.next();;
        while (iterator.hasNext()) {
            Row questionRow = iterator.next();
            String type = questionRow.getCell(TYPE).getStringCellValue();
            Integer level = (int)questionRow.getCell(LEVEL).getNumericCellValue();
            QuizStruct struct = new QuizStruct(type, level);
            structs.add(struct);
        }    
    }
    
    public void show()
    {
        Iterator<QuizStruct> itStruct =  structs.iterator();
        itStruct.next();
        while(itStruct.hasNext())
        {
            QuizStruct struct = itStruct.next();
            System.out.println(struct);
        }
    }
    
    public List<ReportRow> getReportData()
    {
        List<ReportRow> summary = new ArrayList<ReportRow>();
        
        Iterator<QuizStruct> iterQs =  structs.iterator();
        while(iterQs.hasNext())
        {
            int score = 0;
            QuizStruct qs = iterQs.next();
            
            List<QuizResult> correctDone = _progress.stream()
                .filter(q -> q.getLevel().equals(qs.getLevel()) 
                        && q.getType().equals(qs.getType())
                        && q.isPass())
                .collect(Collectors.toList());
            for(QuizResult unit : correctDone)
            {
               score += unit.getWeight();
            }
            int fail = _progress.stream()
                .filter(q -> q.getLevel().equals(qs.getLevel()) 
                        && q.getType().equals(qs.getType())
                        && !q.isPass())
                .collect(Collectors.toList()).size();
            ReportRow rr = new ReportRow(qs.getType(), qs.getLevel().toString(), correctDone.size(), fail, score);
            summary.add(rr);
        }
        return summary;
    }
}
