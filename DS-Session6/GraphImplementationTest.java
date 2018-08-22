package graphImplementation;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

/**
 * @author Deekshika Sharma 
 * This method will have test cases for graph implementation
 */
public class GraphImplementationTest {

	// This test case will add edge and check for graph connectivity
	@Test
	public void graphConnectedTest() {

		GraphImplementation graph = new GraphImplementation(4);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);

		assertTrue(graph.isConnected()); // if graph is connected then return
											// true
	}

	@Test
	public void graphTest() {

		GraphImplementation graph = new GraphImplementation(6);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);
		graph.addEdge(4, 5, 4);

		assertFalse(graph.isConnected()); // if graph is disconnected return
											// false
	}

	// This test case will check for vertices reachable from specified node
	@Test
	public void graphReachableTest() {

		GraphImplementation graph = new GraphImplementation(6);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);
		graph.addEdge(4, 5, 4);

		List<Integer> reachable = graph.reachable(5);

		for (Integer i : reachable)
			System.out.println(i);
	}

	// This test case will check for shortest path
	@Test
	public void graphShortestTest() {

		GraphImplementation graph = new GraphImplementation(4);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);

		assertEquals(8, graph.shortestPath(0, 2));

	}

	// This test case will check for MST
	@Test
	public void graphMSTTest() {

		GraphImplementation graph = new GraphImplementation(4);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 6);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 0, 4);
		graph.addEdge(0, 2, 2);

		List<Edge> g = graph.minimumSpanningTree();
		for (Edge e : g)
			System.out.println(e.getSource() + " " + e.getDestination() + " "
					+ e.getWeight());
	}
}
