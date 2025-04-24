package GraphFrameWork.app;

import GraphFrameWork.DBAllSourceSPAlg;
import GraphFrameWork.Graph;

/**
 * AirFreightApp: This is the main class to run the application.
 * It performs two tasks:
 * 1. Reads a predefined graph from a file and computes shortest paths.
 * 2. Generates large random graphs and measures the performance of Dijkstra's algorithm.
 */

public class AirFreightApp {



    public static void main(String[] args) {
        // Task 1: Read graph from file and compute shortest paths
        Graph graph = new Graph();
        graph.readGraphFromFile("input.txt");

        DBAllSourceSPAlg a=new DBAllSourceSPAlg(graph);
        a.computeDijkstraBasedSPAlg(); // Computes and prints shortest paths for small graph

        // Task 2: Generate large graphs and measure algorithm performance
        int[] nValues = {2000, 3000, 4000, 5000, 6000};
        int[] mValues = {10000, 15000, 20000, 25000, 30000};

        for (int i = 0; i < nValues.length; i++) {
            int n = nValues[i];
            int m = mValues[i];


            graph.make_graph(n, m);// Generate random graph with n vertices and m edges
            long startTime = System.nanoTime();
            a.computeDijkstraBasedSPAlgWithoutPrinting(); // Run Dijkstra without printing
            long endTime = System.nanoTime();

            // Calculate system time for dijkstra algorithm
            long duration = endTime - startTime;

            System.out.println("n = " + n + ", m = " + m);
            System.out.println("Running time of Algorithm: " + duration + " ns");

            // Theoretical time complexity: O((V+E) log V)
            double theoreticalTime = n * ((n + m) *( Math.log(n) / Math.log(2)));
            System.out.println("Expected theoretical time efficiency: " + (long)theoreticalTime + " ns");
            System.out.println("------------------------------------------");
        }



    }

}