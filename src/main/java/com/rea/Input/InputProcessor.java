package com.rea.Input;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputProcessor {

    private static final Logger LOG = Logger.getLogger(InputProcessor.class);

    public Stream<String> processInput(String... args) {

        switch (args.length) {
            case 0:
                return processUserInput();
            case 1:
                return processFileInput(args[0]);
            default:
                LOG.error("Invalid number of arguments to the Program.");
                return Stream.empty();
        }
    }

    private Stream<String> processFileInput(String filePath) {
        try {
            return Files.lines(Paths.get(filePath));
        } catch (IOException ex) {
            LOG.error("Cannot find file : " + filePath);
            return Stream.empty();
        }
    }

    private Stream<String> processUserInput() {
        LOG.info("Not yet implemented");
        return Stream.empty();
    }

}
