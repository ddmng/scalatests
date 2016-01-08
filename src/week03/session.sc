
val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)


x - y - z
y + y
x < y
x max y

val zz = new Rational(2)
//val strange = new Rational(1,0)
//strange add strange


object rationals {

}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be different from 0")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b, a%b)
  private val g = gcd(x,y)
  def numer = x / g
  def denom = y / g
  override def toString(): String = {
    numer + "/" + denom
  }

  def +(that: Rational) = {
    new Rational (numer * that.denom + that.numer * denom, denom * that.denom)
  }

  def unary_- : Rational = {
    new Rational(-numer,denom)
  }

  def -(that: Rational) = {
    this + -that
  }

  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom
  def max(that: Rational): Rational = if(this < that) that else this

}

