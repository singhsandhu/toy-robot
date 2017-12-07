package com.rea.Input;

import static org.hamcrest.MatcherAssert.assertThat;

import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import co.unruly.matchers.StreamMatchers;

import java.io.InputStream;
import java.util.stream.Stream;

@Test
public class InputProcessorTest {

    @Mock
    private InputStream inputStream;

    private InputProcessor processor;

    private static final String INVALID_FILE = "InvalidFile.txt";
    private static final String VALID_FILE = "ValidFile.txt";

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        processor = Mockito.spy(new InputProcessor(inputStream));
    }

    public void shouldInvokeCorrectMethodIfNoArgumentProvided() {
        processor.processInput();
        Mockito.verify(processor, Mockito.times(1)).processUserInput();
        Mockito.verify(processor, Mockito.times(0)).processFileInput(ArgumentMatchers.anyString());
    }

    public void shouldInvokeCorrectMethodIfOneArgumentProvided() {
        processor.processInput(VALID_FILE);
        Mockito.verify(processor, Mockito.times(0)).processUserInput();
        Mockito.verify(processor, Mockito.times(1)).processFileInput(VALID_FILE);

    }

    public void shouldReturnEmptyStreamIfMoreThanOneArgumentProvided() {
        Stream<String> inputFileStream = processor.processInput(VALID_FILE, INVALID_FILE);
        Mockito.verify(processor, Mockito.times(0)).processUserInput();
        Mockito.verify(processor, Mockito.times(0)).processFileInput(ArgumentMatchers.anyString());
        assertThat(inputFileStream, StreamMatchers.empty());
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