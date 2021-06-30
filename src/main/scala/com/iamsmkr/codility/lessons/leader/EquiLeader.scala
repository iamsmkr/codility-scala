package com.iamsmkr.codility.lessons.leader

/**
 * A non-empty array A consisting of N integers is given.
 *
 * The leader of this array is the value that occurs in more than half of the elements of A.
 *
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1]
 * have leaders of the same value.
 *
 * For example, given array A such that:
 *
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * we can find two equi leaders:
 *
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 *
 * Write a function:
 *
 * object Solution { def solution(a: Array[Int]): Int }
 *
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 *
 * For example, given:
 *
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * the function should return 2, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */

object EquiLeader {

  // 55% : Correctness = 100%, Performance = 0%
  def solution(a: Array[Int]): Int = {

    def hasLeader(a: Array[Int]): (Boolean, Int) = {
      if (a.isEmpty) return (false, -1)
      else if (a.length == 1) return (true, a(0))

      val arr = a.zipWithIndex.sortBy(_._1)

      var num = arr(0)._1
      var count = 1

      for (i <- 1 until arr.length) {
        if (arr(i)._1 == num) {
          count += 1
          if (count > a.length / 2) return (true, arr(i)._1)
        } else {
          num = arr(i)._1
          count = 1
        }
      }

      (false, -1)
    }

    var count = 0

    for (i <- a.indices) {
      val (bool1, leader1) = hasLeader(a.take(i))
      val (bool2, leader2) = hasLeader(a.drop(i))

      if (bool1 && bool2 && leader1 == leader2) count += 1
    }

    count
  }

  // The premise of the previous solution was that dominators in sub arrays could be different compared to
  // the dominator in the complete array. But a general observation is that the dominator always stays the same!
  // Similarly if there isn't any leader in the whole array, neither would there be any leaders in sub arrays.
  // This observation influences the following solution.
  def solution2(a: Array[Int]): Int = {

    def findLeader(a: Array[Int]): Int = {
      if (a.isEmpty) return -1
      else if (a.length == 1) return a(0)

      val arr = a.zipWithIndex.sortBy(_._1)

      var num = arr(0)._1
      var count = 1

      for (i <- 1 until arr.length) {
        if (arr(i)._1 == num) {
          count += 1
          if (count > a.length / 2) return arr(i)._1
        } else {
          num = arr(i)._1
          count = 1
        }
      }

      -1
    }

    val leader = findLeader(a)

    if (leader != -1) {
      val count = a.count(_ == leader) // since find leader exits early, we need to count the occurences again

      var equiLeaderCount = 0
      var leadersInLeftArr = 0
      var leadersInRightArr = count

      for (i <- a.indices) {
        if (a(i) == leader) {
          leadersInLeftArr += 1
          leadersInRightArr -= 1
        }

        if ((leadersInLeftArr > (i + 1) / 2) && (leadersInRightArr > (a.length - 1 - i) / 2))
          equiLeaderCount += 1
      }

      equiLeaderCount
    } else 0

  }
}
