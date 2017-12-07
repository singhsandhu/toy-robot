import com.rea.robot.position.Direction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.rea.robot.ToyRobot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Test
public class ToyRobotAppIntegrationTest {

    private static final String INPUT_FILE_1 = "test1.txt";
    private static final String INPUT_FILE_2 = "test2.txt";
    private static final String INPUT_FILE_3 = "test3.txt";

    private ToyRobotApp robotApp;
    private ToyRobot robot;

    @BeforeMethod
    public void setUp() throws Exception {
        robotApp = new ToyRobotApp();
        robot = new ToyRobot();
    }

    public void resultShouldMatcgWithExpectedOutput_1() {
        robotApp.startRobot(robot, INPUT_FILE_1);
        assertThat(robot.getRobotDirection(), is(Direction.WEST));
        assertThat(robot.getRobotLocation().getRobotTableRow(), is(0));
        assertThat(robot.getRobotLocation().getRobotTableColumn(), is(2));

    }

    public void resultShouldMatcgWithExpectedOutput_() {
        robotApp.startRobot(robot, INPUT_FILE_2);
        assertThat(robot.getRobotDirection(), is(Direction.WEST));
        assertThat(robot.getRobotLocation().getRobotTableRow(), is(3));
        assertThat(robot.getRobotLocation().getRobotTableColumn(), is(2));
    }

    public void resultShouldMatcgWithExpectedOutput_2() {
        robotApp.startRobot(robot, INPUT_FILE_3);
        assertThat(robot.getRobotDirection(), is(Direction.EAST));
        assertThat(robot.getRobotLocation().getRobotTableRow(), is(3));
        assertThat(robot.getRobotLocation().getRobotTableColumn(), is(4));
    }

}