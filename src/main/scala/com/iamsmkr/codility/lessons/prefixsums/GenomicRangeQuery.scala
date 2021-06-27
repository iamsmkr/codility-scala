package com.iamsmkr.codility.lessons.prefixsums

import scala.annotation.tailrec

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence.
 * Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
 * You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 *
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
 * There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
 * The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 *
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 *
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 *
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 *
 * object Solution { def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] }
 *
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers,
 * returns an array consisting of M integers specifying the consecutive answers to all queries.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 *
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */

object GenomicRangeQuery extends App {

  // 62% : Correctness = 100%, Performance = 0%
  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val arr = s.toCharArray

    p.zip(q).map { case (i, j) => arr.slice(i, j + 1).toSet.min }.map {
      case 'A' => 1
      case 'C' => 2
      case 'G' => 3
      case 'T' => 4
    }
  }

  // 87% : Correctness = 100%, Performance = 66%
  def solution2(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val arr = s.toCharArray

    @tailrec
    def findMin(start: Int, end: Int, min: Char): Char = {
      if (start == end) if (arr(start).toInt < min.toInt) arr(start) else min
      else if (arr(start) == 'A') 'A'
      else if (arr(start).toInt < min.toInt) findMin(start + 1, end, arr(start))
      else findMin(start + 1, end, min)
    }

    p.zip(q)
      .map { case (i, j) => findMin(i, j, arr(i)) }
      .map {
        case 'A' => 1
        case 'C' => 2
        case 'G' => 3
        case 'T' => 4
      }
  }

  // The problem with the solutions above is that they don't consider previous computation results. For example,
  // in a sample genome string "CAGCCTA", the results of a query that returns minimal impact factor for substring "GCC" is not considered
  // while querying the complete string itself i.e., "CAGCCTA". In other words, in order to compute the minimal impact factor
  // for "CAGCCTA" we could combine the results of "GCC" (already computed) and "CATA".

  // There are couple of approaches to solve this problem efficiently:
  // (1) Using adjacency matrix. The problem however with this approach is that it requires a lot of space.
  // (2) Using segment tree. This approach requires lesser space relative to adjacency matrix.
  // (3) Using Binary indexed tree. This could be considered the best approach to solve this problem as it is both memory and time efficient
  //     and is also most efficient for data structures that needs frequent updates.

  // Refer:
  // (1) Solution using adjacency matrix:
  //    (a) https://funnelgarden.com/genomicrangequery-codility-solution/
  //    (b) https://github.com/jmnarloch/codility-scala/blob/master/src/main/scala/com/codility/lessons/GenomicRangeQuery.scala
  //    (c) https://github.com/Firfi/euler-katas/blob/master/src/main/scala/codility/GenomicRangeQuery.scala
  // (2) Solution using segment tree:
  //    (a) https://randxie.github.io/writing/2018/07/01/monoid-and-segment-tree/

  println(solution2("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)).mkString("Array(", ", ", ")"))
  println(solution2("GT", Array(0, 0, 1), Array(0, 1, 1)).mkString("Array(", ", ", ")"))
  println(solution2("TC", Array(0, 0, 1), Array(0, 1, 1)).mkString("Array(", ", ", ")"))
}
