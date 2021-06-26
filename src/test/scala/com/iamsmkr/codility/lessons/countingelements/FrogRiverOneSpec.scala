package com.iamsmkr.codility.lessons.countingelements

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class FrogRiverOneSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("FrogRiverOne should be computed earliest time available for the frog to cross the river") {
    val results =
      Table(
        ("x", "arr", "result"),
        (5, Array(1, 3, 1, 4, 2, 3, 5, 4), 6),
        (5, Array(1, 5, 1, 3, 4, 2, 3, 4), 5)
      )

    forAll(results) { (x, arr, result) =>
      FrogRiverOne.solution(x, arr) should equal(result)
    }
  }
}
