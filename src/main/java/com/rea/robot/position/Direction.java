package com.rea.robot.position;

public enum Direction {
    NORTH {
        public void move(RobotLocation currentLocation) {
            if(currentLocation.isLocationValid(currentLocation.getRobotTableRow(), currentLocation.getRobotTableColumn() + 1)) {
                currentLocation.setRobotTableColumn(currentLocation.getRobotTableColumn() + 1);
            }
        }
    },
    SOUTH {
        public void move(RobotLocation currentLocation) {
            if(currentLocation.isLocationValid(currentLocation.getRobotTableRow(), currentLocation.getRobotTableColumn() - 1)) {
                currentLocation.setRobotTableColumn(currentLocation.getRobotTableColumn() - 1);
            }
        }
    },
    WEST {
        public void move(RobotLocation currentLocation) {
            if(currentLocation.isLocationValid(currentLocation.getRobotTableRow() -1, currentLocation.getRobotTableColumn())) {
                currentLocation.setRobotTableRow(currentLocation.getRobotTableRow() - 1);
            }
        }
    },
    EAST {
        public void move(RobotLocation currentLocation) {
            if(currentLocation.isLocationValid(currentLocation.getRobotTableRow() + 1, currentLocation.getRobotTableColumn())) {
                currentLocation.setRobotTableRow(currentLocation.getRobotTableColumn() + 1);
            }
        }
    };

    public abstract void move(RobotLocation currentLocation);

}
