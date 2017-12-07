package com.rea.robot.command;

import com.rea.robot.ToyRobot;

public class ReportCommand implements Command {

    @Override
    public void apply(ToyRobot toyRobot) {
        System.out.println(toyRobot);
    }
}
