package com.geektrust.backend.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;

public class FileProcessorService {
    private final File file;
    private final BufferedReader reader;
    public FileProcessorService(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        reader = new BufferedReader(new FileReader(file));
    }

    public Command processLine() throws InvalidInputException, IOException{
        String inputString = reader.readLine();
        if(inputString == null){
            return null;
        }
        if(isEmpty(inputString)){
            processLine();
        }
        try{
            return CommandService.getInstance().getCommandFromString(inputString);
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
            return processLine();
        }
    }

    private boolean isEmpty(String line){
        if(line == null || line.length()==0 || line.trim().isEmpty() || line.trim().startsWith("#")){
            return false;
        }
        return true;
    }
}
