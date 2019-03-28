package main.java.com.epam.graph.entity;

import java.util.Objects;

import static main.java.com.epam.Constants.AlgorithmConstants.INFINITY_DISTANCE;

public class Vertex implements IVertex{
    private final String name;

    private int shortestRoute;
    private IVertex parent;
    private boolean isVisited;
    private boolean hasMoreRoutes;

    public Vertex(final String name) {
        this.name = name;
        shortestRoute = INFINITY_DISTANCE;
        parent = null;
        isVisited = false;
        hasMoreRoutes = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getShortestRoute() {
        return shortestRoute;
    }

    @Override
    public void setShortestRoute(final int shortestRoute) {
        this.shortestRoute = shortestRoute;
    }

    @Override
    public IVertex getParent() {
        return parent;
    }

    @Override
    public void setParent(final IVertex parent) {
        this.parent = parent;
    }

    @Override
    public boolean isVisited() {
        return isVisited;
    }

    @Override
    public void setVisited(final boolean visited) {
        isVisited = visited;
    }

    @Override
    public boolean hasMoreRoutes() {
        return hasMoreRoutes;
    }

    @Override
    public void setHasMoreRoutes(final boolean hasMoreRoutes) {
        this.hasMoreRoutes = hasMoreRoutes;
    }

    @Override
    public void clear(){
        shortestRoute = INFINITY_DISTANCE;
        parent = null;
        isVisited = false;
        hasMoreRoutes = false;
    }

    @Override
    public boolean equals(final Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Vertex vertex = (Vertex) object;

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
