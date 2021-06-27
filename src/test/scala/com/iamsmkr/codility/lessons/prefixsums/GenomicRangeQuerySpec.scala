package com.iamsmkr.codility.lessons.prefixsums

import org.scalatest.matchers.should
import org.scalatest.propspec.AnyPropSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class GenomicRangeQuerySpec extends AnyPropSpec with should.Matchers with ScalaCheckPropertyChecks {
  property("GenomicRangeQuery should find correct minimal impact factor for a given genomic sequence and the query range") {
    val results =
      Table(
        ("s", "p", "q", "result"),
        ("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6), Array(2, 4, 1)),
        ("GT", Array(0, 0, 1), Array(0, 1, 1), Array(3, 3, 4)),
        ("TC", Array(0, 0, 1), Array(0, 1, 1), Array(4, 2, 2))
      )

    forAll(results) { (s, p, q, result) =>
      GenomicRangeQuery.solution(s, p, q) should equal(result)
    }
  }
}
