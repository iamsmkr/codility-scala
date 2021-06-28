package com.iamsmkr.codility.lessons.sorting

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class NumberOfDiscIntersectionsSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("NumberOfDiscIntersections should find correct count disc intersections") {
    val results =
      Table(
        ("a", "result"),
        (Array(1, 5, 2, 1, 4, 0), 11),
        (Array(1, 2147483647, 0), 2),
        (Array(1, 1, 1), 3)
      )

    forAll(results) { (a, result) =>
      NumberOfDiscIntersections.solution(a) should equal(result)
    }
  }
}
