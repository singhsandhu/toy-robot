import com.rea.input.InputProcessor;
import static com.rea.validator.CommandValidator.VALID_COMMAND;

public class ToyRobotApp {

    public static void main(String... args) {
        new InputProcessor(System.in)
                .processInput(args)
                .filter(VALID_COMMAND);
    }

}
