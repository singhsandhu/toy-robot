package com.rea.robot.command;

import com.rea.robot.ToyRobot;
import org.apache.log4j.Logger;

public class DoNothingCommand implements Command {

    private static final Logger LOG = Logger.getLogger(DoNothingCommand.class);

    @Override
    public void apply(ToyRobot toyRobot) {
        LOG.info("Not doing anything");
    }
}
