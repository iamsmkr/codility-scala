package com.iamsmkr.codility.lessons.primeandcompositenumbers

object MinPerimeterRectangle {

  def solution(n: Int): Int = {
    for (i <- Math.ceil(Math.sqrt(n)).toInt to 2 by -1)
      if (n % i == 0) return 2 * (i + (n / i))

    2 * (n + 1)
  }

}
