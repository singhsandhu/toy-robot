package com.rea.robot.command;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

@Test
public class CommandMapperTest {

    private CommandMapper commandMapper;

    @BeforeMethod
    public void setUp() throws Exception {
        commandMapper = new CommandMapper();
    }

    public void shouldReturnPlaceCommandIfPlaceStringIsProvided() {
        Command placeCommand = commandMapper.apply("PLACE 1,2,NORTH");
        assertThat(placeCommand, Matchers.instanceOf(PlaceCommand.class));
    }

    public void shouldReturnLeftCommandIfLeftStringIsProvided() {
        Command placeCommand = commandMapper.apply("LEFT");
        assertThat(placeCommand, Matchers.instanceOf(LeftCommand.class));
    }

    public void shouldReturnRightCommandIfRightStringIsProvided() {
        Command placeCommand = commandMapper.apply("RIGHT");
        assertThat(placeCommand, Matchers.instanceOf(RightCommand.class));
    }

    public void shouldReturnMoveCommandIfMoveStringIsProvided() {
        Command placeCommand = commandMapper.apply("MOVE");
        assertThat(placeCommand, Matchers.instanceOf(MoveCommand.class));
    }

    public void shouldReturnReportCommandIfReportStringIsProvided() {
        Command placeCommand = commandMapper.apply("REPORT");
        assertThat(placeCommand, Matchers.instanceOf(ReportCommand.class));
    }

    public void shouldReturnDoNothingCommandIfInvalidStringIsProvided() {
        Command placeCommand = commandMapper.apply("PLACE 1,2");
        assertThat(placeCommand, Matchers.instanceOf(DoNothingCommand.class));
    }

}