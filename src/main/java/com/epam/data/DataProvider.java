package main.java.com.epam.data;

import main.java.com.epam.graph.entity.Graph;
import main.java.com.epam.exception.WrongFileFormatException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataProvider {

    public static Graph readGraphFromFile(final String filePath) throws WrongFileFormatException {
        try {
            final List<String> fileLines = Files.readAllLines(Paths.get(filePath));

            if(!RoadsValidator.checkIsRoadsInfoValid(fileLines)) {
                throw new WrongFileFormatException("Wrong file format!");
            }

            return GraphCreator.createGraph(fileLines);

        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }
}
