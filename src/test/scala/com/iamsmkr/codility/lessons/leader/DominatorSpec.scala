package com.iamsmkr.codility.lessons.leader

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class DominatorSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Dominator should return index of any element that is present more than half the number of elements in an array") {
    val results =
      Table(
        ("a", "result"),
        (Array(3, 4, 3, 2, 3, -1, 3, 3), 7),
        (Array[Int](), -1),
        (Array(29971), 0)
      )

    forAll(results) { (a, result) =>
      Dominator.solution(a) should equal(result)
    }
  }
}
