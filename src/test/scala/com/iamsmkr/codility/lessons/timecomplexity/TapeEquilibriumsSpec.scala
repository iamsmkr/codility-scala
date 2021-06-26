package com.iamsmkr.codility.lessons.timecomplexity

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class TapeEquilibriumsSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  val results =
    Table(
      ("arr", "result"),
      (Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1),
      (Array(3, 1, 2, 4, 3), 1),
      (Array(-1000, 1000), 2000)
    )

  forAll(results) { (arr, result) =>
    TapeEquilibriums.solution(arr) should equal(result)
  }
}
