package com.rea.robot.validator;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import static com.rea.robot.validator.RobotPositionValidator.IS_VALID_POSITION;
import static com.rea.robot.validator.RobotPositionValidator.IS_VALID_DIRECTION;
import static com.rea.robot.command.PlaceCommand.PLACE_COMMAND_MATCHER;


public class CommandValidator {

    public static final Predicate<String> VALID_COMMAND = command -> isValidCommand(command);

    static boolean isValidCommand(String command) {
        if(command.startsWith(CommandSet.PLACE.toString())) {
           return isValidPlaceCommand(command);
        } else {
            return isCommandAllowed(command);
        }
    }

    private static boolean isCommandAllowed(String command) {
        return Stream.of(CommandSet.values())
                .map( x -> x.toString())
                .anyMatch(val -> val.equals(command));
    }

    private static boolean isValidPlaceCommand(String command) {
        Matcher matcher = PLACE_COMMAND_MATCHER(command);
        if (matcher.matches()) {
            return IS_VALID_POSITION(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)))
                    && IS_VALID_DIRECTION(matcher.group(3));
        }
        return false;
    }

}
