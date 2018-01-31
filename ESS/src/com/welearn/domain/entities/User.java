/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.entities;

import java.util.Date;

/**
 *
 * @author Alexander
 */
public class User {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private Date dob;

    public User(String username, String password, String firstname, String lastname, String address, Date dob)
    {
        setUsername(username);
        setPassword(password);
        setFirstname(firstname);
        setLastname(lastname);
        setAddress(address);
        setDob(dob);
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        String userInfo = "user name : " + username +
                "first name : " + firstname +
                "last name : " + lastname +
                "address : " + address;
        return userInfo;
    }
    
    
}
