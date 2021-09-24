# Objetivos de la unidad de aprendizaje

* Entender y utilizar el concepto de datos inmutables.
* Entender y utilizar los tipos de datos algebraicos (TDA).
* Introduccir los traits.
* Entender y definir los objetos de compañía.
* Conectar la coincidencia de patrones con los TDA.

---

# Definiendo estructuras de datos funcionales

* La programación funcional no:
  * actualiza variables,
  * modifica estructuras de datos mutables.
* Entonces:
  * ¿Qué tipo de datos se pueden definir?
  * ¿Cómo se pueden definir?
  * ¿Cómo operar sobre ellos?

---

# Definiendo estructuras de datos funcionales

* Las estructuras de datos funcionales son operadas con funciones puras.
* Una función pura no debe cambiar los datos en el lugar.
* Una función pura no debe ejecutar otros efectos colaterales.
* No se actualizan, ni se modifican.
* Se crean.

---

# Definiendo estructuras de datos funcionales (traits)

* Un **trait** es una interface abstracta que puede contener la implementación de algunos métodos.
* Un **trait** encapsula métodos y definición de campos.
* Un **trait** puede reutilizado por mezcla (**mixin**).
* Una clase puede mezclar cualquier número de **traits**.

---

# Definiendo estructuras de datos funcionales (traits)

```{.scala}
trait Equal {
   def isEqual(x:Any): Boolean
   def isNotEqual(x:Any): Boolean = !isEqual(x)
}
```

---

# Definiendo estructuras de datos funcionales (traits)

* ¿Cuándo utilizar traits?
  * Si el comportamiento no va ser utilizado, implemente una clase.
  * Si el comportamiento será reutilizado de muchas formas, no relacionadas.
  * Si hereda de una clase de Java, utilice clases abstractas.

---

# Definiendo estructuras de datos funcionales

```{.scala}
package co.s4n.inmutable.list

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Const[+A](h: A, t: List[A]) extends List[A]
```

---

# Definiendo estructuras de datos funcionales

* Hay dos definiciones de constructores de datos.
* Una lista puede ser vacía
* Una lista consiste de un elemento inicial, seguida de una lista (posiblemente no vacía).

---

# Definiendo estructuras de datos funcionales

```{.scala}
package co.s4n.inmutable.List

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Const[+A](h: A, t: List[A]) extends List[A]
```

---

# Definiendo estructuras de datos funcionales

* Como las funciones pueden ser polimórficas.
* Los tipos de datos también puede ser polimórficas.
```{.scala}
[+A]
```
* **A** es un parámetro de tipo.
* **A** indica cualquier tipo.
* Utilizada en nuestro ejemplo indica que la lista puede contener cualquier tipo de lista.
* **+** Indica que el tipo es **contravariante**.

---

# Definiendo estructuras de datos funcionales

* En la declaración
```{.scala}
trait List[+A]
```
* El **+** en el frente del tipo de parámetro **A** es una varianza de la anotacón.
* Esta señala que **A** es contravariante ("positivo") parámetro de **List**.
* Esto significa que:
  * Si **Gato** es una subclase (subtipo) de **Mamifero**,
  * entonces, **List[Gato]** es una subclase (subtipo) de **List[Animal]**.


---

# Definiendo estructuras de datos funcionales

* Los constructores de datos nos permite construir valores de estos tipos.
```{.scala}
val lst1: List[Boolean] = Nil
val lst2: List[Double] = Const(1.0, Nil)
val lst3: List[String] = Const("x", Const("y", Const("z", Nil)))
val lst4: List[Double] = Const(2.0, lst2)
```

---

# Definiendo estructuras de datos funcionales

* Necesitamos un constructor más poderoso.
* Requerimos utilizar object companions.

---

# Construcción de listas

* Implementar función
```{.scala}
def const[A](elem:A, lst:List[A]):List[A] = ???
```
* Implementar función
```{.scala}
def append[A](lst1:List[A], lst2:List[A]):List[A] = ???
```

---

# Construcción de listas

* Implementar función
```{.scala}
def init[A](lst:List[A]):List[A] = ???
```
* Implementar función
```{.scala}
def drop[A](n:Int,lst:List[A]):List[A] = ???
```

---


# Construcción de listas

* Implementar función
```{.scala}
def split[A](n:Int,lst:List[A]):(List[A],List[A]) = ???
```
* Implementar función
```{.scala}
def zip[A,B](lst1:List[A],lst2:List[B]):(List[A],List[B]) = ???
```

---


# Construcción de listas

* Implementar función
```{.scala}
def split[A](n:Int,lst:List[A]):(List[A],List[A]) = ???
```
* Implementar función
```{.scala}
def zip[A,B](lst1:List[A],lst2:List[B]):(List[A],List[B]) = ???
```

---

# Construcción de listas

* Implementar la función
```{.scala}
def dropWhile[A](lst:List[A],f:A=>Boolean):List[A] = ???
```
* Mejorando la inferencia de tipos para funciones de alto orden
```{.scala}
def dropWhile[A](lst:List[A]... = ???
```
