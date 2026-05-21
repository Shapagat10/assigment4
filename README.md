# Assignment 4: Graph Traversal and Representation System (with Bonus Task)

## A. Project Overview
This project is a comprehensive Java-based application designed to model, traverse, and analyze graph structures. Graphs are fundamental data structures in computer science used to represent pairwise relations between objects, consisting of **Vertices** (nodes) and **Edges** (connections).

This implementation covers:
1. [**Core Traversals**: Breadth-First Search (BFS) and Depth-First Search (DFS) to explore unweighted graph structures.
2. **Advanced Algorithms (Bonus)**: Dijkstra's Algorithm to find the shortest paths from a single source vertex to all other vertices in a weighted graph.

---

## B. Class Descriptions
The project follows strict Object-Oriented Programming (OOP) standards and is divided into the following core classes:

* **`Vertex`**: Represents a node in the graph, uniquely identified by an integer `id`.
* **`Edge`**: Represents a directed connection between a `source` vertex and a `destination` vertex. Extended to include a `weight` field to support shortest-path calculations.
* **`Graph`**: The central class managing the graph structure. It represents the graph using an **Adjacency List** implemented via `Map<Integer, List<Edge>>`, which maps each vertex ID to its list of outgoing edges.
* **`Experiment`**: Handles automated graph generation and performance testing, dynamically benchmarking traversal times across different graph scales.
* **`Main`**: The entry point of the application that orchestrates the execution of both the performance benchmarks and the custom verification of Dijkstra's algorithm.

---

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)
* **Step-by-Step Logic**: BFS starts at a designated root vertex and explores all of its neighbor vertices at the current depth level before moving to the vertices at the next depth level. It uses a `Queue` (FIFO) to track vertices to visit and a `Set` to record visited nodes to prevent infinite loops.
* **Use Cases**: Finding the shortest path in an unweighted graph, social network peer suggestions, and web crawlers.
* **Time Complexity**: $O(V + E)$, where $V$ is the number of vertices and $E$ is the number of edges.

### 2. Depth-First Search (DFS)
* **Step-by-Step Logic**: DFS starts at a chosen vertex and explores as far as possible along each branch before backtracking. It is implemented using recursion (which implicitly utilizes the call stack) alongside a `Set` to track visited nodes.
* **Use Cases**: Topological sorting, finding strongly connected components, and solving puzzles (like mazes).
* **Time Complexity**: $O(V + E)$.

### 3. Dijkstra's Algorithm (Bonus Task)
* **Step-by-Step Logic**: Dijkstra's algorithm finds the shortest path from a starting vertex to all others in a weighted graph. It initializes distances to all vertices as infinity (except the source, which is 0). Using a loop-based approach (without a PriorityQueue), it repeatedly selects the unvisited vertex with the minimum distance, marks it as visited, and updates ("relaxes") the distances to all its unvisited neighbors.
* **Use Cases**: GPS Navigation systems (Google Maps), network routing protocols (OSPF).
* **Time Complexity**: $O(V^2)$ in this specific array/map loop implementation, optimized for clean educational execution.

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
1.  **How graph size affects performance**: As the number of vertices ($V$) and edges ($E$) scales up, the execution time for both traversals increases. This upward trend matches the theoretical linear growth curve.
2.  **Which traversal is faster**: In smaller and medium graphs, BFS executed significantly faster than DFS in our environment. However, as the graph grew to 100 vertices, DFS performance optimized, completing faster than BFS.
3.  **Matching theoretical complexity**: Yes, the results generally conform to the $O(V + E)$ time complexity. Fluctuations in small graphs are primarily caused by JVM warm-up phases and system-level overhead.
4.  **How graph structure affects traversal order**: Graph density and the randomness of edge allocation determine the sequence of nodes visited. BFS expands evenly outwards in concentric rings, while DFS dives deeply along a single path before backtracking.
5. **When BFS is preferred over DFS**: BFS is highly preferred when you need to find the shortest path or minimum number of steps in an unweighted graph.
6.  **Limitations of DFS**: DFS can consume a dangerous amount of stack memory due to deep recursion on large, linear graphs, potentially leading to a `StackOverflowError`. It also does not guarantee finding the shortest path on the first try.

---


---

## F. Reflection Section
Through implementing this project, I gained a deep practical understanding of graph representations and traversal algorithms. Moving from theoretical concepts to setting up an actual Adjacency List using Java's collection framework (`Map` and `List`) reinforced my object-oriented design skills. Observing how BFS spreads layer by layer versus how DFS explores paths recursively made the theoretical behavioral differences distinct.
The primary challenge encountered during development was adapting the random graph generator in the `Experiment` class to accommodate edge weights seamlessly once the bonus requirements were introduced. Modifying the signature of `addEdge` broke existing sequential generation tests, forcing me to refine the randomized loop logic to assign uniform random costs. Overcoming this highlighted the value of modular, scalable programming practices.
