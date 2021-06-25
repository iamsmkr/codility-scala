package com.iamsmkr.codility.lessons.timecomplexity

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class PermMissingElemSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks  {
  val results =
    Table(
      ("arr", "result"),
      (Array(2, 3, 1, 5), 4),
      (Array(4, 2, 3, 1), 5),
      (Array(1), 2),
      (Array[Int](), 1)
    )

  forAll(results) { (arr, result) =>
    PermMissingElem.solution(arr) should equal(result)
  }
}
