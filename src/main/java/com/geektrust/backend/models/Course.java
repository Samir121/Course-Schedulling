package com.geektrust.backend.models;


import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Course implements Comparable<Course>{

    private final String courseName;
    private final String courseId;
    private final String instructor;
    private final Date date;
    private final int maxCapacity;
    private final int minCapacity;
    private boolean isAllotted;
    private boolean isCancelled;
    private final Map<String,Employee> registeredEmployees;

    public Course(String courseId,String courseName,String instructor,Date date,int minCapacity,int maxCapacity,boolean isAllotted,boolean isCancelled){
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.date = date;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.isAllotted = isAllotted;
        this.isCancelled = isCancelled;
        registeredEmployees = new TreeMap<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getInstructor() {
        return instructor;
    }

    public Date getDate() {
        return date;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public void setAllotted(boolean allotted) {
        isAllotted = allotted;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public boolean isAllotted() {
        return isAllotted;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public Map<String, Employee> getRegisteredEmployee() {
        return registeredEmployees;
    }

    public String addEmployee(Employee e){
        String registrationID = "REG-COURSE-"+e.getName()+"-"+this.courseName;
        this.registeredEmployees.put(registrationID , e);
        return registrationID;
    }

    @Override
    public int compareTo(Course o) {
        return this.courseName.compareTo(o.courseName);
    }
    
}
