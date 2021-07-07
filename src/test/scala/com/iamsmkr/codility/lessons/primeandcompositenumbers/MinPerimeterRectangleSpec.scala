package com.iamsmkr.codility.lessons.primeandcompositenumbers

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class MinPerimeterRectangleSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("MinPerimeterRectangle should find minimal perimeter of a rectangle with a given area") {
    val results =
      Table(
        ("a", "result"),
        (30, 22),
        (101, 204),
        (1, 4)
      )

    forAll(results) { (a, result) =>
      MinPerimeterRectangle.solution(a) should equal(result)
    }
  }
}
