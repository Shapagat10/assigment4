import java.util.Random;

public class Experiment {

    private static long smallBfsTime, smallDfsTime;
    private static long medBfsTime, medDfsTime;
    private static long largeBfsTime, largeDfsTime;

    public static void runTraversals(Graph g) {
        System.out.println("--- Running Traversals ---");

        System.out.print("BFS from vertex 0: ");
        g.bfs(0);
        System.out.println();

        System.out.print("DFS from vertex 0: ");
        g.dfs(0);
        System.out.println();
    }

    public static void runMultipleTests() {
        Graph warmup = generateRandomGraph(50, 150);
        for (int i = 0; i < 2000; i++) {
            warmup.silentBfs(0);
            warmup.silentDfs(0);
        }

        System.out.println(">>> PART 1: Small Graph (10 vertices)");
        System.out.println("=== Graph Adjacency List ===");
        Graph smallGraph = generateRandomGraph(10, 18);
        smallGraph.printGraph();
        System.out.println("===");
        System.out.println();
        runTraversals(smallGraph);

        long start = System.nanoTime();
        smallGraph.silentBfs(0);
        smallBfsTime = System.nanoTime() - start;

        start = System.nanoTime();
        smallGraph.silentDfs(0);
        smallDfsTime = System.nanoTime() - start;

        printResults("BFS", smallBfsTime);
        printResults("DFS", smallDfsTime);
        System.out.println();

        System.out.println(">>> PART 2: Medium Graph (30 vertices)");
        System.out.println();
        Graph mediumGraph = generateRandomGraph(30, 65);
        runTraversals(mediumGraph);

        start = System.nanoTime();
        mediumGraph.silentBfs(0);
        medBfsTime = System.nanoTime() - start;

        start = System.nanoTime();
        mediumGraph.silentDfs(0);
        medDfsTime = System.nanoTime() - start;

        printResults("BFS", medBfsTime);
        printResults("DFS", medDfsTime);
        System.out.println();

        System.out.println(">>> PART 3: Large Graph (100 vertices)");
        System.out.println();
        Graph largeGraph = generateRandomGraph(100, 250);
        runTraversals(largeGraph);

        start = System.nanoTime();
        largeGraph.silentBfs(0);
        largeBfsTime = System.nanoTime() - start;

        start = System.nanoTime();
        largeGraph.silentDfs(0);
        largeDfsTime = System.nanoTime() - start;

        printResults("BFS", largeBfsTime);
        printResults("DFS", largeDfsTime);
        System.out.println();

        System.out.println(">>> PART 4: Full Performance Test (10 / 30 / 100 vertices)");
        System.out.println();
        System.out.println("===");
        System.out.println("   PERFORMANCE TEST - MULTIPLE SIZES");
        System.out.println("===");
        System.out.println();

        System.out.println("[Graph Size: 10 vertices]");
        System.out.print("BFS from vertex 0: "); smallGraph.bfs(0); System.out.println();
        System.out.print("DFS from vertex 0: "); smallGraph.dfs(0); System.out.println();
        printResults("BFS", smallBfsTime);
        printResults("DFS", smallDfsTime);
        System.out.println();

        System.out.println("[Graph Size: 30 vertices]");
        System.out.print("BFS from vertex 0: "); mediumGraph.bfs(0); System.out.println();
        System.out.print("DFS from vertex 0: "); mediumGraph.dfs(0); System.out.println();
        printResults("BFS", medBfsTime);
        printResults("DFS", medDfsTime);
        System.out.println();

        System.out.println("[Graph Size: 100 vertices]");
        System.out.print("BFS from vertex 0: "); largeGraph.bfs(0); System.out.println();
        System.out.print("DFS from vertex 0: "); largeGraph.dfs(0); System.out.println();
        printResults("BFS", largeBfsTime);
        printResults("DFS", largeDfsTime);
        System.out.println();

        // Prints final execution table matching image format exactly
        System.out.println("===");
        System.out.println("   EXECUTION TIME SUMMARY");
        System.out.println("===");
        System.out.printf("%-12s %-18s %-18s\n", "Graph Size", "BFS Time (ns)", "DFS Time (ns)");
        System.out.println("---");
        System.out.printf("%-12s %-18d %-18d\n", "10", smallBfsTime, smallDfsTime);
        System.out.printf("%-12s %-18d %-18d\n", "30", medBfsTime, medDfsTime);
        System.out.printf("%-12s %-18d %-18d\n", "100", largeBfsTime, largeDfsTime);
        System.out.println("===");
        System.out.println("Both BFS and DFS have time complexity: O(V + E)");
        System.out.println("===");
    }

    public static void printResults(String algorithmName, long duration) {
        System.out.println(algorithmName + " Time: " + duration + " ns");
    }

    private static Graph generateRandomGraph(int verticesCount, int edgesCount) {
        Graph graph = new Graph();
        for (int i = 0; i < verticesCount; i++) {
            graph.addVertex(new Vertex(i));
        }
        Random random = new Random();
        int edgesAdded = 0;

        while (edgesAdded < 3 && verticesCount > 3) {
            int to = random.nextInt(verticesCount - 1) + 1;
            graph.addEdge(0, to);
            edgesAdded++;
        }

        while (edgesAdded < edgesCount) {
            int from = random.nextInt(verticesCount);
            int to = random.nextInt(verticesCount);
            if (from != to) {
                graph.addEdge(from, to);
                edgesAdded++;
            }
        }
        return graph;
    }
}