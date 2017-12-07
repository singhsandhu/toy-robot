package com.rea.validator;
import com.rea.position.Direction;

import java.util.stream.Stream;

import static com.rea.position.RobotLocation.X_ROWS;
import static com.rea.position.RobotLocation.Y_ROWS;

public class RobotPositionValidator {

    public static boolean IS_VALID_POSITION(int x, int y) {
        if (x < 0 || x > X_ROWS - 1 || y < 0 || y > Y_ROWS - 1) {
            return false;
        }
        return true;
    }

    public static boolean IS_VALID_DIRECTION(String direction) {
        return Stream.of(Direction.values())
                .map( val -> val.toString())
                .anyMatch(val -> val.equals(direction));
    }

}
