import java.util.*;

public class Graph {

    private List<Edge> edges;
    private Set<Vertex> vertices;
  
    public Graph() {
      edges = new ArrayList<>();
      vertices = new TreeSet<>();
    }
    public void addEdge(Edge edge){
      getEdges().add(edge);
      getVertices().add(edge.getFromVertex());
      getVertices().add(edge.getToVertex());
    }
    
    public void addVertice(Vertex v){
      getVertices().add(v);
    }
  
    public List<Edge> getEdges() {
      return edges;
    }
  
    public Set<Vertex> getVertices() {
      return vertices;
    }
    
    public static void printGraph(Graph g){
      System.out.println("Vertices...");
      for (Vertex v : g.getVertices()) {
        System.out.print(v.getLabel() + " ");
      }
      System.out.println("");
      System.out.println("Edges...");
      for (Edge e : g.getEdges()) {
        System.out.println(e);
      }
    }

    public void tsp() {
        List<Vertex> vertices = new ArrayList<Vertex>(this.getVertices());
        List<Edge> edges = this.getEdges();
        List<String> labels = new ArrayList<String>();

        for (Vertex v: vertices) {
            labels.add(v.getLabel());
        }
    
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
    
          int idxFrom = labels.indexOf(from.getLabel());
          int idxTo = labels.indexOf(to.getLabel());
    
          System.out.println(from.getLabel());
          System.out.println(to.getLabel());
          System.out.println(idxFrom);
          System.out.println(idxTo);
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
