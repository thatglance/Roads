package main.java.com.epam.graph.entity;

public class Edge {

    private final Vertex vertexTo;
    private final int length;
    private final int cost;
    private final int totalCost;

    public Edge(Vertex vertexTo, int length, int cost) {
        this.vertexTo = vertexTo;
        this.length = length;
        this.cost = cost;
        this.totalCost = length * cost;
    }

    public Vertex getVertexTo() {
        return vertexTo;
    }

    public int getLength() {
        return length;
    }

    public int getCost() {
        return cost;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
