package main.java.com.epam.graph.entity;

import java.util.Objects;

import static main.java.com.epam.Constants.AlgorithmConstants.INFINITY_DISTANCE;

public class Vertex {
    private final String name;

    private int shortestRoute;
    private Vertex parent;
    private boolean isVisited;
    private boolean hasMoreRoutes;

    public Vertex(final String name) {
        this.name = name;
        shortestRoute = INFINITY_DISTANCE;
        parent = null;
        isVisited = false;
        hasMoreRoutes = false;
    }

    public String getName() {
        return name;
    }

    public int getShortestRoute() {
        return shortestRoute;
    }

    public void setShortestRoute(int shortestRoute) {
        this.shortestRoute = shortestRoute;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean hasMoreRoutes() {
        return hasMoreRoutes;
    }

    public void setHasMoreRoutes(boolean hasMoreRoutes) {
        this.hasMoreRoutes = hasMoreRoutes;
    }

    public void clear(){
        shortestRoute = INFINITY_DISTANCE;
        parent = null;
        isVisited = false;
        hasMoreRoutes = false;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Vertex vertex = (Vertex) object;

        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
