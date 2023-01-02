package com.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * method 1: using prime factorization method
 * Time Complexity -> O(sqrt(n)) - a loop that runs up to sqrt(n)
 * space complexity -> O(1) -> in general
 * -------------------------------------
 * method 2: use Sieve of Eratosthenes
 * Time Complexity -> O (log(n))
 */
public class PrimeFactors {

  public static void main(String[] args) {
    int n = 1000;
    List<Integer> factors = primeFactorsOfN2(n);
    List<Integer> factors1 = primeFactorsOfN1(n);
    System.out.println(factors);
    System.out.println(factors1);
  }

  /**
   * method1 : divide by 2 (The Smallest prime number) until we get an odd number
   * and once we get odd number start by dividing with the
   * odd numbers until the number is not divisible by that number
   * @param n - value
   * @return - list of prime factors
   */
  private static List<Integer> primeFactorsOfN1(int n) {
    List<Integer> primeFactors = new ArrayList<>();
    // divide by 2 until we get an odd number
    while (n % 2 == 0) {
      primeFactors.add(2);
      n /= 2;
    }
    // once we got odd number start dividing by all odd numbers
    // until sqrt(n)
    for (int i = 3 ; i <= Math.sqrt(n) ; i += 2) {
      while(n % i == 0) {
        primeFactors.add(i);
        n /= i;
      }
    }
    // we should generally get 1/2 , but if we get some other number,
    // then it must be a prime factor
    if (n > 2) {
      primeFactors.add(n);
    }
    return primeFactors;
  }

  /**
   * since all the composite numbers are having factors other than
   * 1 and itself , so we can start dividing the number by smallest prime
   * possible (i.e.., from 2), then all of its multiples will automatically
   * be removed before we actually reach that number
   * @param n - value
   * @return - list of prime factors
   */
  private static List<Integer> primeFactorsOfN2(int n) {
    List<Integer> primeFactors = new ArrayList<>();
    int p = 2;
    // continue until we reach 1 or 0
    while (n > 1) {
      // check if n is divisible by p
      // keep dividing the number until it is divisible by p
      if (n % p == 0) {
        primeFactors.add(p);
        n /= p;
        // else increase p
      } else {
        p++;
      }
    }
    return primeFactors;
  }
}
