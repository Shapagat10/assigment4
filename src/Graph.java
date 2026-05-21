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
    public void addEdge(int from, int to, int weight) {
        if (!vertices.containsKey(from)) addVertex(new Vertex(from));
        if (!vertices.containsKey(to)) addVertex(new Vertex(to));

        Vertex source = vertices.get(from);
        Vertex dest = vertices.get(to);

        Edge edge = new Edge(source, dest, weight);
        adjacencyList.get(from).add(edge);
    }

    public void dijkstra(int start) {
        if (!vertices.containsKey(start)) {
            System.out.println("Start vertex " + start + " not found.");
            return;
        }

        Map<Integer, Integer> distances = new HashMap<>(); // Хранит кратчайшие расстояния
        Set<Integer> visited = new HashSet<>();            // Хранит посещенные вершины

        for (int vertexId : vertices.keySet()) {
            distances.put(vertexId, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        for (int i = 0; i < vertices.size(); i++) {
            int currentVertex = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int vertexId : vertices.keySet()) {
                if (!visited.contains(vertexId) && distances.get(vertexId) < minDistance) {
                    minDistance = distances.get(vertexId);
                    currentVertex = vertexId;
                }
            }

            if (currentVertex == -1) break;

            visited.add(currentVertex);

            for (Edge edge : adjacencyList.get(currentVertex)) {
                int neighborId = edge.getDestination().getId();

                if (!visited.contains(neighborId)) {
                    int edgeWeight = edge.getWeight();
                    int newDist = distances.get(currentVertex) + edgeWeight;

                    if (newDist < distances.get(neighborId)) {
                        distances.put(neighborId, newDist);
                    }
                }
            }
        }

        System.out.println("Shortest distances from vertex " + start + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            int target = entry.getKey();
            int dist = entry.getValue();

            System.out.print("To vertex " + target + ": ");
            if (dist == Integer.MAX_VALUE) {
                System.out.println("Unreachable (Infinity)");
            } else {
                System.out.println(dist);
            }
        }
    }

    public void printGraph() {
        for (int key : adjacencyList.keySet()) {
            System.out.print("Vertex " + key + " -> ");
            List<Edge> edges = adjacencyList.get(key);
            for (int i = 0; i < edges.size(); i++) {
                System.out.print(edges.get(i).getDestination().getId() + "(" + edges.get(i).getWeight() + ")");
                if (i < edges.size() - 1) System.out.print(", ");
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