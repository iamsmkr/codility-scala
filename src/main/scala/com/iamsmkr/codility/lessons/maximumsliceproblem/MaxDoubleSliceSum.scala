package com.iamsmkr.codility.lessons.maximumsliceproblem

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 *
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 *
 * For example, array A such that:
 *
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * contains the following example double slices:
 *
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 *
 * Write a function:
 *
 * object Solution { def solution(a: Array[Int]): Int }
 *
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 *
 * For example, given:
 *
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */

object MaxDoubleSliceSum extends App {

  // 53% : Correctness = 100%, Performance = 14%
  def solution(a: Array[Int]): Int = {
    var max = 0

    for (i <- a.indices) {
      for (j <- i + 1 until a.length) {
        for (k <- j + 1 until a.length) {
          val sliceSum = a.slice(i + 1, j).sum + a.slice(j + 1, k).sum
          if (sliceSum > max) max = sliceSum
        }
      }
    }

    max
  }

  // 61% : Correctness = 100%, Performance = 28%
  def solution2(a: Array[Int]): Int = {
    val prefixSumArr = a.scanLeft(0)(_ + _).tail
    var max = 0

    for (i <- a.indices) {
      for (j <- i + 1 until a.length) {
        for (k <- j + 1 until a.length) {
          val sliceSum = (prefixSumArr(j - 1) - prefixSumArr(i)) + (prefixSumArr(k - 1) - prefixSumArr(j))
          if (sliceSum > max) max = sliceSum
        }
      }
    }

    max
  }

  // Idea here is to build intermediate arrays that represent max sum up until an index while traversing
  // array in question from either side.
  def solution3(a: Array[Int]): Int = {

    val s = Array.fill(a.length)(0)
    val e = Array.fill(a.length)(0)

    for (i <- 1 until a.length - 1) {
      s(i) = List(a(i), a(i) + s(i - 1), 0).max
      e(a.length - 1 - i) = List(a(a.length - 1 - i), a(a.length - 1 - i) + e(a.length - i), 0).max
    }

    var max = 0

    for (i <- 1 until a.length - 1)
      max = List(s(i - 1) + e(i + 1), max).max

    max
  }

  println(solution3(Array(3, 2, 6, -1, 4, 5, -1, 2)))
}
