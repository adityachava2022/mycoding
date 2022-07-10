package com.datastructures.graphs.shortestpath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import com.datastructures.graphs.Graph;
import com.datastructures.graphs.GraphType;
import com.datastructures.graphs.Vertex;

public class BellmanFordAlgorithm {
  public static void main(String[] args) {
   
    Graph graph1 = new Graph(GraphType.DIRECTED);
    
    graph1.addVertex('A'); // 0
    graph1.addVertex('B'); // 1
    graph1.addVertex('C'); // 2
    graph1.addVertex('D'); // 3
    graph1.addVertex('E'); // 4
    
    
    graph1.addWeightedEdge(0, 1, 2);
    graph1.addWeightedEdge(0, 2, 1);
    graph1.addWeightedEdge(1, 3, 3);
    graph1.addWeightedEdge(1, 4, -2);
    graph1.addWeightedEdge(2, 4, 2);
    graph1.addWeightedEdge(4, 3, 1);
    graph1.addWeightedEdge(2, 1, -5);
    
  bellmanFordAlgorithm(graph1, graph1.getVertexAtIndex(0), graph1.getVertexAtIndex(3));
    
    // graph with - ve cycle in it
    Graph graph2 = new Graph(GraphType.DIRECTED);

    graph2.addVertex('A'); // 0
    graph2.addVertex('B'); // 1
    graph2.addVertex('C'); // 2
    graph2.addVertex('D'); // 3
    graph2.addVertex('E'); // 4
    graph2.addVertex('F'); // 5


    graph2.addWeightedEdge(0, 1, 2);
    graph2.addWeightedEdge(1, 2, 3);
    graph2.addWeightedEdge(2, 3, 2);
    graph2.addWeightedEdge(3, 4, -5);
    graph2.addWeightedEdge(3, 5, 1);
    graph2.addWeightedEdge(4, 5, -3);
    graph2.addWeightedEdge(5, 4, -3);

//    bellmanFordAlgorithm(graph2, graph2.getVertexAtIndex(0), graph2.getVertexAtIndex(5));
  }

  private static void bellmanFordAlgorithm(Graph graph, Vertex source, Vertex dest) {
    Map<Vertex, DistanceInfo> distanceTable = buildDistanceTable(graph, source);
    System.out.println(" distance table ");
    System.out.println(" ==================================== ");
    for (Map.Entry<Vertex, DistanceInfo> v : distanceTable.entrySet()) {
      System.out.print(v.getKey().getLabel() + "  " + v.getValue().getDistanceFromSource() + " "
          + v.getValue().getLastVertex().getLabel());
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
      System.out
          .println(" shortest distance is  " + distanceTable.get(dest).getDistanceFromSource());
      while (!stack.isEmpty()) {
        System.out.print(stack.pop().getLabel());
      }
    }
  }

  private static Map<Vertex, DistanceInfo> buildDistanceTable(Graph graph, Vertex source) {
    Map<Vertex, DistanceInfo> distanceTable = new HashMap<>();
    for (int j = 0; j < graph.vertexCount; j++) {
        distanceTable.put(graph.getVertexAtIndex(j), new DistanceInfo(100000));
    }

    // Set up the distance of the specified source.
    distanceTable.get(source).setDistanceFromSource(0);
    distanceTable.get(source).setLastVertex(source);

    LinkedList<Vertex> queue = new LinkedList<>();

    // Relaxing (processing) all the edges numVertices - 1 times
    for (int numIterations = 0; numIterations < graph.vertexCount - 1; numIterations++) {
        // Add every vertex to the queue so we're sure to access all the edges
        // in the graph.
        for (int v = 0; v < graph.vertexCount; v++) {
            queue.add(graph.getVertexAtIndex(v));
        }

        // Keep track of the edges visited so we visit each edge just once
        // in every iteration.
        Set<String> visitedEdges = new HashSet<>();
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.pollFirst();

            for (Vertex neighbor : graph.getAdjacentVerticesArrayForWeighted(currentVertex)) {
                String edge = String.valueOf(currentVertex) + String.valueOf(neighbor);

                // Do not visit edges more than once in each iteration.
                if (visitedEdges.contains(edge)) {
                    continue;
                }
                visitedEdges.add(edge);

                int distance = distanceTable.get(currentVertex).getDistanceFromSource()
                        + graph.getWeightedEdge(currentVertex.getIndex(), neighbor.getIndex());
                // If we find a new shortest path to the neighbour update
                // the distance and the last vertex.
                if (distanceTable.get(neighbor).getDistanceFromSource() > distance) {
                    distanceTable.get(neighbor).setDistanceFromSource(distance);
                    distanceTable.get(neighbor).setLastVertex(currentVertex);
                }
            }
        }
    }

    // Add all the vertices to the queue one last time to check for
    // a negative cycle.
    for (int v = 0; v < graph.vertexCount; v++) {
        queue.add(graph.getVertexAtIndex(v));
    }

    // Relaxing (processing) all the edges one last time to check if
    // there exists a negative cycle
    while (!queue.isEmpty()) {
        Vertex currentVertex = queue.pollFirst();
        for (Vertex neighbor : graph.getAdjacentVerticesArrayForWeighted(currentVertex)) {
            int distance = distanceTable.get(currentVertex).getDistanceFromSource()
                    + graph.getWeightedEdge(currentVertex.getIndex(), neighbor.getIndex());
            if (distanceTable.get(neighbor).getDistanceFromSource() > distance) {
                throw new IllegalArgumentException("The Graph has a -ve cycle");
            }
        }
    }

    return distanceTable;
  }
}
