package com.iamsmkr.codility.lessons.countingelements

import org.scalacheck.Gen
import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class PermCheckSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("PermCheck should find if a given array is a permutation") {
    val results =
      Table(
        ("arr", "result"),
        (Array(4, 1, 3, 2), 1),
        (Array(1, 2, 3, 5), 0)
      )

    forAll(results) { (arr, result) =>
      PermCheck.solution(arr) should equal(result)
    }
  }
}
