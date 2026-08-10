package com.umb.taller.application;

public class EmailValidator {

    public boolean validateEmail(String email) {
        return email != null && email.contains("@");
    }
}
