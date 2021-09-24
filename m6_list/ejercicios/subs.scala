
// def subs[A](lst:List[A]):List[List[A]] = lst match {
//   case Nil => List(Nil)
//   case x :: xs => {
//     def subxs(xs:List[List[A]]) = subs(xs)
//     val list = subxs(xs)
//     list.map(x::_) ::: list
//   }
// }

def perms01234  
