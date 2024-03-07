package com.geektrust.backend;


import java.io.FileNotFoundException;

import java.io.IOException;

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

