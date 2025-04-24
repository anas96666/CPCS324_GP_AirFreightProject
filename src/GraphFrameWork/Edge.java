package GraphFrameWork;

import GraphFrameWork.app.Location;

/**
 * Edge: Abstract class representing a directed edge in the graph.
 * Stores source, destination, weight, and parent for path tracing.
 */
public abstract class Edge {
    protected Location source; // Source vertex
    protected Location destination; // Destination vertex
    protected int weight; // Weight of the edge
    protected Location parent; // Parent used for shortest path tracing

    public Edge(Location source, Location destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Abstract method to display edge information.
     */
    public abstract void displayInfo();
}

