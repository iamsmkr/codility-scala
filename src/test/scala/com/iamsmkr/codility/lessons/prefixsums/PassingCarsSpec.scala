package com.iamsmkr.codility.lessons.prefixsums

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class PassingCarsSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("PassingCars should find correct number of passing cars") {
    val results =
      Table(
        ("a", "result"),
        (Array(0, 1, 0, 1, 1), 5),
        (Array(0, 0, 0, 1, 1), 6)
      )

    forAll(results) { (a, result) =>
      PassingCars.solution(a) should equal(result)
    }
  }
}
