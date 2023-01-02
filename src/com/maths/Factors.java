package com.maths;

import java.util.ArrayList;
import java.util.List;

public class Factors {
  public static void main(String args[]) {
    int n = 40;
    List<Integer> factors = factorsOfN(n);
    System.out.println(factors);
  }

  public static List<Integer> factorsOfN(int n) {
    List<Integer> factors = new ArrayList<>();
    int i; // declaring i in outer scope
    for (i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        factors.add(i);
      }
    }
	// check if there is a duplicate of factors
    if (i - (n / i) == 0) {
      i -= 2; // incrementing twice once to avoid duplicates and another to decrease the condition
    }
    for (; i >= 1; i--) // quotient of numbers which give remainder as 0
    {
      if (n % i == 0) {
        factors.add(n / i);
      }
    }
    return factors;
  }
}
