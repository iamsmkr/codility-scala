package com.iamsmkr.codility.lessons.iterations

object BinaryGap extends App {

  def solution(n: Int): Int = {
    val binary = n.toBinaryString.toCharArray
    val res = binary.zipWithIndex
      .map { case (x, y) => (x.asDigit, y) }
      .filter(_._1 == 1)
      .map(_._2)
      .sliding(2)
      .map(_.reduce(_ - _).abs)
      .max - 1

    if (res >= 0) res else 0
  }
}
