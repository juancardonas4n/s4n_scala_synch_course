# Agenda

1. Programación orientada a expresiones
2. Funciones puras
3. Funciones literales/Funciones Anónimas
4. Funciones de clase y funciones de alto orden
5. Clausuras
6. Funciones aplicadas parcialmente
7. Funciones curry
8. Recursividad de cola

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

# Funciones literales/Funciones Anónimas

* Un literal es la forma más simple de una expresión.
* Scala le permite a usted expresar funciones como literales.
* Una función literal permite tener una definición de una función sin declarar un nombre para ella.
* Un tipo de función puede ser:
  * El tipo de una variable o parámetro a la cual una función puede ser asignada.
  * Un argumento de alto orden tomando una función como parámetro.
  * El resultdo de una función de alto orden retornando una función.

---

# Recursividad

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
