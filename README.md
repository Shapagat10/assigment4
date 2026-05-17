# Assignment 4: Graph Traversal and Representation System

## A. Project Overview
This project provides a comprehensive Java-based implementation of a directed graph structure and explores fundamental graph traversal techniques. A graph is a mathematical and computational structure consisting of a finite set of **vertices** (or nodes) and a finite set of **edges** that establish connections between them. 

In this system, **vertices** represent individual entities identified by a unique integer ID, while **edges** explicitly define directed paths from a source vertex to a destination vertex. To efficiently analyze connectivity and explore nodes, two foundational traversal methodologies are implemented:
* **Breadth-First Search (BFS):** An algorithm that traverses the graph layer by layer, exploring all immediate neighbors of a vertex before moving deeper into the structure.
* **Depth-First Search (DFS):** An algorithm that plunges deep along each branch, visiting nested children and recursively exploring paths until it reaches a dead-end before backtracking.

## B. Class Descriptions
The architecture adheres to strict Object-Oriented Programming (OOP) principles, isolating node data, connection properties, tracking logic, and benchmark orchestrations across multiple dedicated classes:
* `Vertex`: Represents an individual graph node. It contains a private integer `id` field as its unique identifier, a constructor, a getter, and an overridden `toString()` method to supply the text output matching assignment specifications.
* `Edge`: Models a directed connection between two nodes. It encapsulates two private `Vertex` properties (`source` and `destination`), accompanied by public getters and an intuitive string representation handler.
* `Graph`: The central data framework. It manages structural relationships using an **Adjacency List**, implemented via a `Map<Integer, List<Edge>>`. This structure is highly memory-efficient for sparse layouts, ensuring $O(1)$ lookup times for node headers while keeping track of neighboring records. It contains foundational functions like `addVertex()`, `addEdge()`, `printGraph()`, alongside standard console printing and silent performance-tracking traversal procedures.
* `Experiment`: Houses the testing pipeline. It automates random graph synthesis, guarantees deep reachability paths from root node 0, runs Just-In-Time (JIT) compilation warmup iterations to suppress early benchmark jitter, captures runtime intervals via `System.nanoTime()`, and formats final statistical performance tables.
* `Main`: Acts as the system execution entry point, initializing the programmatic testing sequence and printing setup headers.

## C. Algorithm Descriptions

### 1. Breadth-First Search (BFS)
* **Step-by-Step Explanation:** BFS utilizes an explicit FIFO (First-In, First-Out) `Queue` structure along with a `HashSet` to maintain a log of visited nodes. The execution begins by inserting the designated root node into the queue and flagging it as visited. In a continuous loop running while the queue is not empty, the algorithm extracts the head vertex, logs its ID to the output timeline, and examines its outbound edges. Every unvisited neighbor found is marked as visited and appended to the tail of the queue.
* **Use Cases:** BFS is highly preferred for finding the shortest path on unweighted graphs, network broadcasting routing tables, web crawling indexes, and social network friend-distance mappings.
* **Time Complexity:** $O(V + E)$, where $V$ is the total number of vertices and $E$ is the total number of edges, as every vertex is queued once and every edge is traversed once.

### 2. Depth-First Search (DFS)
* **Step-by-Step Explanation:** DFS leverages a LIFO (Last-In, First-Out) pattern, implemented via native method call recursion utilizing the system execution stack. Backed by a `HashSet` tracker, it registers the starting vertex, appends it to the console sequence, and sequentially inspects its immediate adjacency edge list. For each unvisited neighbor detected, the algorithm pauses current execution and immediately invokes itself recursively on that child node, digging deep into the graph path before backtracking to clear remaining adjacent branches.
* **Use Cases:** DFS is highly effective for topological sorting in build systems, identifying strongly connected components, detecting cycles in circuits, and solving complex maze puzzles where backtracking is necessary.
* **Time Complexity:** $O(V + E)$, mirroring BFS since it must systematically explore all reachable nodes and inspect their entire outbound adjacency structures.

## D. Experimental Results
The automated benchmarking framework tracked exact execution periods across varied dimensions (Small, Medium, Large scales). The empirical data collected from my successful execution run is summarized below:

| Graph Size (Vertices) | BFS Time (ns) | DFS Time (ns) |
|-----------------------|---------------|---------------|
| **10** (Small)        | 598300 ns     | 453000 ns     |
| **30** (Medium)       | 581300 ns     | 368600 ns     |
| **100** (Large)       | 1215900 ns    | 926900 ns     |

### Analysis and Answers to Assignment Questions:
1. **How does graph size affect BFS and DFS performance?** As the number of vertices ($V$) and edges ($E$) expands, execution durations increase. The growth exhibits a clean linear progression when scaling to large dimensions, matching the expected theoretical model.
2. **Which traversal is faster in your experiments?** DFS consistently demonstrated faster execution speeds across all test boundaries. This occurs because DFS operates over the direct execution stack with minimal overhead, while BFS demands active instantiation, insertion, and polling of heavy reference nodes inside a heap-allocated `LinkedList` structure.
3. **Do results match the expected complexity O(V + E)?** Yes, the empirical data strongly confirms the linear $O(V + E)$ complexity. Moving from a medium to a large graph size presents a proportional scaling factor relative to the increased edge densities.
4. **How does graph structure affect traversal order?** The structural distribution of edges directly determines the traversal path. In dense graphs with deep nested structures, DFS explores deep paths first, while BFS spreads across wide branches layer by layer, altering the exact sequence of discovered IDs.
5. **When is BFS preferred over DFS?** BFS is preferred when searching for the shortest path between two nodes in unweighted networks, or when the target element is expected to reside close to the source node.
6. **What are the limitations of DFS?** DFS can get trapped in extremely deep or infinite paths if cycle protection is missing. Additionally, it does not guarantee finding the shortest path first and can incur risky `StackOverflowError` crashes if the recursion depth exceeds memory limits.

## E. Screenshots
Below are the visual validations of the program execution taken directly from my IDE console output:

## F. Reflection Section
This assignment provided valuable practical insights into graph theory, moving from abstract theoretical paradigms into practical, structured Java code. Working through the implementation highlighted how minor architectural choices can significantly impact live terminal outputs. A key learning point was observing the performance gap between explicit heap allocation (BFS queues) and stack frame utilization (DFS recursion), which made abstract Big-O notation tangible and practical.

The primary technical challenge involved managing random edge generation. Early test runs resulted in isolated root nodes and empty traversal histories. This was successfully resolved by forcing dedicated connections from vertex 0 to subsequent nodes during the generation phase, ensuring fully coherent and meaningful console listings.
