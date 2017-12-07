package com.rea.robot.validator;
import com.rea.robot.position.Direction;

import java.util.stream.Stream;

import static com.rea.robot.position.RobotLocation.TABLE_ROWS_LIMIT;
import static com.rea.robot.position.RobotLocation.TABLE_COLUMN_LIMIT;

public class RobotPositionValidator {

    public static boolean IS_VALID_POSITION(int x, int y) {
        if (x < 0 || x > TABLE_ROWS_LIMIT - 1 || y < 0 || y > TABLE_COLUMN_LIMIT - 1) {
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
