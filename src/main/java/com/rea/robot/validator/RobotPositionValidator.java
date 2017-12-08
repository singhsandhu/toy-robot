package com.rea.robot.validator;
import com.rea.robot.position.Direction;

import java.util.stream.Stream;

import static com.rea.robot.position.RobotLocation.TABLE_ROWS_LIMIT;
import static com.rea.robot.position.RobotLocation.TABLE_COLUMN_LIMIT;

public final class RobotPositionValidator {

    /**
     * Private constructor for this Utility class
     */
    private RobotPositionValidator() {
    }

    public static boolean isValidPosition(final int row, final int column) {
        if (row < 0 || row > TABLE_ROWS_LIMIT - 1 || column < 0 || column > TABLE_COLUMN_LIMIT - 1) {
            return false;
        }
        return true;
    }

    public static boolean isValidDirection(String direction) {
        return Stream.of(Direction.values())
                .map(Enum::toString)
                .anyMatch(direction::equals);
    }

}
