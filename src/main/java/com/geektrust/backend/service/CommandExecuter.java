package com.geektrust.backend.service;

import java.util.Map;
import java.util.TreeMap;
import com.geektrust.backend.exception.CourseFullException;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.models.Course;

public interface CommandExecuter {
    void executeCommand(TreeMap<String,Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseFullException;
}
