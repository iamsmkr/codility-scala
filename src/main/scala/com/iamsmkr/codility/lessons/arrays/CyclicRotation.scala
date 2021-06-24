package com.iamsmkr.codility.lessons.arrays

object CyclicRotation extends App {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.nonEmpty) {
      val rotations = k % a.length
      a.takeRight(rotations) ++ a.take(a.length - rotations)
    } else a
  }
}
