package com.iamsmkr.codility.lessons.maximumsliceproblem

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class MaxProfitSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("MaxProfit should return max profit") {
    val results =
      Table(
        ("a", "result"),
        (Array(23171, 21011, 21123, 21366, 21013, 21367), 356),
      )

    forAll(results) { (a, result) =>
      MaxProfit.solution(a) should equal(result)
    }
  }
}
