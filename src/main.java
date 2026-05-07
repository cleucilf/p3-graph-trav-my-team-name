import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class main
{
    public static void main(String[] args)
    {
        DirectedGraph<String> graph = new DirectedGraph<>();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");

        // Add directed edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("A", "E");
        graph.addEdge("B", "E");
        graph.addEdge("D", "G");
        graph.addEdge("E", "F");
        graph.addEdge("E", "H");
        graph.addEdge("G", "H");
        graph.addEdge("F", "C");
        graph.addEdge("F", "H");
        graph.addEdge("H", "I");
        graph.addEdge("C", "B");
        graph.addEdge("I", "F");

        System.out.println("Directed Graph:");
        graph.displayGraph();

        bfs(graph, "A");
        bfsTree(graph, "A");

        System.out.println();
        System.out.println("Number of vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of edges: " + graph.getNumberOfEdges());
    }
// Role B: BFS traversal using queue
    public static void bfs(DirectedGraph<String> graph, String start) {
    Set<String> visited = new LinkedHashSet<>();
    Queue<String> queue = new LinkedList<>();

    visited.add(start);
    queue.add(start);

    System.out.println("BFS Visit Order:");

    while (!queue.isEmpty()) {
        String current = queue.remove();
        System.out.print(current + " ");

        List<String> neighbors = graph.getNeighbors(current);
        Collections.sort(neighbors);

        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
    }

    System.out.println();
}

public static void bfsTree(DirectedGraph<String> graph, String start) {
    Set<String> visited = new LinkedHashSet<>();
    Queue<String> queue = new LinkedList<>();

    visited.add(start);
    queue.add(start);

    System.out.println("BFS Tree Edges:");

    while (!queue.isEmpty()) {
        String current = queue.remove();

        List<String> neighbors = graph.getNeighbors(current);
        Collections.sort(neighbors);

        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.add(neighbor);

                System.out.println("(" + current + ", " + neighbor + ")");
            }
        }
    }
}
}