package GraphFrameWork.app;

import GraphFrameWork.Edge;

/**
 * Route: Subclass of Edge, represents a specific route between locations.
 */
public class Route extends Edge {

    public Route(Location source, Location destination, int weight) {
        super(source, destination, weight);
    }

    /**
     * Displays information about the route.
     */
    @Override
    public void displayInfo() {
        System.out.println("--- route length: " + weight);
    }
}
