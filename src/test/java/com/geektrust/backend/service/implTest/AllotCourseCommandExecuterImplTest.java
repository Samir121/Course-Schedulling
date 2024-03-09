package com.geektrust.backend.service.implTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import com.geektrust.backend.concrete.CommandExecutionFactory;
import com.geektrust.backend.exception.CourseFullException;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.models.Course;
import com.geektrust.backend.service.CommandExecuter;
import com.geektrust.backend.service.CommandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AllotCourseCommandExecuterImplTest {
    
    TreeMap<String, Course> courses;
    Map<String,Course> registrationIdCourseMap;
    Command commandTest;
    CommandExecuter commandExecuterTest;

    @BeforeEach
    public void assignValues() throws InvalidInputException{
        commandTest = CommandService.getInstance().getCommandFromString("ALLOT OFFERING-DATASCIENCE-BOB");
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        commandExecuterTest = CommandExecutionFactory.getExecutor(commandTest);
    }

    @Test
    public void executeCommandTest(){
        assertThrows(InvalidInputException.class,()-> commandExecuterTest.executeCommand(courses, registrationIdCourseMap, commandTest));
    }

    @Test
    public void executeCommand1() throws InvalidInputException, CourseFullException{
        Command commandTest1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING DATASCIENCE BOB 05062022 1 3");
        Command commandTest2 = CommandService.getInstance().getCommandFromString("REGISTER WOO@GMAIL.COM OFFERING-DATASCIENCE-BOB");
        Command commandTest3 = CommandService.getInstance().getCommandFromString("ALLOT OFFERING-DATASCIENCE-BOB");
        CommandExecuter commandExecuter1 = CommandExecutionFactory.getExecutor(commandTest1);
        CommandExecuter commandExecuter2 = CommandExecutionFactory.getExecutor(commandTest2);
        CommandExecuter commandExecuter3 = CommandExecutionFactory.getExecutor(commandTest3);
        commandExecuter1.executeCommand(courses,registrationIdCourseMap,commandTest1);
        commandExecuter2.executeCommand(courses,registrationIdCourseMap,commandTest2);
        assertDoesNotThrow(()->commandExecuter3.executeCommand(courses, registrationIdCourseMap, commandTest3));
    }
}
