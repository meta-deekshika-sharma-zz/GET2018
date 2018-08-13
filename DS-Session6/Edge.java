package graphImplementation;

/**
 * @author Deekshika Sharma
 * This class will have a edge information with their source node, destination node and weight
 */
public class Edge implements Comparable<Edge>{

	private final GraphNode source;
	private final GraphNode destination;
	private int weight;
	
	public Edge(GraphNode source, GraphNode destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public GraphNode getSource() {
		return source;
	}

	public GraphNode getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge edge) {
		
		return (this.weight - edge.weight);
	}
	
}
