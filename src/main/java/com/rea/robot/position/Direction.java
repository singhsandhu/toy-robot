package com.rea.robot.position;

public enum Direction {
    NORTH {
        public void move(RobotLocation currentLocation) {
            int nextRow = currentLocation.getRobotTableRow();
            int nextColumn = currentLocation.getRobotTableColumn() + 1;
            if (currentLocation.isLocationValid(nextRow, nextColumn)) {
                currentLocation.setRobotTableColumn(nextColumn);
            }
        }
    },
    SOUTH {
        public void move(RobotLocation currentLocation) {
            int nextRow = currentLocation.getRobotTableRow();
            int nextColumn = currentLocation.getRobotTableColumn() - 1;
            if (currentLocation.isLocationValid(nextRow, nextColumn)) {
                currentLocation.setRobotTableColumn(nextColumn);
            }
        }
    },
    WEST {
        public void move(RobotLocation currentLocation) {
            int nextRow = currentLocation.getRobotTableRow() - 1;
            int nextColumn = currentLocation.getRobotTableColumn();
            if (currentLocation.isLocationValid(nextRow, nextColumn)) {
                currentLocation.setRobotTableRow(nextRow);
            }
        }
    },
    EAST {
        public void move(RobotLocation currentLocation) {
            int nextRow = currentLocation.getRobotTableRow() + 1;
            int nextColumn = currentLocation.getRobotTableColumn() + 1;
            if (currentLocation.isLocationValid(nextRow, nextColumn)) {
                currentLocation.setRobotTableRow(nextRow);
            }
        }
    };

    public abstract void move(RobotLocation currentLocation);

}
