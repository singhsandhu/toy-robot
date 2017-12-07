import com.rea.robot.command.CommandMapper;
import com.rea.robot.input.InputProcessor;
import com.rea.robot.input.RobotCommands;
import com.rea.robot.ToyRobot;

import static com.rea.robot.validator.CommandValidator.VALID_COMMAND;

public class ToyRobotApp {

    public static void main(String... args) {
        new ToyRobotApp().startRobot(new ToyRobot(), args);
    }

    public void startRobot(ToyRobot robot, String... args) {
        new RobotCommands()
                .apply(new InputProcessor(System.in)
                        .processInput(args)
                        .map(val -> val.trim())
                        .filter(VALID_COMMAND))
                .map(new CommandMapper())
                .forEach(command -> command.apply(robot));
    }

}
