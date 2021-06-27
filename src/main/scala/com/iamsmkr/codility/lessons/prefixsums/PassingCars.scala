package com.iamsmkr.codility.lessons.prefixsums

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 *
 * Array A contains only 0s and/or 1s:
 *
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N,
 * is passing when P is traveling to the east and Q is traveling to the west.
 *
 * For example, consider array A such that:
 *
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 *
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 *
 * For example, given:
 *
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 */

object PassingCars {

  // 60% : Correctness = 100%, Performance = 20%
  def solution(a: Array[Int]): Int = {
    val easts = ListBuffer.empty[Int]
    val wests = ListBuffer.empty[Int]

    a.zipWithIndex.foreach { case (n, i) =>
      if (n == 0) easts += i else wests += i
    }

    var passingCars = 0
    for {
      x <- easts
      y <- wests
    } yield {
      if (x < y) passingCars += 1
    }

    if (passingCars > 1000000000) -1 else passingCars
  }

  // 60% : Correctness = 100%, Performance = 20%
  def solution2(a: Array[Int]): Int = {
    val passingCarsMap = mutable.Map[Int, Int]()

    a.zipWithIndex.foreach { case (n, i) =>
      if (n == 0 && !passingCarsMap.contains(i))
        passingCarsMap += (i -> 0)
      if (n == 1)
        passingCarsMap.keySet.foreach(k => passingCarsMap += (k -> (passingCarsMap(k) + 1)))
    }

    val passingCars = passingCarsMap.values.sum

    if (passingCars > 1000000000) -1 else passingCars
  }

  def solution3(a: Array[Int]): Int = {
    var zeros = 0
    var passingCars = 0

    a.foreach { x =>
      if (x == 0) zeros += 1
      else if (x == 1) passingCars += zeros
    }

    if (passingCars > 1000000000) -1 else passingCars
  }

}
