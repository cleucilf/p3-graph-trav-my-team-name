import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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
    public List<T> breadthFirstTraversal(T startVertex)
{
    List<T> traversalOrder = new ArrayList<>();
    Set<T> visited = new HashSet<>();
    Queue<T> queue = new LinkedList<>();

    if (!adjacencyList.containsKey(startVertex))
    {
        return traversalOrder;
    }

    visited.add(startVertex);
    queue.add(startVertex);

    while (!queue.isEmpty())
    {
        T currentVertex = queue.remove();
        traversalOrder.add(currentVertex);

        for (T neighbor : adjacencyList.get(currentVertex))
        {
            if (!visited.contains(neighbor))
            {
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
    }

    return traversalOrder;
}
public List<T> depthFirstTraversal(T startVertex)
{
    List<T> traversalOrder = new ArrayList<>();
    Set<T> visited = new HashSet<>();
    Stack<T> stack = new Stack<>();

    if (!adjacencyList.containsKey(startVertex))
    {
        return traversalOrder;
    }

    stack.push(startVertex);

    while (!stack.isEmpty())
    {
        T currentVertex = stack.pop();

        if (!visited.contains(currentVertex))
        {
            visited.add(currentVertex);
            traversalOrder.add(currentVertex);

            List<T> neighbors = adjacencyList.get(currentVertex);

            for (int index = neighbors.size() - 1; index >= 0; index--)
            {
                T neighbor = neighbors.get(index);

                if (!visited.contains(neighbor))
                {
                    stack.push(neighbor);
                }
            }
        }
    }

        return traversalOrder;
    }
    public List<String> breadthFirstTree(T startVertex)
{
    List<String> treeEdges = new ArrayList<>();
    Set<T> visited = new HashSet<>();
    Queue<T> queue = new LinkedList<>();

    if (!adjacencyList.containsKey(startVertex))
    {
        return treeEdges;
    }

    visited.add(startVertex);
    queue.add(startVertex);

    while (!queue.isEmpty())
    {
        T currentVertex = queue.remove();

        for (T neighbor : adjacencyList.get(currentVertex))
        {
            if (!visited.contains(neighbor))
            {
                visited.add(neighbor);
                queue.add(neighbor);
                treeEdges.add(currentVertex + " -> " + neighbor);
            }
        }
    }

    return treeEdges;
    }
    public List<String> depthFirstTree(T startVertex)
{
    List<String> treeEdges = new ArrayList<>();
    Set<T> visited = new HashSet<>();
    Stack<T> vertexStack = new Stack<>();
    Stack<T> parentStack = new Stack<>();

    if (!adjacencyList.containsKey(startVertex))
    {
        return treeEdges;
    }

    vertexStack.push(startVertex);
    parentStack.push(null);

    while (!vertexStack.isEmpty())
    {
        T currentVertex = vertexStack.pop();
        T parentVertex = parentStack.pop();

        if (!visited.contains(currentVertex))
        {
            visited.add(currentVertex);

            if (parentVertex != null)
            {
                treeEdges.add(parentVertex + " -> " + currentVertex);
            }

            List<T> neighbors = adjacencyList.get(currentVertex);

            for (int index = neighbors.size() - 1; index >= 0; index--)
            {
                T neighbor = neighbors.get(index);

                if (!visited.contains(neighbor))
                {
                    vertexStack.push(neighbor);
                    parentStack.push(currentVertex);
                }
            }
        }
    }

    return treeEdges;
    }
}
