package com.graphs.shortestpath;

import com.graphs.dfs.Vertex;

public class DistanceInfo {
  private int distanceFromSource;
  private Vertex lastVertex;

  public DistanceInfo() {
    distanceFromSource = -1;
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
