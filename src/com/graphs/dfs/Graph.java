package com.graphs.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {
  Vertex[] vertices;
  int[][] adjMatrix;
  int vertexCount;
  GraphType type;

  public Graph(GraphType type) {
    this.vertices = new Vertex[20];
    this.adjMatrix = new int[20][20];
    this.vertexCount = 0;
    this.type = type;
  }

  public void addVertex(char vertexLabel) {
    this.vertices[this.vertexCount] = new Vertex(vertexLabel, this.vertexCount);
    this.vertexCount++;
  }

  public void addEdge(int start, int end) {
    this.adjMatrix[start][end] = 1;
    if (this.type == GraphType.UNDIRECTED)
      this.adjMatrix[end][start] = 1;
  }

  public void addWeightedEdge(int start, int end, int weight) {
    this.adjMatrix[start][end] = weight;
    if (this.type == GraphType.UNDIRECTED)
      this.adjMatrix[end][start] = weight;
  }
  
  public int getWeightedEdge(int start, int end) {
    return this.adjMatrix[start][end];
  }
  
  public void displayVertex(int v) {
    System.out.println(
        "label : " + this.vertices[v].getLabel() + " , index is " + this.vertices[v].getIndex());
  }

  public void resetGraph() {
    for (int i = 0; i < this.vertexCount; i++)
      this.vertices[i].setVisited(false);
  }

  // time complexity - O(V2) in adjacencyMatrix
  public void recursiveDFS(int index) {
    displayVertex(index); // instead of displaying, we can do any other operation
    vertices[index].setVisited(true); // mark it visited

    // for each of its adjacent vertex ( i.e there should be an edge) and
    // it should be unvisited run dfs
    for (int i = 0; i < adjMatrix[index].length; i++) {
      if ((adjMatrix[index][i] == 1) && (!vertices[i].isVisited())) {
        recursiveDFS(i);
      }
    }
  }

  public void iterativeDFS() {
    Stack<Integer> stack = new Stack<>();
    displayVertex(0);
    this.vertices[0].setVisited(true);
    stack.push(0);
    while (!stack.isEmpty()) {
      Integer top = stack.peek();
      int v = getAdjUnvisitedVertex(top);
      if (v == -1) {
        stack.pop();
      } else {
        displayVertex(v);
        this.vertices[v].setVisited(true);
        stack.push(v);
      }
    }
  }

  private int getAdjUnvisitedVertex(Integer top) {
    for (int column = 0; column < this.vertexCount; column++) {
      if ((adjMatrix[top][column] == 1) && (!vertices[column].isVisited())) {
        return column;
      }
    }
    return -1;
  }

  public Vertex[] getVertices() {
    return vertices;
  }

  public List<Vertex> getAdjacentVerticesArray(Vertex currentVertex) {
    List<Vertex> adjVertexArray = new ArrayList<>();
    for (int column = 0; column < this.vertexCount; column++) {
      if ((adjMatrix[currentVertex.getIndex()][column] == 1) && (!vertices[column].isVisited())) {
        adjVertexArray.add(vertices[column]);
      }
    }
    return adjVertexArray;
  }

}
