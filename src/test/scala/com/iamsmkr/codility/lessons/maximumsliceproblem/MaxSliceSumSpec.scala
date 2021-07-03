package com.iamsmkr.codility.lessons.maximumsliceproblem

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class MaxSliceSumSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("MaxSliceSum should return max slice") {
    val results =
      Table(
        ("a", "result"),
        (Array(3, 2, -6, 4, 0), 5),
      )

    forAll(results) { (a, result) =>
      MaxSliceSum.solution(a) should equal(result)
    }
  }
}
