package com.rea.robot.position;

public class RobotLocation {

    public static final int TABLE_ROWS_LIMIT = 5;
    public static final int TABLE_COLUMN_LIMIT = 5;

    private int robotTableRow;
    private int robotTableColumn;

    public int getRobotTableRow() {
        return robotTableRow;
    }

    public void setRobotTableRow(int robotTableRow) {
        this.robotTableRow = robotTableRow;
    }

    public int getRobotTableColumn() {
        return robotTableColumn;
    }

    public void setRobotTableColumn(int robotTableColumn) {
        this.robotTableColumn = robotTableColumn;
    }

    public boolean isLocationValid(int row, int column) {
        return row >=0 && row < TABLE_ROWS_LIMIT
                && column >=0 && column <TABLE_COLUMN_LIMIT;
    }

}
