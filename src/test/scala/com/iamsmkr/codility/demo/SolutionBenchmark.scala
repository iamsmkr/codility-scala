package com.iamsmkr.codility.demo

import org.scalameter.api._

object SolutionBenchmark extends Bench.LocalTime {
  val sizes = Gen.range("size")(100, 200, 1)

  val ranges = for {
    size <- sizes
  } yield -100 until size

  performance of "Range" in {
    measure method "smallestNum" in {
      using(ranges) in {
        r => Solution.solution(r.toArray)
      }
    }
  }
}
