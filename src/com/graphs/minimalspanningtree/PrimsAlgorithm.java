package com.graphs.minimalspanningtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import com.graphs.Graph;
import com.graphs.GraphType;
import com.graphs.Vertex;
import com.graphs.shortestpath.DistanceInfo;

public class PrimsAlgorithm {

  public static void main(String[] args) {

    Graph graph1 = new Graph(GraphType.UNDIRECTED);

    graph1.addVertex('A'); // 0
    graph1.addVertex('B'); // 1
    graph1.addVertex('C'); // 2
    graph1.addVertex('D'); // 3
    graph1.addVertex('E'); // 4
    graph1.addVertex('F'); // 5
    graph1.addVertex('G'); // 6
    graph1.addVertex('H'); // 7

    graph1.addWeightedEdge(0, 1, 2);
    graph1.addWeightedEdge(0, 3, 4);
    graph1.addWeightedEdge(0, 5, 5);
    graph1.addWeightedEdge(1, 2, 7);
    graph1.addWeightedEdge(1, 3, 1);
    graph1.addWeightedEdge(1, 4, 3);
    graph1.addWeightedEdge(1, 5, 8);
    graph1.addWeightedEdge(1, 6, 4);
    graph1.addWeightedEdge(2, 4, 10);
    graph1.addWeightedEdge(2, 6, 6);
    graph1.addWeightedEdge(3, 4, 2);
    graph1.addWeightedEdge(5, 6, 1);

    spanningTree(graph1, graph1.getVertexAtIndex(0));
  }

  @SuppressWarnings("unlikely-arg-type")
  private static void spanningTree(Graph graph1, Vertex source) {
    Map<Vertex, DistanceInfo> distanceTable = new HashMap<>();
    Queue<Vertex> queue = new PriorityQueue<>((o1, o2) -> o1.getWeight() - o2.getWeight());

    for (int j = 0; j < graph1.vertexCount - 1; j++) {
      distanceTable.put(graph1.getVertexAtIndex(j), new DistanceInfo(true));
    }

    source.setWeight(0);
    distanceTable.get(source).setDistanceFromSource(0);
    distanceTable.get(source).setLastVertex(source);
    
    queue.offer(source);

    Set<String> spanningTree = new HashSet<>();
    Set<Vertex> visitedVertices = new HashSet<>();
    
    spanningTree.retainAll(visitedVertices);

    while (!queue.isEmpty()) {
      Vertex currentVertex = queue.poll();

      // do not re-visit vertices which are already part of the tree
      if (visitedVertices.contains(currentVertex)) {
        continue;
      }
      visitedVertices.add(currentVertex);

      // If the current vertex is a source we do not have an edge yet
      if (!currentVertex.equals(source)) {
        String edge = currentVertex.getLabel() + "-"
            + distanceTable.get(currentVertex).getLastVertex().getLabel();
        if (!spanningTree.contains(edge)) {
          spanningTree.add(edge);
        }
      }

      for (Vertex adjacentVertex : graph1.getAdjacentVerticesArrayForWeighted(currentVertex)) {
        int distance = graph1.getWeightedEdge(currentVertex.getIndex(), adjacentVertex.getIndex());
        
        if (distance < distanceTable.get(adjacentVertex).getDistanceFromSource()) {
          distanceTable.get(adjacentVertex).setDistanceFromSource(distance);
          distanceTable.get(adjacentVertex).setLastVertex(currentVertex);
          
          adjacentVertex.setWeight(distance);
          queue.add(adjacentVertex);
          
        }
      }
    }
    
    for (String edge : spanningTree) {
      System.out.println(edge);
    }
    
  }
}
