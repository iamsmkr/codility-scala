package com.iamsmkr.codility.lessons.countingelements

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class MaxCountersSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("MaxCounters should be computed max counters correctly") {
    val results =
      Table(
        ("x", "arr", "result"),
        (1, Array(2, 1, 1, 2, 1), Array(3)),
        (5, Array(3, 4, 4, 6, 1, 4, 4), Array(3, 2, 2, 4, 2))
      )

    forAll(results) { (x, arr, result) =>
      MaxCounters.solution(x, arr) should equal(result)
    }
  }
}
