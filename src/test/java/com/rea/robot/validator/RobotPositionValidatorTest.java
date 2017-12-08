package com.rea.robot.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class RobotPositionValidatorTest {

    public void shouldReturnFalseIfInvalidPosition_1() {
        Assert.assertFalse(RobotPositionValidator.isValidPosition(3,5));
    }

    public void shouldReturnFalseIfInvalidPosition_2() {
        Assert.assertFalse(RobotPositionValidator.isValidPosition(-1,0));
    }

    public void shouldReturnFalseIfInvalidPosition_3() {
        Assert.assertFalse(RobotPositionValidator.isValidPosition(7,6));
    }

    public void shouldReturnFalseIfInvalidPosition_4() {
        Assert.assertFalse(RobotPositionValidator.isValidPosition(5,5));
    }

    public void shouldReturnFalseIfInvalidPosition_5() {
        Assert.assertFalse(RobotPositionValidator.isValidPosition(-1,-1));
    }

    public void shouldReturnFalseIfInvalidPosition_6() {
        Assert.assertFalse(RobotPositionValidator.isValidPosition(0,5));
    }

    public void shouldReturnFalseIfInvalidPosition_7() {
        Assert.assertFalse(RobotPositionValidator.isValidPosition(5,0));
    }

    public void shouldReturnTrueIfValidPosition_1() {
        Assert.assertTrue(RobotPositionValidator.isValidPosition(0,0));
    }

    public void shouldReturnTrueIfValidPosition_2() {
        Assert.assertTrue(RobotPositionValidator.isValidPosition(4,4));
    }

    public void shouldReturnTrueIfValidPosition_3() {
        Assert.assertTrue(RobotPositionValidator.isValidPosition(3,2));
    }

    public void shouldReturnTrueIfValidDirection_1() {
        Assert.assertTrue(RobotPositionValidator.isValidDirection("NORTH"));
    }

    public void shouldReturnTrueIfValidDirection_2() {
        Assert.assertTrue(RobotPositionValidator.isValidDirection("WEST"));
    }

    public void shouldReturnTrueIfValidDirection_3() {
        Assert.assertTrue(RobotPositionValidator.isValidDirection("EAST"));
    }

    public void shouldReturnTrueIfValidDirection_4() {
        Assert.assertTrue(RobotPositionValidator.isValidDirection("SOUTH"));
    }

    public void shouldReturnFalseIfInvalidDirection_1() {
        Assert.assertFalse(RobotPositionValidator.isValidDirection("SOUTHS"));
    }

    public void shouldReturnFalseIfInvalidDirection_2() {
        Assert.assertFalse(RobotPositionValidator.isValidDirection("HELLO"));
    }

    public void shouldReturnFalseIfInvalidDirection_3() {
        Assert.assertFalse(RobotPositionValidator.isValidDirection("SOUTHWEST"));
    }

}