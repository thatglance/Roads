package main.java.com.epam.graph.entity;

import java.util.*;

public class Graph<V extends IVertex> implements IGraph<V> {

    private final Map<String, V> vertexes;
    private final Map<V, List<Edge<V>>> adjacencyList;

    public Graph() {
        this.vertexes = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public Collection<V> getVertexes() {
        return vertexes.values();
    }

    @Override
    public Map<V, List<Edge<V>>> getAdjacencyList() {
        return adjacencyList;
    }

    @Override
    public List<Edge<V>> getVertexNeighbours(final V vertex) {
        return adjacencyList.get(vertex);
    }

    @Override
    public void addVertex(final V vertex) {
        vertexes.put(vertex.getName(), vertex);
    }

    @Override
    public void addEdge(final V vertexFrom, final Edge<V> edge) {
        final V vertexTo = edge.getVertexTo();
        addVertex(vertexFrom);
        addVertex(vertexTo);

        final List<Edge<V>> listFromAdjacencyList = adjacencyList.getOrDefault(vertexFrom, new ArrayList<>());
        listFromAdjacencyList.add(edge);
        adjacencyList.put(vertexFrom, listFromAdjacencyList);
    }

    @Override
    public boolean contains(final String vertexName) {
        return vertexes.containsKey(vertexName);
    }

    @Override
    public V get(final String vertexName) {
        return vertexes.get(vertexName);
    }

    @Override
    public V getOrDefault(final String vertexName, final V defaultVertex) {
        return vertexes.getOrDefault(vertexName, defaultVertex);
    }
}
