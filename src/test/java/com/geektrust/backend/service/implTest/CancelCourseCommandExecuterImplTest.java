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

public class CancelCourseCommandExecuterImplTest {

    TreeMap<String, Course> courses;
    Map<String,Course> registrationIdCourseMap;
    Command commandTest;
    CommandExecuter commandExecuterTest;

    @BeforeEach
    public void assignValues(){
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    @Test
    public void executeCommandTest() throws InvalidInputException{
        commandTest = CommandService.getInstance().getCommandFromString("CANCEL REG-COURSE-BOBY-PYTHON");
        commandExecuterTest = CommandExecutionFactory.getExecutor(commandTest);
        assertDoesNotThrow(()->commandExecuterTest.executeCommand(courses,registrationIdCourseMap,commandTest));
    } 

    @Test
    public void executeCommandTest1() throws InvalidInputException{
        Command commandTest1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3");
        Command commandTest2 = CommandService.getInstance().getCommandFromString("REGISTER WOO@GMAIL.COM OFFERING-PYTHON-JOHN");
        Command commandTest3 = CommandService.getInstance().getCommandFromString("CANCEL REG-COURSE-BOBY-PYTHON");
        CommandExecuter commandExecuterTest1 = CommandExecutionFactory.getExecutor(commandTest1);
        CommandExecuter commandExecuterTest2 = CommandExecutionFactory.getExecutor(commandTest2);
        CommandExecuter commandExecuterTest3 = CommandExecutionFactory.getExecutor(commandTest3);
        assertDoesNotThrow(()->commandExecuterTest1.executeCommand(courses, registrationIdCourseMap, commandTest1));;
        assertDoesNotThrow(()->commandExecuterTest2.executeCommand(courses,registrationIdCourseMap,commandTest2));
        assertDoesNotThrow(()->commandExecuterTest3.executeCommand(courses, registrationIdCourseMap, commandTest3));
    }
    
}
