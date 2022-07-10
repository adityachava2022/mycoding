package com.datastructures.graphs;

import java.util.Objects;

public class Vertex {
  private char label;
  private boolean isVisited;
  private int index;
  private int weight;

  public Vertex(char label, int index) {
    this.setLabel(label);
    this.setVisited(false);
    this.setIndex(index);
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean isVisited) {
    this.isVisited = isVisited;
  }

  public char getLabel() {
    return label;
  }

  public void setLabel(char label) {
    this.label = label;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(index);
  }

  @Override
  public boolean equals(Object obj) {
    Vertex other = (Vertex) obj;
    return index == other.index;
  }
  

}
