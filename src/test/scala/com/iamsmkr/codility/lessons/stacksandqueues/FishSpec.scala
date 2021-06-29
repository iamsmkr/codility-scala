package com.iamsmkr.codility.lessons.stacksandqueues

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class FishSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Fish should find count of number of fishes survived") {
    val results =
      Table(
        ("a", "b", "result"),
        (Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 0), 2),
        (Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 0), 2),
        (Array(4, 3, 2, 1, 5), Array(0, 0, 0, 0, 0), 5),
        (Array(4, 3, 2, 1, 5), Array(1, 1, 1, 1, 1), 5),
        (Array(4, 3, 2, 1, 5), Array(1, 0, 1, 1, 1), 4),
        (Array(4, 3, 2, 1, 5), Array(1, 0, 1, 0, 1), 3),
        (Array(4, 3, 2, 1, 0), Array(1, 0, 1, 0, 1), 3),
        (Array(4, 3, 2, 1, 0), Array(1, 0, 0, 0, 0), 1),
        (Array(1, 2, 3, 4, 5), Array(0, 0, 0, 0, 1), 5),
        (Array(1, 2, 3, 4, 5), Array(1, 0, 0, 0, 0), 4),
        (Array(5, 4, 3, 2, 1), Array(1, 0, 0, 0, 0), 1),
        (Array(4, 3, 2, 1, 5), Array(0, 1, 1, 0, 0), 2)
      )

    forAll(results) { (a, b, result) =>
      Fish.solution(a, b) should equal(result)
    }
  }
}
