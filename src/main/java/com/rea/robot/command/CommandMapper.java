package com.rea.robot.command;

import com.rea.robot.position.Direction;
import org.apache.log4j.Logger;

import java.util.function.Function;
import java.util.regex.Matcher;

import static com.rea.robot.validator.CommandSet.PLACE;
import static com.rea.robot.validator.CommandSet.MOVE;
import static com.rea.robot.validator.CommandSet.LEFT;
import static com.rea.robot.validator.CommandSet.REPORT;
import static com.rea.robot.validator.CommandSet.RIGHT;

public class CommandMapper implements Function<String, Command> {

    private static final Logger LOG = Logger.getLogger(CommandMapper.class);

    @Override
    public Command apply(String commandString) {
        if(commandString.startsWith(PLACE.name())) {
            return getPlaceCommand(commandString);
        }
        else if(commandString.equals(MOVE.name())) {
            return new MoveCommand();
        }
        else if(commandString.equals(LEFT.name())) {
            return new LeftCommand();
        }
        else if(commandString.equals(RIGHT.name())) {
            return new RightCommand();
        }
        else if(commandString.equals(REPORT.name())) {
            return new ReportCommand();
        }
        else {
            return new DoNothingCommand();
        }
    }

    private Command getPlaceCommand(String commandString) {
        Matcher matcher = PlaceCommand.PLACE_COMMAND_MATCHER(commandString);
        if(matcher.matches()) {
            int row = Integer.parseInt(matcher.group(1));
            int column = Integer.parseInt(matcher.group(2));
            switch (matcher.group(3)) {
                case "SOUTH":
                    return new PlaceCommand(row, column, Direction.SOUTH);
                case "NORTH":
                    return new PlaceCommand(row, column, Direction.NORTH);
                case "WEST":
                    return new PlaceCommand(row, column, Direction.WEST);
                case "EAST":
                    return new PlaceCommand(row, column, Direction.EAST);
                default:
                    LOG.warn("Invalid Direction provided in PLACE Command");
                    return new DoNothingCommand();
            }
        }
        else {
            return new DoNothingCommand();
        }
    }
}
