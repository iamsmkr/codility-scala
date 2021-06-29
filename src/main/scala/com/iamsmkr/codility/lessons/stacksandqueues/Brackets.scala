package com.iamsmkr.codility.lessons.stacksandqueues

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */

object Brackets {

  // 50% : Correctness = 100%, Performance = 20%
  def solution(s: String): Int = {
    @tailrec
    def check(stack: mutable.Stack[Char], str: String): Int = {
      if (str.isEmpty && stack.nonEmpty) 0
      else if (str.isEmpty && stack.isEmpty) 1
      else {
        str.head match {
          case '(' | '{' | '[' => check(stack.push(str.head), str.tail)
          case ')' => if (stack.isEmpty) 0 else if (stack.pop != '(') 0 else check(stack, str.tail)
          case '}' => if (stack.isEmpty) 0 else if (stack.pop != '{') 0 else check(stack, str.tail)
          case ']' => if (stack.isEmpty) 0 else if (stack.pop != '[') 0 else check(stack, str.tail)
        }
      }
    }

    check(mutable.Stack[Char](), s)
  }

  // 50% : Correctness = 100%, Performance = 20%
  def solution2(s: String): Int = {
    @tailrec
    def check(ls: List[Char], str: String): Int = {
      if (str.isEmpty && ls.nonEmpty) 0
      else if (str.isEmpty && ls.isEmpty) 1
      else {
        str.head match {
          case '(' | '{' | '[' => check(str.head :: ls, str.tail)
          case ')' => if (ls.isEmpty) 0 else if (ls.head != '(') 0 else check(ls.tail, str.tail)
          case '}' => if (ls.isEmpty) 0 else if (ls.head != '{') 0 else check(ls.tail, str.tail)
          case ']' => if (ls.isEmpty) 0 else if (ls.head != '[') 0 else check(ls.tail, str.tail)
        }
      }
    }

    check(List[Char](), s)
  }

  // 100% : Correctness = 100%, Performance = 100%
  def solution3(s: String): Int = {
    var ls: List[Char] = Nil

    for (i <- s.indices) {
      s(i) match {
        case '(' | '{' | '[' => ls = s(i) :: ls
        case ')' => if (ls.isEmpty) return 0 else if (ls.head != '(') return 0 else ls = ls.tail
        case '}' => if (ls.isEmpty) return 0 else if (ls.head != '{') return 0 else ls = ls.tail
        case ']' => if (ls.isEmpty) return 0 else if (ls.head != '[') return 0 else ls = ls.tail
      }
    }

    if (ls.isEmpty) 1 else 0
  }

  // The reason why solution 1 and solution 2 are not as performant as solution 3 and solution 4
  // because the string operations are really costly. Its always better to avoid string operations
  // if performance is a concern.

  // 100% : Correctness = 100%, Performance = 100%
  def solution4(s: String): Int = {
    @tailrec
    def check(ls: List[Char], index: Int): Int = {
      if (index > s.length - 1 && ls.nonEmpty) 0
      else if (index > s.length - 1 && ls.isEmpty) 1
      else {
        s(index) match {
          case '(' | '{' | '[' => check(s(index) :: ls, index + 1)
          case ')' => if (ls.isEmpty) 0 else if (ls.head != '(') 0 else check(ls.tail, index + 1)
          case '}' => if (ls.isEmpty) 0 else if (ls.head != '{') 0 else check(ls.tail, index + 1)
          case ']' => if (ls.isEmpty) 0 else if (ls.head != '[') 0 else check(ls.tail, index + 1)
        }
      }
    }

    check(List[Char](), 0)
  }

}
