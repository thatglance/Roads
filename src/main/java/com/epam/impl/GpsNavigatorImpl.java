package main.java.com.epam.impl;

import main.java.com.epam.api.GpsNavigator;
import main.java.com.epam.api.Path;
import main.java.com.epam.data.DataProvider;
import main.java.com.epam.exception.MultiplePathsException;
import main.java.com.epam.exception.NoInputDataException;
import main.java.com.epam.exception.PathNotFoundException;
import main.java.com.epam.graph.algorithm.GraphAlgorithms;
import main.java.com.epam.graph.entity.Graph;
import main.java.com.epam.graph.entity.Vertex;
import main.java.com.epam.exception.WrongFileFormatException;

public class GpsNavigatorImpl implements GpsNavigator {
    private Graph graph;

    @Override
    public void readData(String filePath) {
        try {
            graph = DataProvider.readGraphFromFile(filePath);
        } catch (WrongFileFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Path findPath(String pointA, String pointB){
        try {
            if (graph == null) {
                throw new NoInputDataException("No input data provided!");
            }

            return GraphAlgorithms.findShortestRoute(new Vertex(pointA), new Vertex(pointB), graph);
        } catch (final MultiplePathsException | PathNotFoundException | NoInputDataException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }
}
