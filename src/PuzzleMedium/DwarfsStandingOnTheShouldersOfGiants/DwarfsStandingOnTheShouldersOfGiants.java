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

        graph.getChains();
        graph.printChains();
        System.out.println(graph.getLongestChain());
        // The number of people involved in the longest succession of influences
    }
}

class DirectedGraph {

    private Map<Integer, List<Integer>> vertexMap = new HashMap<>();
    private ArrayList<String> chains = new ArrayList<>(0);

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

    public void getChains() {
        for (Map.Entry<Integer, List<Integer>> vertex : vertexMap.entrySet()) {
            getChain(vertex.getKey(), "");
        }
    }

    private void getChain(int vertex, String chain) {
        List<Integer> edges = vertexMap.get(vertex);
        chain += vertex + " ";
        if (edges.size() == 0) {
            chains.add(chain);
        } else {
            for (int edge : edges) {
                getChain(edge, chain);
            }
        }
    }

    public void printChains() {
        for (String chain: chains) {
            System.out.println(chain);
        }
    }

    public int getLongestChain() {
        int max = 0;
        for (String chain: chains) {
            String[] count = chain.split(" ");
            max = Math.max(max, count.length);
        }
        return max;
    }
}