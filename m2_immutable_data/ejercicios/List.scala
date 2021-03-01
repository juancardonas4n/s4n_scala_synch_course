package co.s4n.inmutable.list
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Const[+A](h: A, t: List[A]) extends List[A]


// ejercicio 1. El tercer caso respuesta 9
object List {
  def apply[A](as: A*): List[A] = if (as.isEmpty) Nil else Const(as.head, apply(as.tail: _*))
  // ejercicio 2.
  def tail[A](lst:List[A]):List[A] = lst match {
    case Nil => Nil
    case Const(_,t) => t
  }
  // ejercicio 3. Tiene un problema que se va a discutir después.
  def head[A](lst:List[A]):A = lst match {
    case Const(h,t) => h
  }
  // ejercicio 4. 
  def and(lst:List[Boolean]):Boolean = lst match {
    case Nil => true
    case Const(h,t) => h && and(lst)
  }
  // ejercicio 5.
  def or(lst:List[Boolean]):Boolean = lst match {
    case Nil => false
    case Const(h,t) => h || or(lst)
  }
  // ejercicio 6.
  def max(lst:List[Int]):Int = {
    def maxP(lst:List[Int],max:Int):Int = lst match {
      case Nil => max
      case Const(h,t) => maxP(t,if (h > max) h else max)
    }
    maxP(tail(lst),head(lst))
  }
  // ejercicio 7.
  def min(lst:List[Long]):Long = {
    def minP(lst:List[Long],min:Long):Long = lst match {
      case Nil => max
      case Const(h,t) => maxP(t,if (h < min) h else min)
    }
    minP(tail(lst),head(lst))
  }
  // ejercicio 8.
  def maxMin(lst:List[Double]):(Double,Double) = {
    def maxMinP(lst:List,mm:(Double,Double)):(Double,Double) = lst match {
      case Nil => mm
      case Const(h,t) => maxMinP(t,(if (h < mm._1) h else mm._1, if (h > mm._2) h else mm._2))
    }
    minP(tail(lst),head(lst),head(lst))
  }
}
