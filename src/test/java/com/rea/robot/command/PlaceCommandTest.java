package com.rea.robot.command;

import com.rea.robot.position.Direction;
import org.testng.annotations.BeforeMethod;
import com.rea.robot.ToyRobot;
import com.rea.robot.position.RobotLocation;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Test
public class PlaceCommandTest {

    private PlaceCommand command;
    private ToyRobot robot;
    private RobotLocation robotLocation;

    @BeforeMethod
    public void setUp() throws Exception {
        robot = new ToyRobot();
        robotLocation = new RobotLocation();
    }


    public void shouldPlaceRobotIfPlaceCommandIsValid() {
        command = new PlaceCommand(2,3, Direction.WEST);

        robotLocation.setRobotTableRow(3);
        robotLocation.setRobotTableColumn(4);
        robot.setRobotDirection(Direction.EAST);
        robot.setRobotLocation(robotLocation);

        command.execute(robot);

        assertThat(robot.getRobotDirection(), is(Direction.WEST));
        assertThat(robot.getRobotLocation().getRobotTableRow(), is(2));
        assertThat(robot.getRobotLocation().getRobotTableColumn(), is(3));
    }

    public void shouldNotChnageStateOfRobotIfPlaceCommandIsInvalid() {
        command = new PlaceCommand(5,1, Direction.WEST);

        robotLocation.setRobotTableRow(3);
        robotLocation.setRobotTableColumn(4);
        robot.setRobotDirection(Direction.EAST);
        robot.setRobotLocation(robotLocation);

        command.execute(robot);

        assertThat(robot.getRobotDirection(), is(Direction.EAST));
        assertThat(robot.getRobotLocation().getRobotTableRow(), is(3));
        assertThat(robot.getRobotLocation().getRobotTableColumn(), is(4));
    }
}