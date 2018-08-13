package graphImplementation;


/**
 * @author Deekshika Sharma
 * This method will have connected node with a specified graph node
 */
public class ConnectedNode {

	private final GraphNode connectedNode;
	private final int weight;
	
	public ConnectedNode(GraphNode connectedNode, int weight) {
		this.connectedNode = connectedNode;
		this.weight = weight;
	}

	public GraphNode getConnectedNode() {
		return connectedNode;
	}

	public int getWeight() {
		return weight;
	}
	
	
}
