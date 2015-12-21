import scala.annotation.tailrec



object excercise {

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a>b) 1
    else f(a) * product(f)(a+1,b)

  def factorial(n: Int) =
    product2(x=>x)(1,n)

  def generic(f: Int => Int)(op: Int => Int => Int)(identity: Int, a: Int, b: Int): Int =
    if (a>b) identity
    else op(f(a))(generic(f)(op)(identity,a+1,b))

  def product2(f: Int => Int)(a: Int, b: Int): Int =
    generic(f)(x=>y=>x*y)(1,a,b)


}
excercise.product(x=>x*x)(3,7)
excercise.factorial(5)
excercise.generic(x=>x)(a=>b=>a*b)(1,1,7)
excercise.product2(x=>x)(1,7)

println("Tests")
object tests {
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
  //sqrt(16.0)
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
  //sum(a => a)( 3,6)

  def sum2(f: Int => Int): (Int, Int) => Int = {

    def sumF(a: Int, b: Int): Int = {
      if (a>b) 0
      else f(a) + sumF(a+1,b)
    }
    sumF
  }

  def sumInts = sum2(x => x)

  //sumInts(2, 8)
  //sum2(x=>x*x*x)(2,8)

  def sum3(f: Int => Int)(a: Int, b: Int): Int = {
      if (a>b) 0
      else f(a) + sum3(f)(a+1,b)
  }
  //sum3(x=>x*x*x)
  //sumC(2,8)

}


