package com.rea.robot.validator;

import co.unruly.matchers.StreamMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.stream.Stream;

@Test
public class CommandValidatorIntegrationTest {

    private static Stream<String> inputCommands = Stream.of("PLACE 1,2,NORTH", "MOVE", "LEFT", "RIGHT", "REPORT", "PLACE 7,7,NORTH", "MOVE");
    private static Stream<String> expectedFilteredCommands = Stream.of("PLACE 1,2,NORTH", "MOVE", "LEFT", "RIGHT", "REPORT", "MOVE");

    public void shouldFilterOutInvalidCommandsFromStreamOfGivenCommands() {
        MatcherAssert.assertThat(inputCommands.filter(CommandValidator.VALID_COMMAND),
                StreamMatchers.equalTo(expectedFilteredCommands));
    }

}