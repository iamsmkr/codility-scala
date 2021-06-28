package com.iamsmkr.codility.lessons.sorting

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class MaxProductOfThreeSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("MaxProductOfThree should find triplet with maximal product in a given array") {
    val results =
      Table(
        ("a", "result"),
        (Array(-3, 1, 2, -2, 5, 6), 60),
        (Array(-2, -2, 1, 2), 8)
      )

    forAll(results) { (a, result) =>
      MaxProductOfThree.solution(a) should equal(result)
    }
  }
}
