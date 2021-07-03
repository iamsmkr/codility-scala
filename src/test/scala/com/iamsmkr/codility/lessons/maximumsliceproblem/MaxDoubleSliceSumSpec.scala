package com.iamsmkr.codility.lessons.maximumsliceproblem

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class MaxDoubleSliceSumSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("MaxDoubleSliceSum should return max double slice") {
    val results =
      Table(
        ("a", "result"),
        (Array(3, 2, 6, -1, 4, 5, -1, 2), 17),
      )

    forAll(results) { (a, result) =>
      MaxDoubleSliceSum.solution(a) should equal(result)
    }
  }
}
