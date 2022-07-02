package com.graphs.shortestpath;

import com.graphs.dfs.Graph;
import com.graphs.dfs.GraphType;
import com.graphs.dfs.Vertex;

public class DijkstrasAlgorithm {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Graph graph1 = new Graph(GraphType.DIRECTED);
    
    
    graph1.addVertex('A'); // 0
    graph1.addVertex('B'); // 1
    graph1.addVertex('C'); // 2
    graph1.addVertex('D'); // 3
    graph1.addVertex('E'); // 4
    graph1.addVertex('F'); // 5
    graph1.addVertex('G'); // 6
    
    //
    graph1.addEdge(0, 1); // A -> B
    graph1.addEdge(0, 3); // A -> D
    graph1.addEdge(1, 3); // B -> D 
    graph1.addEdge(1, 4); // B -> E
    graph1.addEdge(2, 0); // C -> A
    graph1.addEdge(2, 5); // C -> F
    graph1.addEdge(3, 5); // D -> F
    graph1.addEdge(3, 6); // D -> G
    graph1.addEdge(4, 6); // E -> G
    graph1.addEdge(4, 6); // E -> G
    graph1.addEdge(6, 5); // G -> F

    dijkstrasAlgorithm(graph1, graph1.getVertices()[3], graph1.getVertices()[4]);
  }

  private static void dijkstrasAlgorithm(Graph graph1, Vertex source, Vertex dest) {
    Map<Vertex,>
  }

}
