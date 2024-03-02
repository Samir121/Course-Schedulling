package com.geektrust.backend.concrete;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import com.geektrust.backend.exception.CourseFullException;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.models.Course;
import com.geektrust.backend.service.CommandExecuter;

public class CourseSchedulerSystem {
    private final TreeMap<String, Course> courses;
    private final Map<String,Course> registrationIdCourseMap;

    public CourseSchedulerSystem(){
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command inputCommand) throws InvalidInputException {
        CommandExecuter commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
        try{
            commandExecutor.executeCommand(courses,registrationIdCourseMap, inputCommand);
        }catch(CourseFullException e ){
            System.out.println(e.getMessage());
        }
    }
}
