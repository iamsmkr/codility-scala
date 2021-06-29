package com.iamsmkr.codility.lessons.stacksandqueues

import scala.annotation.tailrec

/**
 * A string S consisting of N characters is called properly nested if:
 *
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 *
 * Write a function:
 *
 * object Solution { def solution(s: String): Int }
 *
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 *
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 */

object Nesting {
  def solution(s: String): Int = {
    @tailrec
    def check(ls: List[Char], index: Int): Int = {
      if (index > s.length - 1 && ls.nonEmpty) 0
      else if (index > s.length - 1 && ls.isEmpty) 1
      else {
        s(index) match {
          case '(' => check(s(index) :: ls, index + 1)
          case ')' => if (ls.isEmpty) 0 else if (ls.head != '(') 0 else check(ls.tail, index + 1)
        }
      }
    }

    check(List[Char](), 0)
  }
}
