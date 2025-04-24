package GraphFrameWork;


import GraphFrameWork.app.Location;

/**
 * ShortestPathAlgorithm: Abstract base class for shortest path algorithms.
 * Provides a common interface and stores the graph reference.
 */
public abstract class ShortestPathAlgorithm {
    protected Graph graph; // The graph to work on

    public ShortestPathAlgorithm(Graph graph) {
        this.graph = graph;
    }

    /**
     * Abstract method to compute shortest paths from a given source.
     * Subclasses must implement this method.
     */
    public abstract void computeDijkstraAlg(Location source);
}

