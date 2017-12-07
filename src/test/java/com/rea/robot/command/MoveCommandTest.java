package com.rea.robot.command;

import com.rea.robot.position.Direction;
import org.testng.annotations.BeforeMethod;
import com.rea.robot.ToyRobot;
import com.rea.robot.position.RobotLocation;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Test
public class MoveCommandTest {

    private MoveCommand command;
    private ToyRobot robot;
    private RobotLocation robotLocation;

    @BeforeMethod
    public void setUp() throws Exception {
        command = new MoveCommand();
        robot = new ToyRobot();
        robotLocation = new RobotLocation();
    }


    public void shouldMoveRobotIfNextLocationIsValid() {
        robotLocation.setRobotTableRow(2);
        robotLocation.setRobotTableColumn(2);
        robot.setRobotDirection(Direction.WEST);
        robot.setRobotLocation(robotLocation);

        command.execute(robot);

        assertThat(robot.getRobotDirection(), is(Direction.WEST));
        assertThat(robot.getRobotLocation().getRobotTableRow(), is(1));
        assertThat(robot.getRobotLocation().getRobotTableColumn(), is(2));
    }

    public void shouldNotMoveRobotIfNextLocationIsInvalid() {
        robotLocation.setRobotTableRow(0);
        robotLocation.setRobotTableColumn(4);
        robot.setRobotDirection(Direction.WEST);
        robot.setRobotLocation(robotLocation);

        command.execute(robot);

        assertThat(robot.getRobotDirection(), is(Direction.WEST));
        assertThat(robot.getRobotLocation().getRobotTableRow(), is(0));
        assertThat(robot.getRobotLocation().getRobotTableColumn(), is(4));
    }
}