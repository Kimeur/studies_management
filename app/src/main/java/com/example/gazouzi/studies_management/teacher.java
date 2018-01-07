package com.example.gazouzi.studies_management;

/**
 * Created by GAZOUZI on 18/12/2017.
 */

public class teacher {
    public int teacherId;
    public String firstname;
    public String lastname;
    public String email;
    public String departement;
    public String comment;

    public teacher() {
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFirstname() {
        return firstname;

    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartementdepartement() {
        return departement;
    }

    public String getComment() {
        return comment;
    }


}
