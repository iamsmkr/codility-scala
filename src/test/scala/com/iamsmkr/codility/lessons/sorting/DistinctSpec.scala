package com.iamsmkr.codility.lessons.sorting

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class DistinctSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Distinct should find correct count of distinct values in a given array") {
    val results =
      Table(
        ("a", "result"),
        (Array(4, 2, 2, 5, 1, 5, 8), 5),
        (Array(-2, -2), 1),
        (Array(2, 1, 1, 2, 3, 1), 3),

      )

    forAll(results) { (a, result) =>
      Distinct.solution(a) should equal(result)
    }
  }
}
