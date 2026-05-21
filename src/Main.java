public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Assignment 4: Graph Traversal System & Bonus");
        System.out.println("==================================================");
        System.out.println();
        System.out.println(">>> running core assignment 4 tests <<<");
        Experiment.runMultipleTests();
        System.out.println();

        System.out.println("==================================================");
        System.out.println("   BONUS TASK");
        System.out.println("==================================================");
        System.out.println();

        Graph bonusGraph = new Graph();
        bonusGraph.addEdge(1, 2, 5);
        bonusGraph.addEdge(1, 3, 10);
        bonusGraph.addEdge(2, 3, 2);
        bonusGraph.addEdge(2, 4, 11);
        bonusGraph.addEdge(3, 4, 3);
        bonusGraph.addEdge(4, 5, 2);
        bonusGraph.addVertex(new Vertex(6)); // Изолированная вершина

        System.out.println("Graph Structure for Dijkstra:");
        bonusGraph.printGraph();
        System.out.println();

        bonusGraph.dijkstra(1);
        System.out.println("==================================================");
    }
}