package com.epam.automation.service;

import com.epam.automation.model.User;

public class UserCreator {
    public static final String USER_NAME="test.user.name";
    public static final String USER_SURNAME="test.user.surname";
    public static final String EMAIL_ADDRESS="test.email.address";
    public static final String PROJECT = "test.project";
    public static final String TITLE = "test.title";
    public static final String COMPANY = "test.company";

    public static User generateUserWithDefaultProperties(){
//        return new User(
//                TestDataReader.getTestData(USER_NAME),
//                TestDataReader.getTestData(USER_SURNAME),
//                TestDataReader.getTestData(EMAIL_ADDRESS),
//                TestDataReader.getTestData(PROJECT),
//                TestDataReader.getTestData(TITLE),
//                TestDataReader.getTestData(COMPANY)
//        );
        return new User(
                USER_NAME,
                USER_SURNAME,
                EMAIL_ADDRESS,
                PROJECT,
                TITLE,
                COMPANY
        );
    }
}
