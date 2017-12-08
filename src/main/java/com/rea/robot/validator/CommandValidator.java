package com.rea.robot.validator;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import static com.rea.robot.validator.RobotPositionValidator.isValidPosition;
import static com.rea.robot.validator.RobotPositionValidator.isValidDirection;
import static com.rea.robot.command.PlaceCommand.placeCommandMatcher;

public final class CommandValidator {

    public static final Predicate<String> VALID_COMMAND = command -> isValidCommand(command);

    /**
     * Private constructor for this Utility class
     */
    private CommandValidator() {
    }

    static boolean isValidCommand(String command) {
        if (command.startsWith(CommandSet.PLACE.toString())) {
           return isValidPlaceCommand(command);
        } else {
            return isCommandAllowed(command);
        }
    }

    private static boolean isCommandAllowed(String command) {
        return Stream.of(CommandSet.values())
                .map(Enum::toString)
                .anyMatch(command::equals);
    }

    private static boolean isValidPlaceCommand(String command) {
        Matcher matcher = placeCommandMatcher(command);
        if (matcher.matches()) {
            return isValidPosition(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)))
                    && isValidDirection(matcher.group(3));
        }
        return false;
    }

}
