package GraphFrameWork;


import GraphFrameWork.app.Location;
import GraphFrameWork.app.Route;

import java.util.*;

/**
 * SingleSourceSPAlg: Implements Dijkstra's algorithm from a single source vertex.
 * It calculates the shortest path from the given source to all other vertices.
 */

public class SingleSourceSPAlg extends ShortestPathAlgorithm {
    public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }

    /**
     * Executes Dijkstra's algorithm starting from the given source vertex.
     * Updates the parent pointers of edges to trace the shortest paths.
     */

    @Override
    public void computeDijkstraAlg(Location source) {
        Map<Location, Integer> distance = new HashMap<>();
        PriorityQueue< Location > pq =new PriorityQueue<>(Comparator.comparingInt(distance::get));
        Map<Location, Route> prev = new HashMap<>();

        // Initialize distances to infinity, except the source
        for(Location v: graph.getVertices()){
            distance.put(v, Integer.MAX_VALUE);
        }
        distance.put(source, 0);
        pq.add(source);

        // Main loop of Dijkstra
        while(!pq.isEmpty()){
            Location current=pq.poll();

            for(Route u: current.adjList){

                if(u.getDestination().isVisited)
                    continue;

                int newDist = distance.get(current) + u.getWeight();

                if(newDist < distance.get(u.getDestination())){
                    distance.put(u.getDestination(), newDist);
                    u.parent=current; // Update parent for path tracing
                    pq.add(u.getDestination());
                    prev.put(current, u); // Optional: if you want to track edges
                }
            }
            current.isVisited=true;  // Mark as visited
        }

    }
}

