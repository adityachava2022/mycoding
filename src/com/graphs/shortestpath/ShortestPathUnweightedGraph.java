package com.graphs.shortestpath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import com.graphs.Graph;
import com.graphs.GraphType;
import com.graphs.Vertex;

public class ShortestPathUnweightedGraph {

   /**
     a -------- > b -----> e
     |
     | - > b
     c ---------> d -> e
  
  */
  public static void main(String[] args) {
    Graph graph1 = new Graph(GraphType.DIRECTED);
    
    graph1.addVertex('A'); // 0
    graph1.addVertex('B'); // 1
    graph1.addVertex('C'); // 2
    graph1.addVertex('D'); // 3
    graph1.addVertex('E'); // 4
    
    //
    graph1.addEdge(0, 1); // A -> B
    graph1.addEdge(0, 2); // A -> C
    graph1.addEdge(1, 4); // B -> E
    graph1.addEdge(2, 1); // C -> B
    graph1.addEdge(2, 3); // C -> D
    graph1.addEdge(3, 4); // D -> E
    getShortestPath(graph1, graph1.getVertices()[0], graph1.getVertices()[4]);
  }

  /*
   * build a distance table
   */
  
  
  public static Map<Vertex, DistanceInfo> buildDistanceTable(Graph graph, Vertex src) {
    Map<Vertex, DistanceInfo> distanceTable = new HashMap<>();
    // initialize the distanceTable
    for(int i = 0; i < graph.vertexCount; i++) {
      distanceTable.put(graph.getVertices()[i], new DistanceInfo());
    }
    // set the src vertex in the distanceTable
    distanceTable.get(src).setDistanceFromSource(0);
    distanceTable.get(src).setLastVertex(src);
    // build the distance table
    Queue<Vertex> queue = new LinkedList<>();
    queue.offer(src);
    while (!queue.isEmpty()) {
      Vertex currentVertex = queue.poll();
      for (Vertex adjV : graph.getAdjacentVerticesArray(currentVertex)) {
        if (distanceTable.get(adjV).getDistanceFromSource() == -1 ) {
          int distance = 1 + distanceTable.get(currentVertex).getDistanceFromSource();
          distanceTable.get(adjV).setDistanceFromSource(distance);
          distanceTable.get(adjV).setLastVertex(currentVertex);
          queue.offer(adjV);
        }
      }
    }
    return distanceTable;
  }

  public static void getShortestPath(Graph graph, Vertex src, Vertex dest) 
  {
    Map<Vertex, DistanceInfo> distanceTable = buildDistanceTable(graph, src);
    System.out.println(" distance table ");
    System.out.println(" ==================================== ");
    for (Map.Entry<Vertex, DistanceInfo> v: distanceTable.entrySet())
    {
      System.out.print(v.getKey().getLabel() + "  " + v.getValue().getDistanceFromSource() + " " + v.getValue().getLastVertex().getLabel());
      System.out.println();
    }
    Stack<Vertex> stack = new Stack<>();
    stack.push(dest);
    Vertex lastV = dest;
    while (lastV != null && lastV != src) {
      stack.push(distanceTable.get(lastV).getLastVertex());
      lastV = distanceTable.get(lastV).getLastVertex();
    }
    if (lastV == null) {
      System.out.println("no path");
    } else {
      while (!stack.isEmpty()) {
        System.out.print(stack.pop().getLabel());
      }
    }
  }
}