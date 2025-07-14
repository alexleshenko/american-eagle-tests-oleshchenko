package com.ae.testdata;

public class UserData {
    public String email;
    public String firstName;
    public String lastName;
    public String password;
    public String birthMonth;
    public String birthDay;
    public String zip;

    public UserData(String email, String firstName, String lastName, String password,
                    String birthMonth, String birthDay, String zip) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.zip = zip;
    }
}
