package com.datastructures.disjointset;

public class DisjointSetExample {

  public static void main(String[] args) {
    DisjointSet ds = new DisjointSet();
    ds.makeSet(10);
    
    System.out.println(" disjoint set is ");
    ds.printDisjointSet();
    
    System.out.println(" disjoint set is after Union (1,2) ");

    System.out.println("find 1: " + ds.find(1));
    System.out.println("find 2: " +ds.find(2));
    
    ds.union(1, 2);
    ds.printDisjointSet();
    
    System.out.println(" disjoint set is after Union (1,2) ");
    ds.union(2, 3);
    ds.printDisjointSet();
    
    System.out.println(" disjoint set is after Union (1,2) ");
    ds.union(3, 4);
    ds.printDisjointSet();
  }

}
