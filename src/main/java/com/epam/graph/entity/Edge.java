package main.java.com.epam.graph.entity;

public class Edge<V extends IVertex> {

    private final V vertexTo;
    private final int length;
    private final int cost;
    private final int totalCost;

    public Edge(final V vertexTo, final int length, final int cost) {
        this.vertexTo = vertexTo;
        this.length = length;
        this.cost = cost;
        this.totalCost = length * cost;
    }

    public V getVertexTo() {
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
