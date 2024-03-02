  package com.geektrust.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.geektrust.backend.concrete.CourseSchedulerSystem;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.service.FileProcessorService;

public class App {

	public static void main(String[] args) {
        // System.out.println(args[0]);
		try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                CourseSchedulerSystem cs = new CourseSchedulerSystem();
                FileProcessorService fileProcessorService = new FileProcessorService(args[0]);
                try {
                    try {
                        Command command = fileProcessorService.processLine();
                        while (command != null) {
                            cs.fulfillCommand(command);
                            command = fileProcessorService.processLine();
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

}
