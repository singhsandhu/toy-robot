import com.rea.input.InputProcessor;
import com.rea.input.RobotCommands;

import static com.rea.validator.CommandValidator.VALID_COMMAND;

public class ToyRobotApp {

    public static void main(String... args) {
        new RobotCommands()
                .apply(new InputProcessor(System.in)
                .processInput(args)
                .map(val -> val.trim())
                .filter(VALID_COMMAND));
    }

}
