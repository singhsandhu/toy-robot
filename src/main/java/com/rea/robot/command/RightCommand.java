package com.rea.robot.command;

import com.rea.robot.ToyRobot;
import com.rea.robot.position.Direction;

import static com.rea.robot.position.ChangeDirection.RIGHT;

public class RightCommand implements Command {

    @Override
    public void apply(ToyRobot toyRobot) {
        Direction currentDirection = toyRobot.getRobotDirection();
        toyRobot.setRobotDirection(RIGHT.getNextDirection(currentDirection));
    }
}
