package com.rea.robot.validator;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.rea.robot.validator.RobotPositionValidator.IS_VALID_POSITION;
import static com.rea.robot.validator.RobotPositionValidator.IS_VALID_DIRECTION;


public class CommandValidator {

    private static final Pattern REGEX_PLACE_COMMAND = Pattern.compile("(\\d+),(\\d+),(\\w+)");
    private static final String WHITESPACE = " ";

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
        Matcher matcher = REGEX_PLACE_COMMAND.matcher(command.substring(command.indexOf(WHITESPACE) + 1));
        if (matcher.matches()) {
            return IS_VALID_POSITION(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)))
                    && IS_VALID_DIRECTION(matcher.group(3));
        }
        return false;
    }

}
