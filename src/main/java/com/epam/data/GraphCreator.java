package main.java.com.epam.data;

import main.java.com.epam.graph.entity.Edge;
import main.java.com.epam.graph.entity.Graph;
import main.java.com.epam.graph.entity.IGraph;
import main.java.com.epam.graph.entity.IVertex;
import main.java.com.epam.graph.entity.Vertex;

import java.util.List;

import static main.java.com.epam.Constants.IOInfo.*;

public final class GraphCreator {

    private GraphCreator() {
    }

    public static IGraph<IVertex> createGraph(final List<String> lines) {
        final IGraph<IVertex> graph = new Graph<>();

        for (final String line : lines) {
            final String[] roadInfo = line.split(SEPARATOR);

            final String nameFrom = roadInfo[FIRST_VERTEX_INDEX];
            final String nameTo = roadInfo[SECOND_VERTEX_INDEX];

            final IVertex vertexFrom = graph.getOrDefault(nameFrom, new Vertex(nameFrom));
            final IVertex vertexTo = graph.getOrDefault(nameTo, new Vertex(nameTo));

            final Edge<IVertex> edge = new Edge<>(vertexTo, Integer.valueOf(roadInfo[ROAD_LENGTH_INDEX]),
                    Integer.valueOf(roadInfo[ROAD_COST_INDEX]));

            graph.addEdge(vertexFrom, edge);
        }

        return graph;
    }
}
