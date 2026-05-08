# Project 3: Graph Traversal

## Team Members
- Cleucil Francisco — Role A: Graph structure, vertices, edges, adjacency list
- Alex Raygoza — Role B/C: BFS traversal, BFS tree, DFS traversal, DFS tree, integration/README

## Individual Contributions

### Role A
Created repo, project foundation, and implemented graph structure including vertices, edges, and adjacency list.

### Role B/C
Implemented BFS traversal using a queue and BFS tree discovery edges.  
Implemented DFS traversal using a stack and DFS tree discovery edges.  
Handled integration, added adjacency matrix, created unit tests, and updated README.

## Project Description
This program builds a directed graph with vertices A through I and performs iterative Breadth-First Search and Depth-First Search starting at vertex A.

## Features Implemented
- Directed graph using adjacency list
- Alphabetical neighbor processing
- Iterative BFS using a queue
- BFS visit order output
- BFS tree discovery edges
- Iterative DFS using a stack
- DFS visit order output
- DFS tree discovery edges
- Vertex and edge count output

## Extra Credit Features

### Adjacency Matrix
Implemented a second graph representation using an adjacency matrix in `AdjacencyMatrixGraph.java`. The matrix displays all vertices and directed edges.

### Unit Testing
Created `GraphTests.java` to test:
- Vertex count
- Edge count
- Edge existence
- Invalid edge detection

All tests pass successfully.

## Expected Output

### BFS Visit Order
```
A B D E G F H C I
```

### DFS Visit Order
```
A B E F C H I D G
```

## How to Run

Compile:
```
javac src/*.java
```

Run main program:
```
java -cp src main
```

Run tests:
```
java -cp src GraphTests
```
