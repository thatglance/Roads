package main.java.com.epam.graph.algorithm;

import main.java.com.epam.api.Path;
import main.java.com.epam.exception.MultiplePathsException;
import main.java.com.epam.exception.PathNotFoundException;
import main.java.com.epam.graph.entity.Edge;
import main.java.com.epam.graph.entity.IGraph;
import main.java.com.epam.graph.entity.IVertex;

import java.util.*;
import java.util.function.Function;

public final class GraphAlgorithms {

    private GraphAlgorithms() {
    }

    public static <V extends IVertex> Path findShortestRoute(final V point1,
                                                             final V point2,
                                                             final IGraph<V> graph,
                                                             final Function<Edge<V>, Integer> costCountRule)
            throws MultiplePathsException, PathNotFoundException {
        clearVerticesMarks(graph);

        final Map<V, List<Edge<V>>> adjacencyList = graph.getAdjacencyList();

        V currentVertex = point1;
        point1.setShortestRoute(0);
        point1.setVisited(true);

        final Queue<V> queue = new PriorityQueue<>(Comparator.comparingInt(IVertex::getShortestRoute));

        queue.add(currentVertex);

        while (!queue.isEmpty()) {
            currentVertex = queue.poll();

            final List<Edge<V>> edges = adjacencyList.get(currentVertex);

            if (edges != null) {

                for (final Edge<V> edge : edges) {
                    final V neighbour = edge.getVertexTo();

                    if (neighbour.getShortestRoute() == currentVertex.getShortestRoute() + costCountRule.apply(edge)) {
                        neighbour.setHasMoreRoutes(true);
                    }

                    if (!neighbour.isVisited()) {

                        if (neighbour.getShortestRoute() > currentVertex.getShortestRoute() + costCountRule.apply(edge)) {
                            neighbour.setShortestRoute(currentVertex.getShortestRoute() + costCountRule.apply(edge));
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
            throw new PathNotFoundException("There is no path from point " + point1
                    + " to point " + point2 + "!");
        }

        return findPath(point1, currentVertex);
    }

    private static <V extends IVertex> Path findPath(final V point1, final V point2)
            throws MultiplePathsException {
        final List<IVertex> path = new ArrayList<>();
        path.add(point2);
        IVertex current = point2;

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

    private static <V extends IVertex> void clearVerticesMarks(final IGraph<V> graph) {
        final Collection<V> vertices = graph.getVertexes();

        for (final V vertex : vertices) {
            vertex.clear();
        }
    }

}
