package main.java.com.epam.data;

import main.java.com.epam.graph.entity.IGraph;
import main.java.com.epam.exception.WrongFileFormatException;
import main.java.com.epam.graph.entity.IVertex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class DataProvider {

    public static IGraph<IVertex> readGraphFromFile(final String filePath)
            throws WrongFileFormatException {

        try {
            final List<String> fileLines = Files.readAllLines(Paths.get(filePath));

            if(!RoadsValidator.checkIsRoadsInfoValid(fileLines)) {
                throw new WrongFileFormatException("Wrong file format!");
            }

            return GraphCreator.createGraph(fileLines);

        } catch (final IOException e) {
            e.printStackTrace();

            return null;
        }
    }
}
