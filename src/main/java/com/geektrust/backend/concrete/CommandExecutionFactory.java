package com.geektrust.backend.concrete;

import com.geektrust.backend.models.Command;
import com.geektrust.backend.service.CommandExecuter;
import com.geektrust.backend.service.impl.AddCourseCommandExecuterImpl;
import com.geektrust.backend.service.impl.AllotCourseCommandExecuterImpl;
import com.geektrust.backend.service.impl.CancelCourseCommandExecuterImpl;
import com.geektrust.backend.service.impl.RegisterCourseCommandExecuterImpl;

public class CommandExecutionFactory {
    public static CommandExecuter getExecutor(Command task){
        CommandExecuter executor = null;
        if(task != null){
            switch(task.getInputCommand()){
                case ADD_COURSE_OFFERING:
                    executor = new AddCourseCommandExecuterImpl();
                    break;
                case CANCEL:
                    executor = new CancelCourseCommandExecuterImpl();
                    break;
                case ALLOT:
                    executor = new AllotCourseCommandExecuterImpl();
                    break;
                case REGISTER:
                    executor = new RegisterCourseCommandExecuterImpl();
                    break;
                default:
                    break;
            }
        }
        return executor;
    }
}
