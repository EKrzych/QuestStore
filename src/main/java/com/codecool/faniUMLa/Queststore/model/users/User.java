package com.codecool.faniUMLa.Queststore.model.users;

public abstract class User {

    private int idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserAccess access;

    public User(int idUser, String firstName, String lastName, String email, String phoneNumber) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserAccess getAccess() {
        return access;
    }

    public void setAccess(UserAccess access) {
        this.access = access;
    }
}
