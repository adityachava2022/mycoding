package com.datastructures.disjointset;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
  private List<Integer> sets;
  
  public DisjointSet() {
    sets = new ArrayList<>();
  }
 
  // implementation of union by size
  public void makeSet(int size) {
    for (int i = 0 ; i < size ; i++) {
      sets.add(-1);
    }
  }
  
  public int find(int v) {
    if (sets.get(v) < 0 )
      return v;
    else
      return (sets.set(v, find(sets.get(v)))); // with path compression,  array version = return arr[v] = find(arr[v])
  }
  
  public void union(int u, int v) {
    int parentOfU = find(u);
    int parentOfV = find(v);
    if (parentOfU == parentOfV)
      return;
    // make U as parent
    int newParentValue = sets.get(parentOfU) + sets.get(parentOfV);
    if (sets.get(parentOfU) < sets.get(parentOfV)) {
      sets.set(parentOfU, newParentValue);  // arr[parentOfU] += arr[parentOfV]
      sets.set(parentOfV, parentOfU);       // arr[parentOfV] = parentOfU;
    } else {
      
      sets.set(parentOfV, newParentValue);  // arr[parentOfV] += arr[parentOfU]
      sets.set(parentOfU, parentOfV);       // arr[parentOfU] = parentOfV;
    }
  }
  
  public void printDisjointSet() {
    for (int i = 0 ; i < sets.size(); i++) {
      System.out.println(" index : " + i + " value : " + sets.get(i));
    }
  }
}
