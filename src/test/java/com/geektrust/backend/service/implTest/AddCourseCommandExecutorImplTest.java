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

public class AddCourseCommandExecutorImplTest {

    TreeMap<String,Course> courses;
    Map<String,Course> registrationIdCourseMap;
    Command commandTest;
    CommandExecuter commandExecutorTest;

    @BeforeEach
     public void setup()throws InvalidInputException{
        commandTest = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING DATASCIENCE BOB 05062022 1 3");
        commandExecutorTest = CommandExecutionFactory.getExecutor(commandTest);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
     }

     @Test
     public void executeCommandTest(){
        assertDoesNotThrow(() -> commandExecutorTest.executeCommand(courses,registrationIdCourseMap,commandTest));
     }

     @Test
     public void executeCommandTest1() throws InvalidInputException{
      Command command1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3");
      CommandExecuter commandExecuterTest1 = CommandExecutionFactory.getExecutor(command1);
      assertDoesNotThrow(()->commandExecuterTest1.executeCommand(courses,registrationIdCourseMap,command1));
     }
}
