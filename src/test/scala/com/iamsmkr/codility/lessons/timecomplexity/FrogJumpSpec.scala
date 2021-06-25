package com.iamsmkr.codility.lessons.timecomplexity

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class FrogJumpSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Frog Jump should be computed min hops required correctly") {
    val results =
      Table(
        ("x", "y", "d", "result"),
        (85, 10, 30, 3)
      )

    forAll(results) { (x, y, d, result) =>
      whenever(x > 0 && y > 0 && y > x && d > 0 && d < (y - x) && result > 0) {
        FrogJump.solution(x, y, d) should equal(result)
      }
    }
  }

}
