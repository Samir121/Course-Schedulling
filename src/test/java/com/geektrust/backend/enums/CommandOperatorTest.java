package com.geektrust.backend.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandOperatorTest {
    Integer cancel;
    Integer allot;
    Integer registerValue;
    Integer courseOfferingValue;

    @BeforeEach
    public void setup(){
        cancel = 1;
        allot = 1;
        registerValue = 2;
        courseOfferingValue = 5;
    }
    @Test
    public void testGetNumberOfArguments() {
        assertEquals(Optional.of(CommandOperator.REGISTER.getNumberOfArguments()).get(),registerValue);
        assertEquals(Optional.of(CommandOperator.ADD_COURSE_OFFERING.getNumberOfArguments()).get(),courseOfferingValue);
    }
}
