/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn;

import com.welearn.app.forms.LoginFrame;
import com.welearn.app.forms.QuestionsFrame;
import com.welearn.app.forms.SummaryFrame;
import com.welearn.domain.entities.QuizResult;
import com.welearn.domain.entities.User;
import com.welearn.domain.service.Configuration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author weiwei2017
 */
public class ESSController {

    /**
     * @return the progress
     */
    public List<QuizResult> getProgress() {
        return progress;
    }
    private Integer completed_size =0;
    private LoginFrame loginFrame;
    private QuestionsFrame qFrame;
    private SummaryFrame summaryFrame;
    private List<QuizResult> progress = new ArrayList<QuizResult>();
    
    private User loginuser;
    
    public ESSController()
    {
        loginFrame = new LoginFrame(this);
        qFrame = new QuestionsFrame(this);
        summaryFrame = new SummaryFrame(this);
        
        loginFrame.setVisible(true);
    }
    /**
     * @param args the command line arguments
     * 
     * This is from Alexander Nie
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ESSController ess = new ESSController();
    }

    public void goQuestionFrame() {
        loginFrame.setVisible(false);
        qFrame.start();
        qFrame.setVisible(true);
    }    

    public void goSummary() {
        qFrame.setVisible(false);
        summaryFrame.summary();
        summaryFrame.setVisible(true);
    }

    public boolean finish() {
        if(completed_size<Configuration.QUIZ_SIZE)
        {
            completed_size++;
            return false;
        }
        return true;
    }

    public void setupUserProfile(User loginUser) {
        setLoginuser(loginUser);
    }

    /**
     * @return the loginuser
     */
    public User getLoginuser() {
        return loginuser;
    }

    /**
     * @param loginuser the loginuser to set
     */
    public void setLoginuser(User loginuser) {
        this.loginuser = loginuser;
    }

    public void updateProgress(QuizResult qz) {
        getProgress().add(qz);
    }

    public void logout() {
        System.exit(0);
    }
}