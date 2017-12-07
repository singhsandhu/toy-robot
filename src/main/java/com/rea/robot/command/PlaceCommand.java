package com.rea.robot.command;

import com.rea.robot.ToyRobot;
import com.rea.robot.position.Direction;
import com.rea.robot.position.RobotLocation;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceCommand implements Command {

    private int row;
    private int column;
    private Direction direction;
    private static final Logger LOG = Logger.getLogger(PlaceCommand.class);

    private static final Pattern REGEX_PLACE_COMMAND = Pattern.compile("(\\d+),(\\d+),(\\w+)");
    private static final String WHITESPACE = " ";

    public PlaceCommand(int row, int column, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    @Override
    public void apply(ToyRobot toyRobot) {
        RobotLocation robotLocation = new RobotLocation();
        if(robotLocation.isLocationValid(row, column)) {
            robotLocation.setRobotTableRow(row);
            robotLocation.setRobotTableColumn(column);

            toyRobot.setRobotLocation(robotLocation);
            toyRobot.setRobotDirection(direction);
        }
        else {
            LOG.warn("Invalid arguments to PLACE command : (" + row + "," + column+")");
        }
    }

    public static Matcher PLACE_COMMAND_MATCHER(String command) {
        return REGEX_PLACE_COMMAND.matcher(command.substring(command.indexOf(WHITESPACE) + 1));
    }
}
