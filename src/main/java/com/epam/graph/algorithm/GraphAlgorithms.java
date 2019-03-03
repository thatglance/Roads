package main.java.com.epam.graph.algorithm;

import main.java.com.epam.api.Path;
import main.java.com.epam.exception.MultiplePathsException;
import main.java.com.epam.exception.PathNotFoundException;
import main.java.com.epam.graph.entity.Edge;
import main.java.com.epam.graph.entity.Graph;
import main.java.com.epam.graph.entity.Vertex;

import java.util.*;

public class GraphAlgorithms {
    private GraphAlgorithms() {
    }

    public static Path findShortestRoute(Vertex point1, Vertex point2, Graph graph) throws MultiplePathsException,
            PathNotFoundException {

        clearVerticesMarks(graph);

        final Map<Vertex, List<Edge>> adjacencyList = graph.getAdjacencyList();

        Vertex currentVertex = point1;
        point1.setShortestRoute(0);
        point1.setVisited(true);

        final Queue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(Vertex::getShortestRoute));

        queue.add(currentVertex);

        while (!queue.isEmpty()) {
            currentVertex = queue.poll();

            final List<Edge> edges = adjacencyList.get(currentVertex);

            if (edges != null) {
                for (Edge edge : edges) {
                    final Vertex neighbour = edge.getVertexTo();

                    if (neighbour.getShortestRoute() == currentVertex.getShortestRoute() + edge.getTotalCost()) {
                        neighbour.setHasMoreRoutes(true);
                    }

                    if (!neighbour.isVisited()) {

                        if (neighbour.getShortestRoute() > currentVertex.getShortestRoute() + edge.getTotalCost()) {
                            neighbour.setShortestRoute(currentVertex.getShortestRoute() + edge.getTotalCost());
                            neighbour.setHasMoreRoutes(false);
                            neighbour.setParent(currentVertex);
                        }

                        queue.add(neighbour);
                    }
                }
            }

            currentVertex.setVisited(true);

            if (currentVertex.equals(point2)) {
                break;
            }

        }

        if (!currentVertex.equals(point2)) {
            throw new PathNotFoundException("There is no path from point " + point1.toString()
                    + " to point " + point2.toString() + "!");
        }

        return findPath(point1, currentVertex);
    }

    private static Path findPath(Vertex point1, Vertex point2) throws MultiplePathsException {
        final List<Vertex> path = new ArrayList<>();
        path.add(point2);
        Vertex current = point2;

        while (!current.equals(point1)) {

            if (current.hasMoreRoutes()) {
                throw new MultiplePathsException("There is more than one cheapest route!");
            }

            current = current.getParent();
            path.add(current);
        }

        final List<String> stringPath = new ArrayList<>(path.size());

        for (int i = path.size() - 1; i >= 0; i--) {
            stringPath.add(path.get(i).getName());
        }

        return new Path(stringPath, point2.getShortestRoute());
    }

    private static void clearVerticesMarks(final Graph graph) {
        final Collection<Vertex> vertices = graph.getVertexes();

        for (Vertex vertex : vertices) {
            vertex.clear();
        }
    }
    
}
