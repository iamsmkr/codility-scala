package com.iamsmkr.codility.lessons.misc

/**
 * Given two integers A and B, return the number of integers from the range A..B which can be expressed as the product of
 * two consecutive integers, that is X *(X + 1) which is also known as Pronic Number.
 *
 * Example 1 :
 * A = 6 and B = 20, the function should return 3, These integers are 6 = 2 * 3, 12 = 3 * 4 and 20 = 4* 5
 *
 * Example 2 :
 * A = 21 and B = 29, the function should return 0
 *
 * Assumptions:
 * A and B are integers within the range [1...1000,000,000]
 * A <= B
 */

object PronicNumbers {
  def solution(a: Int, b: Int): Int = {
    var count = 0

    for (i <- a to b) {
      val div = Math.sqrt(i).toInt

      if (i % div == 0 && i % (div + 1) == 0)
        count += 1
    }

    count
  }

  // Refer: https://stackoverflow.com/questions/65874967/how-to-optimize-the-solution-to-calculate-pronic-number-in-java
  def solution2(A: Int, B: Int): Int = {
    var count = 0
    val start = Math.sqrt(A).toInt
    val end = Math.sqrt(B).toInt

    count = end - start - 1

    if (start * (start + 1) >= A) count += 1
    if (end * (end + 1) <= B) count += 1

    count
  }
}
