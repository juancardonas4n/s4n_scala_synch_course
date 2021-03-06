# Agenda

1. Programación orientada a expresiones
2. Funciones puras
3. Funciones literales/Funciones Anónimas
4. Funciones de primera clase y funciones de alto orden
5. Clausuras
6. Funciones aplicadas parcialmente
7. Funciones curry
8. Recursividad y recursividad de cola

---

# Objetivos de la unidad de aprendizaje:

* Entender la programación funcional en Scala
* Entender que las funciones son valores y sus consecuencias
* Entender que significa la recursivad de cola
* Aplicar la recursividad de cola y su forma de optimización en Scala

---

# Programación orientada a expresiones

* Cada instrucción es una expresión.
* Una instrucción ejecuta código pero no retorna un valor.
* Una expresión retorna un valor.

---

# Funciones puras

* Una función es pura
  1. Retorna un único valor.
  2. El resultado es calculado en base a los parámetros de entrada.
  3. La función no modifica ningún valor existente.
* Transparencia referencial

---

# Funciones literales/Funciones anónimas

* Un literal es la forma más simple de una expresión.
* Scala le permite a usted expresar funciones como literales.
* Una función literal permite tener una definición de una función sin declarar un nombre para ella.
* Un tipo de función puede ser:
  * El tipo de una variable o parámetro a la cual una función puede ser asignada.
  * Un argumento de alto orden tomando una función como parámetro.
  * El resultdo de una función de alto orden retornando una función.

---

# Funciones literales/Funciones anónimas

* Una función literal es instanciada dentro de objetos llamados **funciones valores**.
* Una función valor es una función objeto y puede ser invocada como cualquier otra función.

---

# Funciones de primera clase y funciones de alto orden

* Todas las funciones son objetos.
* En la programación funcional, las funciones son ciudadanos de primera clase.
  1. Asignado a variables,
  2. Pasado como argumentos a **otra funcion**
  3. Retornados como valores de **otra funcion**

---

# Clausuras

* Una clausura es una función, cuyo valor de retorno depende del valor de una o más variables declaradas por fuera de esta función.

---

# Funciones aplicadas parcialmente

* En programación funcional cuando se invoca una función, esto recibe un nombre **aplicación**.
* Cuando todos los parámetros son pasados a una función **aplicación completa**.
* Cuando al menos uno de los parámetros no se paso, se llama **aplicación parcial**.

---

# Funciones currificadas

* La currificación convierte una función con múltiples parámetros creando una cadena de funciones.
* Cada elemento espera una único valor.

---

# Recursividad y recursividad de cola

* Una función recursiva es una función que se llama a si misma.
* La recursividad es importante dentro de al programación funcional.
  - Permite recorrer estructuras
  - Permite sustituir las ciclos e iteracciones

---

# Ejemplo de recursividad potencia(```pow3```)

* Vamos a implementar al función que computa el valor x multiplicada n veces
* Esta es la función de potencia
* Miremos en primer lugar una versión de obtener 3 a la n veces
* Implementemos la correspondiente función ```pow3``` en Scala

---

# Ejemplo de recursividad potencia(```pow```)

* Vamos a implementar al función que computa el valor x multiplicada n veces
* Generalicemos obtengamos el valor de x
* Implementemos la correspondiente función ```pow``` en Scala

---

# Ejemplo de recursividad longitud listas

* Las estructuras de datos pueden ser definidas de forma recursiva
* Por ejemplo las listas puede ser definidas:
  - Una lista esta vacia
  - Compuesta de un elemento y una lista restante
```{.scala}
Nil
x :: xs
```
  - Implementar la función ```longitud```

---

# Ejemplo de recursividad mínimo y máximo de una lista

* Vamos a obtener dos valores de una lísta
  - El máximo elemento de la lista
  - El mínimo elemento de la lista
* Los vamos a entregar en una tupla con los dos elementos
* No vamos a considerar la lista vacia
* Nuestras listas tienen al menos un elemento.

