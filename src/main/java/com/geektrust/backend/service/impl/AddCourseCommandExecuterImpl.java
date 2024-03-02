package com.geektrust.backend.service.impl;
import com.geektrust.backend.service.CommandExecuter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.models.Course;

public class AddCourseCommandExecuterImpl implements CommandExecuter{
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String,Course> registrationIdCourseMap, Command command) throws InvalidInputException{
        List<String> params = command.getCommandParams();
        Course course = constructCourseObject(params);
        offerCourse(courses,course);
    }

    private Course constructCourseObject(List<String> params) throws InvalidInputException{
        Course course = null;
        try{
            String courseName = params.get(0);
            String  courseInstructor = params.get(1);
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
            Date date = inputFormat.parse(params.get(2));
            int minCount = Integer.parseInt(params.get(3));
            int maxCount = Integer.parseInt(params.get(4));
            course = new Course("OFFERING-"+courseName+"-"+courseInstructor,courseName,courseInstructor,date,minCount,maxCount,false,false);
        }
        catch(Exception e){
            throw new InvalidInputException("Input Error");
        }
        return course;
    }

    private void offerCourse(TreeMap<String,Course> courses,Course course){
        courses.put(course.getCourseId(),course);
        System.out.println(course.getCourseId());
    }
}
