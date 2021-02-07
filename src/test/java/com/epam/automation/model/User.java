package com.epam.automation.model;

import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private String emailAddress="";
    private String project;
    private String title;
    private String company;

    public User(String name, String surname, String emailAddress, String project, String title, String company) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.project = project;
        this.title = title;
        this.company = company;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getProject() {
        return project;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(emailAddress, user.emailAddress) &&
                Objects.equals(project, user.project) &&
                Objects.equals(title, user.title) &&
                Objects.equals(company, user.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, emailAddress, project, title, company);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", project='" + project + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
