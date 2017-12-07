package com.rea.robot.input;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;

import static com.rea.robot.validator.CommandSet.PLACE;

public class RobotCommands implements Function<Stream<String>, Stream<String>>{

    private static final Logger LOG = Logger.getLogger(RobotCommands.class);
    private static final Predicate<String> PLACE_COMMAND = command -> command.startsWith(PLACE.toString());

    @Override
    public Stream<String> apply(Stream<String> commandsStream) {
        List<String> listOfCommands = commandsStream.collect(Collectors.toList());
        Optional<String> firstPlaceCommand = listOfCommands.stream().filter(PLACE_COMMAND).findFirst();

        if (firstPlaceCommand.isPresent()) {
            int placeIndex = listOfCommands.indexOf(firstPlaceCommand.get());
            return listOfCommands.subList(placeIndex, listOfCommands.size()).stream();
        } else {
            LOG.warn("No PLACE command found in the Instruction Set");
            return Stream.empty();
        }

    }
}
