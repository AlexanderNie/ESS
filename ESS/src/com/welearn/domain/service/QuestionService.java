/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.service;

import com.welearn.domain.entities.Answers;
import com.welearn.domain.entities.QAPair;
import com.welearn.domain.entities.Questions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author weiwei2017
 */
public class QuestionService {
    private List<Questions> questions = new ArrayList<Questions>();
    private Map<Integer, List<Answers>> answers = new HashMap<Integer, List<Answers>>();

    // question sheet sequence  and column sequence 
    
    private static final int Q_ID = 0;
    private static final int Q_DESCRIPTION = 1;
    private static final int Q_HINT = 2;
    private static final int Q_WEIGHT = 3;
    private static final int Q_LEVEL = 4;
    private static final int Q_TYPE = 5;

    // answer sheet sequence  and column sequence 
    
    private static final int A_ID = 0;
    private static final int A_QID = 1;
    private static final int A_DESCRIPTION = 2;
    private static final int A_RIGHT = 3;

    private Sheet questionsheet;
    private Sheet answersheet;

    public QuestionService() {
            questionsheet = FileService.getQuestionSheet();
            answersheet = FileService.getAnswerSheet();
    }

    private void LoadQuestions() {
        Iterator<Row> iterator = questionsheet.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row questionRow = iterator.next();
            Questions q = new Questions((int) questionRow.getCell(Q_ID).getNumericCellValue(),
                    questionRow.getCell(Q_DESCRIPTION).getStringCellValue(),
                    questionRow.getCell(Q_HINT).getStringCellValue(),
                    (int) questionRow.getCell(Q_WEIGHT).getNumericCellValue(),
                    (int) questionRow.getCell(Q_LEVEL).getNumericCellValue(),
                    questionRow.getCell(Q_TYPE).getStringCellValue());
            questions.add(q);
        }
        
    }

    private void loadAnswers() {
        Iterator<Row> iterator = answersheet.iterator();
        iterator.next();
        List<Answers> tempAnaswerLib = new ArrayList<Answers>();
        while (iterator.hasNext()) {
            Row answerRow = iterator.next();
            Answers a = new Answers((int) answerRow.getCell(A_ID).getNumericCellValue(),
                    (int) answerRow.getCell(A_QID).getNumericCellValue(),
                    answerRow.getCell(A_DESCRIPTION).getStringCellValue(),
                    answerRow.getCell(A_RIGHT).getBooleanCellValue());
            tempAnaswerLib.add(a);
        }

        Collections.sort(tempAnaswerLib);
        Iterator<Answers> iterQ = tempAnaswerLib.iterator();
        while (iterQ.hasNext()) {
            List<Answers> subAnswerList = new ArrayList<Answers>();
            for (int i = 0; i < 4; i++) {
                Answers a = iterQ.next();
                subAnswerList.add(a);
            }
            answers.put(subAnswerList.get(0).getqId(), subAnswerList);
        }

    }

    private void printQuestion() {
        Iterator<Questions> iterQ = questions.iterator();
        while (iterQ.hasNext()) {
            Questions q = iterQ.next();
            System.out.println(q);
        }
    }

    private void printAnswers() {
        Iterator<Map.Entry<Integer, List<Answers>>> iterAMap = answers.entrySet().iterator();
        while (iterAMap.hasNext()) {
            Map.Entry pair = (Map.Entry) iterAMap.next();
            List<Answers> answers = (List<Answers>) pair.getValue();
            Iterator<Answers> iterAList = answers.iterator();
            while (iterAList.hasNext()) {
                Answers a = iterAList.next();
                System.out.println(a);
            }
        }
    }

    private void clearData() {
        answers.clear();
        questions.clear();
    }

    public void load() {
        if (questions.isEmpty()) {
            System.out.println("==============loading question===============");
            LoadQuestions();
        }
        if (answers.isEmpty()) {
            System.out.println("==============loading answers===============");
            loadAnswers();
        }
    }
    
    public QAPair nextQuestion()
    {
        Random generator = new Random();
        int index = generator.nextInt(questions.size());
        Questions q = questions.get(index);
        List<Answers>  qanswer = answers.get(q.getqId());
        System.out.println("==============generating question==============");
        System.out.println(q);
        Iterator<Answers> itQanswer = qanswer.iterator();
        while(itQanswer.hasNext())
        {
            Answers ans = itQanswer.next();
            System.out.println(ans);
        }
        System.out.println("==============end generating question==============");
        return new QAPair(q, qanswer);
    }
}
