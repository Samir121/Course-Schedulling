package com.geektrust.backend.service.implTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import com.geektrust.backend.concrete.CommandExecutionFactory;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.models.Course;
import com.geektrust.backend.service.CommandExecuter;
import com.geektrust.backend.service.CommandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterCourseCommandExecuterImplTest {

    TreeMap<String,Course> courses;
    Map<String,Course> registrationIdCourseMap;

    @BeforeEach
    public void assignValues(){
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    @Test
    public void executeCommandTest() throws InvalidInputException{
        Command command = CommandService.getInstance().getCommandFromString("REGISTER WOO@GMAIL.COM OFFERING-PYTHON-JOHN");
        CommandExecuter commandExecuter = CommandExecutionFactory.getExecutor(command);
        assertDoesNotThrow(()->commandExecuter.executeCommand(courses, registrationIdCourseMap, command));
    }

    @Test
    public void executeCommandTest1() throws InvalidInputException{
        Command command = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING DATASCIENCE BOB 05062022 1 3");
        Command command1 = CommandService.getInstance().getCommandFromString("REGISTER WOO@GMAIL.COM OFFERING-PYTHON-JOHN");
        CommandExecuter commandExecuter = CommandExecutionFactory.getExecutor(command);
        CommandExecuter commandExecuter1 = CommandExecutionFactory.getExecutor(command1);
        assertDoesNotThrow(()->commandExecuter.executeCommand(courses, registrationIdCourseMap, command));
        assertDoesNotThrow(()->commandExecuter1.executeCommand(courses, registrationIdCourseMap, command1));
    }
}
