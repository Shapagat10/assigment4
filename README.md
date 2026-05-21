# Assignment 4: Graph Traversal and Representation System (with Bonus Task)

## A. Project Overview
This project is a comprehensive Java-based application designed to model, traverse, and analyze graph structures. Graphs are fundamental data structures in computer science used to represent pairwise relations between objects, consisting of **Vertices** (nodes) and **Edges** (connections).

This implementation covers:
1. **Core Traversals**: Breadth-First Search (BFS) and Depth-First Search (DFS) to explore graph structures.
2. **Advanced Algorithms (Bonus)**: Dijkstra's Algorithm to find the shortest paths from a single source vertex to all other vertices in a weighted graph.

---

## B. Class Descriptions
The project follows strict Object-Oriented Programming (OOP) standards and is divided into the following core classes:

* **`Vertex`**: Represents a node in the graph, uniquely identified by a private integer `id`.
* **`Edge`**: Represents a directed connection between a `source` vertex and a `destination` vertex. It includes a `weight` field to explicitly support shortest-path edge metrics for Dijkstra's algorithm.
* **`Graph`**: The central class managing the graph structure. It represents the graph using an **Adjacency List** implemented via `Map<Integer, List<Edge>>`, which maps each vertex ID to its corresponding list of outgoing edges.
* **`Experiment`**: Handles automated graph generation and performance testing, dynamically benchmarking traversal times across different graph scales using `System.nanoTime()`.
* **`Main`**: The entry point of the application that orchestrates the execution of both the performance benchmarks and the custom verification of Dijkstra's algorithm.

---

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)
The algorithm starts at a designated root vertex and explores all of its neighbor vertices at the current depth level before moving to the vertices at the next depth level. It uses a queue (FIFO) to track vertices to visit and a tracking mechanism to record visited nodes to prevent loops. This approach is widely used for finding the shortest path in an unweighted graph or managing peer suggestions in social networks.
* **Time Complexity**: $O(V + E)$, where $V$ is the number of vertices and $E$ is the number of edges.

### 2. Depth-First Search (DFS)
The algorithm starts at a chosen vertex and explores as far as possible along each branch before backtracking recursively. It implicitly utilizes the execution call stack alongside a visited tracker. This method is commonly applied in topological sorting, finding connected components, and solving path puzzles like mazes.
* **Time Complexity**: $O(V + E)$.

### 3. Dijkstra's Algorithm (Bonus Task)
The algorithm finds the shortest path from a starting node to all other nodes in a graph with positive edge weights. It initializes all node distances to infinity, except the source node which is set to 0. Using simple iterative loops without a priority queue, it repeatedly evaluates the closest unvisited node and updates ("relaxes") the distance values of its neighbors. This matches standard network routing protocols and GPS map processing.
* **Time Complexity**: $O(V^2)$ for an iterative structure without a binary heap optimization scheme.

---

## D. Experimental Results

### Execution Time Comparison Table
The benchmark test evaluates the execution time of BFS and DFS traversals across three distinct graph sizes (measured in nanoseconds):

| Graph Size (Vertices) | BFS Time (ns) | DFS Time (ns) |
|-----------------------|---------------|---------------|
| **10 (Small)** | 3,400         | 23,600        |
| **30 (Medium)** | 5,400         | 11,800        |
| **100 (Large)** | 28,800        | 12,500        |

### Observations and Analysis
1. **How graph size affects performance**: As the number of vertices ($V$) and edges ($E$) scales up, the execution time for both traversals increases. This upward trend matches the expected linear growth curve.
2. **Which traversal is faster**: In smaller and medium graphs, BFS executed significantly faster than DFS in our environment. However, as the graph grew to 100 vertices, DFS performance optimized, completing faster than BFS.
3. **Matching theoretical complexity**: Yes, the results generally conform to the $O(V + E)$ time complexity. Fluctuations in small graphs are primarily caused by JVM warm-up phases and temporary processor allocation updates.
4. **How graph structure affects traversal order**: Graph density and the randomness of edge allocation determine the sequence of nodes visited. BFS expands evenly outwards in concentric rings, while DFS dives deeply along a single path before backtracking.
5. **When BFS is preferred over DFS**: BFS is highly preferred when you need to find the shortest path or minimum number of transitions in an unweighted graph structure.
6. **Limitations of DFS**: DFS can consume a significant amount of stack memory due to deep recursion on large, linear graphs, potentially leading to a `StackOverflowError`. It also does not guarantee finding the shortest path on the first try.

---


---

## F. Reflection Section
Through implementing this project, I gained a deep practical understanding of graph representations and traversal algorithms. Moving from theoretical concepts to setting up an actual Adjacency List using Java's collection framework (`Map` and `List`) reinforced my object-oriented design skills. Observing how BFS spreads layer by layer versus how DFS explores paths recursively made the theoretical behavioral differences distinct.

The primary challenge encountered during development was adapting the random graph generator in the `Experiment` class to accommodate edge weights seamlessly once the bonus requirements were introduced. Modifying the signature of `addEdge` broke existing sequential generation tests, forcing me to refine the randomized loop logic to assign uniform random costs. Overcoming this highlighted the value of modular, scalable programming practices.
## Bonus Task Implementation Details

To fulfill the requirements of the Bonus Task, the original codebase was upgraded with weighted graph support and pathfinding capabilities. Here is exactly what was added and modified in the existing code:

1. **`Edge.java` (Modification)**:
   * Added a private `weight` field (integer) to the edge structure.
   * Updated the constructor to initialize the weight alongside the source and destination vertices.
   * Added a `getWeight()` getter method to retrieve edge costs during path exploration.

2. **`Graph.java` (Extensions)**:
   * **Method `addEdge(int from, int to, int weight)`**: Modified the standard edge creation method to accept a third parameter (`weight`). This ensures every dynamically generated or manually assigned connection stores its precise routing cost in the adjacency list.
   * **Method `dijkstra(int start)`**: Implemented a single-source shortest path algorithm from scratch. Following the constraints, it avoids using a `PriorityQueue` and strictly relies on standard iterative loops and hash maps (`Map<Integer, Integer>` for distances and `Set<Integer>` for visited nodes) to find the minimum distance node at each step. It successfully handles unreachable nodes by displaying them as `Infinity`.

3. **`Experiment.java` (Adaptation)**:
   * Updated the `generateRandomGraph` algorithm. Now, when random edges are bound together, a random weight multiplier between `1` and `20` is automatically assigned using `random.nextInt(20) + 1` to keep the auto-generated graphs structurally compatible with the updated `addEdge` method.

4. **`Main.java` (Integration)**:
   * Combined both assignment parts. After executing the core performance tests, the system automatically builds a fixed verification graph and executes `graph.dijkstra(1)` to demonstrate the mathematical correctness of the shortest path calculation in real time.
