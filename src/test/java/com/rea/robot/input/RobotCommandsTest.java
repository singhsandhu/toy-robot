package com.rea.robot.input;

import co.unruly.matchers.StreamMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Stream;

@Test
public class RobotCommandsTest {

    private RobotCommands robotCommands;
    private Stream<String> inputStream = Stream.of("MOVE", "LEFT", "PLACE 1,2,NORTH", "LEFT", "REPORT", "PLACE 1,4,SOUTH","MOVE");
    private Stream<String> expectedOutputStream = Stream.of("PLACE 1,2,NORTH", "LEFT", "REPORT", "PLACE 1,4,SOUTH","MOVE");

    private Stream<String> inputStream_2 = Stream.of("MOVE", "LEFT", "REPORT", "MOVE");

    private Stream<String> inputStream_3 = Stream.of("MOVE", "LEFT", "REPORT", "MOVE", "PLACE 1,2,SOUTH");
    private Stream<String> expectedOutputStream_3 = Stream.of("PLACE 1,2,SOUTH");

    private Stream<String> inputStream_4 = Stream.of("PLACE 1,2,SOUTH", "MOVE", "LEFT");
    private Stream<String> getExpectedOutputStream_4 = Stream.of("PLACE 1,2,SOUTH", "MOVE", "LEFT");


    @BeforeMethod
    public void setUp() throws Exception {
        robotCommands = new RobotCommands();
    }

    public void shouldReturnTheValidSequenceOfCommandsToExecute() {
        Stream<String> outputStream = robotCommands.apply(inputStream);
        MatcherAssert.assertThat(outputStream, StreamMatchers.equalTo(expectedOutputStream));

    }

    public void shouldReturnTheValidSequenceOfCommandsToExecute_2() {
        Stream<String> outputStream = robotCommands.apply(inputStream_2);
        MatcherAssert.assertThat(outputStream, StreamMatchers.empty());
    }

    public void shouldReturnTheValidSequenceOfCommandsToExecute_3() {
        Stream<String> outputStream = robotCommands.apply(inputStream_3);
        MatcherAssert.assertThat(outputStream, StreamMatchers.equalTo(expectedOutputStream_3));
    }

    public void shouldReturnTheValidSequenceOfCommandsToExecute_4() {
        Stream<String> outputStream = robotCommands.apply(inputStream_4);
        MatcherAssert.assertThat(outputStream, StreamMatchers.equalTo(getExpectedOutputStream_4));
    }
}