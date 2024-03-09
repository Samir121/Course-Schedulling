package com.geektrust.backend.service.implTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
}
