package com.example.gazouzi.studies_management;

/**
 * Created by GAZOUZI on 18/12/2017.
 */

public class student {
    public String firstname;
    public String lastname;
    public String email;

    public student() {
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFirstname() {
        return firstname;

    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getComment() {
        return comment;
    }

    public int age;
    public String comment;
}
