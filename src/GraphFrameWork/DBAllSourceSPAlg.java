package GraphFrameWork;




import GraphFrameWork.app.Location;
import GraphFrameWork.app.Route;

import java.util.Stack;
/**
 * DBAllSourceSPAlg: Implements Dijkstra's algorithm for all pairs of vertices.
 * It can either print the shortest paths or just compute them silently for performance testing.
 */

public class DBAllSourceSPAlg {
    private Graph graph; // The graph to process

    public DBAllSourceSPAlg(Graph graph) {
        this.graph = graph;
    }
    /**
     * Computes and prints the shortest paths from each vertex to all others.
     */
    public void computeDijkstraBasedSPAlg() {
        for (Location v : graph.getVertices()) {
            System.out.println("The starting point location is " + v.getLabel());
            System.out.println("The routes from location " + v.getLabel() + " to the rest of the locations are:");
            SingleSourceSPAlg dijkstra = new SingleSourceSPAlg(graph);
            dijkstra.computeDijkstraAlg(v);

            for (Location target : graph.getVertices()) {
                if (target == v) continue;
                printPath(v, target, dijkstra); // Print the shortest path from v to the target vertice
            }

            System.out.println("----------------------------------------");
            for (Location p : graph.getVertices()) {
                p.isVisited=false;
                for(Edge e:p.adjList){
                    e.parent=null;
                }
            }
        }
    }

    private void printPath(Location source, Location target, SingleSourceSPAlg dijkstra) {
        Stack<Location> path = new Stack<>();
        Location current = target;
        int cost=0;

        while (!current.equals(source)) {
            path.push(current);
            boolean found = false;
            for (Route e : graph.getEdges()) {
                if (e.getDestination().equals(current) && e.parent != null) {
                    cost+=e.getWeight();
                    current = e.parent;
                    found = true;
                    break;
                }
            }

            if (!found) return; // Path not found
        }

        path.push(source);

        // Print the path
        while (!path.isEmpty()) {
            Location v = path.pop();
            v.displayInfo();
            if (!path.isEmpty()) System.out.print(" – ");
        }

        System.out.println(" --- route length: " + cost);
    }

    /**
     * Computes shortest paths from all vertices without printing.
     * Used for performance evaluation.
     */
    public void computeDijkstraBasedSPAlgWithoutPrinting() {
        for (Location v : graph.getVertices()) {
            SingleSourceSPAlg dijkstra = new SingleSourceSPAlg(graph);
            dijkstra.computeDijkstraAlg(v);

            for (Location p : graph.getVertices()) {
                p.isVisited = false;
                for (Edge e : p.adjList) {
                    e.parent = null;
                }
            }
        }
    }

}
