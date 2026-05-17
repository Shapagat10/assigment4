
import java.util.*;

public class Graph {
    private final Map<Integer, List<Edge>> adjacencyList;
    private final Map<Integer, Vertex> vertices;

    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        if (!vertices.containsKey(v.getId())) {
            vertices.put(v.getId(), v);
            adjacencyList.put(v.getId(), new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from)) addVertex(new Vertex(from));
        if (!vertices.containsKey(to)) addVertex(new Vertex(to));

        Vertex source = vertices.get(from);
        Vertex dest = vertices.get(to);

        Edge edge = new Edge(source, dest);
        adjacencyList.get(from).add(edge);
    }

    public void printGraph() {
        for (int key : adjacencyList.keySet()) {
            System.out.print("Vertex " + key + " -> ");
            List<Edge> edges = adjacencyList.get(key);
            for (int i = 0; i < edges.size(); i++) {
                System.out.print(edges.get(i).getDestination().getId());
                if (i < edges.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        if (!vertices.containsKey(start)) return;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int currentId = queue.poll();
            System.out.print(currentId + " ");

            for (Edge edge : adjacencyList.get(currentId)) {
                int neighborId = edge.getDestination().getId();
                if (!visited.contains(neighborId)) {
                    visited.add(neighborId);
                    queue.add(neighborId);
                }
            }
        }
    }

    public void dfs(int start) {
        if (!vertices.containsKey(start)) return;

        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(int currentId, Set<Integer> visited) {
        visited.add(currentId);
        System.out.print(currentId + " ");

        for (Edge edge : adjacencyList.get(currentId)) {
            int neighborId = edge.getDestination().getId();
            if (!visited.contains(neighborId)) {
                dfsHelper(neighborId, visited);
            }
        }
    }

    public void silentBfs(int start) {
        if (!vertices.containsKey(start)) return;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int currentId = queue.poll();
            for (Edge edge : adjacencyList.get(currentId)) {
                int neighborId = edge.getDestination().getId();
                if (!visited.contains(neighborId)) {
                    visited.add(neighborId);
                    queue.add(neighborId);
                }
            }
        }
    }

    public void silentDfs(int start) {
        if (!vertices.containsKey(start)) return;
        Set<Integer> visited = new HashSet<>();
        silentDfsHelper(start, visited);
    }

    private void silentDfsHelper(int currentId, Set<Integer> visited) {
        visited.add(currentId);
        for (Edge edge : adjacencyList.get(currentId)) {
            int neighborId = edge.getDestination().getId();
            if (!visited.contains(neighborId)) {
                silentDfsHelper(neighborId, visited);
            }
        }
    }
}