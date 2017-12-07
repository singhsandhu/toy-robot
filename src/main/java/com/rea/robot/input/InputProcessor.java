package com.rea.robot.input;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputProcessor {

    private static final Logger LOG = Logger.getLogger(InputProcessor.class);
    private InputStream inputStream;

    public InputProcessor(InputStream inputStream) {
        this.inputStream = inputStream;
    }

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

    Stream<String> processFileInput(String filePath) {
        try {
            return Files.lines(Paths.get(filePath));
        } catch (IOException ex) {
            LOG.error("Cannot find file : " + filePath);
            return Stream.empty();
        }
    }

    Stream<String> processUserInput() {
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name());
        List<String> result = new ArrayList<>();

        System.out.println("****** TOY ROBOT says Welcome********");
        System.out.println("VALID commands are : PLACE, MOVE, LEFT, RIGHT, REPORT: ");
        System.out.println("Invalid commands will be ignored");
        System.out.println("Type \"CTRL + D\" to start execution.");
        System.out.println();

        while (scanner.hasNext()) {
            result.add(scanner.nextLine());
        }

        return result.stream();
    }

}
