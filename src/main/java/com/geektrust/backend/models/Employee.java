package com.geektrust.backend.models;

import java.util.regex.Pattern;
import com.geektrust.backend.exception.InvalidInputException;

public class Employee {
    private final String name;
    private final String emailAddress;

    public Employee(String emailAddress) throws InvalidInputException {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        if(pattern.matcher(emailAddress).matches()){
            this.emailAddress = emailAddress;
            this.name = this.emailAddress.substring(0,this.emailAddress.indexOf('@'));
        }
        else{
            throw new InvalidInputException("Invalid Email Error");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
