package com.iamsmkr.codility.lessons.arrays

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class OddOccurencesInArraySpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("OddOccurencesInArray should be able to find odd number") {
    val results =
      Table(
        ("arr", "odd"),
        (Array(9, 3, 9, 3, 9, 7, 9), 7),
        (Array[Int](), 0),
        (Array(9, 3, 9, 3, 9, 7, 7, 9), 0),
      )

    forAll(results) { (arr, odd) =>
      OddOccurencesInArray.solution3(arr) should equal(odd)
    }
  }
}
