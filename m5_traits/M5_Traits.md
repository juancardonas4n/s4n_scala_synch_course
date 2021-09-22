# Agenda

1. Traits
2. Sealed Traits
3. Modelando datos con Traits

---

# Objetivos de la unidad de aprendizaje

* Entender y ampliar el concepto de Traits.
* Profundar los conceptos de abstracción de información

---

# Traits

* Son plantillas para crear clases.
* Traits nos permite expresar elementos comunes entre clases.
* Traits son semejantes a interfaces en Java 8 con métodos por omisión.

---

# Traits (Ejemplo)

* Sintaxis
```{.scala}
package co.s4n.campus.traits

import java.util.Date

case class Anonimo(id:String, createEn: Date = new Date())

case class Usuario(
   id: String,
   email: String,
   creadoEn: Date = new Date())
```

---

# Traits (Ejemplo)

* Ambas clases tiene un identificación (*id*) y tiene fecha de creacion (*createAt*)
* Aquí existe una duplicación y no es bueno duplicar.
* Vamos a crear un tipo común a las dos clases.

---

# Traits (Ejemplo)

```{.scala}
package co.s4n.campus.traits

import java.util.Date

trait Visitante {
   def id: String
   def creadoEn: Date
   def edad: Long = new Date().getTime - creadoEn.getTime
}

case class Anonimo(id:String, createAt: Date = new Date()) extends Visitor

case class Usuario(
   id: String
   email: String,
   creadoEn: Date = new Date()) extends Visitor
```

--- 

# Traits (Ejemplo)

* Se definido un *trait* *Visitante*.
* Se han declarado *Anonimo* y *Usuario* como subclases de *Visitante*.
* Al definirlo de esta manera nos permite trabajar de forma comun con cualquier subclase.

---

# Traits (Ejemplo)

```{.scala}
def esMayor(v1: Visitor, v2: Visitor): Boolean = v1.creadoEn.before(v2.creadoEn)


esMayor(Anonimo("1"), Usuario("2", "prueba@nosesabe.com"))
```

---

# Traits (Sintaxis)

```{.scala}
trait <nombreTrait> {
   <declaracionOExpresion> ...
}
class <nombre>(...) extends <nombreTrait> {
   ...
}
case class <nombre>(...) extends <nombreTrait> {
   ...
}

```

---

# Traits (Comparado con clases)

* Aunque comparte con las clases que es un nombre para un conjunto de atributos y métodos.
* Difiere:
  * Un *trait* no puede tener un constructor
  * Un *trait* puede tener métodos abstractos

---

# Sealed Traits 

* En muchos casos se pueden enumerar todos los posibles clases que pueden extender un trait.
* En el ejemplo anterior: cubrimos todas las posibilidades.
* Pero hay circunstancias en las que no se muestran todos los casos.

---

# Sealed Traits

```{.scala}
trait Op
case object Uno extends Op
case object Dos extends Op
case object Tres extends Op
object Op {
  def doSomething(op:Op):Unit = op match {
    case Uno => println("Uno")
    case Tres => println("Tres")
  }
}

```

---

# Sealed Traits

```{.scala}
sealed trait Op
final case object Uno extends Op
final case object Dos extends Op
final case object Tres extends Op
object Op {
  def doSomething(op:Op):Unit = op match {
    case Uno => println("Uno")
    case Tres => println("Tres")
  }
}
```

---

# Modelando datos con traits

* Vamos a ahondar en el concepto modelamiento de datos con Scala.
* Esta definido en los términos de las operaciones lógicas *o* y *y*.
* En la terminología orientada a objeto esta definido en las relaciones:
  * Es-un.
  * Tiene-un.

---

# Modelando datos con traits (Tiene-un)

* If *A* tiene un *b* (con tipo *B*) y un *c* (con tipo *C) escriba:
```{.scala}
case class A(b: B, c: C)

trait A {
  def b: B
  def c: C
}
```

---

# Modelando datos con traits (Es-un)

* if A es A or C escriba
```{.scala}
sealed trait A
final case class B() extends A
final case class C() extends A
```

---

# Modelando con datos (tipos de datos algebraicos)

* Un tipo de datos algebraico es cualquier tipo que utilice los dos tipos anteriores.
* En la programación funcional un tipo *tiene-un* se conoce como un tipo producto
* En la programación funcional un tipo *es-un" se conoce como un tipo suma.

---

# Modelando datos con traits (Patrones perdidos)

* En el siguiente diagrama se observa de dos patrones
|          |  Y            |     O     |
|----------|---------------|-----------|
| Es-un    |               | Tipo suma |
|----------|---------------|-----------|
| Tiene-un | Tipo producto |           |
|----------|---------------|-----------|
* Estos patrones son:
  * Es-un(Y)
  * Tiene-un(O)

---

# Modelando datos con traits (Patrones perdidos - Es-un(Y))

* El patrón Es-un(Y) significa que `A` es `B` y `C`.
```{.scala}
trait B
trait C
trait A extends B with C
```
* Si queremos representar un dato que conforma a un número de diferentes interfaces (`type class`).
* Se usa en:
  * Modularidad (**Patrón torta**)
  * Compartir implementación a través de diferentes clases donde no tiene sentido tener un implementación por omisión.

---

# Modelando datos con traits (Patrones perdidos - Tiene-un(O))

* El patrón Tiene-un(O) significa que `A` tiene un `B` o `C`. 
* Hay dos formas de implementación.
* Podemos decir que `A` tiene un `d` de tipo `D`, donde `D` es de tipo `B` o `C`. 
```{.scala}
trait A {
  def d: D
}
sealed trait D
final case class B() extends D
final case class C() extends D
```

---

# Modelando datos con traits (Patrones perdidos - Tiene-un(O))

* `A` es un `D` o `E`, y `D` tiene un `B` y `E` tiene un `C`. 
```{.scala}
sealed trait A
final case class D(b: B) extends A
final case class E(c: C) extends A
```

---

# Trabajando con Datos


