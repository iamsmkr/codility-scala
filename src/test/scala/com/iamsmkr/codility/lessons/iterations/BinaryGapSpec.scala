package com.iamsmkr.codility.lessons.iterations

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class BinaryGapSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {

  property("Binary gap should be computed correctly for a given number") {
    val results =
      Table(
        ("num", "binarygap"),
        (9, 2),
        (15, 0),
        (20, 1),
        (32, 0),
        (529, 4),
        (1041, 5)
      )

    forAll(results) { (num, binarygap) =>
      BinaryGap.solution(num) should equal(binarygap)
    }
  }

}
