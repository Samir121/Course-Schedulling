  package com.geektrust.backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.geektrust.backend.concrete.CourseSchedulerSystem;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;
import com.geektrust.backend.service.CommandService;
import com.geektrust.backend.service.FileInputReader;


public class App {

	public static void main(String[] args) {
    // BufferedReader reader;
    try{
      if (args.length != 1) {
        throw new FileNotFoundException("Input file is not supplied");
      }
      FileInputReader.readFile(args[0]);
    }
		catch(IOException e){
      e.printStackTrace();
    }
  }
}

