package clazz

class Rational(n: Int, d: Int) {
  require(d != 0)
  def this(n: Int) = this(n, 1)
  override def toString = n + "/" + d
  val number = n
  val denom = d

  private val g = gcd(n.abs, d.abs)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def add(that: Rational) =
    new Rational(
      number * that.denom + that.number * denom,
      denom * that.denom)
  
  def +(that:Rational)  =
     new Rational( 
       (this.number * that.denom + that.number * this.denom),
       (denom * that.denom) 
     ) 
  def + (i:Int) =
     new Rational (number + i * denom, denom)
  
  implicit def intToRational(x:Int) = new Rational(x)
}