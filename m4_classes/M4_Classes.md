# Agenda

1. Literales Objetos
2. Clases

---

# Objetivos de la unidad de aprendizaje

* Entender y utilizar el concepto de objetos literales en Scala.
* Entender y utilizar el concepto de clases en Scala (POO).

---

# Literales Objetos

* Scala permite crear instancias de objetos
```{.scala}
object Example
object Instance { }
```
* No requieren ser creadas, son como los literales de otros valore
```{.scala}
scala> val value = Example
scala> val value 2 = Instance
```

---

# Literales objetos

* Sintaxis
```{.scala}
object <Name> {
   def name(parameter: type, ...)[: resultType] = bodyExpression
   def name[: resultType] = bodyExpression
   val name[: type] = valueExpression
   var name[: type] = valueExpression
}
```

---

# Literales objetos

* Utiliza var define campos (atributos inmutables)
* Utilizar val define campo (atributos mutables)
* Siempre prefiera val sobre var.

---

# Literales objetos

* Ejercicio. La tabla abajo muestra, los nombres, color y comida favorita de tres gatos.
  Defina un objeto para cada uno
  | Nombre | Color  |   Food  |
  | ------ | ------ | ------- |
  |   Io   |  Fawn  | Churrus |
  |  Make  |   Red  | Leche   |

---

# Clases 

* Una clase es un plano (o plantilla) para la creación de objetos que son instancias concretas de una clase.
* Una definición de una clase consiste de declaración de cero o más campos.
* Una definición de una clase consiste de la definición de cero o más métodos.
* Dada una clase nostros podemos hacer que muchos objetos tengan el mismo tipo y compartan propiedades.

---

# Clases

* Ejemplo:
```{.scala}
class Libro {
   val titulo = "El visconde demediado"
   val autor  = "Italo Calvino"
   val ref    = "Realismo mágico"
   def nombre = titulo + " " + autor + " " + ref
}
```

---

# Clases

* Ejemplo continuación:
```{.scala}
object editorial {
  def presentar(b: Libro) = "Presentamos a " + b.titulo + " de " + b.autor + " un ejemplar de " + b.ref
}
```

---

# Clases (Constructores)

* Ejemplo
```{.scala}
class Libro(t: String, a: String, r: String) {
   val titulo = t
   val autor  = a
   val ref    = r
   def nombre = titulo + " " + autor + " " + ref
}
```

---

# Clases (Constructores)

* Ejemplo
```{.scala}
class Libro(val titulo: String, val autor: String, val ref: String) {
   def nombre = titulo + " " + autor + " " + ref
}
```

---

# Clases (Constructores - Sintaxis)

```{.scala}
class <Nombre>([<mod>] parametro: type, ...) {
   <declaciónOExpresion> ...
}
```
* Donde **mod** puede ser ```val``` o ```var``` 


---

# Clases (Parámetros clave y por omisión)

* Todos los métodos y constructores de Scala soportan parámetros por clave y valore de parámetros por omisión.
* Cuando se invoca un método o constructor, se puede utilizar parámetros por nombre como palabras clave arbitrariamente.
```{.scala}
new Libro(autor = "Philip Roth", ref = "Ficción", titulo = "La mancha humana")
```

--- 


# Clases (Constructores auxiliares)

* Se puede definir uno o más constructores auxiliares para una clase que suministra formas diferentes de crear objetos.
```{.scala}
class Libro(val titulo: String, val autor: String, val ref: String) {
   def this(titulo: String, autor: String) = this(titulo, autor, "Ficcion")
   def nombre = titulo + " " + autor + " " + ref
}

```

---


# Clases (Herencia)

* Ejemplo
```{.scala}
class Forma {
def área: Double = 0.0
}
class Rectangulo(val ancho:Double, val altura:Double) extends Shape {
override def área:Double = ancho * altura
}
class Círculo(val radio:Double) extends Shape {
override def área:Double = math.Pi * radio * radio
}
```

---

# Llamado por nombre

* En Java las invocaciones se hacen:
  * Llamadas por referencia
  * Llamadas por valor
* Scala tiene un mecanismo adicional para pasar parámetros.
  * Llamada por nombre
* Permite que se pueda pasar un bloque de instrucciones.
* Este no se invoca hasta que es llamado especificamente por el invocador.

---

# Objetos de compañia

* En Scala tanto una clase como un objeto pueden compartir su mismo nombre.
* Cuando el objeto comparte el mismo nombre se llama objeto de compañia.
* Permite crear fabricas (**factories**) de los objetos.
