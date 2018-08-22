package graphImplementation;

import java.util.List;

/**
 * @author Deekshika Sharma
 * This interface have methods for graph implementation and implements in concrete class
 */
public interface Graph {

    public boolean isConnected();
    
    public List<Integer> reachable(int source);
    
    public List<Edge> minimumSpanningTree();
    
    public int shortestPath(int source, int destination);
}
