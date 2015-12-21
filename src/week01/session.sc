import scala.annotation.tailrec

object session {

  1 + 2

  def abs(x: Double) = if (x < 0) -x else x
  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < x * 0.0001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(16.0)
  sqrt(4.0)
  sqrt(0.001)
  sqrt(0.1e-20)
  sqrt(1.0e20)
  sqrt(1.0e50)

  def fact(x: Int): Int =
    if (x==0) 1 else x * fact(x-1)

  fact(4)


  def sum(f: Int => Int)( a: Int, b: Int): Int = {
    @tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a>b) acc
      else loop(a+1, acc+f(a))
    }
    loop(a, 0)
  }

  sum(a => a)( 3,6)


  def sum2(f: Int => Int): (Int, Int) => Int = {

    def sumF(a: Int, b: Int): Int = {
      if (a>b) 0
      else f(a) + sumF(a+1,b)
    }
    sumF
  }


}

