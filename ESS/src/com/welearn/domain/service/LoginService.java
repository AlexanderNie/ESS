/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.service;

import com.welearn.domain.entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class LoginService {
    
    public static final String NO_SUCH_USER = "please check user name";
    public static final String INVALID_PASSWORD = "please check password";
    public static final String INVALID_ACCT= "please contact admin for account issue";
    public static final String LOGIN_SUCCESS = "login success";
            
    List<User> users = new ArrayList<User>();
    private Sheet usersheet;
    
    private static final Integer USER_NAME = 0;
    private static final Integer PASSWORD = 1;
    private static final Integer FIRST_NAME = 2;
    private static final Integer LAST_NAME = 3;
    private static final Integer ADDRESS = 4;
    private static final Integer DOB = 5;
    
    private Date loginDate;
    private User loginUser;
    
    
    public LoginService()
    {
        usersheet = FileService.getUserSheet();
    }
    
    public void loadUsers()
    {
        
        Iterator<Row> iterator = usersheet.iterator();
        iterator.next();;
        while (iterator.hasNext()) {
            Row questionRow = iterator.next();
            String username = questionRow.getCell(USER_NAME).getStringCellValue();
            String password = questionRow.getCell(PASSWORD).getStringCellValue();
            String firstname = questionRow.getCell(FIRST_NAME).getStringCellValue();
            String lastname = questionRow.getCell(LAST_NAME).getStringCellValue();
            String address = questionRow.getCell(ADDRESS).getStringCellValue();
            Date dob = questionRow.getCell(DOB).getDateCellValue();
            User user = new User(username, password, firstname, lastname, address, dob);
            users.add(user);
        }    
    }
    
    public void showUsers()
    {
        Iterator<User> itUser =  users.iterator();
        while(itUser.hasNext())
        {
            User user = itUser.next();
            System.out.println(user);
        }
    }
    
    public String ValidateUser(String _username, String _password)
    {
        List<User> matchusers = users.stream()
                .filter(q -> q.getUsername().equals(_username))
                .collect(Collectors.toList());
        if (matchusers.isEmpty()) return NO_SUCH_USER;
        List<User> matchpassword = matchusers.stream()
                .filter(q -> q.getPassword().equals(_password))
                .collect(Collectors.toList());
        if (matchpassword.size() < 1) return INVALID_PASSWORD;
        if (matchpassword.size() > 1) return INVALID_ACCT;
        setLoginDate(new Date());
        setLoginUser(matchpassword.get(0));
        return LOGIN_SUCCESS;
    }

    /**
     * @return the loginDate
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * @param loginDate the loginDate to set
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * @return the loginUser
     */
    public User getLoginUser() {
        return loginUser;
    }

    /**
     * @param loginUser the loginUser to set
     */
    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }
    
    public static void main(String[] args)
    {
        new LoginService();
    }
}
