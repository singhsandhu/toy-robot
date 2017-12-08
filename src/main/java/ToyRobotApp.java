import com.rea.robot.command.CommandMapper;
import com.rea.robot.input.InputProcessor;
import com.rea.robot.input.RobotCommands;
import com.rea.robot.ToyRobot;

import java.util.stream.Stream;

import static com.rea.robot.validator.CommandValidator.VALID_COMMAND;

public class ToyRobotApp {

    public static void main(String... args) {
        new ToyRobotApp().startRobot(new ToyRobot(), args);
    }

    public void startRobot(final ToyRobot robot, final String... args) {

        /**
          * Filter the valid commands from given input.
          */
        Stream<String> validCommandsStream = new InputProcessor(System.in)
                .processInput(args)
                .map(String::trim)
                .filter(VALID_COMMAND);

        /**
         * Ignore any command prior to first valid PLACE command
         * and start executing the commands
         */
        new RobotCommands()
                .apply(validCommandsStream)
                .map(new CommandMapper())
                .forEach(command -> command.execute(robot));
    }

}
