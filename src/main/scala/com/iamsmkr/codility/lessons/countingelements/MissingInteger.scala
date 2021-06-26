package com.iamsmkr.codility.lessons.countingelements

import scala.annotation.tailrec

/**
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

object MissingInteger {

  def solution(a: Array[Int]): Int = {
    val posNums = a.toSet.filter(_ > 0)

    @tailrec
    def checkForSmallestNum(ls: Set[Int], nextMin: Int): Int = {
      if (ls.contains(nextMin)) checkForSmallestNum(ls, nextMin + 1)
      else nextMin
    }

    checkForSmallestNum(posNums, 1)
  }

}
