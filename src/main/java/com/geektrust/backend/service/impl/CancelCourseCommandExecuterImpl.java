package com.geektrust.backend.service.impl;

import java.util.Map;
import java.util.TreeMap;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.models.Course;
import com.geektrust.backend.service.CommandExecuter;

public class CancelCourseCommandExecuterImpl implements CommandExecuter{
    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String,Course> registrationIdCourseMap, Command command){
        String regId = command.getCommandParams().get(0);
        if(isValidRegistrationId(regId,registrationIdCourseMap)){
            if(isCourseNotAllotted(regId,registrationIdCourseMap)){
                System.out.println(regId + " " + "CANCEL_REJECTED");
            }
            else{
                removeRegisteredEmployee(regId,registrationIdCourseMap);
                System.out.println(regId+" "+"CANCEL_ACCEPTED");
            }
        }
        else{
            System.out.println(regId + " " + "CANCEL_REJECTED");
        }
    }

    private void removeRegisteredEmployee(String regId,Map<String,Course> registrationIdCourseMap){
        Course course = registrationIdCourseMap.get(regId);
        course.getRegisteredEmployee().remove(regId);
        registrationIdCourseMap.remove(regId);
    }

    private boolean isCourseNotAllotted(String regId,Map<String,Course> registrationIdCourseMap){
        return registrationIdCourseMap.get(regId).isAllotted();
    }

    private boolean isValidRegistrationId(String regId,Map<String,Course> registrationIdCourseMap){
        if(registrationIdCourseMap.get(regId) != null){
            return true;
        }
        else{
            return false;
        }
    }
}
