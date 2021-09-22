# Agenda

1. Excepciones son efectos colaterales.
2. Tipo de dato ```Option```

---

# Excepciones son efectos colaterales

* Lanzar excepciones es un efecto colateral.
* Se puede representar fallas y excepciones con valores ordinarios.
* Se pueden crear funciones de alto orden para manejar patrones de:
  * manejor de error,
  * y recuperación.
* Scala suministra varias opciones para manejar errores:
  * `Option`
  * `Either`
  * `Try`

---

# Excepciones son efectos colaterales

* Las excepciones **no tienen** transparencia referencial.
```{.scala}
def failingFn(i: Int): Int = {
  val y: Int = throw new Exception("fail!")
  try {
    val x = 42 + 5
    x + y
  }
  catch { case e: Exception => 43 }
}
```

---

# Excepciones son efectos colaterales

* Existen dos problemas básicos con las excepciones
  * Excepciones rompen el **RT** e introducen *dependencia en el contexto*
  * Excepciones no son seguras de tipos.
* La idea de excepciones no es mala:
  * Ellas nos permiten **consolidar y centralizar la lógica de manejo de errores**.
* Nuestra idea:
  * En vez de lanzar una excepción, *retornar* un valor que indica que una excepción ha ocurrido.
  * No utilizar *códigos de error*
  * Utilizar tipos que representa la existencia o la ausencia de errores.
  * Esta estrategia es *segura en los tipos*

---

# El tipo de datos Option

* Se representa un tipo de dato que indique la función siempre no tiene la respuesta.
```{.scala}
sealed trait Option[+A]
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]
```

---

# El tipo de dato ```Option``` (Ejemplo)

* En el siguiente ejemplo para calcular la media de una lista vacía
```{.scala}
def media(lst:List[Double]): Option[Double] = 
   if (lst.isEmpty) None
   else Some(lst.sum / lst.length)
```

---

# Funciones parcial y funciones totales

* Una función es total, si para todo el conjunto de entrada, tiene un valor 
  definido en el conjunto de salida
* Una función es parcial, si para todo el conjunto de entrada, al menos un
  valor no esta definido para el conjunto de salida.
  
---

# El tipo de dato ```Option``` (Uso)

* Las funciones parciales abundan dentro de la programación.
* Los tipos de datos como ```Option``` son la forma de como tratarlos.
* Por ejemplo:
  * En listas y tipos de datos las funciones ```headOption``` y ```tailOption```
  * En los ```Map``` las búsquedas retornan un ```Option```

---

# El tipo de dato ```Option``` 

```{.scala}
trait Option[+A] {
   def map[B](f: A => B): Option[B]
   def flatMap[B](f: A => [B]): Option[B]
   def getOrElse[B >: A](default: => B): B
   def orElse[B >: A](ob: => Option[B]): Option[B]
   def filter(f: A => Boolean): Option[A]
}
```

---

# El tipo de dato `Option` 

* Es claro que una vez se utiliza `Option`todo el código queda infectado con `Option`.
* Esto implica que todo las funciones deben produccir `Option` para manejar estas condiciones.
* Se puede hacer que una función se transforme en un función con valores de tipo `Option`.
```{.scala}
def lift[A,B](f: A => B): Option[A] => Option[B] = _ map f
```
* Una función puede convertirse a option:
```{.scala}
def absO:Option[Double] => Option[Double] = lift(math.abs)
```


