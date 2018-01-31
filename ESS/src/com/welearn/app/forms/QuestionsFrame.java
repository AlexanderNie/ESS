/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.app.forms;

import com.welearn.ESSController;
import com.welearn.domain.entities.Answers;
import com.welearn.domain.entities.QAPair;
import com.welearn.domain.entities.QuizResult;
import com.welearn.domain.entities.User;
import com.welearn.domain.service.Configuration;
import com.welearn.domain.service.QuestionService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author weiwei2017
 */
public class QuestionsFrame extends javax.swing.JFrame {

    private boolean submitted = false;
    
    private QuestionService questionService = new QuestionService();
    private ESSController controller;
    javax.swing.Timer timer;
    Integer timeLeft;
    Integer hintsLeft;
    private QAPair qaPari;
    /**
     * Creates new form QuestiosFrame
     */
    public QuestionsFrame(ESSController _controller) {
        initComponents();
        setController(_controller);
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answerGroup = new javax.swing.ButtonGroup();
        lblTimer = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        rbAnswer1 = new javax.swing.JRadioButton();
        rbAnswer2 = new javax.swing.JRadioButton();
        rbAnswer3 = new javax.swing.JRadioButton();
        rbAnswer0 = new javax.swing.JRadioButton();
        btnNextQuestion = new javax.swing.JButton();
        lblSeq = new javax.swing.JLabel();
        btnHints = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();
        btnEnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblUserName.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(102, 102, 255));

        answerGroup.add(rbAnswer1);

        answerGroup.add(rbAnswer2);

        answerGroup.add(rbAnswer3);

        answerGroup.add(rbAnswer0);

        btnNextQuestion.setText("Next");
        btnNextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextQuestionActionPerformed(evt);
            }
        });

        btnHints.setText("Hints");
        btnHints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHintsActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnEnd.setText("End");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(lblSeq)
                        .addGap(38, 38, 38)
                        .addComponent(lblTimer))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAnswer1)
                            .addComponent(rbAnswer2)
                            .addComponent(rbAnswer3)
                            .addComponent(rbAnswer0)
                            .addComponent(lblQuestion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHints)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnd)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSeq)
                    .addComponent(lblTimer)
                    .addComponent(lblUserName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion)
                .addGap(18, 18, 18)
                .addComponent(rbAnswer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAnswer2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAnswer3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAnswer0)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextQuestion)
                    .addComponent(btnHints)
                    .addComponent(btnSubmit)
                    .addComponent(btnEnd))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextQuestionActionPerformed
        // TODO add your handling code here:
        if ( (!isSubmitted()))
        {
            checkAnswer();
        }
        loadQuestion();
        setSubmitted(false);
    }//GEN-LAST:event_btnNextQuestionActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        checkAnswer();
        setSubmitted(true);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnHintsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHintsActionPerformed
        // TODO add your handling code here:
        hintsLeft = Configuration.HINT_TIME;
        final JOptionPane msg = new JOptionPane(qaPari.getQuestion().getHint(), JOptionPane.INFORMATION_MESSAGE);
        
        final JDialog dlg = msg.createDialog("Hints");
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.setLocationRelativeTo(this);
        dlg.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                final Timer t = new Timer(1000,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dlg.setTitle("Hints is closing in " + hintsLeft + " Seconds");
                        if(hintsLeft<=0)
                        {
                            dlg.setVisible(false);
                        }
                        hintsLeft--;
                    }
                });
                t.start();
            }
        });
        dlg.setVisible(true);
    }//GEN-LAST:event_btnHintsActionPerformed

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
        // TODO add your handling code here:
        controller.goSummary();
    }//GEN-LAST:event_btnEndActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup answerGroup;
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnHints;
    private javax.swing.JButton btnNextQuestion;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblSeq;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JRadioButton rbAnswer0;
    private javax.swing.JRadioButton rbAnswer1;
    private javax.swing.JRadioButton rbAnswer2;
    private javax.swing.JRadioButton rbAnswer3;
    // End of variables declaration//GEN-END:variables

    private void render(QAPair qaPari) {
        setTitle("Q" +qaPari.getQuestion().getqId());
        lblQuestion.setText(qaPari.getQuestion().getDescription());
        List<Answers> ans = qaPari.getAnwers();
        rbAnswer0.setText(ans.get(0).getDescription()); 
        rbAnswer1.setText(ans.get(1).getDescription()); 
        rbAnswer2.setText(ans.get(2).getDescription()); 
        rbAnswer3.setText(ans.get(3).getDescription()); 
        answerGroup.clearSelection();
        pack();
    }

    /**
     * @return the controller
     */
    public ESSController getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(ESSController controller) {
        this.controller = controller;
    }

    private void loadQuestion() {
        if(!controller.finish())
        {
            qaPari =  questionService.nextQuestion();
            render(qaPari);
        }
        else
        {
            controller.goSummary();
        }
    }

    private void startTimer() {
        timeLeft = Configuration.QUIZ_MAX_TIME;
        timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer minutes =  timeLeft/60;
                Integer seconds = timeLeft % 60;
                lblTimer.setText(String.format("%02d", minutes) + " : " + String.format("%02d", seconds));
                if (timeLeft <= 0) {
                    System.out.println("======================Exame End======================");
                    timer.stop();
                    controller.goSummary();
                }
                timeLeft--;
                if(timeLeft< Configuration.WARNING_LEVEL_1) lblTimer.setForeground(Color.blue);
                if(timeLeft< Configuration.WARNING_LEVEL_2) lblTimer.setForeground(Color.red);
            }
        });
        System.out.println("======================Exame Begin======================");
        timer.start();
    }

    private void loadUser(User loginuser) {
        lblUserName.setText(loginuser.getFirstname() + " " +loginuser.getLastname());
    }

    public void start() {
        loadUser(controller.getLoginuser());
        startTimer();
        questionService.load();
        loadQuestion();
    }

    /**
     * @return the submitted
     */
    public boolean isSubmitted() {
        return submitted;
    }

    /**
     * @param submitted the submitted to set
     */
    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
        btnSubmit.setEnabled(!submitted);
    }

    private void checkAnswer() {
        QuizResult qz;
        if ((rbAnswer0.isSelected()&& qaPari.getAnwers().get(0).isRight()) ||
                    (rbAnswer1.isSelected()&& qaPari.getAnwers().get(1).isRight())||
                    (rbAnswer2.isSelected()&& qaPari.getAnwers().get(2).isRight())||
                            (rbAnswer3.isSelected()&& qaPari.getAnwers().get(3).isRight()))
            {
                qz = new QuizResult(qaPari.getQuestion().getqId(), qaPari.getQuestion().getType(), 
                        qaPari.getQuestion().getLevel(), qaPari.getQuestion().getWeight(), true);
            }
            else
            {
                qz = new QuizResult(qaPari.getQuestion().getqId(),qaPari.getQuestion().getType(), 
                        qaPari.getQuestion().getLevel(), qaPari.getQuestion().getWeight(), false);
            }
            System.out.println(qz);
            controller.updateProgress(qz);
    }

}
