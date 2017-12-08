package com.rea.robot;

import com.rea.robot.position.Direction;
import com.rea.robot.position.RobotLocation;

public class ToyRobot {

    private RobotLocation robotLocation;
    private Direction robotDirection;

    public RobotLocation getRobotLocation() {
        return robotLocation;
    }

    public void setRobotLocation(final RobotLocation robotLocation) {
        this.robotLocation = robotLocation;
    }

    public Direction getRobotDirection() {
        return robotDirection;
    }

    public void setRobotDirection(final Direction robotDirection) {
        this.robotDirection = robotDirection;
    }

    @Override
    public String toString() {
        return "Robot is now placed at " + getRobotLocation().getRobotTableRow() + ","
                + getRobotLocation().getRobotTableColumn() + " "
                + getRobotDirection().name();
    }
}
