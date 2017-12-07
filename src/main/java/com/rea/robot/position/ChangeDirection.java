package com.rea.robot.position;

public enum ChangeDirection {
    LEFT {
        public Direction getNextDirection(Direction currentDirection) {
            switch (currentDirection) {
                case SOUTH:
                    return Direction.EAST;
                case NORTH:
                    return Direction.WEST;
                case EAST:
                    return Direction.NORTH;
                case WEST:
                    return Direction.SOUTH;
                default:
                    return currentDirection;
            }
        }
    },

    RIGHT {
        public Direction getNextDirection(Direction currentDirection) {
            switch (currentDirection) {
                case SOUTH:
                    return Direction.WEST;
                case NORTH:
                    return Direction.EAST;
                case EAST:
                    return Direction.SOUTH;
                case WEST:
                    return Direction.NORTH;
                default:
                    return currentDirection;
            }
        }
    };

    public abstract Direction getNextDirection(Direction currentDirection);

}
