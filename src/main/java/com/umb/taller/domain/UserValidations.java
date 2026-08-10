package com.umb.taller.domain;

public class UserValidations {

    public static boolean isNotEmpty(String value) {
        return value != null && !value.isBlank();
    }

    public boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}
