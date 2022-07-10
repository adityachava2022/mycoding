package com.datastructures.graphs.minimalspanningtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import com.datastructures.graphs.Edge;
import com.datastructures.graphs.Graph;
import com.datastructures.graphs.GraphType;
import com.datastructures.graphs.Vertex;

public class KruskalAlgorithmPriorityQueue {

  public static void main(String[] args) {
    Graph graph1 = new Graph(GraphType.UNDIRECTED);
    
    graph1.addVertex('A'); // 0
    graph1.addVertex('B'); // 1
    graph1.addVertex('C'); // 2
    graph1.addVertex('D'); // 3
    graph1.addVertex('E'); // 4
    graph1.addVertex('F'); // 5
    
    graph1.addWeightedEdge(0, 1, 3);
    graph1.addWeightedEdge(0, 2, 15);
    graph1.addWeightedEdge(0, 4, 5);
    graph1.addWeightedEdge(1, 2, 2);
    graph1.addWeightedEdge(1, 4, 5);
    graph1.addWeightedEdge(1, 5, 8);
    graph1.addWeightedEdge(2, 5, 9);
    graph1.addWeightedEdge(3, 4, 11);
    graph1.addWeightedEdge(3, 5, 4);
    graph1.addWeightedEdge(4, 5, 4);
    
    Set<Edge> result = spanningTreeByKruskalAlgo(graph1);
    for(Edge edgeInfo : result ) {
      System.out.println(edgeInfo);
  }

  }

  public static Set<Edge> spanningTreeByKruskalAlgo(Graph graph) {
    Set<Edge> spanningTree = new HashSet<>();
    Queue<Edge> priorityQueue = new PriorityQueue<>((e1, e2) -> (e1.getWeight() - e2.getWeight()));
    for (Edge edge : graph.getWeightedEdges()) {
      priorityQueue.offer(edge);
    }
    Map<Vertex, Set<Vertex>> edgeMap = new HashMap<>();
    for (int i = 0 ; i < graph.vertexCount ; i++) {
      edgeMap.put(graph.getVertexAtIndex(i), new HashSet<>());
    }
    Set<Vertex> visitedVertices = new HashSet<>();
    while (!priorityQueue.isEmpty() && spanningTree.size() < graph.vertexCount - 1) {
      Edge currentEdge = priorityQueue.poll();
      edgeMap.get(currentEdge.getVertex1()).add(currentEdge.getVertex2());
      if (hasCycle(edgeMap)) {
        edgeMap.get(currentEdge.getVertex1()).remove(currentEdge.getVertex2());
        continue;
      }
      spanningTree.add(currentEdge);
      visitedVertices.add(currentEdge.getVertex1());
      visitedVertices.add(currentEdge.getVertex2());
    }
    return spanningTree;
  }

  private static boolean hasCycle(Map<Vertex, Set<Vertex>> edgeMap) {
    for (Vertex vertex : edgeMap.keySet()) {
      Queue<Vertex> queue = new LinkedList<>();
      queue.offer(vertex);
      Set<Vertex> visitedVertices = new HashSet<>();
      while (!queue.isEmpty()) {
        Vertex currentVertex = queue.poll();
        if (visitedVertices.contains(currentVertex)) {
          return true;
        }
        visitedVertices.add(currentVertex);
        queue.addAll(edgeMap.get(currentVertex));
      }
    }
    return false;
  }

}
