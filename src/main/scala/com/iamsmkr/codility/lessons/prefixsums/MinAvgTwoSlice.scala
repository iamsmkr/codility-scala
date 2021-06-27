package com.iamsmkr.codility.lessons.prefixsums

import scala.util.control.Breaks.break

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N,
 * is called a slice of array A (notice that the slice contains at least two elements).
 * The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
 * To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 *
 * For example, array A such that:
 *
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 *
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average.
 * If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 *
 * For example, given array A such that:
 *
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */

object MinAvgTwoSlice {

  sealed trait SegmentTree

  case class Node(l: Int, r: Int, value: Int, leftChild: SegmentTree, rightChild: SegmentTree) extends SegmentTree

  case class Leaf(value: Int) extends SegmentTree

  object SegmentTree {
    def apply(arr: Array[Int]): SegmentTree = {

      def build(l: Int, r: Int): SegmentTree = {
        if (l == r) Leaf(arr(l))
        else Node(l, r, arr.slice(l, r + 1).sum, build(l, mid(l, r)), build(mid(l, r) + 1, r))
      }

      build(0, arr.length - 1)
    }

    private def mid(l: Int, r: Int): Int = (l + r) / 2

    def findSum(st: SegmentTree, i: Int, j: Int): Int = st match {
      case Node(l, r, value, leftChild, rightChild) =>
        if (l == i & j == r) value
        else if (j <= mid(l, r)) findSum(leftChild, i, j)
        else if (i > mid(l, r)) findSum(rightChild, i, j)
        else findSum(leftChild, i, mid(l, r)) + findSum(rightChild, mid(l, r) + 1, j)

      case Leaf(value) => value
    }
  }

  // 60% : Correctness = 100%, Performance = 20%
  def solution(a: Array[Int]): Int = {
    val st = SegmentTree(a)

    var min = (Double.PositiveInfinity, 0, 0)

    for (i <- a.indices; j <- (i + 1) until a.length) {
      val avg = SegmentTree.findSum(st, i, j).toDouble / (j - i + 1)
      if (avg < min._1) min = (avg, i, j)
    }

    min._2
  }
}
