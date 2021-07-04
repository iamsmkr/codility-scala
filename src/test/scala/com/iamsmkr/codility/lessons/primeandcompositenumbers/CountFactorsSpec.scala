package com.iamsmkr.codility.lessons.primeandcompositenumbers

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class CountFactorsSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("CountFactors should find correct number of factors for a given number") {
    val results =
      Table(
        ("a", "result"),
        (24, 8),
        (69, 4),
        (120, 16),
        (362880, 160),
        (2147395600, 135),
        (1, 1)
      )

    forAll(results) { (a, result) =>
      CountFactors.solution(a) should equal(result)
    }
  }
}
