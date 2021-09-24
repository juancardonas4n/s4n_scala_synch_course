package co.s4n.calnat

import scala.io.StdIn

object Main extends App {
  def leerInt(prompt:String):Int = {
    val s = StdIn.readLine(prompt)
    s.toInt
  }
  def esCero(nat:Nat) = nat match {
    case Cero   => true
    case Suc(nat) => false
  }
  def fromInt2Nat(i:Int):Nat = i match {
    case 0 => Cero
    case n => Suc(fromInt2Nat(n - 1))
  }
  def print2Nat(nat:Nat):String = nat match {
    case Cero => "Cero"
    case Suc(n) => "Suc(" + print2Nat(n) + ")"
  }
  def sumaNat(nat1:Nat,nat2:Nat):Nat = nat1 match {
    case Cero => nat2
    case Suc(n) => Suc(sumaNat(n,nat2))
  }
  val i1 = leerInt("Leer primer entero ")
  val n1 = fromInt2Nat(i1)
  val i2 = leerInt("Leer segundo entero ")
  val n2 = fromInt2Nat(i2)
  val res = sumaNat(n1,n2)
  println(print2Nat(res))
}
