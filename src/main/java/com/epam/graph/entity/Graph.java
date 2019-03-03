package main.java.com.epam.graph.entity;

import java.util.*;

public class Graph {
    private final Map<String, Vertex> vertexes;
    private final Map<Vertex, List<Edge>> adjacencyList;

    public Graph() {
        this.vertexes = new HashMap<>();
        this.adjacencyList = new HashMap<>();
    }

    public Collection<Vertex> getVertexes() {
        return vertexes.values();
    }

    public Map<Vertex, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public List<Edge> getVertexNeighbours(final Vertex vertex) {
        return adjacencyList.get(vertex);
    }

    public void addVertex(final Vertex vertex) {
        vertexes.put(vertex.getName(), vertex);
    }

    public void addEdge(final Vertex vertexFrom, final Edge edge) {
        Vertex vertexTo = edge.getVertexTo();
        addVertex(vertexFrom);
        addVertex(vertexTo);

        final List<Edge> listFromAdjacencyList = adjacencyList.getOrDefault(vertexFrom, new ArrayList<>());
        listFromAdjacencyList.add(edge);
        adjacencyList.put(vertexFrom, listFromAdjacencyList);
    }

    public boolean contains(final String vertexName){
        return vertexes.containsKey(vertexName);
    }

    public Vertex get(final String vertexName){
        return vertexes.get(vertexName);
    }

    public Vertex getOrDefault(final String vertexName, final Vertex defaultVertex){
        return vertexes.getOrDefault(vertexName, defaultVertex);
    }
}
