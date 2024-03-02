package com.geektrust.backend.enums;

public enum CommandOperator {
    ADD_COURSE_OFFERING(5),
    CANCEL(1),
    REGISTER(2),
    ALLOT(1);
    private final Integer numberOfArguments;
    CommandOperator(Integer numArgs){
        this.numberOfArguments = numArgs;
    }

    public Integer getNumberOfArguments(){
        return numberOfArguments;
    }
}
