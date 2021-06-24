package com.iamsmkr.codility.lessons.arrays

object CyclicRotation {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.nonEmpty) {
      val rotations = k % a.length
      a.takeRight(rotations) ++ a.take(a.length - rotations)
    } else a
  }
}
