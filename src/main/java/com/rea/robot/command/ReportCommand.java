package com.rea.robot.command;

import com.rea.robot.ToyRobot;

public class ReportCommand implements Command {

    @Override
    public void execute(final ToyRobot toyRobot) {
        System.out.println(toyRobot);
    }
}
