  package com.geektrust.backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.geektrust.backend.concrete.CourseSchedulerSystem;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.service.CommandService;


public class App {

	public static void main(String[] args) {
    BufferedReader reader;
		try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                CourseSchedulerSystem cs = new CourseSchedulerSystem();
        //         FileProcessorService fileProcessorService = new FileProcessorService(args[0]);
                reader = new BufferedReader(new FileReader(args[0]));
                String inputString = reader.readLine();
                  try {
                    // Command command = CommandService.getInstance().getCommandFromString(inputString);
                    while (inputString != null) {
                      Command command = CommandService.getInstance().getCommandFromString(inputString);
                      cs.fulfillCommand(command);
                      // if(reader.readLine() == null){
                      //   reader.close();
                      //   // return;
                      // }
                      inputString = reader.readLine();
                    }
                  } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                  }
                }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
  }
}

