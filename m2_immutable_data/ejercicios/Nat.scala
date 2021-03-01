package co.s4n.inmutable.nat

// Ejercicio 9.
sealed trait Nat
case object Cero extends Nat
case class Suc(nat:Nat) extends Nat


object Nat {

  // Ejercicio 10.
  def fromNatToInt(nat:Nat):Int = nat match {
    case Cero   => 0
    case Suc(n) => 1 + fromNatToInt(n)
  }

  // Ejercicio 11.
  def fromIntToNat(i:Int):Nat = i match {
    case 0 => Cero
    case n => 1 + fromIntToNat(n-1)
  }
}
