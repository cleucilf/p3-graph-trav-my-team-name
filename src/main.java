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

        System.out.println();
        System.out.println("Number of vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of edges: " + graph.getNumberOfEdges());

        System.out.println();
        System.out.println("BFS starting at A:");
        System.out.println(graph.breadthFirstTraversal("A"));

        System.out.println();
        System.out.println("DFS starting at A:");
        System.out.println(graph.depthFirstTraversal("A"));
        System.out.println();
        System.out.println("BFS tree starting at A:");
        System.out.println(graph.breadthFirstTree("A"));

        System.out.println();
        System.out.println("DFS tree starting at A:");
        System.out.println(graph.depthFirstTree("A"));
    }
}