# Assignment 4: Graph Traversal and Representation System (with Bonus Task)

## A. Project Overview
[cite_start]This project is a comprehensive Java-based application designed to model, traverse, and analyze graph structures[cite: 23]. [cite_start]Graphs are fundamental data structures in computer science used to represent pairwise relations between objects, consisting of **Vertices** (nodes) and **Edges** (connections)[cite: 25].

This implementation covers:
1. [cite_start]**Core Traversals**: Breadth-First Search (BFS) and Depth-First Search (DFS) to explore unweighted graph structures[cite: 27].
2. [cite_start]**Advanced Algorithms (Bonus)**: Dijkstra's Algorithm to find the shortest paths from a single source vertex to all other vertices in a weighted graph[cite: 2, 3].

---

## B. Class Descriptions
[cite_start]The project follows strict Object-Oriented Programming (OOP) standards and is divided into the following core classes[cite: 37, 74]:

* [cite_start]**`Vertex`**: Represents a node in the graph, uniquely identified by an integer `id`[cite: 38, 41].
* [cite_start]**`Edge`**: Represents a directed connection between a `source` vertex and a `destination` vertex[cite: 46, 49, 50]. [cite_start]Extended to include a `weight` field to support shortest-path calculations[cite: 6].
* [cite_start]**`Graph`**: The central class managing the graph structure[cite: 55]. [cite_start]It represents the graph using an **Adjacency List** implemented via `Map<Integer, List<Edge>>`, which maps each vertex ID to its list of outgoing edges[cite: 56, 57].
* [cite_start]**`Experiment`**: Handles automated graph generation and performance testing, dynamically benchmarking traversal times across different graph scales[cite: 65, 66].
* **`Main`**: The entry point of the application that orchestrates the execution of both the performance benchmarks and the custom verification of Dijkstra's algorithm.

---

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)
* [cite_start]**Step-by-Step Logic**: BFS starts at a designated root vertex and explores all of its neighbor vertices at the current depth level before moving to the vertices at the next depth level[cite: 35]. It uses a `Queue` (FIFO) to track vertices to visit and a `Set` to record visited nodes to prevent infinite loops.
* **Use Cases**: Finding the shortest path in an unweighted graph, social network peer suggestions, and web crawlers.
* [cite_start]**Time Complexity**: $O(V + E)$, where $V$ is the number of vertices and $E$ is the number of edges[cite: 101].

### 2. Depth-First Search (DFS)
* [cite_start]**Step-by-Step Logic**: DFS starts at a chosen vertex and explores as far as possible along each branch before backtracking[cite: 36]. It is implemented using recursion (which implicitly utilizes the call stack) alongside a `Set` to track visited nodes.
* **Use Cases**: Topological sorting, finding strongly connected components, and solving puzzles (like mazes).
* [cite_start]**Time Complexity**: $O(V + E)$[cite: 101].

### 3. Dijkstra's Algorithm (Bonus Task)
* [cite_start]**Step-by-Step Logic**: Dijkstra's algorithm finds the shortest path from a starting vertex to all others in a weighted graph[cite: 3]. [cite_start]It initializes distances to all vertices as infinity (except the source, which is 0)[cite: 13]. [cite_start]Using a loop-based approach (without a PriorityQueue), it repeatedly selects the unvisited vertex with the minimum distance, marks it as visited, and updates ("relaxes") the distances to all its unvisited neighbors[cite: 18].
* **Use Cases**: GPS Navigation systems (Google Maps), network routing protocols (OSPF).
* [cite_start]**Time Complexity**: $O(V^2)$ in this specific array/map loop implementation, optimized for clean educational execution[cite: 18].

---

## D. Experimental Results

### Execution Time Comparison Table
[cite_start]The benchmark test evaluates the execution time of BFS and DFS traversals across three distinct graph sizes (measured in nanoseconds)[cite: 89, 94, 95]:

| Graph Size (Vertices) | BFS Time (ns) | DFS Time (ns) |
|-----------------------|---------------|---------------|
| **10 (Small)** | 3,400         | 23,600        |
| **30 (Medium)** | 5,400         | 11,800        |
| **100 (Large)** | 28,800        | 12,500        |

### Observations and Analysis
1.  [cite_start]**How graph size affects performance**: As the number of vertices ($V$) and edges ($E$) scales up, the execution time for both traversals increases[cite: 99]. This upward trend matches the theoretical linear growth curve.
2.  [cite_start]**Which traversal is faster**: In smaller and medium graphs, BFS executed significantly faster than DFS in our environment[cite: 100]. However, as the graph grew to 100 vertices, DFS performance optimized, completing faster than BFS.
3.  [cite_start]**Matching theoretical complexity**: Yes, the results generally conform to the $O(V + E)$ time complexity[cite: 101]. Fluctuations in small graphs are primarily caused by JVM warm-up phases and system-level overhead.
4.  [cite_start]**How graph structure affects traversal order**: Graph density and the randomness of edge allocation determine the sequence of nodes visited[cite: 102]. BFS expands evenly outwards in concentric rings, while DFS dives deeply along a single path before backtracking.
5.  [cite_start]**When BFS is preferred over DFS**: BFS is highly preferred when you need to find the shortest path or minimum number of steps in an unweighted graph[cite: 103].
6.  [cite_start]**Limitations of DFS**: DFS can consume a dangerous amount of stack memory due to deep recursion on large, linear graphs, potentially leading to a `StackOverflowError`[cite: 104]. It also does not guarantee finding the shortest path on the first try.

---


---

## F. Reflection Section
[cite_start]Through implementing this project, I gained a deep practical understanding of graph representations and traversal algorithms[cite: 135]. [cite_start]Moving from theoretical concepts to setting up an actual Adjacency List using Java's collection framework (`Map` and `List`) reinforced my object-oriented design skills[cite: 57, 112]. [cite_start]Observing how BFS spreads layer by layer versus how DFS explores paths recursively made the theoretical behavioral differences distinct[cite: 136].

[cite_start]The primary challenge encountered during development was adapting the random graph generator in the `Experiment` class to accommodate edge weights seamlessly once the bonus requirements were introduced[cite: 137]. Modifying the signature of `addEdge` broke existing sequential generation tests, forcing me to refine the randomized loop logic to assign uniform random costs. Overcoming this highlighted the value of modular, scalable programming practices.
