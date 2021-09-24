package co.s4n.calnat

import scala.io.StdIn

object Main extends App {
  def leerInt(prompt:String):Int = {
    val s = StdIn.readLine(prompt)
    s.toInt
  }
  def esCero(nat:Nat) = nat match {
    case Cero     => true
    case Suc(nat) => false
  }
  def esMayorIgual(nat1:Nat,nat2:Nat):Boolean = nat1 match {
    case Cero => nat2 match {
      case Cero   => true
      case _      => false
    }
    case Suc(pnat) => nat2 match {
      case Cero      => true
      case Suc(snat) => esMayorIgual(pnat,snat)
    }
  }
  def conIntANat(i:Int):Nat = i match {
    case 0 => Cero
    case n => Suc(conIntANat(n - 1))
  }
  def imprimirNat(nat:Nat):String = nat match {
    case Cero   => "Cero"
    case Suc(n) => "Suc(" + imprimirNat(n) + ")"
  }
  def restaNat(nat1:Nat,nat2:Nat):Nat = nat2 match {
    case Cero    => nat1
    case Suc(n) => nat1 match {
      case Suc(n1) => restaNat(n1,n)
    }
  }

  val i1 = leerInt("Leer primer entero ")
  val n1 = conIntANat(i1)
  val i2 = leerInt("Leer segundo entero ")
  val n2 = conIntANat(i2)
  if (esMayorIgual(n1,n2)) {
    val res = restaNat(n1,n2)
    println(imprimirNat(res))
  }
  else
    println("No se puede hacer la operacion")
}
