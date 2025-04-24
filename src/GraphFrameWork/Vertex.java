package GraphFrameWork;

import GraphFrameWork.app.Route;

import java.util.ArrayList;

/**
 * Vertex: Abstract class representing a node in the graph.
 * Stores label, adjacency list, visit status, and city ID.
 */
public abstract class Vertex {
    protected String label; // The label of the vertex (e.g., "A", "B", ...)
    public ArrayList<Route> adjList; // List of edges from this vertex
    public boolean isVisited; // Flag to track if visited in algorithms
    public int city; // City ID, unique for each vertex

    public Vertex(String label,int city) {
        this.label = label;
        adjList = new ArrayList<Route>();
        isVisited = false;
        this.city=city;
    }

    /**
     * Adds an edge to the adjacency list.
     */
    public void addadj(Route adj) {
        adjList.add(adj);
    }

    public String getLabel() {
        return label;
    }

    /**
     * Abstract method to display vertex information.
     */
    public abstract void displayInfo();
}

