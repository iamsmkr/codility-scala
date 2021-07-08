package com.iamsmkr.codility.lessons.misc

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
