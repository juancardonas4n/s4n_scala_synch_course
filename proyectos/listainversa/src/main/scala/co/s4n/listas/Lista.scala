package co.s4n.listas

sealed trait Lista
case object Vacia extends Lista
case class Cons(i:Int,lst:Lista) extends Lista
