import static java.lang.System.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");

		Graph g = new Graph();

		g.addEdge(new Edge(a, b, 10.0));
		g.addEdge(new Edge(a, c, 15.0));
		g.addEdge(new Edge(a, d, 20.0));
		g.addEdge(new Edge(b, c, 35.0));
		g.addEdge(new Edge(b, d, 25.0));
		g.addEdge(new Edge(c, d, 30.0));

		Graph.printGraph(g);

		List<Vertex> vertices = g.getVertices();
	    List<Edge> edges = g.getEdges();

	    double[][] distance = new double[vertices.size()][vertices.size()];

	    for (int i = 0; i < vertices.size(); i++) {
	      for (int j = 0; j < vertices.size(); j++) {
	        distance[i][j] = Double.POSITIVE_INFINITY;
	      }
	    }

	    for (Edge edge : edges) {
	      Vertex from = edge.getFromVertex();
	      Vertex to = edge.getToVertex();
	      Double weight = edge.getWeight();

	      int idxFrom = vertices.indexOf(from);
	      int idxTo = vertices.indexOf(to);

	      distance[idxFrom][idxTo] = weight;
	      distance[idxTo][idxFrom] = weight;
	    }

		TspSolver tspSolver = new TspSolver(distance);

		double minCost = tspSolver.getTourCost();
		List<Integer> minTour = tspSolver.getTour();

		System.out.println("Min tour");
		for (Integer idx : minTour) {
			System.out.println("- " + vertices.get(idx).getLabel());
		}

		System.out.println("TSP cost = " + tspSolver.getTourCost());
	}
}