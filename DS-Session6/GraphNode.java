package graphImplementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deekshika Sharma
 * This method will have a graph node with their connected node list
 */
public class GraphNode {

	private final String name;
	List<ConnectedNode> connectedNodeList = new ArrayList<>();
	
	public GraphNode(String name) {
		this.name = name;
	}

	public List<ConnectedNode> getConnectedNodeList() {
		return connectedNodeList;
	}

	public void setConnectedNodeList(List<ConnectedNode> connectedNodeList) {
		this.connectedNodeList = connectedNodeList;
	}

	public String getName() {
		return name;
	}
	
}
