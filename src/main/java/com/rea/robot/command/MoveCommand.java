package com.rea.robot.command;

import com.rea.robot.ToyRobot;

public class MoveCommand implements Command {

    @Override
    public void execute(ToyRobot toyRobot) {
        toyRobot.getRobotDirection().move(toyRobot.getRobotLocation());
    }
}
