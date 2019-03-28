package main.java.com.epam.graph.entity;

public interface IVertex {
    String getName();

    void setShortestRoute(final int shortestRoute);
    int getShortestRoute();

    void setVisited(final boolean visited);
    boolean isVisited();

    void setHasMoreRoutes(final boolean hasMoreRoutes);
    boolean hasMoreRoutes();

    void setParent(final IVertex parent);
    IVertex getParent();

    void clear();
}
