package com.rea.Input;

import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import co.unruly.matchers.StreamMatchers;

import java.util.stream.Stream;

@Test
public class InputProcessorTest {

    private InputProcessor processor;
    private static final String INVALID_FILE = "InvalidFile.txt";
    private static final String VALID_FILE = "ValidFile.txt";

    @BeforeMethod
    public void setUp() throws Exception {
        processor = new InputProcessor();
    }

    public void shouldReturnEmptyStreamIfInputFilePathNotValid() {
        Stream<String> inputFileStream = processor.processInput(INVALID_FILE);
        assertThat(inputFileStream, StreamMatchers.empty());
    }

    public void shouldReturnCorrectStreamForValidFileInput() {
        Stream<String> inputFileStream = processor.processInput(VALID_FILE);
        assertThat(inputFileStream, StreamMatchers.contains("PLACE X,Y,F", "MOVE", "LEFT", "RIGHT", "REPORT"));
    }

}