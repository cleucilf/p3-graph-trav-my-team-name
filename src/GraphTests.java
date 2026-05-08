public class GraphTests {
    public static void main(String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");

        boolean passed = true;

        if (graph.getNumberOfVertices() != 3) {
            passed = false;
            System.out.println("FAILED: vertex count test");
        }

        if (graph.getNumberOfEdges() != 2) {
            passed = false;
            System.out.println("FAILED: edge count test");
        }

        if (!graph.hasEdge("A", "B")) {
            passed = false;
            System.out.println("FAILED: edge A -> B test");
        }

        if (!graph.hasEdge("B", "C")) {
            passed = false;
            System.out.println("FAILED: edge B -> C test");
        }

        if (graph.hasEdge("C", "A")) {
            passed = false;
            System.out.println("FAILED: false edge C -> A test");
        }

        if (passed) {
            System.out.println("All graph tests passed.");
        }
    }
}