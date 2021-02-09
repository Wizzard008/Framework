package com.epam.automation.service;

import com.epam.automation.model.User;

public class UserCreator {
    public static final String USER_NAME = "testdata.user.name";
    public static final String USER_SURNAME = "testdata.user.surname";
    public static final String EMAIL_ADDRESS = "testdata.email.address";
    public static final String PROJECT = "testdata.project";
    public static final String TITLE = "testdata.title";
    public static final String COMPANY = "testdata.company";

    public static User generateUserWithProperties(){
        return new User(
                TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_SURNAME),
                TestDataReader.getTestData(EMAIL_ADDRESS),
                TestDataReader.getTestData(PROJECT),
                TestDataReader.getTestData(TITLE),
                TestDataReader.getTestData(COMPANY)
        );
    }
}
