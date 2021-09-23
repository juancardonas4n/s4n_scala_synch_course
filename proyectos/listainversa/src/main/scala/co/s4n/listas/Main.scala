package co.s4n.listas

import scala.io.Source

object Main extends App {
  def deListALista(lst:List[Int]):Lista = lst match {
    case Nil => Vacia()
    case (i :: lstp) => Cons(i, deListALista(lstp))
  }
  def leerArchivo(src:String):Lista =
    deListALista(Source.fromFile(src).getLines().toList.map(_.toInt))
  def concatenar(lst1:Lista,lst2:Lista):Lista = lst1 match {
    case Vacia() => lst2
    case Cons(i,lst) => Cons(i,concatenar(lst,lst2))
  }
  def imprimirLista(lst:Lista):String = {
    def imprimirListaResto(lst:Lista):String = {
      lst match {
	case Vacia()  => ""
	case Cons(i,Cons(j,Vacia())) => "" + i + "," + j
	case Cons(i,lstp) => "" + i + "," + imprimirListaResto(lstp)
      }
    }
    "[" + imprimirListaResto(lst) + "]"
  }
  def invertirLista(lst:Lista):Lista = lst match {
    case Vacia() => Vacia()
    case Cons(i,lst) => concatenar(invertirLista(lst),Cons(i,Vacia()))
  }
  val lista = leerArchivo(args(0))
  println(imprimirLista(lista))
  val invlista = invertirLista(lista)
  println(imprimirLista(invlista))
}
