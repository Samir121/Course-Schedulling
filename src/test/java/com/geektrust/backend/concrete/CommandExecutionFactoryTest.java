package com.geektrust.backend.concrete;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.service.CommandService;
import com.geektrust.backend.service.impl.AddCourseCommandExecuterImpl;
import com.geektrust.backend.service.impl.AllotCourseCommandExecuterImpl;
import com.geektrust.backend.service.impl.CancelCourseCommandExecuterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CommandExecutionFactoryTest {

    Command command;
    Command command1;
    Command command2;

    @BeforeEach
    public void assignValues() throws InvalidInputException{
        command = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING DATASCIENCE BOB 05062022 1 2");
        command1 = CommandService.getInstance().getCommandFromString("ALLOT OFFERING-DATASCIENCE-BOB");
        command2 = CommandService.getInstance().getCommandFromString("REGISTER WOO@GMAIL.COM OFFERING-DATASCIENCE-BOB");
    }
    
    @Test
    public void getExecuterTest(){
        assertTrue(CommandExecutionFactory.getExecutor(command) instanceof AddCourseCommandExecuterImpl);
        assertTrue(CommandExecutionFactory.getExecutor(command1)instanceof AllotCourseCommandExecuterImpl);
        assertFalse(CommandExecutionFactory.getExecutor(command2) instanceof CancelCourseCommandExecuterImpl);
    }
}
