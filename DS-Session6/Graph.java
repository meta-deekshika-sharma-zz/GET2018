package graphImplementation;

import java.util.List;

/**
 * @author Deekshika Sharma
 * This interface have several methods which will implemented in concrete class
 */
public interface Graph {

	public boolean isConnected();
	
	public List<GraphNode> reachable(GraphNode graphNode);
	
	public List<Edge> minimumSpanningTree();
	
	public List<GraphNode> shortestPath(GraphNode source, GraphNode destination);
}
