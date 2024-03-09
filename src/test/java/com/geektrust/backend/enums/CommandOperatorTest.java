package com.geektrust.backend.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandOperatorTest {

    Integer registerValue;
    Integer allotValue;
    Integer addCourseOfferingValue;

    @BeforeEach
    public void assignValues(){
        registerValue = 2;
        allotValue = 1;
        addCourseOfferingValue = 5;
    }

    @Test
    public void getNumberOfArgumentsTest(){
        assertEquals(1,Optional.of(CommandOperator.ALLOT.getNumberOfArguments()).get());
        assertEquals(5,Optional.of(CommandOperator.ADD_COURSE_OFFERING.getNumberOfArguments()).get());
        assertEquals(2,Optional.of(CommandOperator.REGISTER.getNumberOfArguments()).get());
    }
}
