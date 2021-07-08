package com.iamsmkr.codility.lessons.misc

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class PronicNumbersSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("PronicNumbers should compute count of all pronic numbers from a given range") {
    val results =
      Table(
        ("a", "b", "result"),
        (1, 1, 0),
        (6, 6, 1),
        (1, 6, 2),
        (2, 6, 2),
        (6, 20, 3),
        (21, 29, 0),
        (1, 1000000000, 31622),
        (5000, 990000000, 31393)
      )

    forAll(results) { (a, b, result) =>
      PronicNumbers.solution2(a, b) should equal(result)
    }
  }
}