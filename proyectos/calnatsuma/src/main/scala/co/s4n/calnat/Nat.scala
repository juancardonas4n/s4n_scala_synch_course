package co.s4n.calnat

trait Nat
case object Cero extends Nat
case class Suc(nat:Nat) extends Nat

