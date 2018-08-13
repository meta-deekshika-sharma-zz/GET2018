package graphImplementation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Deekshika Sharma 
 * This class will have test cases related to graph implementation
 */
public class GraphImplementationTest {

	private List<GraphNode> listOfNode = new ArrayList<GraphNode>();
	GraphNode node1, node2, node3, node4;

	@Before
	public void graphVerticesTest() {
		node1 = new GraphNode("a");
		node2 = new GraphNode("b");
		node3 = new GraphNode("c");
		node4 = new GraphNode("d");

		listOfNode.add(node1);
		listOfNode.add(node2);
		listOfNode.add(node3);
		listOfNode.add(node4);
	}

	GraphImplementation graph = new GraphImplementation(4, listOfNode);

	@Test
	public void graphTest() {

		graph.addedge(node1, node2, 2);
		graph.addedge(node1, node4, 4);
		graph.addedge(node2, node3, 6);
		graph.addedge(node3, node4, 5);
		assertTrue(graph.isConnected());
	}

}
