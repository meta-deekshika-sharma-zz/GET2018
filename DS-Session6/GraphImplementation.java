package graphImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author Deekshika Sharma
 * This class implements the Graph interface and override its methods
 */
public class GraphImplementation implements Graph{

	int noOfVertices;
	List<GraphNode> listOfNode;
	List<Edge> listOfEdge = new ArrayList<>();
	
	// constructor will initializes the no. of vertices and list of nodes in graph
	public GraphImplementation(int noOfVertices, List<GraphNode> listOfNode) {
		this.noOfVertices = noOfVertices;
		this.listOfNode = listOfNode;
	}
	
	// This method will add the edge in the graph for both node source and destination
	public void addedge(GraphNode node1, GraphNode node2, int weight)
	{
		node1.getConnectedNodeList().add(new ConnectedNode(node2, weight));
		node2.getConnectedNodeList().add(new ConnectedNode(node1, weight));
		
		listOfEdge.add(new Edge(node1, node2, weight));
	}
	
	// This method will return is their is path available for each pair of nodes
	@Override
	public boolean isConnected() {
		Map<GraphNode, Boolean> nodeTraversed = new HashMap<GraphNode, Boolean>();
		boolean isConnected = true;
		
		for(int i = 0; i < noOfVertices; i++)
			nodeTraversed.put(listOfNode.get(i), false);
		DFSTraversal(listOfNode.get(0), nodeTraversed);
		
		for(Boolean traversed: nodeTraversed.values())
		{
			if(traversed == false)
			{
				isConnected = false;
				break;
			}
				
		}
		return isConnected;
	}

	// This method will traversed the graph using DFS Traversal
	private void DFSTraversal(GraphNode graphNode, Map<GraphNode, Boolean> nodeTraversed) {
		
		nodeTraversed.put(graphNode, true);
		Iterator<ConnectedNode> iterator = graphNode.getConnectedNodeList().iterator();
		
		while(iterator.hasNext())
		{	
			ConnectedNode node = iterator.next();
			
			if(!nodeTraversed.get(node.getConnectedNode())){	
			//	System.out.println(node.getConnectedNode().getName());
				DFSTraversal(node.getConnectedNode(), nodeTraversed);
			}
		}		
	}
	
    // This method will return the no. of reachable nodes from a source node
	@Override
	public List<GraphNode> reachable(GraphNode graphNode) {

        List<GraphNode> reachableNodes = new ArrayList<>();
        Map<GraphNode, Boolean> nodeTraversed = new HashMap<GraphNode, Boolean>();
        
        for(int i = 0; i < noOfVertices; i++)
			nodeTraversed.put(listOfNode.get(i), false);
		
        DFSTraversal(graphNode, nodeTraversed);
		
		for(GraphNode node: nodeTraversed.keySet())
		{
			if(nodeTraversed.get(node) == true)
			{
				reachableNodes.add(node);
			}
		}
		reachableNodes.remove(graphNode);
		
		return reachableNodes;
	}

	
	@Override
	public List<Edge> minimumSpanningTree() {
		List<Edge> mst = new ArrayList<>();
		List<GraphNode> emptyGraph = new ArrayList<>();
		for(int i = 0; i < noOfVertices; i++)
		{
			GraphNode node = new GraphNode(listOfNode.get(i).getName());
			emptyGraph.add(node);
		}
		Map<GraphNode, Boolean> nodeTraversed = new HashMap<GraphNode, Boolean>();
		
		for(int i = 0; i < noOfVertices; i++)
			nodeTraversed.put(emptyGraph.get(i), false);
			
		Collections.sort(listOfEdge);
//		for(Edge edge: listOfEdge)
//			System.out.println(edge.getSource().getName() + " " + edge.getDestination().getName() + " " + edge.getWeight());
//		
		for(Edge edge: listOfEdge)
		{
			boolean isConnected = true;
			mst.add(edge);
			ConnectedNode connect = null;
			//System.out.println(edge.getSource().getName());
			for(GraphNode node: emptyGraph)
			{
				//System.out.println(node.getName());
				if(node.getName().equals(edge.getSource().getName()))
				{
					System.out.println("in if" + edge.getSource().getName() + edge.getDestination().getName());
					connect = new ConnectedNode(edge.getDestination(), edge.getWeight());
					edge.getSource().getConnectedNodeList().add(connect);
					break;
				}
			}
			
			DFSTraversal(emptyGraph.get(0), nodeTraversed);
			for(Boolean traversed: nodeTraversed.values())
			{
				if(traversed == false)
				{
					isConnected = false;
					break;
				}
			}
			
			if(isConnected)
			{
				System.out.println(edge.getWeight());
				mst.remove(edge);	
			}
		}
	
		//System.out.println(mst.size());
		return mst;
	}

	@Override
	public List<GraphNode> shortestPath(GraphNode source, GraphNode destination) {
		
		List<Edge> shortestDistance = new ArrayList<Edge>();
		
        Map<GraphNode, Boolean> nodeTraversed = new HashMap<GraphNode, Boolean>();
		
		for(int i = 0; i < noOfVertices; i++)
			nodeTraversed.put(listOfNode.get(i), false);
		
		
		for(GraphNode graphNode: listOfNode)
		{
			if(graphNode == source)
				shortestDistance.add(new Edge(source, graphNode, 0));
			else
			    shortestDistance.add(new Edge(source, graphNode, Integer.MAX_VALUE));
		}
		
		return null;
	}

}
