package PuzzleMedium.SkynetRevolutionEpisode1;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SkynetRevolutionEpisode1_1 {
    private static Map<Integer, Set<Integer>> linkMap;
    private static Map<Integer, Set<Integer>> severed;
    private static List<List<Integer>> routes;
    private static List<Integer> gateways;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        linkMap = new HashMap<>(N);
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            addLink(N1, N2);
            addLink(N2, N1);
        }
        gateways = Stream.generate(in::nextInt).limit(E).collect(Collectors.toList());
//        for (int i = 0; i < E; i++) {
//            int EI = in.nextInt(); // the index of a gateway node
//        }
        severed = new HashMap<>(N);
        init(severed, N);
        // game loop
        //noinspection InfiniteLoopStatement
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            routes = new ArrayList<>();
            findRoutes(SI);
            System.err.println(routes);
            List<Integer> route = routes.stream().min((a, b) -> Integer.compare(a.size(), b.size())).get();
            System.err.println(route);
            int i = route.stream().limit(route.size() - 1).min((a, b) -> Integer.compare(getAvailable(a, route).size(), getAvailable(b, route).size())).get();
            System.err.println(i);
            i = route.indexOf(i);
            int a = route.get(i);
            int b = route.get(i + 1);
            severed.get(a).add(b);
            severed.get(b).add(a);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            System.out.println(a + " " + b);
        }
    }

    private static void addLink(int n1, int n2) {
        linkMap.computeIfAbsent(n1, HashSet::new).add(n2);
    }

    private static void init(Map<Integer, Set<Integer>> map, int n) {
        IntStream.range(0, n).forEach(i -> map.put(i, new HashSet<>()));
    }

    private static void findRoutes(int SI) {
        List<Integer> route = new ArrayList<>();
        weNeedToGoDeeper(SI, route);
    }

    private static void weNeedToGoDeeper(int node, List<Integer> route) {
        route.add(node);
        Set<Integer> links = getAvailable(node, route);
        Optional<Integer> gateway = links.stream().filter(gateways::contains).findAny();
        if (gateway.isPresent()) {
            route.add(gateway.get());
            routes.add(route);
        } else {
            links.forEach(i -> weNeedToGoDeeper(i, new ArrayList<>(route)));
        }
    }

    private static Set<Integer> getAvailable(int node, List<Integer> route) {
        HashSet<Integer> links = new HashSet<>(linkMap.get(node));
        links.removeAll(severed.get(node));
        links.removeAll(route);
        return links;
    }
}
