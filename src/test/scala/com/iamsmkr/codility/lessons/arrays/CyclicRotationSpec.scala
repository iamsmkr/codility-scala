package com.iamsmkr.codility.lessons.arrays

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class CyclicRotationSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("Cyclic rotation should result in correctly rotated array") {
    val results =
      Table(
        ("arr", "rotations", "rotatedArr"),
        (Array(3, 8, 9, 7, 6), 3, Array(9, 7, 6, 3, 8)),
        (Array(0, 0, 0), 1, Array(0, 0, 0)),
        (Array(1, 2, 3, 4), 4, Array(1, 2, 3, 4)),
        (Array[Int](), 0, Array())
      )

    forAll(results) { (arr, rotations, rotatedArr) =>
      CyclicRotation.solution(arr, rotations) should equal(rotatedArr)
    }
  }
}
