package graphImplementation;

import java.util.ArrayList;
import java.util.List;

public class GrpahMain {

	public static void main(String[] args) {
		
		List<GraphNode> listOfNode = new ArrayList<>();
		GraphNode node1 = new GraphNode("a");
		GraphNode node2 = new GraphNode("b");
		GraphNode node3 = new GraphNode("c");
		GraphNode node4 = new GraphNode("d");
		
		
		listOfNode.add(node1);
		listOfNode.add(node2);
		listOfNode.add(node3);
		listOfNode.add(node4);
		GraphImplementation graph = new GraphImplementation(4, listOfNode);
		
	
		graph.addedge(node1, node2, 2);
		graph.addedge(node1, node4, 4);
		graph.addedge(node2, node3, 6);
		graph.addedge(node3, node4, 5);
		
		if(graph.isConnected())
			System.out.println("is connected");
		else
			System.out.println("not connected");

		List<GraphNode> g = graph.reachable(node3);
		if(g.size() > 0)
			System.out.println(g.size() + "reachable");
		else
			System.out.println(g.size() + "not connected");
		
//		List<Edge> e = graph.minimumSpanningTree();
//		if(e.size() > 0)
//			System.out.println(e.size() + "edges");
		
		graph.shortestPath(node1, node3);
		
	}
}
