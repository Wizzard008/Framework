package com.epam.automation.service;

import com.epam.automation.model.User;

public class UserCreator {
    public static final String USER_NAME="Test_User_Name";
    public static final String USER_SURNAME="Test_User_Surname";
    public static final String EMAIL_ADDRESS="noname@company.com";
    public static final String PROJECT = "Test Automation Training";
    public static final String TITLE = "Engineer";
    public static final String COMPANY = "Test_Company";

    public static User generateUserWithDefaultProperties(){
        return new User(USER_NAME, USER_SURNAME, EMAIL_ADDRESS, PROJECT, TITLE, COMPANY);
    }
}
