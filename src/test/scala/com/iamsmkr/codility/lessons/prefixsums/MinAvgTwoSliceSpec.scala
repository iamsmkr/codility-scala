package com.iamsmkr.codility.lessons.prefixsums

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class MinAvgTwoSliceSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("MinAvgTwoSlice should find correct index of the slice that has minimum average") {
    val results =
      Table(
        ("a", "result"),
        (Array(4, 2, 2, 5, 1, 5, 8), 1),
        (Array(-2, -2), 0)
      )

    forAll(results) { (a, result) =>
      MinAvgTwoSlice.solution(a) should equal(result)
    }
  }
}
