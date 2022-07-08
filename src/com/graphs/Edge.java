package com.graphs;

public class Edge {
  
  private Vertex vertex1;
  private Vertex vertex2;
  private Integer weight;
  
  public Edge(Vertex vertex1, Vertex vertex2, int weight) {
    this.vertex1 = vertex1;
    this.vertex2 = vertex2;
    this.weight = weight;
  }

  public Vertex getVertex1() {
    return vertex1;
  }
  public void setVertex1(Vertex vertex1) {
    this.vertex1 = vertex1;
  }
  public Vertex getVertex2() {
    return vertex2;
  }
  public void setVertex2(Vertex vertex2) {
    this.vertex2 = vertex2;
  }
  public Integer getWeight() {
    return weight;
  }
  public void setWeight(Integer weight) {
    this.weight = weight;
  }
  
  @Override
  public String toString() {
    return "Edge [vertex1=" + vertex1.getLabel() + ", vertex2=" + vertex2.getLabel() + ", weight=" + weight + "]";
  }
}
