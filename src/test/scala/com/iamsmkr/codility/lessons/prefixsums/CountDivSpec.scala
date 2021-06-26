package com.iamsmkr.codility.lessons.prefixsums

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class CountDivSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("CountDiv should find count of all numbers divisible by 'k' in a range from 'a' to 'b'") {
    val results =
      Table(
        ("a", "b", "k", "result"),
        (6, 11, 2, 3),
        (11, 35, 17, 2)
      )

    forAll(results) { (a, b, k, result) =>
      CountDiv.solution(a, b, k) should equal(result)
    }
  }
}
