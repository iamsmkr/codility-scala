package com.iamsmkr.codility.lessons.leader

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class EquiLeaderSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("EquiLeader should return the count of equileaders in a given array") {
    val results =
      Table(
        ("a", "result"),
        (Array(4, 3, 4, 4, 4, 2), 2),
        (Array[Int](), 0),
        (Array(4, 4, 2, 5, 3, 4, 4, 4), 3)
      )

    forAll(results) { (a, result) =>
      EquiLeader.solution(a) should equal(result)
    }
  }
}
