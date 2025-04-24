package GraphFrameWork.app;

import GraphFrameWork.Vertex;

/**
 * Location: Subclass of Vertex, represents a specific location (city).
 */
public class Location extends Vertex {


    public Location(String label,int city) {
        super(label,city);
    }

    /**
     * Displays information about the location.
     */
    @Override
    public void displayInfo() {
        System.out.print("loc. " + label + ": city " + city);
    }
}

