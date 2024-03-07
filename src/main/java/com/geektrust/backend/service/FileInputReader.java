package com.geektrust.backend.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.geektrust.backend.concrete.CourseSchedulerSystem;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;

public class FileInputReader {
    public static void readFile(String input){
      BufferedReader reader;
      CourseSchedulerSystem cs = new CourseSchedulerSystem();
      try {
        reader = new BufferedReader(new FileReader(input));
        String inputString = reader.readLine();
        // Command command = CommandService.getInstance().getCommandFromString(inputString);
        while (inputString != null) {
          Command command;
          try {
            command = CommandService.getInstance().getCommandFromString(inputString);
            cs.fulfillCommand(command);
          } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
          } 
          inputString = reader.readLine();
        }
        reader.close();
      }
      catch (IOException e) {
        System.out.println(e.getMessage());
      }          
                  
        //         }
        // } catch (IOException ex) {
        //     ex.printStackTrace();
        // }
    }
}
