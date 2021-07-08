package com.iamsmkr.codility.lessons.misc

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class ImproveComplexitySpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("ImproveComplexity should return expected results in reasonable time") {
    val results =
      Table(
        ("arr", "result"),
        (Array(4, 6, 2, 2, 6, 6, 1), 4),
        (Array(1, 2, 3, 4, 5, 6, 7), 0),
        (Array(2, 2, 2, 2, 2, 2, 2), 6),
        (Array.fill(50000)(2), 49999)
      )

    forAll(results) { (arr, result) =>
      ImproveComplexity.solution2(arr) should equal(result)
    }
  }
}
