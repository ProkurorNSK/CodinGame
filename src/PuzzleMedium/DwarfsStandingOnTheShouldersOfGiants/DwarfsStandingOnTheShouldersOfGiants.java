package PuzzleMedium.DwarfsStandingOnTheShouldersOfGiants;

import java.util.*;

public class DwarfsStandingOnTheShouldersOfGiants {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of relationships of influence
        DirectedGraph graph = new DirectedGraph();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(); // a relationship of influence between two people (x influences y)
            int y = in.nextInt();
            graph.addEdge(x, y);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // The number of people involved in the longest succession of influences
        System.out.println(graph.getLongestPath(0));
    }
}

class DirectedGraph {

    private Map<Integer, List<Integer>> vertexMap = new HashMap<>();

    private void addVertex(Integer vertex) {
        if (!hasVertex(vertex)) {
            vertexMap.put(vertex, new ArrayList<>());
        }
    }

    private boolean hasVertex(Integer vertex) {
        return vertexMap.containsKey(vertex);
    }

    public boolean hasEdge(Integer vertex1, Integer vertex2) {
        if (!hasVertex(vertex1)) return false;
        List<Integer> edges = vertexMap.get(vertex1);
        return Collections.binarySearch(edges, vertex2) != -1;
    }

    public void addEdge(Integer vertex1, Integer vertex2) {
        if (!hasVertex(vertex1)) addVertex(vertex1);
        if (!hasVertex(vertex2)) addVertex(vertex2);
        List<Integer> edges = vertexMap.get(vertex1);
        edges.add(vertex2);
        Collections.sort(edges);
    }

    public Map<Integer, List<Integer>> getVertexMap() {
        return vertexMap;
    }

    public int getLongestPath(int result) {
        for (int i = 0; i < vertexMap.size(); i++) {
            List<Integer> edges = vertexMap.get(i);
            if (edges != null && (result != 0 || edges.size() == 0)) {
                result++;
                for (int j = 0; j < vertexMap.size(); j++) {
                    List<Integer> edgesUp = vertexMap.get(i);
                    if (edgesUp.contains(i)) {
                        result = getLongestPath(result);
                    }
                }
            }
        }
        return result;
    }
}