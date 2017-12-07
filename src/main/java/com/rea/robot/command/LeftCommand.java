package com.rea.robot.command;

import com.rea.robot.ToyRobot;
import com.rea.robot.position.Direction;

import static com.rea.robot.position.ChangeDirection.LEFT;

public class LeftCommand implements Command {

    @Override
    public void apply(ToyRobot toyRobot) {
        Direction currentDirection = toyRobot.getRobotDirection();
        toyRobot.setRobotDirection(LEFT.getNextDirection(currentDirection));
    }
}
