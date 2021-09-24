# Agenda

1. Construcción de listas
2. Recursión sobre listas

---

# Objetivos de la unidad de aprendizaje

* Entender y utilizar el concepto de datos inmutables.
* Entender y utilizar los tipos de datos algebraicos.
* Introduccir los traits.
* Entender y definir los objetos de compañía.
* Entender y utilizar la coincidencia de patrones.

---


# Recursión sobre listas

* Observemos
```{.scala}
def sum(lst:List[Int]): Int = lst match {
   case Nil => 0
   case Const(h,t) => h + sum(t)
}
def product(lst:List[Int]): Int = lst match {
   case Nil => 1
   case Const(h,t) => h * product(t)
}
```

---

# Recursión sobre listas

* Aunque los tipos son diferentes se pueden generalizar con un tipo **A**
* La estructura es similar
* Tiene un valor de retorno en el caso base
* Tiene un utiliza una función que produce un valor.
```{.scala}
f : (A,A) => A
```
* Se puede generalizar
```{.scala}
f : (A,B) => B
```

---

# Recursión sobre listas

* Definir la función
```{.scala}
def foldRight[A,B](as: List[A], z: B)(f: (A,B) => B): B = ???
```

---

# Recursión sobre listas

* Función **foldRight**
```{.scala}
def foldRight[A,B](as: List[A], z: B)(f: (A,B) => B): B = as match {
   case Nil => z
   case Const(h, t) => f(x, foldRight(xs, z)(f))
}
```
* Funciones **sum2** y *product2**
```{.scala}
def sum2(lst:List[Int]) = foldRight(lst, 0)((x,y) => x + y)
def product2(lst:List[Int]) = foldRight(lst, 1)(_ * _)
```

---


# Recursión sobre listas (notación guión bajo)

* Función **foldRight**
```{.scala}
_ + _     (x,y) => x + y
_ * 2     x => x * 2
_.head    xs => xs.head
_ drop _  (xs,n) => xs.drop(n)
```

---

# Recursión sobre listas

* Ejercicio. Mire que sucede cuando usted pasa **Nil** y **Const** ellos mismos
  a **foldRight*. Pruebe con:
```{.scala}
foldRight(List(1,2,3), Nil:List[Int]) (Const(_,_))
```
* Explique: ¿Qué paso?

---

# Recursión sobre listas

* Ejercicio. Compute utilizando **foldRight**
```{.scala}
def sum(as: List[Int]): Int = ???
```
---

# Recursión sobre listas

* La implementación de **foldRight* no tiene recursividad de cola y
  resultará en un **StackOverflowError** para listas muy largas.
* Vamos a escribir una función **foldLeft** que tenga esa propiedad
```{.scala}
def foldLeft[A,B](lst:List[A],z: B)(f:(B,A) => B): B = ???
```

---

# Recursión sobre listas

```{.scala}
def foldLeft[A,B](lst:List[A],z: B)(f:(B,A) => B): B = lst match {
   case Nil => z
   case Const(h,t) => foldLeft(t, f(z,h))(f)
}
```

---

# Recursión sobre listas

* Ejercicio. Escriba **sum** y **product** en terminos de **foldLeft**
* Ejercicio. Escriba una función que transforme una lista de enteros adicionando
             uno a cada elemento.
```{.scala}
def sumarUno(lst:List[Int]):List[Int] = ???
```
* Ejercicio. Escriba una función que tome cada valor de un **List[Double]** en un
  **String**. Usted puede utlizar la expresión **d.toString** para convertir
  un **d: Double** a **String**
```{.scala}
def listFromDoubleToString(lst:List[Double]):List[String] = ???
```

---

# Recursión sobre listas

* Escriba una función **map** que generaliza la modificación de cada elemento en una
  lista mientras mantiene la estructura de la lista. Esta es la firma:
```{.scala}
def map[A,B](lst:List[A])(f:A => B): List[B] = ???
```
