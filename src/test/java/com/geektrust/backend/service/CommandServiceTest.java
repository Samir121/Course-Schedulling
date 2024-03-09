package com.geektrust.backend.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.geektrust.backend.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

public class CommandServiceTest {

    String input;

    @Test
    public void getCommandFromStringTest(){
        input = "ADD-COURSE-OFFERING DATASCIENCE BOB 05062022 1 3";
        assertDoesNotThrow(()->CommandService.getInstance().getCommandFromString(input));
    }

    @Test
    public void getCommandFromStringTest1(){
        input = "REGISTER ALICE@GMAIL.COM";
        assertThrows(InvalidInputException.class,()->CommandService.getInstance().getCommandFromString(input));
    }
    
}
