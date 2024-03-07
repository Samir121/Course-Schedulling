package com.geektrust.backend.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.models.Course;
import com.geektrust.backend.models.Employee;
import com.geektrust.backend.service.CommandExecuter;

public class AllotCourseCommandExecuterImpl implements CommandExecuter{
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String,Course> registrationIdCourseMap, Command command) throws InvalidInputException{
        String courseId = command.getCommandParams().get(0);
        Course course = courses.get(courseId);
        if(course != null){
            if(course.getRegisteredEmployees().size() < course.getMinCapacity()){
                course.setCancelled(true);
                printCourseData(course);
            }
            else{
                course.setAllotted((true));
                printCourseData(course);
            }
        }
        else{
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    private void printCourseData(Course course){
        String status = course.isCancelled()?"COURSE_CANCELED":"CONFIRMED";
        for(Map.Entry<String, Employee> emp:course.getRegisteredEmployees().entrySet()){
            String pattern = "ddMMyyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            System.out.println(emp.getKey()+" "+emp.getValue().getEmailAddress()+" "+course.getCourseId()+" "+course.getCourseName()+" "+course.getInstructor()+" "
                    + df.format(course.getDate())+" "+status);
        }
    }
    
}
