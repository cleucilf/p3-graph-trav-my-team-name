import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph<T> implements BasicGraphInterface<T>
{
    private Map<T, List<T>> adjacencyList;
    private int edgeCount;

    public DirectedGraph()
    {
        adjacencyList = new HashMap<>();
        edgeCount = 0;
    }

    public boolean addVertex(T vertexLabel)
    {
        if (adjacencyList.containsKey(vertexLabel))
        {
            return false;
        }

        adjacencyList.put(vertexLabel, new ArrayList<>());
        return true;
    }

    public boolean addEdge(T begin, T end)
    {
        return addEdge(begin, end, 0);
    }

    public boolean addEdge(T begin, T end, double edgeWeight)
    {
        if (!adjacencyList.containsKey(begin))
        {
            addVertex(begin);
        }

        if (!adjacencyList.containsKey(end))
        {
            addVertex(end);
        }

        List<T> neighbors = adjacencyList.get(begin);

        if (neighbors.contains(end))
        {
            return false;
        }

        neighbors.add(end);
        edgeCount++;
        return true;
    }

    public boolean hasEdge(T begin, T end)
    {
        if (!adjacencyList.containsKey(begin))
        {
            return false;
        }

        return adjacencyList.get(begin).contains(end);
    }

    public boolean isEmpty()
    {
        return adjacencyList.isEmpty();
    }

    public int getNumberOfVertices()
    {
        return adjacencyList.size();
    }

    public int getNumberOfEdges()
    {
        return edgeCount;
    }

    public void clear()
    {
        adjacencyList.clear();
        edgeCount = 0;
    }

    public List<T> getNeighbors(T vertex)
    {
        return adjacencyList.get(vertex);
    }

    public void displayGraph()
    {
        for (T vertex : adjacencyList.keySet())
        {
            System.out.println(vertex + " -> " + adjacencyList.get(vertex));
        }
    }
}
