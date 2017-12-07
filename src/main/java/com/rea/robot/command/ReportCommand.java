package com.rea.robot.command;

import com.rea.robot.ToyRobot;

public class ReportCommand implements Command {

    @Override
    public void execute(ToyRobot toyRobot) {
        System.out.println(toyRobot);
    }
}
