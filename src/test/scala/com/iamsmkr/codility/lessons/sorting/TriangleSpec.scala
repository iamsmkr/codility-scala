package com.iamsmkr.codility.lessons.sorting

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class TriangleSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Triangle should find if a given array has a triplet") {
    val results =
      Table(
        ("a", "result"),
        (Array[Int](), 0),
        (Array(10, 2, 5, 1, 8, 20), 1),
        (Array(5, 3, 3), 1),
        (Array(1, 1, 1, 1, 5, 5, 5), 1)
      )

    forAll(results) { (a, result) =>
      Triangle.solution(a) should equal(result)
    }
  }
}
