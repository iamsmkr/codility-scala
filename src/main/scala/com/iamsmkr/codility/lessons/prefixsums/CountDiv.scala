package com.iamsmkr.codility.lessons.prefixsums

/**
 * Write a function:
 *
 * object Solution { def solution(a: Int, b: Int, k: Int): Int }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */

object CountDiv {

  // 50% : Correctness = 100%, Performance = 0%
  def solution(a: Int, b: Int, k: Int): Int = {
    (a to b).toList.count(_ % k == 0)
  }

  def solution2(a: Int, b: Int, k: Int): Int = {
    if (a % k == 0) b / k - a / k + 1
    else b / k - a / k
  }
}
