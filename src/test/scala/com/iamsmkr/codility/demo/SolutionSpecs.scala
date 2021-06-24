package com.iamsmkr.codility.demo

import org.scalacheck.Gen
import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class SolutionSpecs extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {

  property("solution2 should find the min for all values between −1,000,000 ... 1,000,000") {
    forAll(Gen.listOf(Gen.posNum[Int]) -> "ints") { ints =>
      val asSet = ints.toSet
      val smallestNI = Solution.solution(ints.toArray)

      (1 until smallestNI).foreach { x =>
        asSet should contain(x)
      }
    }
  }
}
