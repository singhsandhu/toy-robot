package com.rea.robot.command;

import com.rea.robot.position.Direction;
import org.testng.annotations.BeforeMethod;
import com.rea.robot.ToyRobot;
import com.rea.robot.position.RobotLocation;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Test
public class DoNothingCommandTest {

    private  DoNothingCommand command;
    private ToyRobot robot;
    private RobotLocation robotLocation;

    @BeforeMethod
    public void setUp() throws Exception {
        command = new DoNothingCommand();
        robot = new ToyRobot();
        robotLocation = new RobotLocation();
        robotLocation.setRobotTableRow(3);
        robotLocation.setRobotTableColumn(4);
    }

    public void shouldNotChangeStateOfRobot() {
        robot.setRobotDirection(Direction.EAST);
        robot.setRobotLocation(robotLocation);

        command.execute(robot);

        assertThat(robot.getRobotDirection(), is(Direction.EAST));
        assertThat(robot.getRobotLocation().getRobotTableRow(), is(3));
        assertThat(robot.getRobotLocation().getRobotTableColumn(), is(4));
    }
}