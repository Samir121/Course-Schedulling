package com.geektrust.backend.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.enums.CommandOperator;
import com.geektrust.backend.exception.InvalidInputException;
import com.geektrust.backend.models.Command;

public class CommandService {
    static CommandService commandService = null;

    public static CommandService getInstance() {
        if (commandService == null) {
            commandService = new CommandService();
        }
        return commandService;
    }

    public Command getCommandFromString(String input) throws InvalidInputException {
        try {
            String[] commandWithArguments = input.split(" ");
            CommandOperator operator = CommandOperator.valueOf(Constants.getValue(commandWithArguments[0]));
            List<String> commandParams = Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
            Command command = new Command(operator, commandParams);
            this.validateInput(operator, command);
            return command;

        }
        catch(Exception e){
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }

    private void validateInput(CommandOperator inputCommand,Command command) throws InvalidInputException{
        if(inputCommand.getNumberOfArguments() != command.getCommandParams().size()){
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }
}
