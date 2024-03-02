package com.geektrust.backend.constants;

public class Constants {
    public static final String REJECTED = "REJECTED";
    public static final String ACCEPTED = "ACCEPTED";
    public static final String CANCEL_REJECTED = "CANCEL_REJECTED";
    public static final String CANCEL_ACCEPTED = "CANCEL_ACCEPTED";

    public static String getValue(String input){
        String value = "";
        switch(input){
            case "ADD-COURSE-OFFERING":
                value = "ADD_COURSE_OFFERING";
                break;
            case "ALLOT-COURSE":
                value = "ALLOT_COURSE";
                break;
            default:
                value = input;
                break;
        }
        return value;
    }
}
