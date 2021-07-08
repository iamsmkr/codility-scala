package com.iamsmkr.codility.lessons.misc

import scala.collection.mutable

/**
 * 'solution' function works slowly on large input data and the goal is to optimize it so as to achieve better time
 * and/or space complexity. The optimized function should return the same results as 'solution' function.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1...100,000];
 * - each element of array A is an integer within the range [1..N].
 *
 */

object ImproveComplexity {
  def solution(a: Array[Int]): Int = {
    var result: Int = 0

    for (i <- 0 until a.length - 1)
      for (j <- i + 1 until a.length)
        if (a(i) == a(j))
          result = Math.max(result, Math.abs(i - j))

    result
  }

  def solution2(a: Array[Int]): Int = {
    val m = mutable.Map[Int, List[Int]]()

    for (i <- a.indices) {
      if (m.contains(a(i))) m += a(i) -> (i :: m(a(i)))
      else m += a(i) -> (i :: List[Int]())
    }

    val v = m.filter(_._2.length > 1).values
    if (v.nonEmpty) v.map(x => x.head - x.last).max else 0
  }
}
