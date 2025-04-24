package GraphFrameWork;

import GraphFrameWork.app.Location;
import GraphFrameWork.app.Route;

import java.io.File;
import java.util.*;

/**
 * Graph: Represents the graph structure consisting of vertices and edges.
 * Provides functionality to read a graph from a file, create vertices and edges,
 * and generate random graphs for performance testing.
 */
public class Graph {
    public int veticesNo; // Number of vertices
    public int edgeNo; // Number of edges
    public boolean isDiGraph; // Indicates if the graph is directed
    private List<Location> vertices = new ArrayList<>(); // List of vertices
    private List<Route> edges = new ArrayList<>(); // List of edges

    /**
     * Reads a graph from a text file.
     * Each line in the file should be in the format: "Vertex Vertex Weight".
     */
    public void readGraphFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                String currentLine = read.nextLine();
                String[] parts = currentLine.split(" ");
                if (parts.length != 3) {
                    System.out.println("Invalid input format. Expected: Vertex Vertex Weight");
                    break;
                }
                Location ver1 = null;
                Location ver2 = null;

                // Check if vertices already exist
                for (Location vertex : vertices) {
                    if (vertex.getLabel().equals(parts[0])) {
                        ver1 = vertex;
                    } else if (vertex.getLabel().equals(parts[1])) {
                        ver2 = vertex;
                    }
                }
                // Create vertices if not found
                ver1 = (ver1 == null) ? createVertex(parts[0]) : ver1;
                ver2 = (ver2 == null) ? createVertex(parts[1]) : ver2;

                // Check if edge already exists
                boolean edgeExist = false;
                for (Route edge : edges) {
                    if ((edge.source.getLabel().equals(parts[0])) && (edge.destination.getLabel().equals(parts[1]))) {
                        edgeExist = true;
                    }
                }
                // Create edge if not existing
                if (!edgeExist) {
                    createEdge(ver1, ver2, Integer.parseInt(parts[2]));
                }
            }
            read.close();

        } catch (NumberFormatException e) {
            System.out.println("Weight in input file must be an integer.");
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }

    /**
     * Creates a new vertex and adds it to the graph.
     */
    public Location createVertex(String label) {
        veticesNo++;
        Location v = new Location(label,veticesNo);
        vertices.add(v);
        return v;
    }

    /**
     * Creates a new edge and adds it to the graph.
     */
    public Route createEdge(Location source, Location target, int weight) {
        Route e = new Route(source, target, weight);
        edges.add(e);
        source.addadj(e);
        edgeNo++;
        return e;
    }

    public List<Location> getVertices() {
        return vertices;
    }

    public List<Route> getEdges() {
        return edges;
    }

    /**
     * Generates a random graph with given number of vertices and edges.
     * Edge weights are random integers between 10 and 100.
     */
    public void make_graph(int n, int m) {
        Random rand = new Random();
        vertices.clear();
        edges.clear();
        veticesNo = 0;
        edgeNo = 0;

        // Create vertices
        for (int i = 0; i < n; i++) {
            createVertex("Loc" + (i + 1));
        }

        // Create random edges
        for (int i = 0; i < m; i++) {
            Location source = vertices.get(rand.nextInt(vertices.size()));
            Location dest = vertices.get(rand.nextInt(vertices.size()));
            int weight = rand.nextInt(91) + 10; // Weight between 10 and 100
            if (source != dest) {
                createEdge(source, dest, weight);
            } else {
                i--; // Avoid self-loops
            }
        }
    }
}









