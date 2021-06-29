package com.iamsmkr.codility.lessons.stacksandqueues

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class NestingSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Brackets should find if a given string has paired brackets") {
    val results =
      Table(
        ("s", "result"),
        ("((()()))", 1),
        ("()", 1),
        (")(", 0),
        ("", 1),
        ("(()", 0),
      )

    forAll(results) { (a, result) =>
      Brackets.solution(a) should equal(result)
    }
  }
}
