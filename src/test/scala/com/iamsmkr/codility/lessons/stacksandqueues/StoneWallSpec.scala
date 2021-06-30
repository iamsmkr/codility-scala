package com.iamsmkr.codility.lessons.stacksandqueues

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class StoneWallSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("StoneWall should find minimum number of consecutive blocks of same size required to build a skyline defined by a given array") {
    val results =
      Table(
        ("a", "result"),
        (Array(8, 8, 5, 7, 9, 8, 7, 4, 8), 7),
        (Array(8, 8, 5, 7, 9, 8, 7, 5, 8), 6),
        (Array(1, 2, 3, 4, 3), 4),
        (Array(8, 8, 5), 2),
        (Array(8), 1),
        (Array(8, 8, 8, 8, 8), 1),
        (Array(1000000000, 2), 2),
        (Array(2, 1000000000, 2), 2),
        (Array(2, 1000000000, 2, 1000000000, 1000000000), 3)
      )

    forAll(results) { (a, result) =>
      StoneWall.solution(a) should equal(result)
    }
  }
}
