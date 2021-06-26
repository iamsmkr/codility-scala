package com.iamsmkr.codility.lessons.countingelements

import org.scalacheck.Gen
import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class MissingIntegerSpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {

  property("Smallest number should find the min for all values between −1,000,000 ... 1,000,000") {
    forAll(Gen.listOf(Gen.choose(-1000000, 1000000)) -> "ints") { ints =>
      val asSet = ints.toSet
      val smallestNI = MissingInteger.solution(ints.toArray)

      (1 until smallestNI).foreach { x =>
        asSet should contain(x)
      }
    }
  }
}

import org.scalameter.api._

object MissingIntegerBenchmark extends Bench.LocalTime {
  val sizes = org.scalameter.api.Gen.range("size")(100, 200, 1)

  val ranges = for {
    size <- sizes
  } yield -100 until size

  performance of "Range" in {
    measure method "smallestNum" in {
      using(ranges) in {
        r => MissingInteger.solution(r.toArray)
      }
    }
  }
}
