package com.rea.validator;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;


@Test
public class CommandValidatorTest {

    public void shouldReturnFalseIfUnknownCommand() {
        assertFalse(CommandValidator.isValidCommand("Hello World"));
    }

    public void shouldReturnTrueIfValidPlaceCommand() {
        assertTrue(CommandValidator.isValidCommand("PLACE 3,4,NORTH"));
    }

    public void shouldReturnFalseIFInvalidPlaceCommand_1() {
        assertFalse(CommandValidator.isValidCommand("PLACE"));
    }

    public void shouldReturnFalseIFInvalidPlaceCommand_2() {
        assertFalse(CommandValidator.isValidCommand("PLACE 1,2,3"));
    }

    public void shouldReturnFalseIFInvalidPlaceCommand_3() {
        assertFalse(CommandValidator.isValidCommand("PLACE 7"));
    }

    public void shouldReturnFalseIFInvalidPlaceCommand_4() {
        assertFalse(CommandValidator.isValidCommand("PLACE 3,4"));
    }

    public void shouldReturnFalseIFInvalidPlaceCommand_5() {
        assertFalse(CommandValidator.isValidCommand("PLACE A,B,NORTH"));
    }

    public void shouldReturnTrueIfValidMoveCommand() {
        assertTrue(CommandValidator.isValidCommand("MOVE"));
    }

    public void shouldReturnFalseIfInvalidMoveCommand() {
        assertFalse(CommandValidator.isValidCommand("MOVE LEFT"));
    }

    public void shouldReturnTrueIfValidLeftCommand() {
        assertTrue(CommandValidator.isValidCommand("LEFT"));
    }

    public void shouldReturnFalseIfInvalidLeftCommand() {
        assertFalse(CommandValidator.isValidCommand("LEFT 12"));
    }

    public void shouldReturnTrueIfValidRightCommand() {
        assertTrue(CommandValidator.isValidCommand("RIGHT"));
    }

    public void shouldReturnFalseIfInvalidRightCommand() {
        assertFalse(CommandValidator.isValidCommand("RIGHT YEAH"));
    }

    public void shouldReturnTrueIfValidReportCommand() {
        assertTrue(CommandValidator.isValidCommand("REPORT"));
    }

    public void shouldReturnFalseIfInvalidReportCommand() {
        assertFalse(CommandValidator.isValidCommand("REPORT POSITION"));
    }

}