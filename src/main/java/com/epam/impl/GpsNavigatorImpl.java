package main.java.com.epam.impl;

import main.java.com.epam.api.GpsNavigator;
import main.java.com.epam.api.Path;
import main.java.com.epam.data.DataProvider;
import main.java.com.epam.exception.MultiplePathsException;
import main.java.com.epam.exception.NoInputDataException;
import main.java.com.epam.exception.PathNotFoundException;
import main.java.com.epam.graph.algorithm.GraphAlgorithms;
import main.java.com.epam.graph.entity.IGraph;
import main.java.com.epam.graph.entity.IVertex;
import main.java.com.epam.exception.WrongFileFormatException;

public class GpsNavigatorImpl implements GpsNavigator {

    private IGraph<IVertex> graph;

    @Override
    public void readData(final String filePath) {
        try {
            graph = DataProvider.readGraphFromFile(filePath);
        } catch (final WrongFileFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Path findPath(final String pointA, final String pointB) {
        try {
            if (graph == null) {
                throw new NoInputDataException("No input data provided!");
            }

            return GraphAlgorithms.findShortestRoute(graph.get(pointA), graph.get(pointB), graph,
                    edge -> edge.getCost() * edge.getCost() * edge.getLength());
        } catch (final MultiplePathsException | PathNotFoundException | NoInputDataException e) {
            System.out.println(e.getMessage());

            return null;
        }
    }

}
