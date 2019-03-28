package main.java.com.epam.graph.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IGraph<V extends IVertex> {

    Collection<V> getVertexes();

    Map<V, List<Edge<V>>> getAdjacencyList();

    List<Edge<V>> getVertexNeighbours(final V vertex);

    void addVertex(final V vertex);

    void addEdge(final V vertexFrom, final Edge<V> edge);

    boolean contains(final String vertexName);

    V get(final String vertexName);

    V getOrDefault(final String vertexName, final V defaultVertex);
}
