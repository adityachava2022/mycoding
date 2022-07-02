package com.graphs.shortestpath;

import java.util.Map;
import com.graphs.dfs.Graph;
import com.graphs.dfs.GraphType;
import com.graphs.dfs.Vertex;

public class DijkstrasAlgorithm {

  public static void main(String[] args) {
    Graph graph1 = new Graph(GraphType.DIRECTED);
    
    graph1.addVertex('A'); // 0
    graph1.addVertex('B'); // 1
    graph1.addVertex('C'); // 2
    graph1.addVertex('D'); // 3
    graph1.addVertex('E'); // 4
    
    graph1.addWeightedEdge(0, 1, 4); // A -> B, 4
    graph1.addWeightedEdge(0, 2, 1); // A -> C, 1
    graph1.addWeightedEdge(1, 4, 4); // B -> E , 4
    graph1.addWeightedEdge(2, 1, 2); // C -> B, 2
    graph1.addWeightedEdge(2, 3, 4); // C -> D, 4
    graph1.addWeightedEdge(3, 4, 4); // D -> E, 4
    
    dijkstrasAlgorithm(graph1, graph1.getVertices()[0], graph1.getVertices()[4]);
  }

  private static void dijkstrasAlgorithm(Graph graph1, Vertex source, Vertex dest) {
    Map<Vertex, DistanceInfo> distanceTable = buildDistanceTable(graph1, source);
  }

  private static Map<Vertex, DistanceInfo> buildDistanceTable(Graph graph1, Vertex source) {
    // TODO Auto-generated method stub
    return null;
  }

}
