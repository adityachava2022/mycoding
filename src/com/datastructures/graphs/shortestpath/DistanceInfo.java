package com.datastructures.graphs.shortestpath;

import com.datastructures.graphs.Vertex;

public class DistanceInfo {
  private int distanceFromSource;
  private Vertex lastVertex;

  public DistanceInfo() {
    distanceFromSource = -1;
    lastVertex = null;
  }
  
  public DistanceInfo(boolean setToMaxValue) {
    distanceFromSource = setToMaxValue ? Integer.MAX_VALUE : -1;
    lastVertex = null;
  }
  
  public DistanceInfo(int value) {
    distanceFromSource = value;
    lastVertex = null;
  }

  public int getDistanceFromSource() {
    return distanceFromSource;
  }

  public void setDistanceFromSource(int distanceFromSource) {
    this.distanceFromSource = distanceFromSource;
  }

  public Vertex getLastVertex() {
    return lastVertex;
  }

  public void setLastVertex(Vertex lastVertex) {
    this.lastVertex = lastVertex;
  }
}
