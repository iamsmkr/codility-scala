package com.iamsmkr.codility.lessons.misc

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class NecklacesSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Necklaces should return the length of a necklace with maximum number of beads") {
    val results =
      Table(
        ("arr", "result"),
        (Array(5, 4, 0, 3, 1, 6, 2), 4),
        (Array(0, 1, 2, 3, 4, 5, 6), 1),
        (Array[Int](), 0)
      )

    forAll(results) { (arr, result) =>
      Necklaces.solution(arr) should equal(result)
    }
  }
}
