package com.graphs.shortestpath;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import com.graphs.Graph;
import com.graphs.GraphType;
import com.graphs.Vertex;

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
    while (lastV != null && lastV != source) {
      stack.push(distanceTable.get(lastV).getLastVertex());
      lastV = distanceTable.get(lastV).getLastVertex();
    }
    if (lastV == null) {
      System.out.println("no path");
    } else {
      System.out.println(" shortest distance is  " + distanceTable.get(dest).getDistanceFromSource());
      while (!stack.isEmpty()) {
        System.out.print(stack.pop().getLabel());
      }
    }
  }

  private static Map<Vertex, DistanceInfo> buildDistanceTable(Graph graph, Vertex source) {
    Map<Vertex, DistanceInfo> distanceTable = new HashMap<>();
    for(int i = 0; i < graph.vertexCount; i++) {
      distanceTable.put(graph.getVertices()[i], new DistanceInfo(true));
    }
    distanceTable.get(source).setDistanceFromSource(0);
    distanceTable.get(source).setLastVertex(source);
    Queue<Vertex> priorityQueue = new PriorityQueue<>((v1, v2) -> (v1.getWeight() - v2.getWeight()));
    priorityQueue.offer(source);
    while(!priorityQueue.isEmpty()) {
      Vertex currentVertex = priorityQueue.poll();
      for (Vertex adjVertex : graph.getAdjacentVerticesArrayForWeighted(currentVertex))
      {
        int newDistance = distanceTable.get(currentVertex).getDistanceFromSource() + graph.getWeightedEdge(currentVertex.getIndex(), adjVertex.getIndex());
        if (newDistance < distanceTable.get(adjVertex).getDistanceFromSource()) {
          distanceTable.get(adjVertex).setDistanceFromSource(newDistance);
          distanceTable.get(adjVertex).setLastVertex(currentVertex);
          adjVertex.setWeight(newDistance);
          priorityQueue.offer(adjVertex);
        }
    }

  }
  return distanceTable ;
  }
}
