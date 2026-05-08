import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph {
    private List<String> vertices;
    private int[][] matrix;

    public AdjacencyMatrixGraph() {
        vertices = new ArrayList<>();
        matrix = new int[20][20];
    }

    public void addVertex(String vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
        }
    }

    public void addEdge(String from, String to) {
        int fromIndex = vertices.indexOf(from);
        int toIndex = vertices.indexOf(to);

        if (fromIndex != -1 && toIndex != -1) {
            matrix[fromIndex][toIndex] = 1;
        }
    }

    public void displayMatrix() {
        System.out.print("  ");

        for (String vertex : vertices) {
            System.out.print(vertex + " ");
        }

        System.out.println();

        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " ");

            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}