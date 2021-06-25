package com.iamsmkr.codility.lessons.arrays

import scala.annotation.tailrec

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 *
 * For example, in array A such that:
 *
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 *
 * object Solution { def solution(a: Array[Int]): Int }
 *
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 *
 * For example, given array A such that:
 *
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 */

object OddOccurencesInArray extends App {

  // 66% : Correctness = 100%, Performance = 25%
  def solution(a: Array[Int]): Int = {

    @tailrec
    def check(a: Array[Int], odd: Int): Int = {
      if (a.isEmpty) odd
      else if (a.count(_ == a.head) % 2 != 0) a.head
      else check(a.filterNot(_ == a.head), odd)
    }

    check(a, 0)
  }

  // 88% : Correctness = 100%, Performance = 75%
  def solution2(a: Array[Int]): Int = {
    var map = Map[Int, Int]()

    a.foreach { i =>
      if (map.contains(i)) map += i -> (map(i) + 1)
      else map += i -> 1
    }

    val res = map.find(_._2 % 2 != 0)
    if (res.isDefined) res.get._1 else 0
  }

  // 100% : Correctness = 100%, Performance = 100%
  def solution3(a: Array[Int]): Int = {
    a.foldLeft(0)(_ ^ _)
  }

}
